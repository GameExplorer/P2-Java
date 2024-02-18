[[DN 4 - Dvojiško sporočilo]]
[[DN 2 - Izpis besedila v Okvirju]]

#tabele #branje_datotek #metode 

---

Napiši program DN03, ki ustvari naključno geslo dolzine n (drugi argument) po naslednjem postopku:  najprej v tabelo besede prebere vse besede, ki so zapisane v datoteki, katere ime je podano v prvem argumentu (glej primer spodaj), nato pa geslo sestavi iz  črk prebranih besed in sicer tako, da n-krat izbere naključno črko naključno izbrane besede iz tabele.  
   
Naključna števila ustvarite s pomočjo razreda Random in metode nextInt(n). Začetno seme za generiranje zaporedja naključnih števil je podano kot tretji argument ob klicu programa.

Datoteka z besedami (primer: gesla.txt) v prvi vrstici vsebuje podatek o številu besed, nato v vsaki vrstici po eno besedo.  

**Primer:** ob klicu programa *java DN03 gesla.txt 10 100*

naj program izpiše	`0t6-37fX89`

## REŠITEV

```
public class DN03 {

  static String[] preberiBesede(String imeDatoteke) throws Exception {
    // odprem datoteko
    Scanner sc = new Scanner(new File(imeDatoteke));
    // preberem stevilo besed ...
    int steviloBesed = sc.nextInt();
    // ... in ustvarim tabelo primerne dolzine ...
    String[] besede = new String[steviloBesed];
    // .... ter preberem vse besede iz datoteke v tabelo
    for (int i = 0; i < steviloBesed; i++) {
      besede[i] = sc.next();
    }
    sc.close();
    
    return besede;
  }

  static String ustvariGeslo(String[] besede, int dolzina, int seme) {
    String geslo = "";
    Random rnd = new Random(seme);
    // generirem n crk in sicer tako, da napjre ...
    for (int i = 0; i < dolzina; i++) {
      int beseda = rnd.nextInt(besede.length); // ... izberem besedo ...
      int crka = rnd.nextInt(besede[beseda].length()); // nato se crko      
      geslo = geslo + besede[beseda].charAt(crka);
    }
    return geslo;
  }
  
  public static void main(String[] args) throws Exception {
    // args = new String[]{"viri/gesla.txt", "8", "100"}; 

    if (args.length != 3) {
      System.out.println("Napacno stevilo argumentov.");
      System.exit(0);
    }

    // shranim (in pretvorim) argumente 
    String imeDatoteke = args[0];              // ime datoteke z gesli
    int dolzina = Integer.parseInt(args[1]);   // dolzina gesla, ki ga generiram
    int seme    = Integer.parseInt(args[2]);   // seme za naključno zaporedje

    String[] besede = preberiBesede(imeDatoteke); 
    String geslo    = ustvariGeslo(besede, dolzina, seme);
    System.out.println(geslo);
  }
}
```