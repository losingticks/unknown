package com.game.client.gfx;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Sprite
{
    private final int[] pixels;
    private final int maxWidth;
    private final int maxHeight;
    private int width = -1;
    private int height = -1;
    private int xOffset = 0;
    private int yOffset = 0;

    private BufferedImage cachedImage = null;

    public Sprite(int[] pixels, int maxWidth, int maxHeight, int width, int height)
    {
        this.pixels = pixels;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.width = width;
        this.height = height;
    }

    public Sprite(int[] pixels, int width, int height)
    {
        this(pixels, width, height, width, height);
    }

    public Sprite(BufferedImage img)
    {
        int w = img.getWidth();
        int h = img.getHeight();
        this.pixels = img.getRGB(0, 0, w, h, null, 0, w);
        this.maxWidth = w;
        this.maxHeight = h;
        this.width = w;
        this.height = h;
    }

    public int[] pixels()
    {
        return pixels;
    }

    public int maxWidth()
    {
        return maxWidth;
    }

    public int maxHeight()
    {
        return maxHeight;
    }

    public int width()
    {
        return width;
    }

    public Sprite width(int width)
    {
        this.width = width;
        return this;
    }

    public int height()
    {
        return height;
    }

    public Sprite height(int height)
    {
        this.height = height;
        return this;
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
            BufferedImage img = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_ARGB);
            img.setRGB(0, 0, maxWidth, maxHeight, pixels, 0, maxWidth);
            cachedImage = img;
            return img;
        }

        return cachedImage;
    }
}
