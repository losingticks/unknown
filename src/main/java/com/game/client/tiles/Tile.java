package com.game.client.tiles;

import com.game.client.gfx.Sprite;
import com.game.client.math.Point2D;
import java.awt.Dimension;

public class Tile
{
    private final Sprite sprite;
    private Dimension size = null;
    private Point2D position = null;

    public Tile(Sprite sprite)
    {
        this.sprite = sprite;
    }

    public Sprite getSprite()
    {
        return sprite;
    }

    public Dimension getSize()
    {
        return size;
    }

    public void setSize(Dimension size)
    {
        this.size = size;
    }

    public Point2D getPosition()
    {
        return position;
    }

    public void setPosition(Point2D position)
    {
        this.position = position;
    }
}
