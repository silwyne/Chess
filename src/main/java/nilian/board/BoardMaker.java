package nilian.board;


import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


import nilian.Pieces.PiecesImages;

public class BoardMaker
{

    public static GridPane chessboard ;
    public static Color myColor ;
    public static ChessBoard theBoard = new ChessBoard();

    public static GridPane getInitialBoard(Color myColor) throws Exception
    {
        BoardMaker.myColor = myColor ;
        chessboard = new GridPane();
        chessboard.setGridLinesVisible(true);
        //rows and columns
        for (int i = 0; i < 8; i++) {
            //column
            ColumnConstraints column = new ColumnConstraints(SizeEntity.squareSize);
            chessboard.getColumnConstraints().add(column);
            //row
            RowConstraints row = new RowConstraints(SizeEntity.squareSize);
            chessboard.getRowConstraints().add(row);
        }


        // giving colorful squares
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                ChessSquare square ;
                if(row < 2 || row > 5)
                {
                    square = getSquareWithPiece(row, col);

                } else {
                    square = new ChessSquare(row, col);
                    //putting it empty while is empty
                    square.setPiece(Piece.EMPTY);
                }

                //color thing
                String style = (myColor == Color.WHITE) ^ ((row + col) % 2 == 0) ?
                        BoardStyles.getBlackColor() : BoardStyles.getWhiteColor();
                Color squareColor = (myColor == Color.WHITE) ^ ((row + col) % 2 == 0) ?
                        Color.BLACK : Color.WHITE;

                square.setStyle(style);
                square.setSquareColor(squareColor);


                theBoard.addSquare(square);
                chessboard.add(square, col, row);
            }
        }

        return chessboard;
    }

    private static ChessSquare getSquareWithPiece(int row, int col) throws Exception {

        ChessSquare square = new ChessSquare(row, col);

        //get the piece color
        Color pieceColor = getPieceColor(row, myColor);
        square.setPieceColor(pieceColor);

        // get the image
        //get the piece enum
        Piece pieceName = getPieceName(row, col, myColor);
        System.out.println(pieceName);
        Node pieceImage = PiecesImages.getPieceImageInitial(pieceName, pieceColor);
        square.setPiece(pieceName);
        square.getChildren().add(pieceImage);

        return square;
    }

    private static Color getPieceColor(int row, Color myColor)
    {
        if(row < 2 && myColor == Color.WHITE)
        {
            return Color.BLACK ;
        } else if
        (row < 2 && myColor == Color.BLACK)
        {
            return Color.WHITE ;
        } else if(row > 5 && myColor == Color.WHITE)
        {
            return Color.WHITE ;
        } else {
            return Color.BLACK ;
        }
    }

    private static Piece getPieceName(int row, int col, Color myColor)
    {
        Piece result = null ;
        if(row == 1 || row == 6)
        {
            return Piece.PAWN ;
        } else if(row == 0 || row == 7) {

            switch (col) {
                case 0, 7 -> result = Piece.ROOK;

                case 1, 6 -> result = Piece.HORSE;

                case 2, 5 -> result = Piece.BISHOP;

                case 3 -> {
                    if (myColor == Color.WHITE) {
                        result = Piece.QUEEN;
                    } else {
                        result = Piece.KING;
                    }
                }

                case 4 -> {
                    if (myColor == Color.WHITE) {
                        result = Piece.KING;
                    } else {
                        result = Piece.QUEEN;
                    }
                }
            }
        }
        return result;
    }

}
