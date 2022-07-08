package com.game.client.input;

import com.game.client.Client;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class KeyHandler extends KeyAdapter
{
    private final Client client;
    private final ClipboardManager clipboardManager;

    // this implementation is just temporary
    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean rightPressed = false;
    public boolean leftPressed = false;
    public boolean shiftPressed = false;

    public KeyHandler(Client client)
    {
        this.client = client;
        this.clipboardManager = new ClipboardManager();
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
