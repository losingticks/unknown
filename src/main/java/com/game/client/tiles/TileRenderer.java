package com.game.client.tiles;

import com.game.client.Client;
import com.game.client.gfx.Sprite;
import com.game.client.math.Point2D;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Collection;

public class TileRenderer
{
    private final Client client;

    public TileRenderer(Client client)
    {
        this.client = client;
    }

    public void render(Graphics2D g, Collection<Tile> tiles)
    {
        for (Tile tile : tiles)
        {
            Sprite sprite = tile.getSprite();
            Dimension preferredSize = tile.getSize();
            Point2D preferredLocation = tile.getPosition();
            g.drawImage(sprite.asBufferedImage(), preferredLocation.x, preferredLocation.y, preferredSize.width, preferredSize.height, null);
        }
    }
}
