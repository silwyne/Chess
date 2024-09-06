package nilian.board;

import nilian.Move.Coordinate;

public class PieceSetIdentifier
{
    private Coordinate cord;
    private Color pieceColor;
    private Piece piece;

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
}
