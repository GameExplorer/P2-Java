[[DN 11 - Velika Domača - Na počitnice z vlakom]]
[[DN 9 - Obseg Likov]]

#niz #Množice #HashSet #TreeSet #ArrayList 

---

Napiši program, ki izpiše najdaljši skupni podniz, ki je vsebovan v vseh argumentih programa.

Primer: ob klicu

`java DN10 **abc**abc ab**abc**d`

naj program izpiše niz `abc`.

Namig: Najprej napiši metodo `TreeSet<String> getVsiPodnizi(String niz)`, ki vrne množico vseh podnizov danega niza (primer: podnizi niza `"abcabc`" so *"a", "b", "c", "ab", "bc", "ca", "abc", "bca", "cab", "abca", "bcab", "cabc", "abcab", "bcabc", "abcabc"*). Nato naredi presek vseh množic (uporabi metodo `retainAll()`) in v preseku poišči najdaljšo besedo.


## REŠITEV
```

import java.util.TreeSet;

/**
 * Napiši program, ki izpiše najdaljši podniz, ki je vsebovan v vseh argumentih programa.
 * Primer: java DN10 abcabc ababcd
 *   ... izpis: abc
 * Primer: java DN10 CATGACGTCGCGGACAA ATTCTGAAGTTACAGACTT AGGTGGCAGATTAGGAG
 *   ... izpis: AT
 *
 * Namig: Najprej napiši metodo TreeSet<String> getVsiPodnizi(String niz), ki vrne množico
 *        vseh podnizov danega niza (primer: podnizi niza "abcabc" so
 *        a, b, c, ab, bc, ca, abc, bca, cab, abca, bcab, cabc, abcab, bcabc, abcabc);
 *        nato naredi presek vseh množic (uporabi metodo retainAll()) in iz preseka izberi
 *        najdaljšo besedo.
 *
 **/
public class DN10 {

  static TreeSet<String> getVsiPodnizi(String niz) {
    TreeSet<String> result = new TreeSet<>();
    for (int i = 1; i <= niz.length() ; i++) {
      for (int j = 0; j < niz.length()-i+1; j++) {
        result.add(niz.substring(j,j+i));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Podaj vsaj en argument.");
      System.exit(0);
    }

    TreeSet<String> besede = getVsiPodnizi(args[0]);
    for (int i = 1; i < args.length; i++) {
      besede.retainAll(getVsiPodnizi(args[i]));
    }

    String najD = "";
    for(String b : besede)
      if (b.length() > najD.length()) najD = b;
    System.out.println(najD);
  }
}

```
