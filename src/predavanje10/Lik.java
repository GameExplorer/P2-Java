package predavanje10;

import java.awt.Color;


abstract public class Lik {
    private double x;
    private double y;
    private Color barva;
    private boolean oznacen;

    public Lik(double x, double y, Color barva) {
        this.x = x;
        this.y = y;
        this.barva = barva;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getBarva() {
        return barva;
    }

    public void setBarva(Color barva) {
        this.barva = barva;
    }

    public boolean isOznacen() {
        return oznacen;
    }

    public void setOznacen(boolean oznacen) {
        this.oznacen = oznacen;
    }

    abstract void narisiSe();

    void premakniSe(double dX, double dY) {
        this.x += dX;
        this.y += dY;
    }

    abstract void povecajSe(double f);
}
