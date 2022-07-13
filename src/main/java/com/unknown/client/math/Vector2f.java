package com.unknown.client.math;

public class Vector2f implements Vector<Vector2f>
{
    private final float x;
    private final float y;

    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2f(Vector2f v)
    {
        this(v.x, v.y);
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    @Override
    public Vector2f add(Vector2f other)
    {
        return other == null ? this : new Vector2f(x + other.x, y + other.y);
    }

    @Override
    public Vector2f sub(Vector2f other)
    {
        return other == null ? this : new Vector2f(x - other.x, y - other.y);
    }

    @Override
    public Vector2f mul(Vector2f other)
    {
        return other == null ? this : new Vector2f(x * other.x, y * other.y);
    }

    @Override
    public Vector2f div(Vector2f other)
    {
        return other == null ? this : new Vector2f(x / other.x, y / other.y);
    }

    //--
    public Vector2f mul(float f)
    {
        return new Vector2f(x * f, y * f);
    }

    public float magnitude()
    {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2f normalized()
    {
        float m = magnitude();

        if (m == 0)
        {
            return new Vector2f(x, y);
        }

        return new Vector2f(x / m, y / m);
    }
    //--

    public Vector2i asVector2i()
    {
        return new Vector2i((int) x, (int) y);
    }

    public static Vector2f min(Vector2f a, Vector2f b)
    {
        float x = Math.min(a.x, b.x);
        float y = Math.min(a.y, b.y);
        return new Vector2f(x, y);
    }

    public static Vector2f max(Vector2f a, Vector2f b)
    {
        float x = Math.max(a.x, b.x);
        float y = Math.max(a.y, b.y);
        return new Vector2f(x, y);
    }
}