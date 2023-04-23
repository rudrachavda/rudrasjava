import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CircleUI extends JPanel {
    private int x = 0;
    private int y = 0;

    public CircleUI() {
        Timer timer = new Timer(50, new TimerListener());
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            x += 5;
            y += 5;
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CircleUI());
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
