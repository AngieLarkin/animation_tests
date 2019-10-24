import javax.swing.*;
import java.awt.*;

/* . This is the easiest but also the least effective way of animating objects in Java games. */
public class SwingTimerEx extends JFrame {
    public SwingTimerEx() {
        initUI();
    }

    private void initUI(){

        add(new Board());

        setResizable(false);
        pack();

        setTitle("star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public static void main(String[] args) {
            EventQueue.invokeLater(() -> {
                SwingTimerEx ex = new SwingTimerEx();
                ex.setVisible(true);
            });
        }


}
