package Predavanje08;

import java.util.Scanner;

/**
 * Datoteka vsebbuje razreda Student ii Studenti
 *
 * Razred Student vsebuje štiri atribute (ime, id, ocene in status)
 * ter metodi povprecje() in toString()
 *
 * Razred Studenti vsebuje metode za ttestiranje uporabe in
 * delovanja razreda Student
 *
 */
class Student {

    static final int maxOcen = 10;
    //Atributi so privatni za vse getterje in setterje
    private String ime; //ime studenta
    private String iD; //vpisna številka studenta

    private int[] ocene; //tabela ocen
    private int stOcen; //koliko cen je ze zapisanih v tabeli

    private String status; // ce povprecje >9 si Odlicen sicer Dober

    /**
     * Konstruktor brez parametrov. Nastavim privzete vrednosti atributov
     */
    Student() {
        this.ime="?";
        this.iD="?";
        this.stOcen = 0;
        this.ocene = new int[maxOcen];
    }

    //Definicija kostruktorja
    Student(String ime, String iD) {
        this(); //klic konstruktorja
        this.ime = ime;
        this.iD = iD;
    }

    /********* getterji in setterji za privatne atribute *****************/
    public void setIme(String ime) {
        this.ime = ime;
    }
    public String getIme() {
        return this.ime;
    }
    public void setID(String iD) {
        this.iD = iD;
    }
    public String getiD() {
        return this.iD;
    }

    /**
     * Metoda vrne true če je v tabeli še prostor za ocene
     * false sicer
     * @return
     */
    boolean prostorVTabeli() {
        return this.stOcen < maxOcen;
    }

    /**
     * Metoda doda oceno v tabelo ocen poveca stevec stOcen
     * in posodobi status
     * @return vrne true, če je dodajanje uspelo (če je bilo
     * še dovolj prostora) in false sicer
     * @param ocena
     */
    boolean dodajOceno(int ocena) {
        if(!prostorVTabeli()) return false;

        this.ocene[stOcen++] = ocena;

        if(povprecje() > 9) this.status = "Odličen";
        else this.status = "Dober";

        return true;
    }

    /**
     * Izračuna povprečje ocen v tabeli ocene
     * @return
     */
    double povprecje() {
        if(this.stOcen == 0) return 0;
        double vsota = 0;
        for(int i = 0; i < this.stOcen; i++) {
            vsota += this.ocene[i];
        }
        return vsota / this.stOcen;
    }

    /**
     * Znakovna reprezentacija studenta
     * @return
     */
    public String toString() {
        return String.format("Ime: %s, ID: %s, povp.ocena: %.2f, status:%s ", this.ime, this.iD, povprecje(),
                this.status);
    }
}
public class Studenti {

    static void studenti1() {
        String ime1, ime2, ime3;
        String id1, id2, id3;

        Scanner sc = new Scanner(System.in);

        System.out.println("Vpiši ime: "); ime1 = sc.nextLine();
        System.out.println("Vpiši ID: "); id1 = sc.nextLine();

        System.out.println("Vpiši ime: "); ime2 = sc.nextLine();
        System.out.println("Vpiši ID: "); id2 = sc.nextLine();

        System.out.println("Vpiši ime: "); ime3 = sc.nextLine();
        System.out.println("Vpiši ID: "); id3 = sc.nextLine();
    }

    public static void studenti2(int n) {
        String[] ime = new String[n];
        String[] Id = new String[n];

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            System.out.print("Vpiši ime: ");
            ime[i] = sc.nextLine();

            System.out.print("Vpiši ID: ");
            Id[i] = sc.nextLine();
        }
    }

    public static void studenti3(int n) {
        Student[] studenti = new Student[n]; //ustvarimo tabelo študentov velikosti n v katero lahko dodajm študente

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            Student s = new Student();

            System.out.print("Vpiši ime: ");
            s.setIme(sc.nextLine()); //s.ime = sc.nextLine(); to ne gre saj je ime privatno isto velja za id

            System.out.print("Vpiši ID: ");
            s.setID(sc.nextLine());

            studenti[i] = s;
        }
    }
    public static void studenti4(int n) {
        Student[] studenti = new Student[n]; //ustvarimo tabelo študentov velikosti n v katero lahko dodajm študente

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            String ime, iD;
            System.out.print("Vpiši ime: ");
            ime = sc.nextLine(); //s.ime ne grem ker je ime privaten
            System.out.print("Vpiši ID: ");
            iD = sc.nextLine(); //s.id ne gre ker je id privaten

            Student s = new Student(ime, iD);

            studenti[i] = s;
        }
    }
    public static void studenti5() {
        Scanner sc = new Scanner(System.in);
        String ime, iD;

        System.out.print("Vpiši ime: ");
        ime = sc.nextLine();
        System.out.print("Vpiši ID: ");
        iD = sc.nextLine();

        int ocena;
        Student s1 = new Student(ime, iD);

        do {
            System.out.print("Vnesi oceno: ");
            ocena = sc.nextInt();
            if(ocena != 0) {
                s1.dodajOceno(ocena);
            }
        } while (ocena != 0 && s1.prostorVTabeli());


        System.out.println(s1.toString());
    }
    public static void main(String[] args) {

        //studenti1();
        //studenti2(5);
        //studenti3(5);
        //studenti4(5);
        studenti5();
    }
}