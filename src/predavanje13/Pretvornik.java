package predavanje13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Pretvornik iz enega v drug kodirni sisstem.
 */
public class Pretvornik {
    public static void main(String[] args) {
        String inputCharset = "UTF-8";
        String outputCharset = "CP1250";

        String imeDatoteke = "src/predavanje13/abc.txt";

        String imeIzhodne = "src/predavanje13/abcx.txt";

        try (
            FileInputStream fis = new FileInputStream(imeDatoteke);
            InputStreamReader isr = new InputStreamReader(fis, inputCharset);

            FileOutputStream fos = new FileOutputStream(imeIzhodne);
            OutputStreamWriter osw = new OutputStreamWriter(fos, outputCharset);)
        {
            while(isr.ready()) {
                int znak = isr.read();
                osw.write(znak);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}