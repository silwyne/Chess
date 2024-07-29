package nilian.board;

import javafx.scene.layout.Pane;

public class ChessSquare extends Pane
{
    private int i ;
    private int j ;
    private Piece piece;
    private Color pieceColor;


    public ChessSquare(int i, int j)
    {
        this.i = i ;
        this.j = j ;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
    }

    public Piece getPiece() {
        return piece;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(Color pieceColor) {
        this.pieceColor = pieceColor;
    }
}
