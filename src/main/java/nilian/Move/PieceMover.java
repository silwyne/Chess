package nilian.Move;

import javafx.scene.Node;
import nilian.Game.EndGameChecker;
import nilian.Move.Validation.MoveValidation;
import nilian.Style.BoardStyles;
import nilian.board.ChessBoard;
import nilian.board.ChessSquare;
import nilian.board.Piece;

public class PieceMover
{

    public static void move(ChessSquare sourceSquare, Coordinate dstCord)
    {
        //IF MOVE IS KILL
        /*
        So we delete the killed piece from present pieces in board
         */
        ChessBoard board = sourceSquare.getBoard();
        if(board.getSquare(dstCord).getPieceColor() != sourceSquare.getPieceColor())
        {
            board.deletePiece(board.getSquare(dstCord));
        }
        /*
        Update the piece place from the present pieces list in Board Object
         */
        board.updatePiece(sourceSquare, dstCord);

        //if check light is on so we put it off
        LightHandler.turnCheckLightOff();
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
            System.out.println("KING IS CHECK");
            LightHandler.turnCheckLightOn(board, kingCoordinate);
            if(EndGameChecker.isEndGame(board))
            {
                System.out.println("END GAME");
            }
        }

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
