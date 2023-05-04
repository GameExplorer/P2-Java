package predavanje11;

import java.util.*;
public class SeznamImen {
    public static void main(String[] args) {
        ArrayList<String> imena = new ArrayList<>();

        imena.add("Cilka");
        imena.add("Ana");
        imena.add("Berti");
        imena.add("Cvetka");
        imena.add("Žiga");
        imena.add("Zala");

        for(String ime : imena) {
            System.out.println(ime);
        }

        System.out.println();
        System.out.println(imena.contains("Ana"));
        System.out.println(imena.contains("Anica"));

        System.out.println(imena.remove("Zala"));
    }
}
