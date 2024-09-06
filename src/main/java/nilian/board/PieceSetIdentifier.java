package nilian.board;

import nilian.Move.Coordinate;

public class PieceSetIdentifier
{
    private final Coordinate cord;
    private final Color pieceColor;
    private final Piece piece;

    public PieceSetIdentifier(Coordinate cord, Color pieceColor, Piece piece)
    {
        this.cord = cord;
        this.pieceColor = pieceColor;
        this.piece = piece;
    }

    public Coordinate getCord() {
        return cord;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString()
    {
        return
                cord+","+
                pieceColor+","+
                piece;
    }
}
