package Kvizi.Kvizi3;

class Kompleksno {
    private String ime;
    private double re;
    private double im;

    Kompleksno(String ime, double re, double im) {
        this.ime = ime;
        this.re = re;
        this.im = im;
    }

    Kompleksno(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public String toString() {
        return String.format("%s = (%.3f + %.3f*i", this.ime, this.re, this.im);
    }

    double velikost() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    void pristej(Kompleksno b) {
        this.re += b.re;
        this.im += b.im;
    }

    void pomnozi(Kompleksno b) {
        double oRe = this.re;
        this.re = this.re * b.re - this.im * b.im;
        this.im = oRe * b.im + this.im * b.re;
    }
}
public class Kviz8 {
    public static void main(String[] args) {
        Kompleksno a = new Kompleksno("a", 3.56, -2.7);
        System.out.println(a.toString());
        Kompleksno b = new Kompleksno("b", -5, 12.33);
        System.out.println(b.toString());
        a.pristej(b);
        System.out.println(a.toString());
        b.pomnozi(new Kompleksno(1.3, 3.22));
        System.out.println(b.toString());
        System.out.printf("Velikost %s) je %f\n", a.toString(), a.velikost());
    }
}
