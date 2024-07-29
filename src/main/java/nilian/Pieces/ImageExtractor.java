package nilian.images;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageExtractor
{

    public static List<BufferedImage> extractPiecesFromImageSet() throws IOException {
        //get the image
        BufferedImage mainImage = extractImageSet();

        return cropImageSet(mainImage,
                (int) mainImage.getWidth() / 6,
                (int) mainImage.getHeight() / 6);
    }


    private static BufferedImage extractImageSet() throws IOException {
        return ImageIO.read(new File("pieces_set_2.png"));
    }

    private static List<BufferedImage> cropImageSet(BufferedImage originalImg, int squareWidth, int squareHeight)
    {
        List<BufferedImage> croppedImages = new ArrayList<>();

        int x = 0 ;
        int y = 0 ;

        for(int i = 0 ; i < 2 ; i ++)
        {
            for(int j = 0 ; j < 6; j ++)
            {
                x += squareWidth ;
                BufferedImage croppedImg = originalImg.getSubimage(x, y, squareWidth, squareHeight);
                croppedImages.add(croppedImg);
            }
            x = 0 ;
            y += squareHeight ;
        }

        return croppedImages ;
    }



}
