package kviz3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sah {
    public static void main(String[] args) {
        preveriInNarisi(new int[] {1,3,0,2});
        System.out.println();

        preveriInNarisi(new int[]{1,0,3,2});
        System.out.println(steviloPostavitev(6));
    }

    static void preveriInNarisi(int[] kraljice) {
        boolean seNapdajo = false;
        for(int i = 0; i < kraljice.length; i++) {
            for(int j = 0; j < kraljice.length; j++) {
                if(!seNapdajo && 1 != j) {
                    //Preverjanje po diagonali
                    if(Math.abs(kraljice[i] - kraljice[j]) == Math.abs(i - j)) {
                        seNapdajo = true;
                    }
                }
                if(kraljice[j] == i) System.out.print("K");
                else System.out.print(". ");
            }
            System.out.println();
        }
        if(seNapdajo) System.out.println("Kraljice se napadajo");
        else System.out.println("Kraljice se ne napadajo");
    }

    static int steviloPostavitev(int n) {
        int p = 0;
        List<Integer> permutacije = new ArrayList<>();
        for(int i = 0; i < n; i++) permutacije.add(i);

        do {
            if(!seNapadajo(permutacije)) p++;
        } while(novaPermutacija(permutacije));
        return p;
    }
    static boolean novaPermutacija(List<Integer> a) {
        int i = a.size() - 2;
        while (i >= 0 && a.get(i) >= a.get(i + 1)) i--;
        if(i < 0) return false;
        int j = a.size() - 1;
        while(a.get(i) >= a.get(j)) j--;

        Collections.swap(a,i,j);
        Collections.reverse(a.subList(i + 1, a.size()));
        return true;
    }
    static boolean seNapadajo(List<Integer> kraljice) {
        for(int i = 0; i < kraljice.size(); i++) {
            for(int j = 0; j < kraljice.size(); j++) {
                if(i != j) {
                    //Preverjanje diagonal
                    if(Math.abs(kraljice.get(i) - kraljice.get(j)) == Math.abs(i - j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
