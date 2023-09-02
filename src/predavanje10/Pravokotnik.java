package predavanje10;

import java.awt.Color;
import edu.princeton.cs.algs4.StdDraw;

public class Pravokotnik extends Lik {
    private double a; //sirina
    private double b; //visina

    public Pravokotnik(double x, double y, double a, double b, Color barva) {
        super(x,y,barva);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    void narisiSe() {
        StdDraw.setPenColor(getBarva());
        StdDraw.filledRectangle(getX(), getY(), a, b);
    }
    void povecajSe(double f) {
        this.a *= f;
        this.b *= f;
    }
}