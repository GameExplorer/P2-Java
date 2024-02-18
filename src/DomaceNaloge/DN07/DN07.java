package DN07;

import java.io.*;
import java.util.*;

public class DN07 {

    /**
     * Main metoda, ki glede na podanega argumenta požene tisto metodo s pomočjo switch ukaza.
     * @param args argumenti
     * @throws FileNotFoundException throws Exception
     */
    public static void main(String[] args) throws IOException {
        //File dat = new File(args[1]);

        File f_tmp = new File("src/DN07/");
        int tmp = 3;
        //int st = Integer.parseInt(args[0]);

        switch (tmp) {
            case 1:
                izpisi_datoteke(f_tmp);
                break;
            case 2:
                najvecja_datoteka(f_tmp);
                break;
            case 3:
                izpis_vsebine(f_tmp, 1);
                break;
            case 4:
                kopiraj_datoteko("src/DN07/besedilo1.txt", "besedilo1_kopija.txt");
                break;
            case 5:
                zdruzi_datoteko(f_tmp, "zdruzeno.txt");
                break;
            case 6:
                najdiVDatotekah(f_tmp, "besedilo");
                break;
            case 7:
                drevo(f_tmp);
                break;
            case 8:
                resiMatematicneIzraze(f_tmp);
                break;
            case 9:
                nNajvecjih(f_tmp, 2);
                break;
        }
    }

    /**
     * Metoda izpiše vse datoteke v podanem direktoriju vključno z mapam. Izpiše pa ime datoteke/mape, tip datoteke/mape
     * ter velikost
     *
     * @param f argument
     */
    public static void izpisi_datoteke(File f) {
        File[] datoteke = f.listFiles();

        for (File datoteka : datoteke) { //sprehod po daotekah
            //Če je datoteka potem izpiše podatke o datoteki, drugače pa podatke o mapi, ker sem iz Gorenjske se izogibam gnezdenju zank :)
            if (datoteka.isFile())
                System.out.printf("%20s %19s %10.3f%n", datoteka.getName(), "Datoteka", datoteka.length() / 1000.0);
            else if (datoteka.isDirectory())
                System.out.printf("%20s %19s %10.3f%n", datoteka.getName(), "Mapa", datoteka.length() / 1000.0);
        }
    }

    /**
     * Metoda v podanem direktoriju prebere vse datoteke in izpiše največjo in najmanjšo datoteko vred z njunima
     * velikostima.
     * Najprej sem deklariral spremenljivki za največjo in najmanjšo datoteko. Pri najmanjši datoteki sem nastavil velikost
     * na MAX vrednost int-a lahko bi uporabil tudi long in naredil podobno in mi ne bi bilo potrebno uporabiti cast-a.
     * Pa še dve spremenljivki tipa String ki si zapomnita ime največje oz. najmanjše datoteke, ki ju potem uporabimo pri
     * izpisu vsebine.
     *
     * @param f argument
     */
    public static void najvecja_datoteka(File f) {
        File[] datoteke = f.listFiles();
        int najvecja_datoteka_velikost = 0;
        int najmanjsa_datoteka_velikost = 2147483647;

        String ime_NajvecjeDatoteke = "";
        String ime_NajmanjseDatoteke = "";

        for (File datoteka : datoteke) { //sprehod po datotekah
            if (datoteka.isFile()) { //if če je datoteka izvede naslednje ...
                if (datoteka.length() > najvecja_datoteka_velikost) { //pogleda če je večja od velikosti trenutne datoteke, če je
                    najvecja_datoteka_velikost = (int) datoteka.length(); // zapiše podatke o velikosti in imenu datoteke
                    ime_NajvecjeDatoteke = datoteka.getName(); // prva datoteka bo vedno večja od največje datoteke
                }
                if (datoteka.length() < najmanjsa_datoteka_velikost) { //na podoben princip kot iskanje največje datoteke
                    najmanjsa_datoteka_velikost = (int) datoteka.length(); //ker je vsako št. manjše od MAX int se potem prva datoteka
                    ime_NajmanjseDatoteke = datoteka.getName(); //shrani in potem to počne dokler datoteka.length() ni večja od
                    //najmanjše datoteke
                }
            }
        }
        System.out.printf("%s %1.3f%n", ime_NajvecjeDatoteke, (double) najvecja_datoteka_velikost / 1000.0); //izpis največje
        System.out.printf("%s %1.3f%n", ime_NajmanjseDatoteke, (double) najmanjsa_datoteka_velikost / 1000.0); //in najmanjše dat.
    }

