package nilian.board;

import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import nilian.Move.Coordinate;
import nilian.Move.ClickHandler;

public class ChessSquare extends Pane
{
    private int i ;
    private int j ;
    private Piece piece;
    private Color pieceColor;
    private Color squareColor;
    private final ChessBoard board;

    public ChessSquare(int i, int j, ChessBoard board)
    {
        this.i = i ;
        this.j = j ;

        this.board = board;

        // Add an onClick event handler
        this.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                ClickHandler.handleClick(ChessSquare.this, board);
            }

        });
    }

    public Color getSquareColor() {
        return squareColor;
    }

    public void setSquareColor(Color squareColor) {
        this.squareColor = squareColor;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Coordinate getCoordinate()
    {
        return new Coordinate(i, j);
    }

    public ChessBoard getBoard() {return this.board;}

    public void updateSquareStyle(String style) {
        this.setStyle(style);
        this.applyCss();
        this.requestLayout();
        board.setSquare(getCoordinate(), this);
    }
}
