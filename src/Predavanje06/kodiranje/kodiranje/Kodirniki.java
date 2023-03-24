package Predavanje06.kodiranje.kodiranje;

import org.apache.commons.codec.binary.Base64;

import java.util.Scanner;

/**
 * Razred z metodami za kodiranje in odkodiranje besedila
 */

public class Kodirniki {

    //Kodiranje z metodo XOR

    static String kodirajXOR(String vsebina, String kljuc){
        StringBuilder result = new StringBuilder();
        int dolzinaGesla = kljuc.length();

        for(int i = 0; i < vsebina.length(); i++) {
            /*
            i-ti znak besedila moramo zakodirati z i-tim znakom kljuca, ker je kljuc praviloma krajši
            od besedila, pri kljuci namesto charAt(i) uporabimo charAt(i % dolzinaGesla).
            Na ta način vsak znak kljuce večkrat ponovno uporabimo
             */
            char novZnak = (char) (vsebina.charAt(i) ^ kljuc.charAt(i % dolzinaGesla));
            result.append(novZnak);
        }
        return result.toString();
    }

    //dekodiranje z metodo XOR
    static String odKodirajXOR(String vsebina, String kljuc){
        return kodirajXOR(vsebina, kljuc); // isto vrne
    }

    /*
    Zakodira vsebino tako, da vsak znak spremeni v njegovo ASCII kodo
    Primer: "abc" -> "97 98 99"
     */
    static String kodirajNUM(String vsebina){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < vsebina.length(); i++) {
           int z = vsebina.charAt(i);
           if(!(result.toString().isEmpty())) {
               result.append(" ");
            }
           result.append(z);
        }
        return result.toString();
    }

    /*
    Odkodira vsebino tako, da vsako številko spremeni v znak
    Primer: "97 98 99" -> "abc"
     */
    static String OdKodirajNUM(String vsebina){
        StringBuilder result = new StringBuilder();
        Scanner sc = new Scanner(vsebina);
        while(sc.hasNextInt()) {
            int c = sc.nextInt();
            result.append((char) c);
        }
        return result.toString();
        //Skeniranje po nizu ni nevarno
    }


    /**
     * Zakodira po metodi Base64 za kodiranje uporabimo metodo
     * encodeBase64String(), ki je definirana v razredu Base64. Ta razred ni
     * del standardne jave, zato smo ga uvozili iz knjižnice
     * org.apache.commons, povezava:
     * https://commons.apache.org/proper/commons-codec/download_codec.cgi
     *
     * Novejše verzije imajo base64 vgrajeno v standardno knjižnico.
     * @param vsebina
     * @return
     */

    static String kodirajB64(String vsebina){
        return Base64.encodeBase64String(vsebina.getBytes());

    }
    static String odKodirajB64(String vsebina){
        return new String(Base64.decodeBase64(vsebina));
    }
}
