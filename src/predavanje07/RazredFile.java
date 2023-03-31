package predavanje07;

import java.io.File;

public class RazredFile {
    public static void main(String[] args) {
        File f = new File("veckratniki.txt");

        File f2 = new File("dist");

        System.out.println(f.exists());
        System.out.println(f.length());
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
        System.out.println(f2.isDirectory());

    }
}
