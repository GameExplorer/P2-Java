package kviz2;

import java.util.HashMap;

public class MorseCode {
    public static void main(String[] args) {
        String rez = vMorse("SOS");
        System.out.println(rez);
    }

    public static String vMorse(String niz) {
        //Morsejeva abeceda
        java.util.HashMap<Character, String> morse = new java.util.HashMap<>();
        morse.put('A', ".-");
        morse.put('B', "-...");
        morse.put('C', "-.-.");
        morse.put('D', "-..");
        morse.put('E', ".");
        morse.put('F', "..-.");
        morse.put('G', "--.");
        morse.put('H', "....");
        morse.put('I', "..");
        morse.put('J', ".---");
        morse.put('K', "-.-");
        morse.put('L', ".-..");
        morse.put('M', "--");
        morse.put('N', "-.");
        morse.put('O', "---");
        morse.put('P', ".--.");
        morse.put('Q', "--.-");
        morse.put('R', ".-.");
        morse.put('S', "...");
        morse.put('T', "-");
        morse.put('U', "..-");
        morse.put('V', "...-");
        morse.put('W', ".--");
        morse.put('X', "-..-");
        morse.put('Y', "-.--");
        morse.put('Z', "--..");
        morse.put('1', ".----");
        morse.put('2', "..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");
        morse.put('.', ".-.-.-");
        morse.put('?', "..--..");
        morse.put('"', ".--..--.");
        morse.put(':', "---...");
        morse.put('(', "-.--.-");
        morse.put(' ', "");

        StringBuilder sb = new StringBuilder();
        char znak;
        for(int i = 0; i < niz.length(); i++) {
            znak = Character.toUpperCase(niz.charAt(i));
            sb.append(morse.get(znak));
            sb.append(" ");
        }

        return sb.toString();
    }
}
