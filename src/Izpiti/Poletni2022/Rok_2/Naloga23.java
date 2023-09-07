package Izpiti.Poletni2022.Rok_2;

/**
 * Razred predstavlja matriko celih števil ima dva atributa  ki določata vellikost matrike in tretji ki nastavi
 * vrednost matrike
 */
class Matrika {
    private int m;
    private int n;

    private int[][] vrednosti;

    // Konstruktor, nastavi vrednost matrike
    public Matrika(int m, int n) {
        this.m = m;
        this.n = n;
        vrednosti = new int[m][n];
    }

    //prejme 2D tabelo in ji določi velikost
    public Matrika(int[][] matrika) {
        this.m = matrika.length;
        this.n = matrika[0].length;
        vrednosti = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                vrednosti[i][j] = matrika[i][j];
            }
        }
    }

    // Metod aza izpis podatkov
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Matrika %d x %d: %n", m,n));
        for(int i = 0; i < m; i++) { //vrstice
            for(int j = 0; j < n; j++) { //stolpci
                sb.append(String.format("%2d ", vrednosti[i][j])); //izpis
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Pomnozi dve matriki
    public void pomnozi(int skalar) {
        for(int i = 0; i < m; i++) { //sprehod po vrsticah
            for(int j = 0; j < n; j++) { // sprehod po stolpcih
                vrednosti[i][j] *= skalar;
            }
        }
    }

    public static Matrika vsota(Matrika m1, Matrika m2) {
        if(m1.m != m2.m || m1.n != m2.n) { //Če se dimenziji matrik ne ujemajo vrni null
            return null;
        }
        Matrika rez = new Matrika(m1.m, m1.n);
        //sprehod po m in n in ju seštejemo
        for(int i = 0; i < m1.m; i++) {
            for(int j = 0; j < m1.n; j++) {
                rez.vrednosti[i][j] = m1.vrednosti[i][j] + m2.vrednosti[i][j];
            }
        }

        return rez;
    }
}
public class Naloga23 {
    public static void main(String[] args) {
        Matrika m1 = new Matrika(new int[][] {{1,2,3,4,5}, {5,4,3,2,4}, {11,12,13,14,15}});
        Matrika m2 = new Matrika(new int[][] {{1,7,5,4,12}, {8,9,12,42,32}, {21,22,24,27,69}});
        Matrika m3 = new Matrika(new int[][] {{1,7,5}, {8,9,12}, {21,22,24}});

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        m1.pomnozi(3);
        System.out.println("SKALAR");
        System.out.println(m1);

        Matrika vsota = Matrika.vsota(m1, m2);
        System.out.println("DVE POMNOŽENI MATRIKI");
        System.out.println(vsota);

        m3.pomnozi(5);
        System.out.println("SKALAR");
        System.out.println(m3);
    }
}
