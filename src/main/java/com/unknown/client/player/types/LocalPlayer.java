package com.unknown.client.player.types;

import com.unknown.client.Camera;
import com.unknown.client.KeyboardHandler;
import com.unknown.client.main.Client;
import com.unknown.client.math.Vector2f;
import com.unknown.util.Constants;
import com.unknown.util.Direction;
import com.unknown.world.entity.Actor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class LocalPlayer extends Actor
{
    private final Client client;

    public final Camera camera;

    private Direction direction = Direction.SOUTH;

    public LocalPlayer(Client client, Vector2f initial)
    {
        super(initial, 1.0f, 1.0f);
        this.client = client;

        this.camera = new Camera(initial, new Rectangle(0, 0, 30 * 64 - Constants.WIDTH, 30 * 64 - Constants.HEIGHT));
    }

    public LocalPlayer(Client client)
    {
        this(client, new Vector2f((float) (Constants.WIDTH / 2) - (float) (Constants.SPRITE_SCALED_SIZE / 2), (float) (Constants.HEIGHT / 2) - (float) (Constants.SPRITE_SCALED_SIZE / 2)));
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
        KeyboardHandler keyHandler = client.getKeyboardHandler();

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

        float dist = (float) velocity * 16;
        position = position.add(vec.normalized().mul(dist));
        position = Vector2f.max(new Vector2f(0, 0), Vector2f.min(position, new Vector2f(30*64-64, 30*64-64)));

        updateCameraPosition();
    }

    @Override
    public void render(Graphics2D g)
    {
        Vector2f v = position.sub(camera.getPosition());
        g.setColor(Color.MAGENTA);
        g.fillRect((int) v.getX(), (int) v.getY(), Constants.SPRITE_SCALED_SIZE, Constants.SPRITE_SCALED_SIZE);
    }

    private void updateCameraPosition()
    {
        int size = Constants.SPRITE_SCALED_SIZE / 2;
        Vector2f position = new Vector2f(
                getX() + size - Constants.WIDTH_HALF,
                getY() + size - Constants.HEIGHT_HALF
        );
        camera.setPosition(position);
    }
}