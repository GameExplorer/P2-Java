[[DN 6 - Kontrolna vsota BSD]]
[[DN 4 - Dvojiško sporočilo]]

#String #for_zanka #formatiranIzpis 

---

Program naj iz podanih argumentov sestavi niz ter prešteje, kolikokrat se v tem nizu pojavi posamezna števka ('0', '1', ..., '9'). Ob koncu naj program izpiše najbolj pogosto uporabljeno števko ter frekvenco uporabe. Če največjo vrednost zasede več števk hkrati, izpišite vse in sicer po vrsti od najmanjše do največje.  
  
Primer: ker se v nizu `'a8d 82 d1810x51'` najpogosteje pojavita števki '1' in '8'  (in to 3-krat), naj program ob klicu  
  
`java DN05 a8d 82 d1810x51`

izpiše  

  `'a8d 82 d1810x51' -> 1 8 (3)`  
   
Pri izpisu upoštevajte tudi primer, da v nizu ni nobene števke (izpis: `V nizu '...' ni stevk`).

## REŠITEV


```
package DomaceNaloge;  
  
public class DN5 {  
public static void main(String[] args) {  
args = new String[]{"85858442 121das 51ffsa"};  
  
if(args.length < 1) {  
System.out.println("Uporaba java DN05 <beseda>...");  
System.exit(0);  
}  
  
String niz = "";  
for(int i = 0; i < args.length; i++) {  
niz += args[i] + " ";  
}  
  
niz = niz.trim(); //odrežem presledek na koncu niza  
  
int steviloStevk = 0; //koliko stevk se je pojavilo v nizu  
  
int[] stevke = new int[10];  
  
for(int i = 0; i < niz.length(); i++) {  
if(niz.charAt(i) >= '0' && niz.charAt(i) <= '9') {  
steviloStevk++;  
stevke[niz.charAt(i) - '0']++;  
}  
}  
  
if(steviloStevk > 0) {  
int max = 0;  
for(int i = 0; i < stevke.length; i++) {  
if(stevke[i] > max) {  
max = stevke[i];  
}  
}  
  
System.out.printf("'%s -> ", niz);  
  
for(int i = 0; i < stevke.length; i++) {  
if(stevke[i] == max) {  
System.out.printf("%c ", (char)(i+'0'));  
}  
}  
System.out.printf("(%d)%n", max);  
}  
else {  
System.out.printf("V nizu '%s' ni stevk %n", niz);  
}  
}  
}
```