    /**
     * Metoda za vsako tekstovno datoteko izpiše prvih n vrstic njene vsebine.
     * Če datoteka ni teksotvna poleg imena izpiše še (ni teksotvna datoteka).
     * @param f argument
     * @param n št. vrstice
     * @throws FileNotFoundException throws Exception
     */
    public static void izpis_vsebine(File f, int n) throws FileNotFoundException {
        File[] datoteke = f.listFiles(); //ustvari seznam datotek in ga shrani v datoteke
        if (f.isDirectory()) { //preveri ali je datoteka f direktorij
            if (datoteke != null) { //preveri ali datoteke obstajajo
                for (File datoteka : datoteke) { //če if true potem se za vsako datoteko v seznamu datoteke preveri če je dat.
                    if (datoteka.isFile()) { // če je datoteka dat. potem izpiše prvnih n vrtic vsebine datoteke
                        izpis_vsebine(datoteka, n);
                    }
                }
            }
        } else if (f.getName().toLowerCase().endsWith(".txt")) { //pogleda če je datoteka tekstovna datoteka, torej če se konča na .txt
            System.out.printf("%s%n", f.getName());  //izpis tekstovne datoteke (ime)
            Scanner sc = new Scanner(f);
            for (int i = 0; i < n && sc.hasNextLine(); i++) { //preberemmo prvih n vrstic datoteke s pomočjo Scannerja
                System.out.println("    " + sc.nextLine()); //izpis vrstic z zamikom 4 presledkov
            }
            sc.close();
        } else System.out.println(f.getName() + " (ni tekstovna datoteka)"); //če datoteka ni tekstovna

    }


    public static void kopiraj_datoteko(String vhodnaDatoteka, String izhodnaDatoteka) {
    }

    public static void zdruzi_datoteko(File direktorij, String izhodnaDatoteka) {
    }

    /**
     * V vseh tekstovnih datotekah direktorija, ki ga podamo v f poišče besedo oz. niz podan v iskanNiz
     * Za vsako datoteko, ki vsebuje niz izpiše njeno ime, št. vrstice v kateri se niz nahaja in celotno vrstico, v
     * kateri se nahaja niz.
     * Razdelil sem na dve metodi zato, ker ne maram špagetov
     * .
     * Če je f direktorij se po vseh datotekah v direktoriju poišče niz, če pa je datoteka se pa poišče  v tisti dat.
     * Če je direktorij uporabimo f.listFiles in dobimo vse datoteke v direktoriju, ki se končajo na .txt
     * Nato za vsako datoteko pokličemo metodo scanner.
     * V primeru da je f datoteka metoda preveri, če se datoteka konča na .txt in šele nato pokliče scanner metodo.
     * @param f - argument
     * @param iskanNiz - iskani niz, ki ga iščemo v datotekah
     * @throws FileNotFoundException
     */
    public static void najdiVDatotekah(File f, String iskanNiz) throws FileNotFoundException {
        if (f.isDirectory()) { //preveri če je podana datoteka direktorij, le je poiššče vse daoteke v tem direktoriju,
            File[] datoteke = f.listFiles(file -> file.isFile() && file.getName().endsWith(".txt")); //ki se končajo na .txt

            for (File datoteka : datoteke) {
                scanner(datoteka, iskanNiz);
            }
        } else if (f.isFile() && f.getName().endsWith(".txt")) {
            scanner(f, iskanNiz);
        }
    }

    /**
     * Metoda prejme argument f in iskaniNiz. Odpre datoteko f in prebere vako vrstico dokller ne najde niza,
     * ki ga iščemo. stevecVrstic šteje vrstice in ko najde niz metoda izpiše ime datoteke in številko vrstice ter
     * vsebino v tisti vrstici, ki vsebuje naš iskanNiz.
     * @param f
     * @param iskanNiz
     * @throws FileNotFoundException
     */

    private static void scanner(File f, String iskanNiz) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        int stevecVrstic = 0;
        while (sc.hasNextLine()) {
            stevecVrstic++;
            String vrstica = sc.nextLine();
            if (vrstica.contains(iskanNiz)) {
                System.out.println(f.getName() + " " + stevecVrstic + ": " + vrstica);
            }
        }
        sc.close();
    }

    public static void drevo(File f) {}

    public static void resiMatematicneIzraze(File f) {
    }

    public static void nNajvecjih(File f, int n) {
    }
}
