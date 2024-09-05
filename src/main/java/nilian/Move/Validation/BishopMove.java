package nilian.Move.Validation;

import nilian.Move.Coordinate;
import nilian.board.ChessSquare;
import nilian.board.Color;
import nilian.board.Piece;


public class BishopMove
{

    public static boolean isEnemyThere(Coordinate kingCoordinate, Color friendColor, Piece piece)
    {
        int i = kingCoordinate.i;
        int j = kingCoordinate.j;
        Coordinate destination;
        ChessSquare checkSquare ;
        //right up moves
        for (int ei = 1; ei < 8; ei++) {
            if (i - ei >= 0 && j + ei < 8) {
                destination = new Coordinate(i - ei, j + ei);
                checkSquare = MoveValidation.getSquare(destination);
                if (checkSquare.getPiece() != Piece.EMPTY)
                {
                    if(checkSquare.getPieceColor() != friendColor
                            && checkSquare.getPiece() == piece)
                    {
                        return true;
                    }
                    break;
                }
            } else {
                break;
            }
        }
        //right down moves
        for (int ei = 1; ei < 8; ei++) {
            if (i + ei < 8 && j + ei < 8)//validation
            {
                destination = new Coordinate(i + ei, j + ei);
                checkSquare = MoveValidation.getSquare(destination);
                if (checkSquare.getPiece() != Piece.EMPTY)
                {
                    if(checkSquare.getPieceColor() != friendColor
                            && checkSquare.getPiece() == piece)
                    {
                        return true;
                    }
                    break;
                }
            } else {
                break;
            }
        }   //left up moves
        for (int ei = 1; ei < 8; ei++) {
            if (i - ei >= 0 && j - ei >= 0)//validation
            {
                destination = new Coordinate(i - ei, j - ei);
                checkSquare = MoveValidation.getSquare(destination);
                if (checkSquare.getPiece() != Piece.EMPTY)
                {
                    if(checkSquare.getPieceColor() != friendColor
                            && checkSquare.getPiece() == piece)
                    {
                        return true;
                    }
                    break;
                }
            } else {
                break;
            }
        }   //left down moves
        for (int ei = 1; ei < 8; ei++) {
            if (i + ei < 8 && j - ei >= 0)//validation
            {
                destination = new Coordinate(i + ei, j - ei);
                checkSquare = MoveValidation.getSquare(destination);
                if (checkSquare.getPiece() != Piece.EMPTY)
                {
                    if(checkSquare.getPieceColor() != friendColor
                    && checkSquare.getPiece() == piece)
                    {
                        return true;
                    }
                    break;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
