package com.unknown.client.math;

public class Vector2i implements Vector<Vector2i>
{
    private final int x;
    private final int y;

    public Vector2i(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2i(Vector2i v)
    {
        this(v.x, v.y);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public Vector2i add(Vector2i other)
    {
        return other == null ? this : new Vector2i(x + other.x, y + other.y);
    }

    @Override
    public Vector2i sub(Vector2i other)
    {
        return other == null ? this : new Vector2i(x - other.x, y - other.y);
    }

    @Override
    public Vector2i mul(Vector2i other)
    {
        return other == null ? this : new Vector2i(x * other.x, y * other.y);
    }

    @Override
    public Vector2i div(Vector2i other)
    {
        return other == null ? this : new Vector2i(x / other.x, y / other.y);
    }

    public Vector2f asVector2f()
    {
        return new Vector2f(x, y);
    }

    public static Vector2i min(Vector2i a, Vector2i b)
    {
        int x = Math.min(a.x, b.x);
        int y = Math.min(a.y, b.y);
        return new Vector2i(x, y);
    }

    public static Vector2i max(Vector2i a, Vector2i b)
    {
        int x = Math.max(a.x, b.x);
        int y = Math.max(a.y, b.y);
        return new Vector2i(x, y);
    }
}
