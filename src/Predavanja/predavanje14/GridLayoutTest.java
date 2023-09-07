package Predavanja.predavanje14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MojPoslusalec implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int ok = JOptionPane.showConfirmDialog(null, "Želiš končati?");
        if(ok == JOptionPane.YES_OPTION) System.exit(0);
    }
}
public class GridLayoutTest {
    public static void main(String[] args) {
        JFrame okno = new JFrame();
        okno.setSize(300,300);
        okno.setLocation(400,400);
        okno.setTitle("GridBagLayout test");

        JLabel imeL          = new JLabel("Ime:");
        JLabel priimekL      = new JLabel("Priimek:");
        JTextField imeTF     = new JTextField();
        JTextField priimekTF = new JTextField();
        JTextArea vpisTA     = new JTextArea();
        JButton okB          = new JButton("OK");
        JButton cancelB      = new JButton("Cancel");
        JButton helpB        = new JButton("Help");

        JPanel gumbiP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        gumbiP.add(okB);gumbiP.add(helpB);gumbiP.add(cancelB);

        okno.setLayout(new GridBagLayout());

        GridBagConstraints gbc;

        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbc.anchor = GridBagConstraints.EAST;
        okno.add(imeL, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbc.anchor = GridBagConstraints.EAST;
        okno.add(priimekL, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1;
        gbc.insets = new Insets(5, 5, 0, 5);
        okno.add(imeTF, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1;
        gbc.insets = new Insets(5, 5, 0, 5);
        okno.add(priimekTF, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.gridwidth=2;
        gbc.insets = new Insets(5, 5, 0, 5);
        okno.add(vpisTA, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1;
        gbc.insets = new Insets(5, 5, 5, 5);
        okno.add(gumbiP, gbc);


        okB.addActionListener(new MojPoslusalec());

        cancelB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vpisTA.setText(imeTF.getText().toUpperCase());
            }
        });

        vpisTA.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                vpisTA.setText(x + "," + y);
            }
        });

        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }
}

