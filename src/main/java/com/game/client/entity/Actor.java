package com.game.client.entity;

import com.game.client.gfx.SpriteSheet;
import com.game.client.math.Point2D;
import com.game.client.math.Vector2D;
import com.game.util.Direction;

public abstract class Actor implements Renderable
{
    protected final SpriteSheet spriteSheet;
    protected int spriteX = 0;
    protected int spriteY = 0;

    protected Point2D position = new Point2D(0, 0);
    protected int velocity = 4;
    protected Direction direction = Direction.SOUTH;

    public Actor(SpriteSheet spriteSheet)
    {
        this.spriteSheet = spriteSheet;
    }
}