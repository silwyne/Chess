package nilian.Pieces;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nilian.board.Color;
import nilian.board.Piece;

import java.awt.image.BufferedImage;
import java.util.List;

public class PiecesImages
{
    private static BufferedImage blackKing;
    private static BufferedImage whiteKing;
    private static BufferedImage blackQueen;
    private static BufferedImage whiteQueen;
    private static BufferedImage blackRook;
    private static BufferedImage whiteRook;
    private static BufferedImage blackHorse;
    private static BufferedImage whiteHorse;
    private static BufferedImage blackBishop;
    private static BufferedImage whiteBishop;
    private static BufferedImage blackPawn;
    private static BufferedImage whitePawn;

    public static void setPieces(List<BufferedImage> allPieces)
    {
        whiteKing = allPieces.get(0);
        whiteQueen = allPieces.get(1);
        whiteBishop = allPieces.get(2);
        whiteHorse = allPieces.get(3);
        whiteRook = allPieces.get(4);
        whitePawn = allPieces.get(5);

        blackKing = allPieces.get(6);
        blackQueen = allPieces.get(7);
        blackBishop = allPieces.get(8);
        blackHorse = allPieces.get(9);
        blackRook = allPieces.get(10);
        blackPawn = allPieces.get(11);
    }

    public static Node getPieceImageInitial(Piece piece, Color pieceColor)
    {
        BufferedImage squarePiece = getImage(piece, pieceColor);

        //converting the image
        Image image = SwingFXUtils.toFXImage(squarePiece, null);
        return new ImageView(image);
    }


    public static BufferedImage getImage(Piece piece, Color color)
    {
        BufferedImage result = null;
        switch (piece) {
            case ROOK -> {if(color == Color.BLACK) {result = blackRook;} else {result = whiteRook;}}

            case HORSE -> {if(color == Color.BLACK) {result = blackHorse;} else {result = whiteHorse;}}

            case BISHOP -> {if(color == Color.BLACK) {result = blackBishop;} else {result = whiteBishop;}}

            case KING -> {if(color == Color.BLACK) {result = blackKing;} else {result = whiteKing;}}

            case QUEEN -> {if(color == Color.BLACK) {result = blackQueen;} else {result = whiteQueen;}}

            case PAWN -> {if(color == Color.BLACK) {result = blackPawn;} else {result = whitePawn;}}
        }
        return result;
    }


}
