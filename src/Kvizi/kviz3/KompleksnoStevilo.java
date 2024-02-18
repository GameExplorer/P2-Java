package kviz3;

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

    public String toString() { return String.format("%s = (%.3f + %.3f*i)", this.ime, this.re, this.im); }

    double velikost()  { return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2)); }

    void pristej(Kompleksno b) {
        this.re += b.re;
        this.im += b.im;
    }
    void pomnozi(Kompleksno b) {
        double oRE = this.re;
        this.re = this.re * b.re - this.im * b.im;
        this.im = oRE * b.im + this.im * b.re;
    }
}
public class KompleksnoStevilo {
    public static void main(String[] args) { /* prazna metoda */ }
}