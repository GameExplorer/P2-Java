package kviz4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Stavki {
    public static void main(String[] args) {
        statistikaStavkov("src/kviz4/assets/besedilo3.txt");
    }
    public static void statistikaStavkov(String imeDatoteke) throws IzjemaManjkajocegaLocila {
        try {
            Scanner sc = new Scanner(new File(imeDatoteke));
            TreeMap<Integer, Integer> pojavitve = new TreeMap<>();
            int st_pojavitev = 0;

            while(sc.hasNext()) {
                String beseda = sc.next();
                st_pojavitev++;

                if(beseda.contains(".") || beseda.contains("?") || beseda.contains("!")) {
                    if(pojavitve.containsKey(st_pojavitev)) {
                        pojavitve.replace(st_pojavitev, pojavitve.get(st_pojavitev) + 1);
                    }
                    else {
                        pojavitve.put(st_pojavitev, 1);
                    }
                    st_pojavitev = 0;
                }
                else if(!sc.hasNext()) {
                    throw new IzjemaManjkajocegaLocila();
                }
            }
            for(Map.Entry<Integer, Integer> podatki : pojavitve.entrySet()) {
                System.out.printf("Stavki dolzine %d se pojavijo: %dx.", podatki.getKey(), podatki.getValue());
                System.out.println();
            }
            sc.close();
        }
        catch (FileNotFoundException fne) {
            System.out.println("Napaka pri branju datoteke.");
        }
    }
}

class IzjemaManjkajocegaLocila extends RuntimeException {
    IzjemaManjkajocegaLocila() {
        super();
    }

    @Override
    public String getMessage() {
        return "Izjema manjkajocega locila.";
    }
}