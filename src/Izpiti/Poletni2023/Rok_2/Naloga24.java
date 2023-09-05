package Izpiti.Poletni2023.Rok_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Nepreverljiva izjema
 */
class NapacnaVrednost extends  RuntimeException {
    public String getMessage() {
        return "Vpisana je bila napačna vrednost";
    }
}
public class Naloga24 {

    /**
     * Metoda za izračun fakultete, je rekurzivna
     * @param n - število
     * @return - vrne rezultat fakultete
     */
    public static int fakulteta(int n) {
        if(n <= 1) return 1;

        return n * fakulteta(n-1);
    }
    public static void main(String[] args) {

        JFrame okno = new JFrame("Računanje fakultete"); //Naslov okna
        okno.setLayout(new FlowLayout(FlowLayout.LEFT)); //Nastavimo kako bo elemente razporejal

        JLabel napis = new JLabel("n = ");
        final JTextField nTF = new JTextField(12); // vnesemo n

        JButton gumb = new JButton("Izračunaj n!");
        final JTextField fakultetaTF = new JTextField(12); //tukaj se izpiše rezultat fakultete

        gumb.addActionListener(new ActionListener() { //gumb logika
            @Override
            public void actionPerformed(ActionEvent e) {
                int stevilo;
                try {
                    stevilo = Integer.parseInt(nTF.getText()); //iz inputa spremenimo v int
                    fakultetaTF.setText(fakulteta(stevilo)+"");
                } catch (Exception ex) {
                    throw new NapacnaVrednost();
                }
            }
        });

        // Dodamo elemente
        okno.add(napis);
        okno.add(nTF);
        okno.add(gumb);
        okno.add(fakultetaTF);

        okno.pack();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }
}
