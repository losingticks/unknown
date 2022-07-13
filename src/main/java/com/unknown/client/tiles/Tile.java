package com.unknown.client.tiles;

import com.unknown.client.graphics.Sprite;
import com.unknown.client.math.Vector2i;
import java.awt.Dimension;

public class Tile
{
    private final Sprite sprite;
    private Dimension size = null;
    private Vector2i position = null;

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

    public Vector2i getPosition()
    {
        return position;
    }

    public void setPosition(Vector2i position)
    {
        this.position = position;
    }
}
