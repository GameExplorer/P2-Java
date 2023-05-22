package predavanje13;

import java.io.*;

/**
 * Imenik omogoča brane in pisanje objektov tipa Oseba
 */
public class Imenik {
    public static void main(String[] args) throws IOException {
        //zapisiObjekte();
        preberiObjekte();
    }

    public static void zapisiObjekte() {
        Oseba Anastija = new Oseba("Anastija", 21);
        Oseba Berta = new Oseba("Berta", 21);
        Oseba Cici = new Oseba("Cici", 22);
        Oseba Dorotea = new Oseba("Dorotea", 26);
        Oseba Elizabeta = new Oseba("Elizabeta", 25);

        try {
            FileOutputStream fos = new FileOutputStream("src/predavanje13/imenik.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(Anastija);
            oos.writeObject(Berta);
            oos.writeObject(Cici);
            oos.writeObject(Dorotea);
            oos.writeObject(Elizabeta);

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