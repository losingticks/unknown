package com.game.client.math;

public class Vector2D implements Vector<Vector2D>
{
    public static final Vector2D ZERO = new Vector2D(0, 0);
    public static final Vector2D X = new Vector2D(1, 0);
    public static final Vector2D Y = new Vector2D(0, 1);

    public float x = -1;
    public float y = -1;

    public Vector2D(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D v)
    {
        this(v.x, v.y);
    }
}