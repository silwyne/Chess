package nilian.Move.Validation;

import nilian.Move.Coordinate;
import nilian.board.ChessSquare;
import nilian.board.Color;
import nilian.board.Piece;

public class KingMove
{

    /**
     *  calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     * @return a list of possible coordinates
     */
    public static boolean isEnemyThere(Coordinate kingCoordinate, Color friendColor, Piece piece)
    {
        int ki = kingCoordinate.i;
        int kj = kingCoordinate.j;
        Coordinate destination;
        ChessSquare checkSquare;
        //right, left, up, down , ru, lu, rd, ld
        //right
        if(kj + 1 < 8)//move is in board
        {
            destination = new Coordinate(ki, kj + 1);
            checkSquare = MoveValidation.getSquare(destination);
            if(checkSquare.getPiece() == piece
            && checkSquare.getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //left
        if(kj - 1 >= 0)//move is in board
        {
            destination = new Coordinate(ki, kj - 1);
            checkSquare = MoveValidation.getSquare(destination);
            if(checkSquare.getPiece() == piece
            && checkSquare.getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //up
        if(ki - 1 >= 0)//move is in board
        {
            destination = new Coordinate(ki - 1, kj);
            checkSquare = MoveValidation.getSquare(destination);
            if(checkSquare.getPiece() == piece
            && checkSquare.getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //down
        if(ki + 1 < 8)//move is in board
        {
            destination = new Coordinate(ki + 1, kj);
            checkSquare = MoveValidation.getSquare(destination);
            if(checkSquare.getPiece() == piece
            && checkSquare.getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //right up
        if(ki - 1 >= 0 && kj + 1 < 8)//move is in board
        {
            destination = new Coordinate(ki - 1, kj + 1);
            checkSquare = MoveValidation.getSquare(destination);
            if(checkSquare.getPiece() == piece
            && checkSquare.getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //right down
        if(ki + 1 < 8 && kj + 1 < 8)//move is in board
        {
            destination = new Coordinate(ki + 1, kj + 1);
            checkSquare = MoveValidation.getSquare(destination);
            if(checkSquare.getPiece() == piece
            && checkSquare.getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //left up
        if(ki - 1 >= 0 && kj - 1 >= 0)//move is in board
        {
            destination = new Coordinate(ki - 1, kj - 1);
            checkSquare = MoveValidation.getSquare(destination);
            if(checkSquare.getPiece() == piece
            && checkSquare.getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //left down
        if(ki + 1 < 8 && kj - 1 >= 0)//move is in board
        {
            destination = new Coordinate(ki + 1, kj - 1);
            checkSquare = MoveValidation.getSquare(destination);
            if(checkSquare.getPiece() == piece
            && checkSquare.getPieceColor() != friendColor)
            {
                return true;
            }
        }
        return false;
    }

}
