package nilian.Move.PieceMoves;

import nilian.Move.Coordinate;
import nilian.board.BoardMaker;
import nilian.board.ChessSquare;
import nilian.board.Color;
import nilian.board.Piece;

import java.util.ArrayList;
import java.util.List;

public class Pawn
{
    /**
     *  calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     * @return a list of possible coordinates
     */
    public static List<Coordinate> calculatePossibleMoves(ChessSquare square) {
        System.out.println("PAWN MOVE IS CALLED");
        List<Coordinate> result = new ArrayList<>();
        int i = square.getI();
        int j = square.getJ();
        Coordinate source = new Coordinate(i, j);

        //First pawn two steps for white pawns
        Coordinate destination ;
        if(square.getI() == 6 && square.getPieceColor() == Color.WHITE)
        {
            //not passing the border
            if(i - 2 >= 0)//validation
            {
                destination = new Coordinate(i - 2, j);
                if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY
                        && MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                {
                    if(BoardMaker.theBoard.getSquare(new Coordinate(i - 1, j)).getPiece() == Piece.EMPTY)
                        result.add(destination);
                }
            }
        }
        //First pawn two steps for black pawns
        if(square.getI() == 1 && square.getPieceColor() == Color.BLACK)
        {
            if(i + 2 < 8 )//not passing the border
            {// validation
                destination = new Coordinate(i + 2, j);
                if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY
                        && MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                {
                    if(BoardMaker.theBoard.getSquare(new Coordinate(i + 1, j)).getPiece() == Piece.EMPTY)
                        result.add(destination);
                }
            }
        }
        //one straight steps for black pawns
        if(square.getPieceColor() == Color.BLACK)
        {
            if(i + 1 < 8)//not passing the border
            {//validation
                destination = new Coordinate(i + 1, j);
                if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY
                        && MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                {
                    result.add(destination);
                }
            }
        }
        //one straight steps for white pawns
        if(square.getPieceColor() == Color.WHITE)
        {
            if(i - 1 >= 0)//not passing the border
            {//validation
                destination = new Coordinate(i - 1, j);
                if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY
                        && MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                {
                    result.add(destination);
                }
            }
        }
        //kill the right black pawn
        if(square.getPieceColor() == Color.BLACK)
        {
            if(i + 1 < 8 && j - 1 >= 0)
            {
                destination = new Coordinate(i + 1, j - 1);
                if(BoardMaker.theBoard.getSquare(destination).getPiece() != Piece.EMPTY
                        && BoardMaker.theBoard.getSquare(destination).getPieceColor() == Color.WHITE
                        &&MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                {
                    result.add(destination);
                }
            }
        }
        //kill the right white pawn
        if(square.getPieceColor() == Color.WHITE)
        {
            if(i - 1 >= 0 && j + 1 < 8)
            {
                destination = new Coordinate(i - 1, j + 1);
                if(BoardMaker.theBoard.getSquare(destination).getPiece() != Piece.EMPTY
                        && BoardMaker.theBoard.getSquare(destination).getPieceColor() == Color.BLACK
                        &&MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                {
                    result.add(destination);
                }
            }
        }
        //kill the left black pawn
        if(square.getPieceColor() == Color.BLACK)
        {
            if(i + 1 < 8 && j + 1 < 8)
            {
                destination = new Coordinate(i + 1, j + 1);
                if(BoardMaker.theBoard.getSquare(destination).getPiece() != Piece.EMPTY
                        && BoardMaker.theBoard.getSquare(destination).getPieceColor() == Color.WHITE
                        &&MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                {
                    result.add(destination);
                }
            }
        }
        //kill the left white pawn
        if(square.getPieceColor() == Color.WHITE)
        {
            if(i - 1 >= 0 && j - 1 >= 0)
            {
                destination = new Coordinate(i - 1, j - 1);
                if(BoardMaker.theBoard.getSquare(destination).getPiece() != Piece.EMPTY
                        && BoardMaker.theBoard.getSquare(destination).getPieceColor() == Color.BLACK
                        &&MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                {
                    result.add(destination);
                }
            }
        }
        return result ;
    }
}
