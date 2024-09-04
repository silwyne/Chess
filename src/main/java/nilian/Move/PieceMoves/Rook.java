package nilian.Move.PieceMoves;

import nilian.Move.Coordinate;
import nilian.board.BoardMaker;
import nilian.board.ChessSquare;
import nilian.board.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rook
{
    /**
     *  calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     * @return a list of possible coordinates
     */
    public static List<Coordinate> calculatePossibleMoves(ChessSquare square) {
        System.out.println("ROOK MOVE IS CALLED");
        List<Coordinate> result = new ArrayList<>();
        int i = square.getI();
        int j = square.getJ();
        Coordinate source = new Coordinate(i, j);
        Coordinate destination;

        //right moves
        for (int ei = 1; ei < 8; ei++) {
            if (j + ei < 8)
            {
                destination = new Coordinate(i, j + ei);
                if (BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
                {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                } else {
                    if (BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor()) {
                        if (MoveValidation.isThisMoveValid(source, destination))
                            result.add(destination);
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
                if (BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY) {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                }
                else {
                    if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor()) {
                        if (MoveValidation.isThisMoveValid(source, destination))
                            result.add(destination);
                    }
                    break;
                }
            } else {
                break;
            }
        }   //up moves
        for (int ei = 1; ei < 8; ei++) {
            if (i - ei >= 0)//validation
            {
                destination = new Coordinate(i - ei, j);
                if (BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY) {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                }
                else {
                    if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor()) {
                        if (MoveValidation.isThisMoveValid(source, destination))
                            result.add(destination);
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
                if (BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY) {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                }
                else {
                    if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor()) {
                        if (MoveValidation.isThisMoveValid(source, destination))
                            result.add(destination);
                    }
                    break;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
