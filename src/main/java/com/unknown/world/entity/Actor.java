package com.unknown.world.entity;

import com.unknown.client.math.Vector2f;
import java.awt.Graphics2D;

public abstract class Actor
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

    public abstract void update();
    public abstract void render(Graphics2D g);
}