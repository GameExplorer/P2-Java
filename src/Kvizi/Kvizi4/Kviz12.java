package Kvizi.Kvizi4;

import java.util.ArrayList;
import java.util.Arrays;

class ArrayListPlus extends ArrayList<String> {
    ArrayListPlus() {
        super();
    }

    ArrayListPlus(String elements) {
        super();
        String[] elementi = elements.split(";");
        this.addAll(Arrays.asList(elementi));
    }

    public String set(int indeks, String element) {
        if(indeks >= this.size()) {
            for(int i = 0; i < indeks; i++) {
                if(i >= this.size()) {
                    this.add("");
                } else if(this.get(i) == null) {
                    this.set(indeks, "");
                }
            }
            this.add(element);
            return element;
        }
        return super.set(indeks, element);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String value : this) {
            sb.append(String.format("%s;", value));
        }
        return sb.substring(0, sb.length() - 1);
    }
}
public class Kviz12 {

    public static void main(String[] args) {
        ArrayListPlus alp1 = new ArrayListPlus();

        alp1.set(3, "3");

        alp1.set(4, "4");

        alp1.set(1, "1");

        System.out.println(alp1);  // ;1;;3;4


        ArrayListPlus alp2 = new ArrayListPlus(";b;c;;;;g");

        System.out.println(alp2); //;b;c;;;;g


        ArrayListPlus alp3 = new ArrayListPlus(";b;c;;;;g");

        alp3.set(0, "a");

        alp3.set(4, "e");

        System.out.println(alp3); // a;b;c;;e;;g
    }
}
