package nilian.Move;

import javafx.scene.Node;
import nilian.Move.Validation.MoveValidation;
import nilian.Style.BoardStyles;
import nilian.board.BoardMaker;
import nilian.board.ChessBoard;
import nilian.board.ChessSquare;
import nilian.board.Piece;

public class PieceMover
{
    private static Coordinate checkLight ;
    private static ChessSquare movedFromSquareLight ;
    private static ChessSquare movedToSquareLight ;

    public static void move(ChessSquare sourceSquare, Coordinate dstCord)
    {
        //if check light is on so we put it off
        if(checkLight != null)
        {
            //Turn off check light
            String style;
            // If the sum of row and column is even, it's a white square, otherwise it's black
            if ((checkLight.i + checkLight.j) % 2 == 0)
            { style = BoardStyles.getWhiteColor();
            } else {style = BoardStyles.getBlackColor();}
            BoardMaker.theBoard.getSquare(checkLight).updateSquareStyle(style);
            checkLight = null;
        }
        ChessBoard board = sourceSquare.getBoard();
        // Get the destination square
        ChessSquare dstSquare = board.getSquare(dstCord);

        // Move the piece to the destination square
        Node piecePicture = sourceSquare.getChildren().get(0);
        dstSquare.getChildren().clear();
        dstSquare.getChildren().add(piecePicture);
        dstSquare.setPiece(sourceSquare.getPiece());
        // Clear the source square
        sourceSquare.setPiece(Piece.EMPTY);
        dstSquare.setPieceColor(sourceSquare.getPieceColor());
        sourceSquare.updateSquareStyle(getSquareStyle(sourceSquare.getI(), sourceSquare.getJ()));
        dstSquare.updateSquareStyle(getSquareStyle(dstCord.i, dstCord.j));

        // Update the board model
        board.setSquare(new Coordinate(sourceSquare.getI(), sourceSquare.getJ()), sourceSquare);
        board.setSquare(dstCord, dstSquare);

        //UPDATE the turn
        board.nextTurn();

        //if the piece is king update the king coordinate
        if(dstSquare.getPiece() == Piece.KING)
        {
            board.updateBoardKingCoordinates(dstSquare.getPieceColor(), dstCord);
        }

        //is my king check ?
        //getting king coordinate
        Coordinate kingCoordinate = board.getKingCoordinate(board.whoTurnIsIt());
        if(!MoveValidation.isThisMoveValid(kingCoordinate, kingCoordinate, board))
        {
            //SO KING IS NOT SAFE NOW
            String checkStyle = BoardStyles.getCheckStyle();
            //update style to check
            board.getSquare(kingCoordinate).updateSquareStyle(checkStyle);
            checkLight = kingCoordinate;
        }

        //HANDLING MOVING LIGHTS
        //TURN IT ON
        movedFromSquareLight = sourceSquare;
        movedToSquareLight = board.getSquare(dstCord);
        movedFromSquareLight.updateSquareStyle(BoardStyles.getMovedFromStyle());
        movedToSquareLight.updateSquareStyle(BoardStyles.getMovedToStyle());
        //TURN IT OFF FOR NEXT TIME
        //adding it to highLightedLights
    }

    private static String getSquareStyle(int i, int j) {
        return (i + j) % 2 == 0 ? BoardStyles.getWhiteColor() : BoardStyles.getBlackColor();
    }

    public static boolean checkForMovement(ChessSquare destinationSquare)
    {
        for (Move possibleMove : ClickHandler.getPossibleMoves()) {
            if (possibleMove.dstCord.equalsCoordinate(destinationSquare.getI(), destinationSquare.getJ())) {
                return true;
            }
        }
        return false ;
    }
}
