package Izpiti.Poletni2023.Rok_3;

import java.io.DataInputStream;
import java.io.FileInputStream;

interface Lik{
    public double obseg();
}

class Krog implements Lik {
    double r;

    public Krog(double r) {
        this.r = r;
    }

    @Override
    public double obseg() {
        return 2*Math.PI*r;
    }

    @Override
    public String toString() {
        return String.format("Krog z obsegom %.2f", obseg());
    }
}

class Pravokotnik implements Lik {
    double a,b;

    public Pravokotnik(double a, double b) {
        this.a= a;
        this.b= b;
    }

    @Override
    public double obseg() {
        return 2*(a+b);
    }

    @Override
    public String toString() {
        return String.format("Pravokotnik z obsegom %.2f", obseg());
    }
}

class Kvadrat implements Lik {
    double a;

    public Kvadrat(double a) {
        this.a= a;
    }

    @Override
    public double obseg() {
        return 4*a;
    }

    @Override
    public String toString() {
        return String.format("Kvadrat z obsegom %.2f", obseg());
    }
}


public class Naloga33 {
    public static void main(String[] args) {
        //args = new String[]{"viri/liki.bin"};

        if (args.length != 1) {
            System.out.println("Manjka ime datoteke!");
            System.exit(1);
        }

        try
                (DataInputStream dis = new DataInputStream(new FileInputStream(args[0])); )
        {
            while (dis.available() > 0) {
                char c = dis.readChar();
                switch (c) {
                    case 'o':
                        int x = dis.readInt();
                        int y = dis.readInt();
                        int r = dis.readInt();
                        System.out.println(new Krog(r));
                        break;
                    case 'k': case 'p':
                        int x1=dis.readInt();
                        int y1=dis.readInt();
                        int x2=dis.readInt();
                        int y2=dis.readInt();
                        if (c=='k')
                            System.out.println(new Kvadrat(x2-x1));
                        else
                            System.out.println(new Pravokotnik(x2-x1, y2-y1));
                }
            }
        } catch (Exception e) {
            System.out.println("Napaka: " + e.toString());
        }
    }
}

