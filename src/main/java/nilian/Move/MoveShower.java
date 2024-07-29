package nilian.Move;

import nilian.Move.PieceMoves.*;
import nilian.board.ChessSquare;
import nilian.board.Piece;

import java.util.List;

public class MoveShower
{
    public static List<Coordinate> showMoves(ChessSquare square)
    {
        List<Coordinate> possibleMoves = null ;
        switch (square.getPiece())
        {
            case BISHOP -> possibleMoves = Bishop.calculatePossibleMoves();

            case ROOK -> possibleMoves = Rook.calculatePossibleMoves();

            case QUEEN -> possibleMoves = Queen.calculatePossibleMoves();

            case KING -> possibleMoves = King.calculatePossibleMoves();

            case HORSE -> possibleMoves = Horse.calculatePossibleMoves();

            case PAWN -> possibleMoves = Pawn.calculatePossibleMoves();
        }
        return possibleMoves ;
    }
}
