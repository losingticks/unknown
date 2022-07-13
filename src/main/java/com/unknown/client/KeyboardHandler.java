package com.unknown.client;

import com.unknown.client.main.Client;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class KeyboardHandler extends KeyAdapter
{
    private final Client client;

    // this implementation is just temporary
    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean rightPressed = false;
    public boolean leftPressed = false;
    public boolean shiftPressed = false;

    public KeyboardHandler(Client client)
    {
        this.client = client;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W)
        {
            upPressed = true;
        }

        if (code == KeyEvent.VK_S)
        {
            downPressed = true;
        }

        if (code == KeyEvent.VK_D)
        {
            rightPressed = true;
        }

        if (code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_SHIFT)
        {
            shiftPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W)
        {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S)
        {
            downPressed = false;
        }

        if (code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }

        if (code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_SHIFT)
        {
            shiftPressed = false;
        }
    }
}
