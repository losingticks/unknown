package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class KeyHandler extends KeyAdapter
{
    // this implementation is just temporary
    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean rightPressed = false;
    public boolean leftPressed = false;

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
    }
}
