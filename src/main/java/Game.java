import input.KeyHandler;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1L;

    public static final String NAME = "2D Game";
    public static final int SIZE = 16;
    public static final int SCALE = 3;
    public static final int TILE_SIZE = SIZE * 3;
    public static final int WIDTH = TILE_SIZE * 16;
    public static final int HEIGHT = TILE_SIZE * 12;

    private Thread gameThread;
    private boolean running = false;

    private final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private KeyHandler keyHandler = new KeyHandler();
    private int x = 0;
    private int y = 0;
    private int velocity = 4;

    private Game()
    {
        setFocusable(true);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        addKeyListener(keyHandler);
    }

    public synchronized void start()
    {
        gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }

    public synchronized void stop()
    {
        try
        {
            gameThread.join();
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            running = false;
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
                tick();
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

        stop();
    }

    public void tick()
    {
        if (keyHandler.upPressed)
        {
            y -= velocity;
        }

        if (keyHandler.downPressed)
        {
            y += velocity;
        }

        if (keyHandler.rightPressed)
        {
            x += velocity;
        }

        if (keyHandler.leftPressed)
        {
            x -= velocity;
        }
    }

    public void render()
    {
        BufferStrategy bs = getBufferStrategy();

        if (bs == null)
        {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        g.setColor(Color.WHITE);
        g.drawRect(x, y, TILE_SIZE, TILE_SIZE);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args)
    {
        Game game = new Game();

        JFrame frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
}
