package nilian.Move.PieceMoves;

import nilian.Move.Coordinate;
import nilian.board.BoardMaker;
import nilian.board.ChessSquare;
import nilian.board.Color;
import nilian.board.Piece;

import java.util.ArrayList;
import java.util.List;

public class Horse
{
    /**
     *  calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     * @return a list of possible coordinates
     */
    public static List<Coordinate> calculatePossibleMoves(ChessSquare square)
    {
        System.out.println("HORSE MOVE IS CALLED");
        List<Coordinate> result = new ArrayList<>();
        int i = square.getI();
        int j = square.getJ();
        Coordinate source = new Coordinate(i, j);
        Coordinate destination ;
        //FIRST : up moves
        //right up : 2 up 1 right
        if( i - 2 >= 0 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i - 2, j + 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
        }
        //left up : 2 up 1 left
        if( i - 2 >= 0 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i - 2, j - 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
        }
        //right down : 2 down 1 right
        if( i + 2 < 8 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i + 2, j + 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
        }
        //left down : 2 down 1 left
        if( i + 2 < 8 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i + 2, j - 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
        }
        //right UPPER : 1 up 2 right
        if( i - 1 >= 0 && j + 2 < 8)//move is in board
        {
            destination = new Coordinate(i - 1, j + 2);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
        }
        //right DOWNER : 1 down 2 right
        if( i + 1 < 8 && j + 2 < 8)//move is in board
        {
            destination = new Coordinate(i + 1, j + 2);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
        }
        //left UPPER : 1 up 2 left
        if( i - 1 >= 0 && j - 2 >= 0)//move is in board
        {
            destination = new Coordinate(i - 1, j - 2);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
        }
        //left DOWNER : 1 down 2 left
        if( i + 1 < 8 && j - 2 >= 0)//move is in board
        {
            destination = new Coordinate(i + 1, j - 2);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination))
                    result.add(destination);
            }
        }
        return result;
    }
}
