package com.game.client.entity;

import com.game.client.math.Vector2f;
import java.awt.Rectangle;

public class Camera
{
    private Vector2f position = null;
    private Rectangle bounds = new Rectangle();

    public Camera(Vector2f position)
    {
        this.position = position;
    }

    public Vector2f getPosition()
    {
        return position;
    }

    public void setPosition(Vector2f position)
    {
        if (position == null)
        {
            return;
        }

        if (bounds != null)
        {
            float x = position.getX();
            float y = position.getY();

            if (x < bounds.x)
            {
                x = bounds.x;
            }
            if (x > bounds.width)
            {
                x = bounds.width;
            }
            if (y < bounds.y)
            {
                y = bounds.y;
            }
            if (y > bounds.height)
            {
                y = bounds.height;
            }

            this.position = new Vector2f(x, y);
            return;
        }

        this.position = position;
    }

    public Rectangle getBounds()
    {
        return bounds;
    }

    public void setBounds(Rectangle bounds)
    {
        this.bounds = bounds;
    }
}