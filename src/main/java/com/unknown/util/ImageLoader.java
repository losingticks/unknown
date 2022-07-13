package com.unknown.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader
{
    public static BufferedImage loadImage(String path)
    {
        try
        {
            BufferedImage img = ImageIO.read(ImageLoader.class.getResource(path));
            return img;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }

        return null;
    }
}
