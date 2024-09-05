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

    public static void move(ChessSquare sourceSquare, Coordinate dstCord)
    {
        //if check light is on so we put it off
        if(checkLight != null)
        {
            System.out.println("Turn Off Check Light");
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
    }

    private static String getSquareStyle(int i, int j) {
        return (i + j) % 2 == 0 ? BoardStyles.getWhiteColor() : BoardStyles.getBlackColor();
    }

}
