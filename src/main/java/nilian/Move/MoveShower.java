package nilian.Move;

import nilian.board.ChessSquare;
import nilian.board.Piece;

public class MoveShower
{
    public static void showMoves(ChessSquare square)
    {
        if(square.getPiece() == Piece.BISHOP)
        {
            Bishop.getPossibleMoves();
        }
    }
}
