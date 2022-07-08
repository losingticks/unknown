package com.game.client.entity;

import com.game.client.Client;
import com.game.client.input.KeyHandler;
import com.game.util.Constants;
import com.game.util.ImageLoader;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player
{
    private final Client client;
    private int x = 0;
    private int y = 0;
    private int velocity = 4;

    private BufferedImage sprite = null;

    public Player(Client client)
    {
        this.client = client;
        this.sprite = ImageLoader.loadImage("../char.png");
    }

    public void update()
    {
        KeyHandler keyHandler = client.getKeyHandler();

        if (keyHandler.upPressed)
        {
            y -= velocity;
        }

        if (keyHandler.downPressed)
        {
            y += velocity;
        }

        if (keyHandler.rightPressed)
        {
            x += velocity;
        }

        if (keyHandler.leftPressed)
        {
            x -= velocity;
        }
    }

    public void render(Graphics2D g)
    {
        g.drawImage(sprite, x, y, Constants.SPRITE_SCALED_SIZE, Constants.SPRITE_SCALED_SIZE, null);
    }
}
