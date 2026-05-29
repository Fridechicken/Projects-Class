import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class Cube_game
{
    private JFrame frame;
    private JPanel mainPanel;
    private Timer timer;
    private static Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA};
    private static int colorIndex = 0;

    // Coordinates of the player
    private int xpos;
    private int ypos;
    
    // Lists of coordinates of each of the randomly appearing blocks
    private List<Integer> blockX;
    private List<Integer> blockY;

    public Cube_game()
    {
        frame = new JFrame("Box Avoider");
        mainPanel = new DrawingPanel(400, 400);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        initialize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Cube_game();
            }
        });
    }

    private void initialize()
    {
        xpos = ypos = 0;
        blockX = new ArrayList<Integer>();
        blockY = new ArrayList<Integer>();
        
        timer = new Timer(1, new TimerHandler());//changed update time to 1 ms 
        timer.start();
        mainPanel.setFocusable(true);
    }

    private class TimerHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Every 1 ms this is called to randomly add another box onto the screen.
            Random random = new Random();
            int x = random.nextInt(mainPanel.getWidth()-10);
            int y = random.nextInt(mainPanel.getHeight()-10);
            
            blockX.add(x);
            blockY.add(y);
            mainPanel.repaint();
        }    
    }
    
    private class DrawingPanel extends JPanel implements KeyListener
    {
        public DrawingPanel(int width, int height)
        {
            super();
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(width, height));
            addKeyListener(this);
        }

        @Override
        public void paintComponent(Graphics g)
        {
            // Draws the player and the random red blocks
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillRect(xpos, ypos, 10, 10);
            colorIndex = (colorIndex + 1) % colors.length;
            g.setColor(colors[colorIndex]); //chnaged so the colors cycle through diferent colors
            for (int i=0; i<blockX.size(); i++)
                g.fillRect(blockX.get(i), blockY.get(i), 10, 10);
            
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            // The arrow keys move the player around.
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT)
                xpos -= 2;
            else if (key == KeyEvent.VK_RIGHT)
                xpos += 2;
            else if (key == KeyEvent.VK_UP)
                ypos -= 2;
            else if (key == KeyEvent.VK_DOWN)
                ypos += 2;
            //Added movement keys to also work for WASD
            else if (key == KeyEvent.VK_A)
                xpos -= 2;
            else if (key == KeyEvent.VK_D)
                xpos += 2;
            else if (key == KeyEvent.VK_W)
                ypos -= 2;
            else if (key == KeyEvent.VK_S)
                ypos += 2;
            //Added space button to be a cheat button
            else if (key == KeyEvent.VK_SPACE) {
                xpos += 50;
                ypos += 50;
            }
            // Loop through the boxes and check to see if we've crashed into anything.
            for (int i=0; i<blockX.size(); i++)
            {
                int x = blockX.get(i);
                int y = blockY.get(i);
                
                if (((xpos+10>=x && xpos+10<=x+10) || (xpos>=x && xpos<=x+10)) &&
                    ((ypos+10>=y && ypos+10<=y+10) || (ypos>=y && ypos<=y+10)))
                {
                    timer.stop();
                    JOptionPane.showMessageDialog(new JFrame(), "You lose");
                    System.exit(0);
                }
            }
            
            // Player wins if they get to bottom right corner.
            if (xpos>=this.getWidth()-10 && ypos>=this.getHeight()-10)
            {
                timer.stop();
                JOptionPane.showMessageDialog(new JFrame(), "You win!");
                System.exit(0);
            }
                    
            this.repaint();
        }

        @Override public void keyReleased(KeyEvent e) {}
        @Override public void keyTyped(KeyEvent e) {}
    }
}