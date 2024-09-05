package nilian.Move.Validation;

import nilian.Move.Coordinate;
import nilian.Move.Move;
import nilian.Move.MoveName;
import nilian.board.BoardMaker;
import nilian.board.ChessSquare;
import nilian.board.Color;
import nilian.board.Piece;

import java.util.ArrayList;
import java.util.List;

public class RookMove
{

    public static boolean isEnemyThere(Coordinate kingCoordinate, Color friendColor, Piece piece) {
        int i = kingCoordinate.i;
        int j = kingCoordinate.j;
        Coordinate destination;
        ChessSquare checkSquare;
        //right moves
        for (int ei = 1; ei < 8; ei++) {
            if (j + ei < 8) {
                destination = new Coordinate(i, j + ei);
                checkSquare = MoveValidation.getSquare(destination);
                if (checkSquare.getPiece() != Piece.EMPTY) {
                    if (checkSquare.getPieceColor() != friendColor
                            && checkSquare.getPiece() == piece) {
                        return true;
                    }
                    break;
                }
            } else {
                break;
            }
        }
        //left moves
        for (int ei = 1; ei < 8; ei++) {
            if (j - ei >= 0)//validation
            {
                destination = new Coordinate(i, j - ei);
                checkSquare = MoveValidation.getSquare(destination);
                if (checkSquare.getPiece() != Piece.EMPTY) {
                    if (checkSquare.getPieceColor() != friendColor
                            && checkSquare.getPiece() == piece) {
                        return true;
                    }
                    break;
                }
            } else {
                break;
            }
        }
        //up moves
        for (int ei = 1; ei < 8; ei++) {
            if (i - ei >= 0)//validation
            {
                destination = new Coordinate(i - ei, j);
                checkSquare = MoveValidation.getSquare(destination);
                if (checkSquare.getPiece() != Piece.EMPTY) {
                    if (checkSquare.getPieceColor() != friendColor
                            && checkSquare.getPiece() == piece) {
                        return true;
                    }
                    break;
                }
            } else {
                break;
            }
        }   //down moves
        for (int ei = 1; ei < 8; ei++) {
            if (i + ei < 8)//validation
            {
                destination = new Coordinate(i + ei, j);
                checkSquare = MoveValidation.getSquare(destination);
                if (checkSquare.getPiece() != Piece.EMPTY) {
                    if (checkSquare.getPieceColor() != friendColor
                            && checkSquare.getPiece() == piece) {
                        return true;
                    }
                    break;
                }
            } else {
                break;
            }
        }
        //Finally safe
        return false;
    }
}
