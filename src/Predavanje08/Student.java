package Predavanje08;

import java.util.Scanner;


class student {

    static final int maxOcen = 10;
    private String ime;
    private String iD;

    private int[] ocene;
    private int stOcen;

    private String status;



    student() {
        this.ime="?";
        this.iD="?";
        this.stOcen = 0;
        this.ocene = new int[maxOcen];
    }

    student(String tIme, String tiD) {
        this(); //klic konstruktorja
        stOcen = 0;
        this.ime = tIme;
        this.iD = tiD;
        ocene = new int[maxOcen];
    }

    public void setIme(String tIme) {
        this.ime = tIme;
    }
    public String getIme() {
        return ime;
    }
    public void setID(String iD) {
        this.iD = iD;
    }
    public String getiD() {
        return iD;
    }
    boolean prostorVTabeli() {
        return stOcen < maxOcen;
    }
    void dodajOceno(int ocena) {
       if(stOcen < maxOcen)
           ocene[stOcen++] = ocena;

        if(povprecje() > 9) status = "Odličen";
        else status = "Dober";
    }
    double povprecje() {
        if(stOcen == 0) return 0;
        double vsota = 0;
        for(int i = 0; i < stOcen; i++) {
            vsota += ocene[i];
        }
        return vsota / stOcen;
    }

    public String toString() {
        return String.format("Ime: %s, ID: %s, povp.ocena: %.2f, status:%s", ime, iD, povprecje(), status);
    }


}
public class Student {

    public static void studenti(int n) {
        String[] ime = new String[n];
        String[] ID = new String[n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            System.out.print("Vpiši ime: ");
            ime[i] = sc.nextLine();

            System.out.print("Vpiši ID: ");
            ID[i] = sc.nextLine();
        }
    }

    public static void studenti3(int n) {
        student[] studenti = new student[n]; //ustvarimo tabelo študentov velikosti n v katero lahko dodajm študente

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            student s = new student();

            System.out.print("Vpiši ime: ");
            s.setIme(sc.nextLine());

            System.out.print("Vpiši ID: ");
            s.setID(sc.nextLine());

            studenti[i] = s;
        }
    }
    public static void studenti4(int n) {
        student[] studenti = new student[n]; //ustvarimo tabelo študentov velikosti n v katero lahko dodajm študente

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            String ime, iD;
            System.out.print("Vpiši ime: ");
            ime = sc.nextLine();
            System.out.print("Vpiši ID: ");
            iD = sc.nextLine();

            student s = new student(ime, iD);

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
        student s1 = new student(ime, iD);
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

        studenti5();

    }
}
