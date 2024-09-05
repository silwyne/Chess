package nilian.Move.Validation;

import nilian.Move.Coordinate;
import nilian.board.ChessSquare;
import nilian.board.Color;
import nilian.board.Piece;

public class PawnMove
{

    public static boolean isEnemyThere(Coordinate kingCoordinate, Color friendColor, Piece piece)
    {
        int ki = kingCoordinate.i;
        int kj = kingCoordinate.j;
        Coordinate destination;
        ChessSquare checkSquare;
        //CHECK FOR BLACK PAWN
        if(friendColor == Color.BLACK)
        {
            //RIGHT DOWN WHITE PAWN?
            if(ki + 1 <8 && kj + 1 < 8)
            {
                destination = new Coordinate(ki + 1, kj + 1);
                checkSquare = MoveValidation.getSquare(destination);
                if(checkSquare.getPiece() == piece
                        && checkSquare.getPieceColor() != friendColor)
                {
                    return true;
                }
            }
            //LEFT DOWN WHITE PAWN?
            if(ki + 1 <8 && kj - 1 >= 0)
            {
                destination = new Coordinate(ki + 1, kj - 1);
                checkSquare = MoveValidation.getSquare(destination);
                if(checkSquare.getPiece() == piece
                        && checkSquare.getPieceColor() != friendColor)
                {
                    return true;
                }
            }
            //CHECK FOR WHITE PAWN
        } else {
            //RIGHT UP BLACK PAWN?
            if(ki - 1 >= 0 && kj + 1 < 8)
            {
                destination = new Coordinate(ki - 1, kj + 1);
                checkSquare = MoveValidation.getSquare(destination);
                if(checkSquare.getPiece() == piece
                        && checkSquare.getPieceColor() != friendColor)
                {
                    return true;
                }
            }
            //LEFT UP BLACK PAWN?
            if(ki - 1 >= 0 && kj - 1 >= 0)
            {
                destination = new Coordinate(ki - 1, kj - 1);
                checkSquare = MoveValidation.getSquare(destination);
                if(checkSquare.getPiece() == piece
                        && checkSquare.getPieceColor() != friendColor)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
