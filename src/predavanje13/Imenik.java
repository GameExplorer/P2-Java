package predavanje13;

import java.io.*;

public class Imenik {
    public static void main(String[] args) throws IOException {
        preberiObjekte();
    }

    public static void zapisiObjekte() {
        Oseba A = new Oseba("A", 21);
        Oseba B = new Oseba("B", 21);
        Oseba C = new Oseba("AC", 22);
        Oseba D = new Oseba("D", 26);
        Oseba E = new Oseba("AE", 25);

        try {
            FileOutputStream fos = new FileOutputStream("src/predavanje13/imenik.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(A);
            oos.writeObject(B);
            oos.writeObject(C);
            oos.writeObject(D);
            oos.writeObject(E);

            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //branje objektov iz datoteke
    public static void preberiObjekte() {
        try (FileInputStream fis = new FileInputStream("src/predavanje13/imenik.bin");
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            Oseba a = (Oseba) ois.readObject(); //prvi objekt
            Object b = ois.readObject(); //drugi objekt
            Object c = ois.readObject(); //tretji objekt

            System.out.println(c.toString());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}