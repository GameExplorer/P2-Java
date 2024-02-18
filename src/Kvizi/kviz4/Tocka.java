package kviz4;

import java.text.DecimalFormat;

public class Tocka {
    private int x;
    private int y;

    public Tocka(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double izracunajRazdaljo(Tocka a) {
        return Math.round(Math.sqrt(Math.pow(a.x - x, 2) + Math.pow(a.y - y, 2)) * 10) / 10.0;
    }

    public double izracunajRazdaljo(Tocka a, Tocka b) {
        return Math.round(Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2)) * 10) / 10.0;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        double distance = Math.round(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 10) / 10.0;
        return "Tocka (" + x + "," + y + ") D = " + decimalFormat.format(distance);
    }

    public static void main(String[] args) {
        Tocka x = new Tocka(1, 1);
        System.out.println(x.toString()); // Tocka (1,1) D = 1.4

        x = new Tocka(1, 1);
        x.setX(2);
        x.setY(2);
        System.out.println(x.toString()); // Tocka (2,2) D = 2.8

        x = new Tocka(1, 1);
        int a = x.getX() + x.getY();
        System.out.println("x.x + x.y = " + a); // x.x + x.y = 2

        x = new Tocka(1, 1);
        System.out.println(x.izracunajRazdaljo(x)); // 1.4

        Tocka y = new Tocka(300, 300);
        System.out.println(x.izracunajRazdaljo(x, y)); // 422.8
    }
}