package Predavanja.predavanje09.Knjiga;

/**
 * Razred za testiranje razreda Knjiga in njegovih podrazredov
 */
public class Knjiznica {
    /**
     * V tej metodi vse naredimo ročno -> uporabimo konstruktor brez parametrov in nato vrednosti
     * atributo nastavimo s pomočjo getterjev / setterjev
     */
    public static void test1() {
        LeposlovnaKnjiga l1 = new LeposlovnaKnjiga();
        l1.setAvtor("George Orwell");
        l1.setNaslov("1984");
        l1.setLetoIzdaje(1946);
        l1.mnenjeBralcev = new String[10];
        l1.stMnenj = 0;
        l1.mnenjeBralcev[l1.stMnenj++] = "Dobra knjiga";
        l1.mnenjeBralcev[l1.stMnenj++] = "Slaba knjiga";

        StrokovnaKnjiga s1 = new StrokovnaKnjiga();
        s1.setAvtor("Tim Lindholm");
        s1.setNaslov("The JVM Specification");
        s1.setLetoIzdaje(2012);
        s1.indeks = new String[10];
        s1.stIdx = 0;
        s1.indeks[s1.stIdx++] = "attributes:101";
        s1.indeks[s1.stIdx++] = "array:55";

    }

    /**
     * Podobno kot v metodi test1() tudi tu ustvarim dva objetka - razlika je v tem, da večino
     * dela opravim s pomočjo konstruktorjev
     */
    public static void test2() {
        LeposlovnaKnjiga l1 = new LeposlovnaKnjiga("George Orwell", "1984", 1946);
        l1.dodajMnenje("Dobra knjiga");
        l1.dodajMnenje("Slaba knjiga");

        Knjiga s1 = new StrokovnaKnjiga("Tim Lindholm", "The JVM Specification", 2012);
        ((StrokovnaKnjiga)s1).dodajIndeks("attributes:101"); //type casting
        ((StrokovnaKnjiga)s1).dodajIndeks("array:55");
        s1.izpisi();

        /*
        Ker je zaporednaStevilka ne-statični atribut ima vsak objekt svojo vrednost.
        Atribut steviloKnjig pa je statičen, zato je skupen vsem in ima eno samo vrednost za vse
         */
        System.out.println(l1.zaporednaStevilka);
        System.out.println(Knjiga.stKnjig);
        System.out.println(s1.zaporednaStevilka);
        System.out.println(s1.stKnjig);

        //System.out.println(Knjiga.stKnjig);
        //System.out.println(l1.zaporednaStevilka);

        //System.out.println(s1 instanceof StrokovnaKnjiga);
        //System.out.println(s1 instanceof Knjiga);
        //System.out.println(s1 instanceof LeposlovnaKnjiga);

        // Vse knjige lahko shranim v tabelo tipa Knjiga[]
        Knjiga[] knjige = new Knjiga[2];
        knjige[0] = l1;
        knjige[1] = s1;

        /*
        Ker je knjige[i] tipa Knjiga, lahko na njem kličem le metode, ki so definirane v razredu Knjiga.
        Če želim klicati metode podrazredov, moram najprej ugotoviti katerega tipa je objekt (uporabim operator
        instanceof) nato s pretvorbo tipov (typecast) prevajalniku povem katerega tipa objekt dejansko je potem
        lahko kličem metode tega tipa
         */

        for(int i = 0; i < 2; i++) {
            if (knjige[i] instanceof StrokovnaKnjiga)
                ((StrokovnaKnjiga)knjige[i]).dodajIndeks("beseda:x");
            else if (knjige[i] instanceof LeposlovnaKnjiga)
                ((LeposlovnaKnjiga)knjige[i]).dodajMnenje("Zanimivo");

            knjige[i].izpisi();
        }
    }
    public static void test3() {
        LeposlovnaKnjiga l1 = new LeposlovnaKnjiga("George Orwell", "1984", 1946);
        l1.dodajMnenje("Dobra knjiga");
        l1.dodajMnenje("Slaba knjiga");

        //System.out.println(l1.toString()); iz Objecta izvira toString(), kliče se vedno ko kličemo nek objekt
        System.out.println(l1);

        //Kniga k = new Knjiga("","",""); //ker sem naredil abstract sem preprečil novo instanco Knjige
    }
    public static void main(String[] args) {
            //test1();
            //test2();
            test3();
    }
}