[[DN 10 - Najdaljši skupni podniz]]
[[DN 8 - Planeti]]

#interfaces  #oop #razredi #izpeljani_razredi 

---

Napiši program za računanje skupnega obsega likov (pravokotnik, kvadrat, pravilni n-kotnik), ki so podani kot argumenti ob klicu programa. Vse velikosti stranic so cela števila.

Primer: ob klicu programa

`  java DN09 kvadrat:5 pravokotnik:10:3 nkotnik:5:2`

naj program izpiše

`56`

(saj je obseg kvadrata s stranico 5 enak 20, obseg pravokotnika s stranicama 10 in 3 enak 26 in obseg 5-kotnika s stranicami dolžine 2 enak 10).

Natančneje:  
  
1) V datoteki Lik.java je zapisan vmesnik, ki opisuje lik, v njem je deklarirana  metoda `obseg()`.  
  
2) Napiši razrede *Pravokotnik*, *Kvadrat*  in *NKotnik*, ki naj implementirajo vmesnik *Lik* in v njih smiselno definiraj metodo `obseg()`. Vsak od teh razredov naj ima atribute, ki ga opisujejo, ter konstruktor s primernim številom parametrov.  
  
3) Napiši razred DN09 in v njem

a) tabelo Liki,  v kateri boš hranil like,  
  
b) statično metodo `skupniObseg()`, ki prejme tabelo likov in izračuna ter vrne njihov skupni obseg (obseg posameznega lika iz tabele dobi s klicem metode obseg()),  
  
c) v metodi main iz argumentov ustrari tabelo, kilči metodo `skupniObseg()` in izpiši rezultat.

## REŠITEV



```

interface Lik {

  public double obseg();
}

class Pravokotnik implements Lik {

  int a, b;

  Pravokotnik(int a, int b) {

    this.a = a;
    this.b = b;
  }

  public double obseg() {
    return 2 * (a + b);
  }
}

class Kvadrat extends Pravokotnik {
  Kvadrat(int a) {
    super(a,a);
  }
}

class NKotnik implements Lik {

  int a; // velikost stranice
  int n; // stevilo stranic

  NKotnik(int a, int n) {
    this.a = a;
    this.n = n;
  }

  public double obseg() {
    return n * a;
  }

}

public class DN09 {

  static int skupenObseg(Lik[] liki) {
    int obseg = 0;
    for (int i = 0; i < liki.length; i++) {
      obseg += liki[i].obseg();
    }
    return obseg;
  }
  
  public static void main(String[] args) {
    //args = new String[]{"kvadrat:5", "pravokotnik:10:3", "nkotnik:5:2"};
    
    // ustvarim tabelo za vse like; število likov je enako številu argumentov ...
    Lik[] liki = new Lik[args.length];
    for (int i=0; i<args.length; i++) {
      String[] podatki = args[i].split(":");
      switch (podatki[0]) {
         case "kvadrat":
            liki[i]= new Kvadrat(Integer.parseInt(podatki[1]));
            break;
          case "pravokotnik":
            liki[i]= new Pravokotnik(Integer.parseInt(podatki[1]), Integer.parseInt(podatki[2]));
            break;
          case "nkotnik":
            liki[i]= new NKotnik(Integer.parseInt(podatki[1]), Integer.parseInt(podatki[2]));
        }
      }
  
    // ... izračunam skupen obseg ...
    int skupenObseg = skupenObseg(liki);
    // ... in izpišem rezultat
    System.out.printf("%d\n", skupenObseg);
  }
}
```

###### VMESNIK LIK

```
public interface Lik {  
	public double obseg();  
}
```
