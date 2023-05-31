package predavanje14;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest {
    public static void main(String[] args) {
        JFrame okno = new JFrame();
        okno.setSize(300,300);
        okno.setLocation(400,400);
        okno.setTitle("BorderLayoutTest");

        // okno je razporejeno z BorderLayout
        JButton gumb1 = new JButton("prvi");
        JButton gumb2 = new JButton("drugi");
        JButton gumb3 = new JButton("tretji");

        gumb1.setPreferredSize(new Dimension(50,50));

        okno.add(gumb1, BorderLayout.PAGE_START);
        okno.add(gumb2, BorderLayout.PAGE_END);
        okno.add(gumb3, BorderLayout.LINE_START);

        JTextArea jta = new JTextArea();
        okno.add(jta);

        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //zapre program
        okno.setVisible(true);
    }
}
