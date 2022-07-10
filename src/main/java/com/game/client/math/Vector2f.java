package com.game.client.math;

public class Vector2f
{
    private float x;
    private float y;

    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void set(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2f src)
    {
        if (src == null)
        {
            return;
        }

        this.x = src.getX();
        this.y = src.getY();
    }
}