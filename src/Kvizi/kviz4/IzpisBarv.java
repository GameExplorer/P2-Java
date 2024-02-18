package kviz4;

import java.io.File;
import java.util.Scanner;

public class IzpisBarv {
    public static void main(String[] args) {
        poisciInIzpisiBarve("src/kviz4/assets/style.css");
    }

    public static void poisciInIzpisiBarve(String imeDatoteke) {
        try {
            Scanner sc = new Scanner(new File(imeDatoteke));

            while(sc.hasNext()) {
                String beseda = sc.next();
                if(beseda.equalsIgnoreCase("color:")) {
                    String barva = sc.next().replace(";", "");
                    if(!barva.matches("^#([A-Fa-f0-9]{6})")) {
                        continue;
                    }
                    //RGB
                    int r = Integer.parseInt(barva.substring(1,3),16);
                    int g = Integer.parseInt(barva.substring(3,5),16);
                    int b = Integer.parseInt(barva.substring(5,7),16);

                    //HSL
                    float R = r / 255f;
                    float G = g / 255f;
                    float B = b / 255f;
                    float M = Math.max(R, Math.max(G,B));
                    float m = Math.min(R, Math.min(G,B));
                    float C = M - m;

                    //Hue
                    float H = 0;
                    if(C == 0) {
                        H = 0;
                    }
                    else if (M == R) {
                        H = ((G - B) / C) % 6;
                    }
                    else if(M == G) {
                        H = ((B-R)/C) + 2;
                    }
                    else if(M == B) {
                        H = ((R-G)/C) + 4;
                    }

                    H = 60f * H;

                    if(H < 0) {
                        H+= 360f;
                    }

                    //LUminance
                    float L = (M + m) * 0.5f;

                    //Saturation
                    float S;
                    if(L == 1) {
                        S = 0;
                    }
                    else {
                        S = C / (1 - Math.abs(2 * L - 1));
                    }

                    System.out.printf("%s -> rgb(%d, %d, %d) -> hsl(%d, %d, %d)", barva, r,g,b,
                            Math.round(H), Math.round(S * 100), Math.round(L * 100));

                    System.out.println();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
