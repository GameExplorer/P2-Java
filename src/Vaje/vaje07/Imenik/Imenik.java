package vaje07.Imenik;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tukaj so metode, ki nam vračajo različne izpise
 */
public class Imenik {
    private Oseba[] osebe = new Oseba[0]; //tabela v kateri hranimo podatke o osebah

    /**
     * Prebere seznam oseb iz datoteke in jih shrani v tabelo. Če datoteka ne obstaja sproži izjemo
     * @param vir - pot do datoteke
     * @return - true če je branje oseb uspešno; false sicer
     * @throws FileNotFoundException če datoteka ne obstaja vrne izjemo
     */
    public boolean preberiOsebe(String vir) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(vir));
        int st = 0; // stevilo oseb
        if(sc.hasNextLine()) st = Integer.parseInt(sc.nextLine());

        osebe = new Oseba[st]; //toliko kolikor je vrstic toliko oseb imam

        //branje iz datoteke
        int i = 0;
        while (i < st && sc.hasNextLine()) {
            String[] deli = sc.nextLine().split(", "); //splita podatke po vejici
            if(deli.length < 4)  continue; //ni vseh podatkov za osebo

            boolean mob = false;
            //če je telefonska številka mobilni nastavi na true
            if(deli.length > 4 && deli[4].equalsIgnoreCase("mobilni")) mob = true;

            Oseba o = new Oseba(deli[0], deli[1], deli[2], deli[3], mob); //shrani podatke
            osebe[i] = o;
            i++;
        }

        sc.close();
        if(st == 0 || i < st) return false; //nismo shranili toliko oseb, kot naj bi jih bilo v datoteki (prva vrstica)
        return true;
    }

    /**
     * Izpiše podatke o osebi
     */
    public void izpisiImenik() {
        System.out.printf("Osebe v imeniku (%d):%n", osebe.length);

        for (Oseba oseba : osebe) System.out.println(oseba.toString());
        //for(int i = 0; i < osebe.length; i++) isto kot zgornji for
    }

    /**
     * V imeniku poišče osebo z imenom ime. Pri tem ne upošteva velikih/malih črk
     * @param ime ime iskane osebe
     * @return Prva najdena oseba z imenom ime. null, če osebe z imenom ime ni v imeniku
     */
    public Oseba vrniOseboPoImenu(String ime) {
        for(int i = 0; i < osebe.length; i++) {
            if(ime.equalsIgnoreCase(osebe[i].getIme())) return osebe[i];
        }
        return null;
    }

    /**
     * Poišče in izpiše podatke oseb, katerih telefonska se začne z delnaTelefonska - delno ujemanje
     * telefonske številke. Če nobena oseba ne ustreza iskani telefonski izpiše ustrezno sporočilo
     * @param delnaTelefona celotna ali začetni del telefonske
     */
    public void izpisiOsebePoTelefonski(String delnaTelefona) {
        int stNajdenih = 0;
        for(int i = 0; i < osebe.length; i++) {
            if(osebe[i].getTelefonska().startsWith(delnaTelefona)) {
                stNajdenih++;
                System.out.println(osebe[i]);
            }
        }

        if (stNajdenih == 0) System.out.println("Iskani telefonski številki ne ustreza nobena oseba");
    }

    /**
     * Poišče in izpiše osebe, ki ustrezajo iskanemu nizu, išče po vseh podatkih osebe. Če nobena oseba ne ustreza
     * iskanemu nizu izpiše ustrezno sporočilo
     * @param iskaniNiz iskani niz, lahko je tudi več besed
     */
    public void izpisiIskaneOsebe(String iskaniNiz) {
        String[] besede = iskaniNiz.toLowerCase().split(" ");
        int stNajdenih = 0;

        for(int i = 0; i < osebe.length; i++) {
            String podatki = osebe[i].toString().toLowerCase();

            //Ali podatke osebe vsebujejo vse iskane besede?
            boolean ustreza = true;
            for(int j = 0; j < besede.length; j++) {
                if(!podatki.contains(besede[j])) {
                    ustreza = false;
                    break;
                }
            }
            // vsebujejo iskani niz
            if(ustreza) {
                stNajdenih++;
                System.out.println(osebe[i]);
            }
        }
        //Nismo našli nobene osebe
        if(stNajdenih == 0) System.out.println("Poizvedbi ne ustreza nobena oseba");
    }
}
