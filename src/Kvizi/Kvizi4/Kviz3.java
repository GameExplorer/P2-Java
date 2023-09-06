package Kvizi.Kvizi4;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Vržemo to izjemo takrat ko se stavek ne konča z eno od izjem
 */
class IzjemaManjkajocegaLocila extends RuntimeException {
    IzjemaManjkajocegaLocila() {
        super();
    }

    public String getMessage() {
        return "Izjema manjkajocega locila";
    }
}
public class Kviz3 {
    public static void statistikaStavkov(String imeDatoteke) throws IzjemaManjkajocegaLocila {
        try (Scanner vhod = new Scanner(new File(imeDatoteke))) {

            TreeMap<Integer, Integer> frekvence = new TreeMap<>();
            int trenutnaFrekvenca = 0;
            while(vhod.hasNext()) {
                String beseda = vhod.next();
                trenutnaFrekvenca++;
                if(beseda.contains(".") || beseda.contains("!") || beseda.contains("?")) { //če vsebuje eno od ločil
                    if(frekvence.containsKey(trenutnaFrekvenca)) {
                        frekvence.replace(trenutnaFrekvenca, frekvence.get(trenutnaFrekvenca) + 1); //zamenjaš frekvenci
                    }
                    else {
                        frekvence.put(trenutnaFrekvenca, 1);
                    }
                    trenutnaFrekvenca = 0;
                }
                else if(!vhod.hasNext()) { //stavek se ne konča z eno izmed ločil
                    throw new IzjemaManjkajocegaLocila();
                }
            }

            //Sprehod po podatkih in izpis podatkov
            for(Map.Entry<Integer, Integer> podatki : frekvence.entrySet()) {
                System.out.printf("Stavki dolzine %d se pojavijo: %dx.", podatki.getKey(), podatki.getValue());
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Napaka pri branju datoteke: " + e);
        }
    }
    public static void main(String[] args) {
        statistikaStavkov("src/Kvizi/viri/besedilo2.txt");
    }
}
