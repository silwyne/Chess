package nilian.Move.PieceMoves;

import nilian.Move.Coordinate;
import nilian.board.BoardMaker;
import nilian.board.ChessSquare;
import nilian.board.Piece;

import java.util.ArrayList;
import java.util.List;

public class Bishop {
    /**
     * calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     *
     * @return a list of possible coordinates
     */
    public static List<Coordinate> calculatePossibleMoves(ChessSquare square) {
        System.out.println("HORSE MOVE IS CALLED");
        List<Coordinate> result = new ArrayList<>();
        int i = square.getI();
        int j = square.getJ();
        Coordinate source = new Coordinate(i, j);
        Coordinate destination;

        //right up moves

        for (int ei = 0; ei < 8; ei++) {
            if (i - ei >= 0 && j + ei < 8)//validation
            {
                destination = new Coordinate(i - ei, j + ei);
                if (BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
                {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                }
                else if (BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
                {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                }
            } else {
                break;
            }
        }
        //right down moves
        for (int ei = 0; ei < 8; ei++) {
            if (i + ei < 8 && j + ei < 8)//validation
            {
                destination = new Coordinate(i + ei, j + ei);
                if (BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
                {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                } else if (BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
                {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                }
            } else {
                break;
            }
        }   //left up moves
        for (int ei = 0; ei < 8; ei++) {
            if (i - ei >= 0 && j - ei >= 0)//validation
            {
                destination = new Coordinate(i - ei, j - ei);
                if (BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
                {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                }
                else if (BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
                {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                }
            } else {
                break;
            }
        }   //left down moves
        for (int ei = 0; ei < 8; ei++) {
            if (i + ei < 8 && j - ei >= 0)//validation
            {
                destination = new Coordinate(i + ei, j - ei);
                if (BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
                {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                } else if (BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
                {
                    if (MoveValidation.isThisMoveValid(source, destination))
                        result.add(destination);
                }
            } else {
                break;
            }
        }
        return result;
    }
}
