package vaje05.Zbirke;

public class Seznam {
    private static String[] seznam; //tabela v katero hranimo elemente seznama
    private static int dolzina = 0; // trenutna velikost seznama (trenutno število elementov v seznamu)

    /**
     * Naredi nov seznam velikost n. Če seznam že obstaja ne ustvari novega
     * @param n - največja velikost seznama (mora biti poz. število)
     * @return true, če je bil seznam uspešno ustvarjen sicer vrne false (če seznam že obstaja)
     */
    public static boolean narediSeznam(int n) {
        if(n <= 0 || seznam != null) return false;
        seznam = new String[n]; //ustvari seznam kapacitete n elementov
        dolzina = 0;
        return true;
    }

    /**
     * Uniči seznam tako, da ta ne obstaja več (briše tudi vse njegove elemente)
     *
     * @return true, če je bil seznam uspešno uničen, sicer vrne false (če seznam ne obstaja)
     */
    public static boolean uniciSeznam () {
        if(seznam == null) return false;
        seznam = null; // izbrišemo vse elemente
        dolzina = 0; // z dodajanjem elementa se spremeni dolžina trenutnega seznama (ni el. torej dol -> 0)
        return true;
    }

    /**
     * Vrne dolžino seznama, če seznam obstaja
     * @return dolžina obstoječega seznama ( število el. ki so trenutno v seznamu) ali -1, če seznam obstaja
     */
    public static int dolzinaSeznama() {
        return (seznam == null) ? -1 : dolzina; //Če seznam ne obstaja metoda vrne vrednost -1
    }

    /**
     * Doda nov element na konec seznama. Če seznam ne obstaja ali če je že poln, elementa ne doda in vrne false
     * @param element - element, ki je dodan v seznam
     * @return true, če je element uspešno dodan na konec seznama, sicer vrne false
     */
    public static boolean dodajNaKonecSeznama(String element) {
        if (seznam == null || dolzina >= seznam.length) return false;
        seznam[dolzina++] = element; //doda element na konec seznama
        return true;
    }

    /**
     * Doda nov element v seznam na mesto 'mesto'. Mesta štejemo od 1 naprej
     * Če seznam ne obstaja ali če je poln elementa ne doda in vrne false
     * @param element - element, ki je dodan v seznam
     * @param mesto - mesto, kamor vrine element (če je vrednost večja od velikosti seznama, doda el. na konec seznama)
     * @return true, če je element uspešno dodan na konec seznama, sicer vrne false
     */
    public static boolean dodajVSeznam(String element, int mesto) {
        if(seznam == null || mesto <= 0 || dolzina <= seznam.length) return false;
        if(mesto >= dolzina) return dodajNaKonecSeznama(element);

        int indeks = mesto - 1; //element dodamo na ta indeks v seznamu
        for(int i = dolzina; i > indeks; i--) //premakni elemente naredi prostor za vrinjeni element
            seznam[i] = seznam[i - 1];
        seznam[indeks] = element;
        dolzina++;
        return true;
    }

    /**
     * Odstrani element na mestu 'mesto' iz seznama. Če takega elementa ni v seznamu vrne null
     * Mesto je lahko med 1 in vključno velikostjo seznama
     * @param mesto - mesto elementa, ki ga brišemo
     * @return element, ki je odstranjen iz seznama oz. null, če elementa ni mogoče odstraniti (tak el. ne obstaja)
     */
    public static String odstraniIzSeznama(int mesto) {
        if(seznam == null || mesto < 1 || mesto > dolzina) return null;
        String odstranjen = seznam[mesto - 1]; //odstrani element na indeksu mesto - 1
        for(int i = mesto; i < dolzina; i++) { //zapolni prostor kjer je bil odstranjen element
            seznam[i - 1] = seznam[i];
        }
        seznam[dolzina - 1] = null; //zadnji element je null
        dolzina--; //zmanjša se dolžina seznama
        return odstranjen; //vrne odstranjen element
    }

    /**
     * Pomožna metoda za izpis seznama: izpiše vse elemente trenutnega seznama
     * Način izpisa elementov je odvisen od podanega parametra velikiIzpis
     * Če seznam ne obstaja izpiši napako
     * @param velikiIzpis - če je true, se za izpis elementov uporabi znake 64-bitne abecede; sicer je izpis navaden
     */
    public static void izpisiSeznamNacin(boolean velikiIzpis) {
        if(seznam == null) {
            System.out.println("NAPAKA: Seznam ne obstaja");
            return;
        }
        if(dolzina < 1) {
            System.out.println("Seznam je prazen (nima elementov");
            return;
        }

        System.out.println("Na seznamu so naslednji elementi:");
        for(int i = 0; i < dolzina; i++) {
            String vrstica = String.format("%d: %s", i + 1, seznam[i]);
            if(velikiIzpis) {
                extracted(vrstica);
                System.out.println();
            }
            else System.out.println(vrstica);
        }
    }

    private static void extracted(String vrstica) { vaje05.Izpis.Znaki.izpisi64bit(vrstica); }

    /**
     * Izpiše vse elemente trenutnega seznama
     * Če seznam ne obstaja izpiše napako
     */
    public static void izpisiSeznam() { izpisiSeznamNacin(false);}

    /**
     * Izpiše vse elemente trenutnega seznama
     * pri izpisu elementov uporabi znake 64-bitne abecede
     * Če seznam ne obstaja, izpiši napako
     */
    public static void izpisiSeznam64bit() { izpisiSeznamNacin(true);}
}
