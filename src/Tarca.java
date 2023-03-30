import java.awt.*;

public class Tarca {
    public static void tarca() {
        StdDraw.setScale(-100, 100);
        StdDraw.setPenColor(Color.blue);
        for(int i = 1; i <= 10; i++) {
            StdDraw.circle(0,0,i*10);
        }
    }

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

    public static void kvadratnaSpirala() {
        StdDraw.setScale(-100, 100);
        int px = 0, py = 0; //prejšna x in y

        int[][] smeri = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        int tsmer = 0;
        int d = 3;

        for(int i = 0; ; i++) {
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
            kot = kot + 3;
            d = d * 1.02;
        }
    }

    public static void radar() {
        StdDraw.setScale(-100, 100);
        StdDraw.clear(Color.black);
        StdDraw.setPenColor(Color.green);
        StdDraw.setPenRadius(0.01);

        StdDraw.enableDoubleBuffering();

        int kot = 0;
        while(true) {
            StdDraw.clear(Color.black);
            for(int i = 0; i <= 4; i++) {
                StdDraw.circle(0,0, i * 20);
            }
            kazalec(85, kot);
            kot += 1;
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
        //kvadrati();S
        //kvadratnaSpirala();
        //spirala();
        radar();
    }
}
