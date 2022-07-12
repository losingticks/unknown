package com.game.client.entity;

import com.game.client.Client;
import com.game.client.input.KeyHandler;
import com.game.client.math.Vector2f;
import com.game.util.Constants;
import com.game.util.Direction;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class LocalPlayer extends Actor
{
    private static final Vector2f CENTER = new Vector2f(
            (float) (Constants.WIDTH / 2) - (float) (Constants.SPRITE_SCALED_SIZE / 2),
            (float) (Constants.HEIGHT / 2) - (float) (Constants.SPRITE_SCALED_SIZE / 2)
    );

    private final Client client;

    public Camera camera;
    private Direction direction = Direction.SOUTH;

    public LocalPlayer(Client client)
    {
        super(CENTER, 1.0f, 1.0f);
        this.client = client;

        camera = new Camera(CENTER);
        camera.setBounds(new Rectangle(0, 0, 30*64-Constants.WIDTH, 30*64-Constants.HEIGHT));
    }

    @Override
    public int getX()
    {
        return (int) position.getX();
    }

    @Override
    public int getY()
    {
        return (int) position.getY();
    }

    @Override
    public void update()
    {
        KeyHandler keyHandler = client.getKeyHandler();

        Vector2f vec = new Vector2f(0.0f, 0.0f);

        if (keyHandler.upPressed)
        {
            vec = vec.add(new Vector2f(0, -1));
        }
        if (keyHandler.downPressed)
        {
            vec = vec.add(new Vector2f(0, 1));
        }
        if (keyHandler.rightPressed)
        {
            vec = vec.add(new Vector2f(1 ,0));
        }
        if (keyHandler.leftPressed)
        {
            vec = vec.add(new Vector2f(-1, 0));
        }

        float dist = (float) velocity * 12;
        position = position.add(vec.normalized().mul(dist));
        position = Vector2f.max(new Vector2f(0, 0), Vector2f.min(position, new Vector2f(30*64-64, 30*64-64)));

        int cx = (getX() + Constants.SPRITE_SCALED_SIZE / 2) - Constants.WIDTH / 2;
        int cy = (getY() + Constants.SPRITE_SCALED_SIZE / 2) - Constants.HEIGHT / 2;
        camera.setPosition(new Vector2f(cx, cy));
    }

    @Override
    public void render(Graphics2D g)
    {
        Vector2f v = position.sub(camera.getPosition());
        g.setColor(Color.MAGENTA);
        g.fillRect((int) v.getX(), (int) v.getY(), Constants.SPRITE_SCALED_SIZE, Constants.SPRITE_SCALED_SIZE);
    }
}