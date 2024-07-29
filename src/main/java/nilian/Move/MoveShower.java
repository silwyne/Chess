package nilian.Move;

import nilian.Move.PieceMoves.*;
import nilian.board.ChessSquare;

import java.util.List;

public class MoveShower
{
    public static List<Coordinate> showMoves(ChessSquare square)
    {
        List<Coordinate> possibleMoves = null ;
        switch (square.getPiece())
        {
            case BISHOP -> possibleMoves = Bishop.calculatePossibleMoves(square);

            case ROOK -> possibleMoves = Rook.calculatePossibleMoves(square);

            case QUEEN -> possibleMoves = Queen.calculatePossibleMoves(square);

            case KING -> possibleMoves = King.calculatePossibleMoves(square);

            case HORSE -> possibleMoves = Horse.calculatePossibleMoves(square);

            case PAWN -> possibleMoves = Pawn.calculatePossibleMoves(square);
        }
        return possibleMoves ;
    }
}
