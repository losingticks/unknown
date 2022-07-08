package com.game.client.gfx;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Sprite
{
    private final int[] pixels;
    private final int width;
    private final int height;
    private int xOffset = 0;
    private int yOffset = 0;

    private BufferedImage cachedImage = null;

    public Sprite(int[] pixels, int width, int height)
    {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }

    public Sprite(BufferedImage img)
    {
        int w = img.getWidth();
        int h = img.getHeight();
        this.pixels = img.getRGB(0, 0, w, h, null, 0, w);
        this.width = w;
        this.height = h;
    }

    public int[] pixels()
    {
        return pixels;
    }

    public int width()
    {
        return width;
    }

    public int height()
    {
        return height;
    }

    public int xOffset()
    {
        return xOffset;
    }

    public void xOffset(int xOffset)
    {
        this.xOffset = xOffset;
    }

    public int yOffset()
    {
        return yOffset;
    }

    public void yOffset(int yOffset)
    {
        this.yOffset = yOffset;
    }

    public BufferedImage flip(boolean horizontal, boolean vertical)
    {
        BufferedImage sprite = asBufferedImage();
        int x = 0, y = 0;
        int w = width, h = height;

        BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = out.createGraphics();

        if (horizontal)
        {
            x = w;
            w *= -1;
        }

        if (vertical)
        {
            y = h;
            h *= -1;
        }

        g.drawImage(sprite, x, y, w, h, null);
        g.dispose();

        return out;
    }

    public BufferedImage rotate(double theta)
    {
        BufferedImage sprite = asBufferedImage();
        AffineTransform transform = new AffineTransform();
        transform.rotate(theta, width / 2.0, height / 2.0);
        AffineTransformOp transformOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        return transformOp.filter(sprite, null);
    }

    public BufferedImage asBufferedImage()
    {
        if (cachedImage == null)
        {
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            img.setRGB(0, 0, width, height, pixels, 0, width);
            cachedImage = img;
            return img;
        }

        return cachedImage;
    }
}
