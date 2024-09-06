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
    private boolean isClicked;
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

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public Coordinate getCoordinate()
    {
        return new Coordinate(i, j);
    }

    public ChessBoard getBoard() {return this.board;}

    public void updateSquareStyle(String style) {
        System.out.println("UPDATE STYLE: "+getCoordinate());
        this.setStyle(style);
        this.applyCss();
        this.requestLayout();
        // If needed, uncomment these lines:
        // BoardMaker.chessboard.getChildren().remove(square);
        // BoardMaker.chessboard.add(square, square.getI(), square.getJ());
        // Update the model if necessary
        board.setSquare(getCoordinate(), this);
    }
}
