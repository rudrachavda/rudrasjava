import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
   private JButton button;
   private JPanel panel;

   public MainWindow() {
      setSize(400, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      panel = new JPanel(new FlowLayout());
      button = new JButton("Go to next page");
      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            NextPage nextPage = new NextPage();
            nextPage.setVisible(true);
         }
      });
      panel.add(button);

      add(panel);
   }

   public static void main(String[] args) {
      MainWindow mainWindow = new MainWindow();
      mainWindow.setVisible(true);
   }
}

class NextPage extends JFrame {
   public NextPage() {
      setSize(400, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setBackground(Color.RED);
   }
}
