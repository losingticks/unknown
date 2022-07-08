package com.game.client.entity;

import java.awt.Graphics2D;

public interface Renderable
{
    void update();
    void render(Graphics2D g);
}