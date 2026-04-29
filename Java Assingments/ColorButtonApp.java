import java.awt.*;
import javax.swing.*;
public class ColorButtonApp {
    private static Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA};
    private static int colorIndex = 0;
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Color Button App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        JButton button = new JButton("Click Me!"){
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        button.setBackground(colors[colorIndex]);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.addActionListener(e -> {
            colorIndex = (colorIndex + 1) % colors.length;
            button.setBackground(colors[colorIndex]);
        });
        frame.add(button, new GridBagConstraints());
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorButtonApp::createAndShowGUI);
    }
}
