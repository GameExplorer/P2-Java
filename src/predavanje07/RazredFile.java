package predavanje07;

import java.io.File;

public class RazredFile {
    public static void main(String[] args) {
        File f = new File("src/predavanje07/test.txt");

        File f2 = new File("dist");

        System.out.println(f.exists()); // pogleda ali datoteka obstaja
        System.out.println(f.length()); // vrne dolzino datoteke
        System.out.println(f.isFile()); // ali je datoteka?
        System.out.println(f.isDirectory()); // ali je direktorij?
        System.out.println(f2.isDirectory());

        String[] datoteke = f2.list();
        for(int i = 0; i < datoteke.length; i++) {
            System.out.println(datoteke[i]);
        }
    }
}