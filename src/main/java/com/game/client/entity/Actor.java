package com.game.client.entity;

import com.game.client.math.Vector2f;

public abstract class Actor implements Renderable
{
    protected Vector2f position;
    protected float radius;
    protected float velocity;

    public Actor(Vector2f position, float radius, float velocity)
    {
        this.position = position;
        this.radius = radius;
        this.velocity = velocity;
    }

    public Vector2f getPosition()
    {
        return position;
    }

    public float getRadius()
    {
        return radius;
    }

    public float getVelocity()
    {
        return velocity;
    }

    public abstract int getX();
    public abstract int getY();
}