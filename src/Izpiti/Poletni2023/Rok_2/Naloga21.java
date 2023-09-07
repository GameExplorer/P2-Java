package Izpiti.Poletni2023.Rok_2;

public class Naloga21 {

    /**
     * Pretvorba iz desetiškega v dvojiski sistem
     * @param x - desetiško število
     * @return - vrnem dvojisko stevilo
     */
    public static String vDvojisko(int x) {
        // Za negativna števila vrnem 0
        if(x <= 0) return "0";

        String rezultat = "";

        while(x > 0) { //dokler je x večji od 0
            if ((x & 1) == 1) rezultat = "1" + rezultat; //zadnjo cifro dodam v rezultat...
            else rezultat = "0" + rezultat; //sicer dodam na koncu 0 ...

            x = x >> 1; //... nato jo odrežem od x
        }

        return rezultat; //vrnem rezultat
    }

    /**
     * Pretvorba iz dvojiskega v desetiški sistem
     * @param d - dvojiški zapis
     * @return - vrne desetiško številko
     */
    public static int vDesetisko(String d) {
        int utez = 1;
        int rezultat = 0;

        //Sprehodim se od najmanj do najbolj pomembnega bita
        for(int i = d.length() - 1; i >= 0; i--) {
            //če je bit prizgan, ga pristejem rezultatu
            if(d.charAt(i) == '1') {
                rezultat += utez;
            }
            utez *= 2; // 2 ... 4... 8 .. 16.. 32
        }

        return rezultat;
    }

    public static void main(String[] args) {
        args = new String[]{"42"};

        int x = Integer.parseInt(args[0]);
        System.out.println("x " + x);

        String dvojisko = vDvojisko(x);
        System.out.println("b: " + dvojisko);

        System.out.println();
        int y = vDesetisko(dvojisko);
        System.out.println();
        System.out.println("d: " + y);
    }
}
