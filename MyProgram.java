import javax.swing.*;
import java.awt.event.*;

public class MyProgram {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Program");
        JLabel label = new JLabel("Click here to open the calculator:");
        JButton button = new JButton("Open Calculator");
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Enter an equation:");
                
                if (input != null && !input.isEmpty()) {
                    String[] parts = input.split("[+-]");
                    if (parts.length == 2) {
                        int num1 = Integer.parseInt(parts[0]);
                        int num2 = Integer.parseInt(parts[1]);
                        int result = 0;
                        
                        if (input.contains("+")) {
                            result = num1 + num2;
                        } else if (input.contains("-")) {
                            result = num1 - num2;
                        }
                        
                        JOptionPane.showMessageDialog(null, "Result: " + result);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input!");
                    }
                }
            }
        });
        
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                button.doClick();
            }
        });
        
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
