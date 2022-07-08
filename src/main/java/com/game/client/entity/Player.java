package com.game.client.entity;

import com.game.client.Client;
import com.game.client.gfx.Sprite;
import com.game.client.gfx.SpriteSheet;
import com.game.client.input.KeyHandler;
import com.game.util.Constants;
import com.game.util.Direction;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Player implements Renderable
{
    private final Client client;

    private List<Sprite> sprites = new ArrayList<>();
    private int x = 0;
    private int y = 0;
    private int velocity = 4;
    private Direction facing = Direction.SOUTH;

    public Player(Client client)
    {
        this.client = client;

        SpriteSheet spriteSheet = SpriteSheet.loadSpriteSheet("char_sheet.png");
        List<Sprite> sprites = spriteSheet.getSprites();

        Sprite facingSouth = sprites.get(0);
        Sprite facingWest = sprites.get(1);
        Sprite facingEast = new Sprite(facingWest.flip(true, false));
        Sprite facingNorth = sprites.get(2);
        this.sprites.add(facingNorth);
        this.sprites.add(facingEast);
        this.sprites.add(facingSouth);
        this.sprites.add(facingWest);
    }

    @Override
    public void update()
    {
        KeyHandler keyHandler = client.getKeyHandler();

        if (keyHandler.upPressed)
        {
            y -= velocity;
            facing = Direction.NORTH;
        }

        if (keyHandler.downPressed)
        {
            y += velocity;
            facing = Direction.SOUTH;
        }

        if (keyHandler.rightPressed)
        {
            x += velocity;
            facing = Direction.EAST;
        }

        if (keyHandler.leftPressed)
        {
            x -= velocity;
            facing = Direction.WEST;
        }
    }

    @Override
    public void render(Graphics2D g)
    {
        int idx = facing.getId() - 1;
        Sprite sprite = sprites.get(idx);
        BufferedImage img = sprite.asBufferedImage();

        g.drawImage(img, x, y, Constants.SPRITE_SCALED_SIZE, Constants.SPRITE_SCALED_SIZE, null);
    }
}
