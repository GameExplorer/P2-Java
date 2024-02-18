[[DN 7 - Velika Domača - Delo z datotekami]]
[[DN 5 -  Štetje števk]]

#bsd #niz #String 

---

**Definicija**: dana niza sta **_sorodna_**, če sta enako dolga in imata enako kontrolno vsoto BSD.

**Naloga:** Napiši program DN06, ki izpiše po abecedi najmanjši niz, ki je sestavljen iz malih črk angleške abecede in je soroden prvemu argumentu programa.

**Primer:** Niz "pomlad" ima enako BDS kontrolno vsoto kot nizi "bbaabi", "bbaadh", "bbaafg", .... Ker je niz "bbaabi" (po abecedi) najmanjši, naj vaš program ob klicu

	java DN06 pomlad

izpiše `bbaabi`

Dodatna navodila:

- Kontrolna vsota BSD se izračuna tako, da se med seštevanjem znakov podanega niza na vsakem koraku prvi bit ciklično premakne na zadnje (15.) mesto, poleg tega pa se vsoto ves čas drži na interval [0...65535]. Natančneje, BDS vsoto (checksum) lahko izračunamo z naslednjo metodo:


```
// povzeto po https://en.wikipedia.org/wiki/BSD_checksum  
static int bsdChecksum(String niz) {      
    int checksum = 0;  
    for (int i = 0; i<niz.length(); i++) {  
      checksum = (checksum >> 1) + ((checksum & 1) << 15);  
      checksum += niz.charAt(i);  
      checksum &= 0xffff;         
    }  
    return checksum;  
 }
```


- Nizi dolžine 5 so po vrsti (po abecednem redu) urejeni takole: "aaaaa", "aaaab", "aaaac", ...., "aaaaz", "aaaba", "aaabb", ...

- Ker morate poiskati _prvi niz_ (ki je soroden podanemu nizu), svetujem, da začnete z najmanjšim nizom (to je niz, ki vsebuje toliko a-jev kot je dolžina niza, ki je podan v argumentu) in ga povečujete. Napišete metodo String povecaj(String niz), ki prejme niz in vrne prvi večji niz. Primer: metoda povecaj("aaaab") vrne "aaaac".

## REŠITEV


```

public class DN06 {

  // Kontrolna vsota BSD (povzeto po https://en.wikipedia.org/wiki/BSD_checksum)
  static int bsdChecksum(String niz) {
    int checksum = 0;

    for (int i = 0; i<niz.length(); i++) {
      checksum = (checksum >> 1) + ((checksum & 1) << 15);
      checksum += niz.charAt(i);
      checksum &= 0xffff;       /* Keep it within bounds. */
    }
    return checksum;
  }

  // Motoda prejme niz in vrne prvi po abecedi večji ni
  static String povecaj(String niz) {
    int z = niz.length()-1;

    // poiščem prvo črko od zadaj, ki je različna od z ...
    while (z >= 0) {
      // ... če taka črka obstaja, jo povečam, vse črke za njo pa postavim na 'a';
      if (niz.charAt(z) < 'z')
        return niz.substring(0,z) + ((char)(niz.charAt(z)+1)) + "a".repeat(niz.length()-z-1); 
      else
        z=z-1;
    }
    // ... če pa taka črka ne obstaja, večjega niza te dolžine ni, zato vrnem null
    return null;
  }

  public static void main(String[] args) {  
    // args = new String[]{"pomlad"};
    
    if (args.length != 1) {
      System.out.println("Program potrebuje en argument!");
      System.exit(0);
    }

    String niz = args[0];
    int csNiz = bsdChecksum(niz);


    // začnem z nizom, ki je enako dolg kot 1. argument in je sestavljen iz samih 'a'-jev
    String trNiz="a".repeat(niz.length());

    while (trNiz != null) {
      
      // izracunam BSD trenutnega niza ...
      int csTr=bsdChecksum(trNiz);
      // ... in ga primerjam z BSD 1. argumenta; če sta enaka, niz izpišem ...
      if (!trNiz.equals(niz) && csTr == csNiz) {
        System.out.println(trNiz);
        return;
      }
      // ... sicer niz "povecam" in nadaljujem z iskanjem
      trNiz = povecaj(trNiz);
    }
  }
}
```
