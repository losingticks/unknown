package com.game.client.map;

import com.game.client.Client;
import com.game.client.gfx.Sprite;
import com.game.client.gfx.SpriteSheet;
import com.game.util.ImageLoader;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    public static final int MAP_SIZE = 11;
    public static final int MAP_WIDTH = MAP_SIZE;
    public static final int MAP_HEIGHT = MAP_SIZE;

    private final Client client;

    private SpriteSheet tileSheet = null;
    private int[][] tiles = new int[MAP_SIZE][MAP_SIZE];

    public TileManager(Client client)
    {
        this.client = client;
        tileSheet = SpriteSheet.load("../tiles.png");
        load();
    }

    private void load()
    {
        try
        {
            InputStream is = ImageLoader.class.getResourceAsStream("../testmap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int r = 0;
            int c = 0;

            while (r < MAP_SIZE && c < MAP_SIZE)
            {
                String line = br.readLine();
                String[] chars = line.split(" ");

                while (c < MAP_SIZE)
                {
                    int num = Integer.parseInt(chars[c]);
                    tiles[c][r] = num;
                    c++;
                }

                if (c == MAP_SIZE)
                {
                    c = 0;
                    r++;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void update()
    {

    }

    public void render(Graphics2D g)
    {
        for (int c = 0; c < MAP_SIZE; c++)
        {
            for (int r = 0; r < MAP_SIZE; r++)
            {
                int tile = tiles[c][r];
                Sprite sprite = tileSheet.getSprite(tile, 0);
                g.drawImage(sprite.asBufferedImage(), c * 64, r * 64, 64, 64, null);
            }
        }
    }
}
