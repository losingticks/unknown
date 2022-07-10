package com.game.client.entity;

import com.game.client.gfx.SpriteSheet;
import com.game.client.math.Vector2f;
import com.game.util.Direction;

public abstract class Actor implements Renderable
{
    protected final SpriteSheet spriteSheet;
    protected int spriteX = 0;
    protected int spriteY = 0;

    protected Vector2f position = new Vector2f(0.0f, 0.0f);
    protected float velocity = 4.0f;
    protected Direction direction = Direction.SOUTH;

    public Actor(SpriteSheet spriteSheet)
    {
        this.spriteSheet = spriteSheet;
    }
}