package nilian.Move.PieceMoves;

import nilian.Move.Coordinate;
import nilian.Move.Move;
import nilian.Move.MoveName;
import nilian.Move.Validation.MoveValidation;
import nilian.board.BoardMaker;
import nilian.board.ChessSquare;
import nilian.board.Piece;

import java.util.ArrayList;
import java.util.List;

public class King
{
    /**
     *  calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     * @return a list of possible coordinates
     */
    public static List<Move> calculatePossibleMoves(ChessSquare square)
    {
        List<Move> result = new ArrayList<>();
        int i = square.getI();
        int j = square.getJ();
        Coordinate source = new Coordinate(i, j);
        Coordinate destination ;
        //right, left, up, down , ru, lu, rd, ld
        //right
        if(j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i, j + 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.MOVE));
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.KILL));
            }
        }
        //left
        if(j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i, j - 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.MOVE));
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.KILL));
            }
        }
        //up
        if(i - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i - 1, j);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.MOVE));
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.KILL));
            }
        }
        //down
        if(i + 1 < 8)//move is in board
        {
            destination = new Coordinate(i + 1, j);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.MOVE));
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.KILL));
            }
        }
        //right up
        if(i - 1 >= 0 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i - 1, j + 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.MOVE));
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.KILL));
            }
        }
        //right down
        if(i + 1 < 8 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i + 1, j + 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.MOVE));
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.KILL));
            }
        }
        //left up
        if(i - 1 >= 0 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i - 1, j - 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.MOVE));
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.KILL));
            }
        }
        //left down
        if(i + 1 < 8 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i + 1, j - 1);
            if(BoardMaker.theBoard.getSquare(destination).getPiece() == Piece.EMPTY)
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.MOVE));
            }
            else if(BoardMaker.theBoard.getSquare(destination).getPieceColor() != square.getPieceColor())
            {
                if(MoveValidation.isThisMoveValid(source, destination, square.getBoard()))
                    result.add(new Move(destination, MoveName.KILL));
            }
        }
        return result;
    }
}
