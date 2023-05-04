package predavanje11;

import java.util.ArrayList;
import java.util.Collections;

public class IImenik{
    public static void main(String[] args) {
        ArrayList<Oseba> osebe = new ArrayList<>();

        osebe.add(new Oseba("Cilka", 25));
        osebe.add(new Oseba("Berta", 50));
        osebe.add(new Oseba("Ana", 21));

        Collections.sort(osebe);
        System.out.println(osebe);
    }
}
