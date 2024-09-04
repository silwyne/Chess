package nilian.Move.PieceMoves;

import nilian.Move.Coordinate;
import nilian.Move.Move;
import nilian.board.ChessSquare;

import java.util.List;

public class Queen
{
    /**
     *  calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     * @return a list of possible coordinates
     */
    public static List<Move> calculatePossibleMoves(ChessSquare square)
    {
        //the bishop moves
        List<Move> result = Bishop.calculatePossibleMoves(square);
        //and the rook moves
        result.addAll(Rook.calculatePossibleMoves(square));

        return result;
    }
}
