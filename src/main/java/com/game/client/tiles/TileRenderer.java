package com.game.client.tiles;

import com.game.client.Client;
import com.game.client.entity.LocalPlayer;
import com.game.client.gfx.Sprite;
import com.game.client.math.Vector2f;
import com.game.client.math.Vector2i;
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
        LocalPlayer player = client.player;

        for (Tile tile : tiles)
        {
            Sprite sprite = tile.getSprite();
            Dimension preferredSize = tile.getSize();
            Vector2i preferredLocation = tile.getPosition();

            Vector2f v = client.player.camera.getPosition();
            float x = v.getX();
            float y = v.getY();

            g.drawImage(sprite.asBufferedImage(), preferredLocation.getX() - (int) x, preferredLocation.getY() - (int) y, preferredSize.width, preferredSize.height, null);
        }
    }
}
