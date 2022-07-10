package com.game.client.math;

public class Point2D implements Point<Point2D>
{
    public final static Point2D ZERO = new Point2D(0, 0);
    public final static Point2D X = new Point2D(1, 0);
    public final static Point2D Y = new Point2D(0, 1);

    public int x = -1;
    public int y = -1;

    public Point2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D p)
    {
        this(p.x, p.y);
    }

    @Override
    public Point2D set(int x, int y)
    {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public Point2D set(Point2D p)
    {
        return set(p.x, p.y);
    }

    @Override
    public Point2D add(int x, int y)
    {
        this.x += x;
        this.y += y;
        return this;
    }

    @Override
    public Point2D add(Point2D p)
    {
        return add(p.x, p.y);
    }

    @Override
    public Point2D sub(int x, int y)
    {
        this.x -= x;
        this.y -= y;
        return this;
    }

    @Override
    public Point2D sub(Point2D p)
    {
        return sub(p.x, p.y);
    }

    @Override
    public Point2D mul(int x, int y)
    {
        this.x *= x;
        this.y *= y;
        return this;
    }

    @Override
    public Point2D mul(Point2D p)
    {
        return mul(p.x, p.y);
    }

    @Override
    public Point2D div(int x, int y)
    {
        this.x /= x;
        this.y /= y;
        return this;
    }

    @Override
    public Point2D div(Point2D p)
    {
        return div(p.x, p.y);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || o.getClass() != this.getClass())
        {
            return false;
        }
        else if (this == o)
        {
            return true;
        }

        Point2D point = (Point2D) o;
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode()
    {
        final int prime = 53;
        int result = 1;
        result = prime * result * this.x;
        result = prime * result * this.y;
        return result;
    }
}
