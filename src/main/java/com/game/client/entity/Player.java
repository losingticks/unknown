package com.game.client.entity;

import com.game.client.Client;
import com.game.client.gfx.SpriteSheet;
import com.game.client.input.KeyHandler;
import com.game.util.Constants;
import com.game.util.Direction;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player extends Actor
{
    private final Client client;

    private int t = 0;
    private int delay = 20;

    public Player(Client client)
    {
        super(SpriteSheet.load("../char.png"));
        this.client = client;
    }

    @Override
    public void update()
    {
        KeyHandler keyHandler = client.getKeyHandler();

        if (keyHandler.upPressed)
        {
            position.sub(0, velocity);
            direction = Direction.NORTH;
            spriteX = 0;
        }

        if (keyHandler.downPressed)
        {
            position.add(0, velocity);
            direction = Direction.SOUTH;
            spriteX = 2;
        }

        if (keyHandler.rightPressed)
        {
            position.add(velocity, 0);
            direction = Direction.EAST;
            spriteX = 1;
        }
        else if (keyHandler.leftPressed)
        {
            position.sub(velocity, 0);
            direction = Direction.WEST;
            spriteX = 3;
        }

        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.rightPressed || keyHandler.leftPressed)
        {
            t++;

            if (t % delay == 0)
            {
                if (spriteY == 0 || spriteY == 1)
                {
                    spriteY++;
                }
                else if (spriteY == 2)
                {
                    spriteY--;
                }
            }
        }
        else
        {
            t = 0;
            spriteY = 0;
        }
    }

    @Override
    public void render(Graphics2D g)
    {
        BufferedImage img = spriteSheet.getSprite(spriteX, spriteY).asBufferedImage();
        g.drawImage(img, position.x, position.y, Constants.SPRITE_SCALED_SIZE, Constants.SPRITE_SCALED_SIZE, null);
    }
}