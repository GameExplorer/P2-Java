[[DN 9 - Obseg Likov]]
[[DN 7 - Velika Domača - Delo z datotekami]]

#razredi #oop  #getSet #Konstruktor

---
# Navodilo

a) Napišite razred Planet z dvema atributoma - ime planeta (String) in radij planeta (int). V razredu Planet napišite tudi metodo double povrsina(), ki izračuna in vrne površino planeta z danim radijem.

b) V razredu DN08 napišite metodo, ki iz datoteke prebere podatke o planetih (ime datoteke je podano kot prvi argument) in vrne tabelo objektov razreda Planet. V datoteki (primer planeti.txt, je vsak planet opisan v svoji vrstici,  podana sta ime in radij planeta (podatka sta ločena z dvopičjem).  Upoštevajte, da je število planetov omejeno (8).

c) Program DN08 naj izpiše skupno površino planetov, ki so podani v drugem argumentu ob klicu programa. Pri tem neznana imena planetov ignorirajte, pri primerjavi imen planetov pa ignorirajte razlike v velikih in malih črkah (primer: ZEMLJA == Zemlja == zemlja, ...).

**Primer 1**: `java DN08 planeti.txt Zemlja`

`Povrsina planetov "Zemlja" je 511 milijonov km2`

**Primer 2**: `java DN08 planeti.txt Zemlja+Mars`

`Povrsina planetov "Zemlja+Mars" je 656 milijonov km2`

**Primer 3**:  `java DN08 planeti.txt ZEMLJA+mars+luna`

`Povrsina planetov "ZEMLJA+mars+luna" je 656 milijonov km2`
## REŠITEV


```
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Planet {
  private String ime;
  private int radij;
  
  Planet() {}
  
  // konstruktor z omeba parametroma
  public Planet(String ime, int radij) {
    this.ime = ime;
    this.radij = radij;
  }

  public String getIme() {
    return ime;
  }
    
  
  double povrsina() {
    double povrsina = 4*Math.PI*radij*radij;
    return povrsina;
  }
}


public class DN08 {

  /**
   * Metoda prebere datoteko in vrne tabelo planetov.
   */
  static Planet[] preberiPlanete(String imeDatoteke) {
    try {
      Planet [] planeti = new Planet[8];
      int i = 0;
      
      // če vem, v kakšnem formatu je zakodirana vhodna datoteka, format (npr. UTF-8)
      // podam kot drugi argument pri klicu konstruktorja razreda Scanner
      Scanner sc = new Scanner(new File(imeDatoteke), "UTF-8");
      while (sc.hasNextLine()) {
        String vrstica = sc.nextLine();
        String [] deli = vrstica.split(":");
        
        if (deli.length == 2) 
          planeti[i++] = new Planet(deli[0], Integer.parseInt(deli[1]));
        
      }
      sc.close();
      return planeti;
    } catch (FileNotFoundException ex) {
      return new Planet[0];
    }    
  }
  
  public static void main(String[] args)  {
    // za lazje testiranje na začetku napolnim tabelo args
    // args = new String[]{"viri/planeti.txt", "ZEMLJA+mars+luna"};
    
    Planet [] planeti = preberiPlanete(args[0]);
    
    String poizvedba = args[1];                 
    String [] deliPoizvedba = poizvedba.split("[+]");  //"Zemlja+Mars++Jupiter" -> {"Zemlja","Mars","Jupiter"}
    double vsota = 0;
    for(int k=0; k<deliPoizvedba.length; k++) { // sprehod po vseh poizvedbah
      int p = -1;
      for (int j = 0; j < planeti.length; j++) { // sprehod po vseh planetih
        if (planeti[j].getIme().equalsIgnoreCase(deliPoizvedba[k])) p=j;
        // namesto equalsIgnoreCase lahko primerjavo naredim tudi ročno takole:
        //if (planeti[j].ime.toLowerCase().equals(deliPoizvedba[k].toLowerCase())) p=j;
      }
      if (p!=-1){
        vsota += planeti[p].povrsina();
      } 
    }
    System.out.printf("Povrsina planetov \"%s\" je %.0f milijonov km2\n", poizvedba, vsota/1000000);
  }
}
```
