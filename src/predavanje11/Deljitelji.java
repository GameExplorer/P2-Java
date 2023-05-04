package predavanje11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


/**
 * TUkaj smo uprabili ArrayList in TreeSet
 */
public class Deljitelji {
    public static /*ArrayList<Integer>*/ Set<Integer> seznamDeljiteljev(int n) {
        //ArrayList<Integer> delitelji = new ArrayList<Integer>();
        Set<Integer> delitelji = new TreeSet<>();

        //Sprehod čez vse možne kandidate

        for(int i = 1; i <= n/2; i++) {
            if(n % i == 0) delitelji.add(i); //Če i deli n ga dodam v seznam
        }

        return delitelji;
    }
    public static void main(String[] args) {
        int n = 7; int b;

        // pridobim seznam deljiteljev števila n
        //ArrayList<Integer> delitelji = seznamDeljiteljev(n);
        Set<Integer> delitelji = seznamDeljiteljev(n);

        // in jih izpišem sprehod po int
        Iterator<Integer> it = delitelji.iterator();

        System.out.printf("Delitelji števila %d so: ", n);

        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("");
    }
}
