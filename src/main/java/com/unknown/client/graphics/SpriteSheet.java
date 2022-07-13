package com.unknown.client.graphics;

import com.unknown.util.Constants;
import com.unknown.util.ImageLoader;
import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private final Sprite sprite;
    private final int rows, cols;
    private final Sprite[][] spriteMap;

    public SpriteSheet(BufferedImage img)
    {
        this.sprite = new Sprite(img).width(Constants.SPRITE_SIZE).height(Constants.SPRITE_SIZE);
        this.rows = sprite.maxHeight() / sprite.height();
        this.cols = sprite.maxWidth() / sprite.width();
        this.spriteMap = new Sprite[rows][cols];

        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                spriteMap[row][col] = crop(col, row);
            }
        }
    }

    private Sprite crop(int x, int y, int width, int height)
    {
        BufferedImage img = sprite.asBufferedImage().getSubimage(x, y, width, height);
        return new Sprite(img);
    }

    private Sprite crop(int gridX, int gridY)
    {
        int w = sprite.width();
        int h = sprite.height();
        return crop(gridX * w, gridY * h, w, h);
    }

    public Sprite getSprite(int x, int y)
    {
        return spriteMap[y][x];
    }

    public static SpriteSheet load(String path)
    {
        return new SpriteSheet(ImageLoader.loadImage(path));
    }
}