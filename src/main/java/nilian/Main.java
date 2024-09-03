package nilian;

import nilian.Pieces.PiecesImages;
import nilian.Window.OriginStarter;
import nilian.Pieces.ImageExtractor;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;


public class Main  {

    public static void main(String[] args) throws IOException {

        ImageExtractor setExtractor = new ImageExtractor("/PeicesSets/set_3.png");
        List<BufferedImage> pieces = setExtractor.extractPiecesFromImageSet();
        PiecesImages.setPieces(pieces);
        OriginStarter.runner(args);

    }
}