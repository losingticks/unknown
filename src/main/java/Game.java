import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{
    public static final String NAME = "2D Game";
    public static final int WIDTH = 352 * 2;
    public static final int HEIGHT = 224 * 2;

    public void start()
    {

    }

    public void stop()
    {

    }

    @Override
    public void run()
    {

    }

    public static void main(String[] args)
    {
        Game game = new Game();
        game.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        game.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        JFrame frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
