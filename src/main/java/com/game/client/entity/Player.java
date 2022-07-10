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
            position.setY(position.getY() - velocity);
            direction = Direction.NORTH;
            spriteX = 0;
        }

        if (keyHandler.downPressed)
        {
            position.setY(position.getY() + velocity);
            direction = Direction.SOUTH;
            spriteX = 2;
        }

        if (keyHandler.rightPressed)
        {
            position.setX(position.getX() + velocity);
            direction = Direction.EAST;
            spriteX = 1;
        }

        if (keyHandler.leftPressed)
        {
            position.setX(position.getX() - velocity);
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
        g.drawImage(img, (int) position.getX(), (int) position.getY(), Constants.SPRITE_SCALED_SIZE, Constants.SPRITE_SCALED_SIZE, null);
    }
}