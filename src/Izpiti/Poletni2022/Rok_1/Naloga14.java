package Izpiti.Poletni2022.Rok_1;


/**
 * Vmesnik
 */
interface Mnozica {
    void add(char c);
    void remove(char c);
    void flip(char c);
    boolean contains(char c);
    boolean isEmpty();
}

/**
 * Razred implementira vmesnik
 */
class MnozicaZnakov implements Mnozica {
    /*
    elemente mnozice hranim v atributu element, element i je v mnozici
    tedaj in le tedaj, ko je v atributu elementi prizgan i-ti bit
     */
    private int elementi;

    public MnozicaZnakov() {
        //spraznim mnozico elementov
        this.elementi = 0;
    }

    //znak c spremenim v zaporedno številko i ('a' -> 1, 'b' -> 2, ...)
    //in vrnem stevilo v katerem je prizgan le i-ti bit

    private int getIndex(char c) {
        return 1 << (Character.toLowerCase(c) - 'a');
    }

    /**
     * doda znak v mnozico
     * @param c ... znak
     */
    public void add(char c) {
        this.elementi |= getIndex(c);
    }

    /**
     * odstrani element iz mnozice
     * @param c ... znak
     */
    public void remove(char c) {
        this.elementi &= ~getIndex(c);
    }

    /**
     * če je znak v mnozici, ga odstrani, sicer dodaj
     * @param c
     */
    public void flip(char c) {
        this.elementi ^= getIndex(c);
    }

    /**
     * vrne true, če je znak v mnozici, sicer false
     */
    public boolean contains(char c) {
        return (this.elementi & getIndex(c)) != 0;
    }

    /**
     * Pogleda ali je element prazen
     */
    public boolean isEmpty() {
        return (this.elementi == 0);
    }

    /**
     * Izpis
     */

    public String toString() {
        String rezultat = "";
        for(char c = 'a'; c <= 'z'; c++) { //grem od a do z
            if(contains(c)) { //če vsebuje to črko
                rezultat += (rezultat.isEmpty() ? "" : ",") + c; //jo dodam v rezultat
            }
        }
        return String.format("[%s]", rezultat);
    }

}
public class Naloga14 {
    public static void main(String[] args) {
        //args = new String[]{"+a", "+b", "+c"};
        args = new String[]{"+a", "+b", "+c", "-a"};
        //args = new String[]{"+a", "+b", "+f", "Xy", "Xe", "Xf"};
        MnozicaZnakov mn = new MnozicaZnakov();

        //Sprehod po argumentih in klic ustreznih metod
        for(int i = 0; i < args.length; i++) {
            String arg = args[i];
            if(arg.length() != 2) continue;

            switch (arg.charAt(0)) {
                case '+':
                    mn.add(arg.charAt(1));
                    break;
                case '-':
                    mn.remove(arg.charAt(1));
                    break;
                case 'X':
                    mn.flip(arg.charAt(1));
                    break;
            }
        }
        //izpis
        System.out.println(mn);
    }
}
