[[DN 3 - Gesla]]
[[DN 1 - Prvi program v Javi]]

#for_zanka 

---

Napišite program DN02, ki besede, ki jih prejme v argumentih, izpiše na zaslon in jih uokviri.

**Primer**: ob klicu

*java DN02 Java je zakon!*  

naj program izpiše

```
******************     
* Java je zakon! *     
******************   
```

Program naj preveri, ali je dobil argumente; če argumentov ni dobil, naj javi napako (*Napaka pri uporabi programa!*).

## REŠITEV

```
public class DN02 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Napaka pri uporabi programa!");
      System.exit(0);
    }
    
    String niz = "";
    for (int i = 0; i < args.length; i++) 
     niz += args[i] + " ";
    int dolzina = niz.length() + 3;
    
    // prva vrstica
    for (int i = 0; i < dolzina; i++) 
      System.out.print("*");
    System.out.println();
    
    // besedilo z levim in desnim okvirom
    System.out.println("* " + niz + "*");
    
    // zadnja vrstica
    for (int i = 0; i < dolzina; i++) 
      System.out.print("*");      
    System.out.println();
  }
}
```

