package com.game.client;

import com.game.client.entity.Player;
import com.game.client.input.KeyHandler;
import com.game.client.input.MouseHandler;
import com.game.client.map.TileManager;
import com.game.util.Constants;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Client implements Runnable
{
    private final Canvas canvas;
    private final KeyHandler keyHandler;
    private final MouseHandler mouseHandler;

    private Thread thread = null;
    private boolean running = false;

    // --
    private final BufferedImage image = new BufferedImage(Constants.WIDTH, Constants.HEIGHT, BufferedImage.TYPE_INT_RGB);
    private final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    // --

    private TileManager tileManager = null;
    private Player player = null;

    public Client()
    {
        this.canvas = new Canvas();
        this.keyHandler = new KeyHandler(this);
        this.mouseHandler = new MouseHandler(this);
        init();

        tileManager = new TileManager(this);
        player = new Player(this);
    }

    private synchronized void init()
    {
        Dimension dimension = new Dimension(Constants.WIDTH, Constants.HEIGHT);

        canvas.setFocusable(true);
        canvas.setMinimumSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setPreferredSize(dimension);

        // Listeners
        canvas.addKeyListener(keyHandler);
        canvas.addMouseListener(mouseHandler);

        JFrame frame = new JFrame();
        frame.setTitle(Constants.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected synchronized void startUp()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    protected synchronized void shutDown()
    {
        try
        {
            thread.join();
            running = false;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public void run()
    {
        long last = System.nanoTime();
        long timer = System.currentTimeMillis();
        double numSeconds = 1_000_000_000.0 / 60.0;
        double delta = 0;
        int ticks = 0;
        int frames = 0;

        while (running)
        {
            long curr = System.nanoTime();
            delta += (curr - last) / numSeconds;
            last = curr;

            while (delta >= 1)
            {
                update();
                ticks++;
                delta--;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;

                System.out.println("TPS: " + ticks + ", FPS: " + frames);

                frames = 0;
                ticks = 0;
            }
        }

        shutDown();
    }

    private void update()
    {
        tileManager.update();
        player.update();
    }

    private void render()
    {
        BufferStrategy bs = canvas.getBufferStrategy();

        if (bs == null)
        {
            canvas.createBufferStrategy(3);
            canvas.requestFocus();
            return;
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();

        g.clearRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        tileManager.render(g);
        player.render(g);

        g.dispose();
        bs.show();
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public KeyHandler getKeyHandler()
    {
        return keyHandler;
    }

    public MouseHandler getMouseHandler()
    {
        return mouseHandler;
    }

    public Thread getThread()
    {
        return thread;
    }

    public boolean isRunning()
    {
        return running;
    }
}
