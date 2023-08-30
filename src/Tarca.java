    import java.awt.*;
    import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    import java.util.Calendar;
    import java.util.Date;

    public class Tarca {
        //Izris 10 krogov s središčem v 0,0
        public static void tarca() {
            StdDraw.setScale(-100, 100);
            StdDraw.setPenColor(Color.blue);
            for(int i = 1; i <= 10; i++) {
                StdDraw.circle(0,0,i*10);
            }
        }

        /**
         * Izris mreže kvadratov (n x n) velikos s presledkom p med njimi
         * Kvadratki so spreminjajoče barve (mešanica rdečge in zelene)
         */
        public static void kvadrati() {
            int n = 25; //št kvadratkov v vsaki vrsti in stolpcu
            int s = 10; // veliko   st posameznega kvadratka
            int p = 0; // presledek med kvadratki

            StdDraw.setScale(0, n*s + (n+1)*p);

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    StdDraw.setPenColor(new Color(10*i, 10*j, 0));
                    StdDraw.filledRectangle(p+i*(s+p)+s/2, p+j*(s+p)+s/2, s/2, s/2);
                }
            }
        }

        /**
         * Izris kvadratne spirale
         */
        public static void kvadratnaSpirala() {
            StdDraw.setScale(-100, 100);
            int px = 0, py = 0; //prejšna x in y

            int[][] smeri = {{0,-1}, {-1,0}, {0,1}, {1,0}}; //smeri izrisa
            int tsmer = 0;
            int d = 3;

            for(int i = 0; ; i++) {
                //sprememba smeri
                int x = px + d * smeri[tsmer][0];
                int y = py + d * smeri[tsmer][1];

                StdDraw.line(px, py, x,y);

                tsmer = (tsmer + 1) % 4;
                d += 2;
                if(d > 200) break;
                px = x;
                py = y;
            }
        }

        public static void spirala() {
            StdDraw.setScale(-100, 100);
            double px = 0, py = 0; //prejšna x in y
            int kot = 0; //kot otčke
            double d = 1; //oddaljenost točke od koordinatnega izhodišča

            for(int i = 0; i < 250; i++) {
                double radiani = (2 * Math.PI * kot) / 360;
                double tx = d * Math.cos(radiani); //trenutni x
                double ty = d * Math.sin(radiani);; //trenutni y

                StdDraw.line(px, py, tx, ty);

                px = tx;
                py = ty;
                kot = kot + 3; // ko povecujem kot se vrtim v krogih
                d = d * 1.02; // povečujem oddaljenost od središča
            }
        }

        public static void radar() {
            StdDraw.setScale(-100, 100);
            StdDraw.clear(Color.black);
            StdDraw.setPenColor(Color.green);
            StdDraw.setPenRadius(0.01);

            StdDraw.enableDoubleBuffering();

            String vzorec = "hh:mm:ss";
            DateFormat df = new SimpleDateFormat(vzorec);

            int kot = 0;
            while(true) {
                //trenuta ura s pomočjo izbranega formata pretvorim v niz
                Date c = Calendar.getInstance().getTime();
                String ura = df.format(c);

                StdDraw.clear(Color.black);

                //izris ure
                StdDraw.text(80,80,ura);

                //izris krogov
                for(int i = 0; i <= 4; i++) {
                    StdDraw.circle(0,0, i * 20);
                }

                //izris kazalca
                kazalec(85, kot);
                kot += 1; // kot povečujem pri vsakem izrisu da se kazalec vrti
                StdDraw.pause(25);
                StdDraw.show();
            }
        }

        public static void kazalec(int dolzina, double kot) {
            double radiani = (2 * Math.PI * kot) / 360;
            StdDraw.line(0,0, dolzina * Math.cos(radiani), dolzina * Math.sin(radiani));
        }
        public static void main(String[] args) {
            //tarca();
            //kvadrati();
            //kvadratnaSpirala();
            //spirala();
            radar();
        }
    }
