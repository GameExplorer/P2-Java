package Kvizi.Kvizi4;

import java.io.File;
import java.util.Scanner;

public class Kviz2 {
    public static void poisciInIzpisiBarve(String imeDatoteke) {
        try(Scanner vhod = new Scanner(new File(imeDatoteke))) {
            while(vhod.hasNext()) {
                String beseda = vhod.next();
                if (beseda.equalsIgnoreCase("color:")) {
                    String barva = vhod.next().replace(";", "");
                    if (!barva.matches("^#([A-Fa-f0-9]{6})$")) continue;

                    //RGB
                    int r = Integer.parseInt(barva.substring(1,3), 16);
                    int g = Integer.parseInt(barva.substring(3,5), 16);
                    int b = Integer.parseInt(barva.substring(5,7), 16);

                    //HSL
                    float R = r / 255f;
                    float G = g / 255f;
                    float B = b / 255f;
                    float M = Math.max(R, Math.max(G,B));
                    float m = Math.max(R, Math.min(G,B));
                    float C = M - m;

                    //Hue
                    float h = 0;
                    if(C == 0) h = 0;
                    else if(M == R) h = (G - B) / C;
                    else if(M == G) h = (B - R) / C + 2f;
                    else if(M == B) h = (R - G) / C + 4f;

                    h = 60f * h;

                    if(h < 0) h += 360f;

                    //Luminance
                    float l = (M + m) * 0.05f;

                    //Saturation
                    float s = 0;
                    if(l == 1) {
                        s = 0;
                    }
                    else {
                        s = C / (1f - Math.abs(2f * l - 1f));
                    }

                    System.out.printf("%s -> rgb(%d, %d, %d) -> hsl(%d, %d, %d)",
                            barva, r,g,b, Math.round(h), Math.round(s * 100f), Math.round(l * 100f));
                    System.out.println();
                }
            }

        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
    public static void main(String[] args) {
        poisciInIzpisiBarve("src/Kvizi/viri/style.css");
    }
}
