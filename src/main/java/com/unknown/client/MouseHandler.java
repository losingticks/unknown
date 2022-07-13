package com.unknown.client;

import com.unknown.client.main.Client;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public final class MouseHandler extends MouseAdapter
{
    private final Client client;

    private boolean mousePressed = false;
    private boolean mouseDragged = false;
    private int mouseButton = -1;
    private float x = -1.0f;
    private float y = -1.0f;
    private float dx = -1.0f;
    private float dy = -1.0f;

    public MouseHandler(Client client)
    {
        this.client = client;
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        mousePressed = true;
        mouseButton = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        mousePressed = false;
        mouseDragged = false;
        dx = 0;
        dy = 0;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        // TODO: fully implement

        int rot = e.getWheelRotation();

        if (rot < 0)
        {
            // Scrolling up
        }
        else
        {
            // Scrolling down
        }
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseDragged = true;
        dx = e.getX() - x;
        dy = e.getY() - y;
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
    }

    public boolean isMousePressed()
    {
        return mousePressed;
    }

    public boolean isMouseDragged()
    {
        return mouseDragged;
    }

    public int getMouseButton()
    {
        return mouseButton;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getDx()
    {
        return dx;
    }

    public float getDy()
    {
        return dy;
    }
}
