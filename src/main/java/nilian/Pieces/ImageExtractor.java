package nilian.Pieces;


import nilian.board.SizeEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageExtractor
{
    private String imageSetPath ;

    public ImageExtractor(String imageSetPath )
    {
        this.imageSetPath = imageSetPath ;
    }
    public List<BufferedImage> extractPiecesFromImageSet() throws IOException
    {
        // Get the image
        BufferedImage mainImage = extractImageSet(imageSetPath);

        return cropImageSet(mainImage,
                mainImage.getWidth() / 6,
                mainImage.getHeight() / 2);

    }


    private BufferedImage extractImageSet(String imageSetPath ) throws IOException
    {
        InputStream inputStream = getClass().getResourceAsStream(imageSetPath);

        assert inputStream != null;
        return ImageIO.read(inputStream);
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
                BufferedImage croppedImg = originalImg.getSubimage(x, y, squareWidth, squareHeight);
                BufferedImage newResizedImage = resizeBufferedImage(croppedImg, SizeEntity.squareSize, SizeEntity.squareSize);
                croppedImages.add(newResizedImage);
                x += squareWidth ;
            }
            x = 0 ;
            y += squareHeight ;
        }
        return croppedImages ;
    }

    private static BufferedImage resizeBufferedImage(BufferedImage originalImage, int newWidth, int newHeight)
    {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

        // Get the Graphics2D object from the new image
        Graphics2D g = resizedImage.createGraphics();

        // Draw the original image onto the new image, resizing it in the process
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);

        // Dispose of the graphics object
        g.dispose();

        return resizedImage;
    }
}