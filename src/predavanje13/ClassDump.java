package predavanje13;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ClassDump {

    public static void main(String[] args) {
        String ime = "out/production/javaPredavanja/predavanje10/Newton.class";
        try {
            FileInputStream fis = new FileInputStream(ime);
            DataInputStream dis = new DataInputStream(fis);

            byte[] magic = new byte[4];
            dis.read(magic);

            for (int i = 0; i < 4; i++) {
                System.out.printf("%X", magic[i]);
            }
            short minor = dis.readShort();
            short major = dis.readShort();

        }catch (Exception e) {
            System.out.println(e);
        }

    }
}
