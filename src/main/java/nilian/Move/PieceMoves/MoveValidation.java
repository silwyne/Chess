package nilian.Move.PieceMoves;

import nilian.Move.Coordinate;
import nilian.board.ChessBoard;
import nilian.board.Color;

public class MoveValidation
{

    /**
     * Checks if the Piece moves to the destination the king gets in danger or not
     *
     * @param destination the coordinate of where the piece can go
     * @param source the coordinate of where the piece is now
     * @return true if king stays safe
     */
    public static boolean isThisMoveValid(Coordinate source, Coordinate destination, ChessBoard board)
    {
        /*
        1. who's turn is it? find his king ...
        2. check if the king by the move is safe
        3.enemy pawns!
        4.enemy horses!
        5.enemy bishops!(or queen)
        6.enemy Rooks!(or queen)
         */
        //STEP 1: GETTING THE KING COORDINATE
        Coordinate kingCoordinate;
        if(board.whoTurnIsIt() == Color.BLACK)
        {
            kingCoordinate = board.getKingCoordinate(Color.BLACK);
        } else {
            kingCoordinate = board.getKingCoordinate(Color.WHITE);
        }
        /*
        NOTE : if the source cord is equal to king cord :
        So the dst Cord is actually the king cord !
         */
        if(source == kingCoordinate)
        {
            kingCoordinate = destination;

        }
        int ki = kingCoordinate.i;
        int kj = kingCoordinate.j;
        //finally in both situations the source is considered empty
        //and the dst is considered the mover or the friend

        return true;
    }
}
