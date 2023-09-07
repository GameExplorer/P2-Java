package Predavanja.predavanje14;

import javax.swing.*;

public class XOkno {
    public static void main(String[] args) {
        JFrame okno = new JFrame();
        okno.setSize(300,300);
        okno.setLocation(400,400);
        okno.setTitle("Prvi GUI program");

        // okno.setResizable(false);

        JPanel panel = new JPanel();
        // panel.setBackground(Color.red);
        panel.setBorder(BorderFactory.createTitledBorder("Moj panel"));
        okno.add(panel);

        JButton okGumb = new JButton("OK");
        panel.add(okGumb);

        JButton cancelGumb = new JButton("Prekliči");
        panel.add(cancelGumb);

        okno.setVisible(true);
    }
}