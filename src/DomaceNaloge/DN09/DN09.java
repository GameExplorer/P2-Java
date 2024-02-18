package DN09;

class Pravokotnik implements LIk {
    int a, b;

    Pravokotnik(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double obseg() {
        return 2 * (a + b);
    }
}

class Kvadrat extends Pravokotnik {
    Kvadrat(int a) {
        super(a, a);
    }
}

class NKotnik implements LIk {
    int a; //veliksot stranice
    int n; //stevilo stranic

    NKotnik(int a, int n) {
        this.a = a;
        this.n = n;
    }

    public double obseg() {
        return n * a;
    }
}



public class DN09 {
    static int skupniObseg(LIk[] liki) {
        int obseg = 0;
        for (int i = 0; i < liki.length; i++) {
            obseg += liki[i].obseg();
        }
        return obseg;
    }
    public static void main(String[] args) {
        args = new String[]{"kvadrat:15", "pravokotnik:10:3", "nkotnik:5:2"};

        // ustvarim tabelo za vse like; št. likov je enako št. argumentov

        LIk[] liki = new LIk[args.length];

        for (int i = 0; i < args.length; i++) {
            String[] podatki = args[i].split(":");
            switch (podatki[0]) {
                case "kvadrat":
                    liki[i] = new Kvadrat(Integer.parseInt(podatki[1]));
                    break;
                case "pravokotnik":
                    liki[i] = new Pravokotnik(Integer.parseInt(podatki[1]), Integer.parseInt(podatki[2]));
                    break;
                case "nkotnik":
                    liki[i] = new NKotnik(Integer.parseInt(podatki[1]), Integer.parseInt(podatki[2]));
                    break;
            }
        }

        //skupni obseg
        int skupniObseg = skupniObseg(liki);
        System.out.printf("Skupni obseg: %d", skupniObseg);
    }
}
