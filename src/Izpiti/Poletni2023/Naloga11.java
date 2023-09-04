package Izpiti.Poletni2023;

/**
 * Kolesarski števec šteje koliko kolesarjev je ta dan peljalo mimo števca
 * Ima tri podatke: današnje število kolesarjev, skupno število kolesarjev in današnji datum.
 * Datum je v obliki MM:DD naprej mesec nato dan.
 * Mi izračunamo povprečje kolesarjev in izračunamo kakšen je bil dan.
 * 1 nadpovprečen
 * 0 povprečen
 * -1 podpovrečen
 * Formula:
 * double povprecje = (double) letos / dni; //izračunamo povprečje kolesarjev do danes
 */
public class Naloga11 {

    public int kaksenDan(String datum, int danes, int letos) {
        String[] deli = datum.split("[.]"); //razbijemo napis 04.03 na mesec in dan
        int mesec = Integer.parseInt(deli[0]); //mesec
        int dan = Integer.parseInt(deli[1]); //dan

        int[] meseci = {31,28,31,30,31,30,31,31,30,31,30,31}; //dnevi po posameznih mesecih

        int dni = 0; //šteje koliko dni je minilo od 1.1 do 'danes'

        for(int i = 0; i < mesec - 1; i++) { //sprehodiš se po mesecih
            dni += meseci[i]; //vsak mesec dodaš k dnevu.. št. dni v posameznem mesecu dodaš k dnem
            //System.out.println(dni);
        }

        dni += dan;
        //System.out.println(dni);


        double povprecje = (double) letos / dni; //izračunamo povprečje kolesarjev do danes
        //System.out.println(povprecje);

        // Če je danes bilo več kolesarjev kot je povprečje vrnem 1
        // Če je danes bilo manj kolesarjev kot je povprečje vrnem -1
        // Če je bil dan povprečen, enako število kolesarjev vrnem 0
        return danes > povprecje ? 1 : (danes < povprecje ? -1 : 0);
    }
    public static void main(String[] args) {
        // Uporabi argumente takole: DATUM DANES LETOS

        Naloga11 naloga11 = new Naloga11();
        System.out.println(naloga11.kaksenDan("04.03", 5, 450));
    }
}
