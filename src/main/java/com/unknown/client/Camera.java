package com.unknown.client;

import com.unknown.client.math.Vector2f;
import java.awt.Rectangle;

public final class Camera
{
    private Vector2f position = null;
    private Rectangle bounds = null;

    public Camera(Vector2f position, Rectangle bounds)
    {
        this.position = position;
        this.bounds = bounds;
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
            int x = Math.max(bounds.x, Math.min((int) position.getX(), bounds.width));
            int y = Math.max(bounds.y, Math.min((int) position.getY(), bounds.height));
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