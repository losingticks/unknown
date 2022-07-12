package com.game.client.tiles;

import com.game.client.gfx.SpriteSheet;
import com.game.client.math.Vector2i;
import com.game.util.Constants;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class TileManager
{
    private static TileManager INSTANCE = null;

    public static TileManager getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new TileManager();
        }

        return INSTANCE;
    }

    public final SpriteSheet spriteSheet;
    public final List<Tile> tiles = new ArrayList<>();

    private final int SIZE = 30;

    private TileManager()
    {
        spriteSheet = SpriteSheet.load("../tiles.png");
        loadMap("../../testmap.txt");
    }

    public void loadMap(String path)
    {
        try (InputStream is = TileManager.class.getResourceAsStream(path))
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int y = 0; y < SIZE; y++)
            {
                String line = br.readLine();
                String[] chars = line.split(" ");

                for (int x = 0; x < SIZE; x++)
                {
                    int tileType = Integer.parseInt(chars[x]);
                    int screenX = x * Constants.SPRITE_SCALED_SIZE;
                    int screenY = y * Constants.SPRITE_SCALED_SIZE;

                    Tile tile = new Tile(spriteSheet.getSprite(tileType, 0));
                    tile.setSize(new Dimension(Constants.SPRITE_SCALED_SIZE, Constants.SPRITE_SCALED_SIZE));
                    tile.setPosition(new Vector2i(screenX, screenY));
                    add(tile);
                }
            }
        }
        catch (IOException | NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized boolean add(Tile tile)
    {
        if (tile == null || tiles.contains(tile))
        {
            return false;
        }

        boolean added = tiles.add(tile);
        return added;
    }

    public synchronized boolean remove(Tile tile)
    {
        if (tile == null)
        {
            return false;
        }

        boolean removed = tiles.remove(tile);
        return removed;
    }

    public synchronized boolean removeIf(Predicate<Tile> filter)
    {
        if (filter == null)
        {
            return false;
        }

        boolean removed = tiles.removeIf(filter);
        return removed;
    }

    public synchronized void clear()
    {
        tiles.clear();
    }

    public synchronized void forEachTile(Consumer<Tile> action)
    {
        if (action != null)
        {
            for (Tile tile : tiles)
            {
                action.accept(tile);
            }
        }
    }
}
