package nilian.Move.Validation;

import nilian.Move.Coordinate;
import nilian.board.ChessBoard;
import nilian.board.Color;
import nilian.board.Piece;

import java.util.ArrayList;
import java.util.List;

public class HorseMove
{

    /**
     *  calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     * @return a list of possible coordinates
     */
    public static boolean isEnemyThere(Coordinate kingCoordinate, Color friendColor, Piece piece)
    {
        int i = kingCoordinate.i;
        int j = kingCoordinate.j;
        Coordinate destination ;
        //FIRST : up moves
        //right up : 2 up 1 right
        if( i - 2 >= 0 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i - 2, j + 1);
            if(MoveValidation.getSquare(destination).getPiece() == piece
            && MoveValidation.getSquare(destination).getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //left up : 2 up 1 left
        if( i - 2 >= 0 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i - 2, j - 1);
            if(MoveValidation.getSquare(destination).getPiece() == piece
            && MoveValidation.getSquare(destination).getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //right down : 2 down 1 right
        if( i + 2 < 8 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i + 2, j + 1);
            if(MoveValidation.getSquare(destination).getPiece() == piece
            && MoveValidation.getSquare(destination).getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //left down : 2 down 1 left
        if( i + 2 < 8 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i + 2, j - 1);
            if(MoveValidation.getSquare(destination).getPiece() == piece
            && MoveValidation.getSquare(destination).getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //right UPPER : 1 up 2 right
        if( i - 1 >= 0 && j + 2 < 8)//move is in board
        {
            destination = new Coordinate(i - 1, j + 2);
            if(MoveValidation.getSquare(destination).getPiece() == piece
            && MoveValidation.getSquare(destination).getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //right DOWNER : 1 down 2 right
        if( i + 1 < 8 && j + 2 < 8)//move is in board
        {
            destination = new Coordinate(i + 1, j + 2);
            if(MoveValidation.getSquare(destination).getPiece() == piece
            && MoveValidation.getSquare(destination).getPieceColor() != friendColor)
            {
                return true;
            }

        }
        //left UPPER : 1 up 2 left
        if( i - 1 >= 0 && j - 2 >= 0)//move is in board
        {
            destination = new Coordinate(i - 1, j - 2);
            if(MoveValidation.getSquare(destination).getPiece() == piece
            && MoveValidation.getSquare(destination).getPieceColor() != friendColor)
            {
                return true;
            }
        }
        //left DOWNER : 1 down 2 left
        if( i + 1 < 8 && j - 2 >= 0)//move is in board
        {
            destination = new Coordinate(i + 1, j - 2);
            if(MoveValidation.getSquare(destination).getPiece() == piece
            && MoveValidation.getSquare(destination).getPieceColor() != friendColor)
            {
                return true;
            }
        }
        return false;
    }
}
