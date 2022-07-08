package com.game.client.gfx;

import com.game.util.Constants;
import com.game.util.ImageLoader;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class SpriteSheet
{
    private final Sprite sprite;
    private final List<Sprite> sprites = new ArrayList<>();

    public SpriteSheet(BufferedImage sheet)
    {
        this.sprite = new Sprite(sheet);
        loadSprites();
    }

    private void loadSprites()
    {
        BufferedImage img = sprite.asBufferedImage();
        int y = 0;

        for (int r = 0; r < (sprite.height() / Constants.SPRITE_SIZE); r++)
        {
            int x = 0;

            for (int c = 0; c < (sprite.width() / Constants.SPRITE_SIZE); c++)
            {
                sprites.add(new Sprite(img.getSubimage(x, y, Constants.SPRITE_SIZE, Constants.SPRITE_SIZE)));
                x += Constants.SPRITE_SIZE;
            }

            y += Constants.SPRITE_SIZE;
        }
    }

    public static SpriteSheet loadSpriteSheet(String path)
    {
        BufferedImage spriteSheet = ImageLoader.loadImage("../" + path);
        return new SpriteSheet(spriteSheet);
    }

    public List<Sprite> getSprites()
    {
        return sprites;
    }

    public Sprite getSprite(int index)
    {
        return sprites.get(index);
    }

    public int size()
    {
        return sprites.size();
    }
}
