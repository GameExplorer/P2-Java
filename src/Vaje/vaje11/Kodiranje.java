package vaje11;

import vaje11.Izjeme.IzjemaDatoteka;
import vaje09.Kodirniki.Kodirniki;

import java.io.*;

/**
 * Vse algoritme in metode kličemo iz prejšnih vaj (vaje 9)
 */
public class Kodiranje {
    private Kodirniki kodirnik; //kodirnik, ki se uporabi za kodiranje in odkodiranje

    public Kodiranje(Kodirniki k) {
        this.kodirnik = k;
    }

    /**
     * Kodiranje besedila (niz znakov)
     */

    public String zakodiranjeBesedila(String besedilo) {
        kodirnik.ponastavi();
        StringBuilder zakodirano = new StringBuilder();

        for(int i = 0; i < besedilo.length(); i++) {
            char zakodiranZnak = (char) kodirnik.zakodiraj(besedilo.charAt(i));
            zakodirano.append(zakodiranZnak);
        }
        return zakodirano.toString();
    }

    /**
     * Odkodiranje besedila (niz znakov)
     */

    public String odkodiranjeBesedila(String besedilo) {
        kodirnik.ponastavi();
        StringBuilder odkodirano = new StringBuilder();

        for(int i = 0; i < besedilo.length(); i++) {
            char odkodiranZnak = (char) kodirnik.odKodiraj(besedilo.charAt(i));
            odkodirano.append(odkodiranZnak);
        }
        return odkodirano.toString();
    }

    /**
     * Kodiranje tekstovne datoteke
     */
    public void zakodirajTekstovneDatoteke(String vhodnaDatoteka, String izhodnaDatoteka) throws IzjemaDatoteka {
        kodirnik.ponastavi();

        try (FileReader vhod = new FileReader(vhodnaDatoteka);
             FileWriter izhod = new FileWriter(izhodnaDatoteka)) {
            int znak;
            while((znak = vhod.read()) != -1) {
                izhod.write((char) kodirnik.zakodiraj(znak));
            }
        } catch (FileNotFoundException e) {
            throw new IzjemaDatoteka(String.format("Napaka: ne najdem datoteke %s", vhodnaDatoteka));
        } catch (IOException e) {
            throw new IzjemaDatoteka(String.format("Napaka: pri branju datoteke %s ali pri pisanju datoteke %s", vhodnaDatoteka, izhodnaDatoteka));
        }
    }

    /**
     * Odkodiranje tekstovnih datotek
     */

    public void odkodiranjeTekstovnihDatotek(String vhodnaDatoteka, String izhodnaDatoteka) throws IzjemaDatoteka {
        kodirnik.ponastavi();

        try(FileReader vhod = new FileReader(vhodnaDatoteka);
            FileWriter izhod = new FileWriter(izhodnaDatoteka)) {
            int znak;
            while((znak = vhod.read()) != -1) {
                izhod.write((char) kodirnik.odKodiraj(znak));
            }
        } catch (FileNotFoundException e) {
            throw new IzjemaDatoteka(String.format("Napaka: ne najdem datoteke %s", vhodnaDatoteka));
        } catch (IOException e) {
            throw new IzjemaDatoteka(String.format("Napaka: pri branju datoteke %s ali pri pisanju datoteke %s", vhodnaDatoteka, izhodnaDatoteka));
        }
    }

    /**
     * Kodiranje binarnih datotek
     */
    public void zakodiranjeBinarneDatoteke(String vhodnaDatoteka, String izhodnaDatoteka) throws IzjemaDatoteka {
        kodirnik.ponastavi();
        try(FileInputStream vhod = new FileInputStream(vhodnaDatoteka);
            FileOutputStream izhod = new FileOutputStream(izhodnaDatoteka)) {
            while(vhod.available() > 0) {
                int bajt = vhod.read();
                izhod.write(kodirnik.zakodiraj(bajt));
            }
        } catch (FileNotFoundException e) {
            throw new IzjemaDatoteka(String.format("Napaka: ne najdem datoteke %s", vhodnaDatoteka));
        } catch (IOException e) {
            throw new IzjemaDatoteka(String.format("Napaka: pri branju datoteke %s ali pri pisanju datoteke %s", vhodnaDatoteka, izhodnaDatoteka));
        }
    }

    /**
     * Odkodiranje binarnih datotek
     */

    public void odkodiranjeBinarneDatoteke(String vhodnaDatoteka, String izhodnaDatoteka) throws IzjemaDatoteka{
        kodirnik.ponastavi();

        try(FileInputStream vhod = new FileInputStream(vhodnaDatoteka);
            FileOutputStream izhod = new FileOutputStream(izhodnaDatoteka)) {
            while(vhod.available() > 0) {
                izhod.write(kodirnik.odKodiraj(vhod.read()));
            }
        } catch (FileNotFoundException e) {
            throw new IzjemaDatoteka(String.format("Napaka: ne najdem datoteke %s", vhodnaDatoteka));
        } catch (IOException e) {
            throw new IzjemaDatoteka(String.format("Napaka: pri branju datoteke %s ali pri pisanju datoteke %s", vhodnaDatoteka, izhodnaDatoteka));
        }
    }

    /**
     * Kodiranje tekstovnih datotek z uporabo podatkovnih tokov
     */
    public void zakodirajPodatkovneDatoteke(String vhodnaDatoteka, String izhodnaDatoteka) throws IzjemaDatoteka {
        kodirnik.ponastavi();

        try(DataInputStream vhod = new DataInputStream(new FileInputStream(vhodnaDatoteka));
            DataOutputStream izhod = new DataOutputStream(new FileOutputStream(izhodnaDatoteka))) {
            while(true) {
                izhod.writeChar(kodirnik.zakodiraj(vhod.readChar()));
            }
        } catch (EOFException e) {
            System.out.println(e);
        } catch (FileNotFoundException fne) {
            throw new IzjemaDatoteka(String.format("Napaka: ne najdem datoteke %s.", vhodnaDatoteka));
        } catch (IOException e) {
            throw new IzjemaDatoteka(String.format("Napaka: pri branju %s ali pisanju %s datoteke", vhodnaDatoteka, izhodnaDatoteka));
        }
    }

    /**
     * Odkodiranje tekstovnih datotek z uporabo podatkovnih tokov
     */
    public void odkodiranjePodatkovneDatoteke(String vhodnaDatoteka, String izhodnaDatoteka) throws IzjemaDatoteka {
        kodirnik.ponastavi();

        try(DataInputStream vhod = new DataInputStream(new FileInputStream(vhodnaDatoteka));
            DataOutputStream izhod = new DataOutputStream(new FileOutputStream(izhodnaDatoteka))) {
            while(true) {
                izhod.writeChar(kodirnik.odKodiraj(vhod.readChar()));
            }
        } catch (EOFException e) {
            System.out.println(e);
        } catch (FileNotFoundException fne) {
            throw new IzjemaDatoteka(String.format("Napaka: ne najdem datoteke %s.", vhodnaDatoteka));
        } catch (IOException e) {
            throw new IzjemaDatoteka(String.format("Napaka: pri branju %s ali pisanju %s datoteke", vhodnaDatoteka, izhodnaDatoteka));
        }
    }
}
