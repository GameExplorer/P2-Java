
**02.04.2023**

[[Vaje 3 - Pikčasti Znaki]]
[[Vaje 5 - Nakupovalni Seznam]]


#branje_datotek 

---

[Koda](https://github.com/GameExplorer/P2_Vaje/tree/master/src/vaje04)

Naredili smo igro Besedle. 

```Besedle je slovenska verzija znane besedne igre Wordle. V tej igri ugibamo neznano besedo s petimi črkami, za kar imamo na voljo 6 poskusov. Po vsakem poskusu dobimo namige za iskano besedo: pravilno uganjene črke se obarvajo zeleno, črke na nepravilnih mestih z rumeno, nepravilne črke pa ostanejo neobarvane.```




[Besedle](https://besedle.com/) je slovenska verzija znane besedne igre Wordle. V tej igri ugibamo neznano besedo s petimi črkami, za kar imamo na voljo 6 poskusov. Po vsakem poskusu dobimo namige za iskano besedo: pravilno uganjene črke se obarvajo zeleno, črke na nepravilnih mestih z rumeno, nepravilne črke pa ostanejo neobarvane.  

**Vaša naloga**: napišite program, ki omogoča igranje igre Besedle.

  

#### Primer igre

  

Preostale črke:  A  B  C  Č  D  E  F  G  H  I  J  K  L  M  N  O  P  R  S  Š  T  U  V  Z  Ž 
Poskus 1/6: DREVO
 D  R  E  V  O 

Preostale črke:  A  B  C  Č  D  E  F  G  H  I  J  K  L  M  N  O  P  R  S  Š  T  U  V  Z  Ž 
Poskus 2/6: KLIMA
 K  L  I  M  A 

Preostale črke:  A  B  C  Č  D  E  F  G  H  I  J  K  L  M  N  O  P  R  S  Š  T  U  V  Z  Ž 
Poskus 3/6: CISTA
 C  I  S  T  A 

Preostale črke:  A  B  C  Č  D  E  F  G  H  I  J  K  L  M  N  O  P  R  S  Š  T  U  V  Z  Ž 
Poskus 4/6: PISTA
 P  I  S  T  A 
Bravo! Besedo si uganil/a v 4 poskusih.
Nova igra? (d/n): n

  

#### Ogrodje programa

  

Pri implementaciji bomo izhajali iz vnaprej pripravljenega ogrodja, ki predstavlja osnovni potek igre. Kreirajte razred `Besedle` ter prenesite ali kopirajte [začetno ogrodje razreda](https://ucilnica.fri.uni-lj.si/pluginfile.php/188763/mod_assign/intro/Besedle.java?time=1678729183041).

  

- Na vrhu razreda so definirane konstante barv in ukazi, ki jih program uporablja za barvni izpis. Več o tem kasneje.
- Niz `abeceda` vsebuje vse veljavne črke, ki jih lahko uporabimo pri ugibanju.
- Tabela `seznamBesed` bo vsebovala seznam vseh besed, med katerimi lahko igra izbira.
- Niz `iskanaBeseda` bo vseboval pravilno (iskano) besedo trenutne igre.
- Tabela celih števil `barveAbecede` za vsako črko abecede določa barvo izpisa.

  

#### Potek igre

  

V metodi `igra()` je definiran potek igre:

1. Na začetku igre z metodo `novaIgra()` pripravimo vse potrebno za začetek igre (ponastavimo spremenljivke).
2. Številko poskusa nastavimo na 1. Dokler je število poskusov manjše od `MAX_POSKUSOV` ponavljamo:
    1. Z metodo `izpisiAbecedo()` izpišemo pobarvane znake abecede, da igralec ve, katerih črk še ni uporabil.
    2. Preberemo ugibano besedo in jo pretvorimo v velike črke.
    3. Z metodo `veljavnaBeseda()` preverimo, ali je ugibana beseda veljavna (pravilna dolžina, le veljavni znaki).
    4. V metodi `pobarvajBesedo()` določimo barve črk v ugibani besedi glede na ujemanje s pravo besedo.
    5. Izpiše pobarvano ugibano besedo z metodo `izpisiBesedo()`.
    6. Če je ugibana beseda pravilna, zaključimo igro.

V metodi `main()` najprej preberemo seznam vseh besed, ki jih igra lahko postavi za uganko (`preberiBesede()`). Nato ponavljamo igro, dokler uporabnik ne izbere opcije za konec igre.

  

#### Uporaba barv pri izpisu

  

Barve v Besedlah igrajo pomembno vlogo, saj igralcu dajejo namige glede črk besede. V programu bomo barve črk predstavili z različnimi celoštevilskimi vrednostmi, definiranimi v konstantah `BELA`, `CRNA`, `RUMENA` in `ZELENA`.

  

Za barvni izpis bomo uporabljali [ANSI ukaze](https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIescapecodes.html). V ta namen je v ogrodju že pripravljena metoda `izpisiZBarvo(char znak, int barva)`, ki izpiše znak `znak` v ustrezni barvi. Preizkusite metodo z različnimi barvami, tako da jo kličete v `main()`. Primer:

  

  
izpisiZBarvo('D', BELA);  
izpisiZBarvo('R', RUMENA);  
izpisiZBarvo('E', ZELENA);  
izpisiZBarvo('V', BELA);  
izpisiZBarvo('O', ZELENA);  
System.out.println();  
  

Izpis:

 **D  R  E  V  O** 

####   

#### Naloge

  

**1)** Prenesite datoteko ([besede.txt](https://ucilnica.fri.uni-lj.si/pluginfile.php/188763/mod_assign/intro/besede.txt)) s seznamom besed in jo shranite v mapo `viri`. V datoteki je v prvi vrstici zapisano število vseh besed v datoteki, sledijo pa besede, zapisane v ločenih vrsticah. Implementirajte metodo `preberiBesede(String datoteka)`, ki prebere besede iz podane datoteke in jih shrani v tabelo `seznamBesed`. Besede pred tem pretvorite v zapis z _velikimi črkami_.

  

  

**2)** Implementirajte metodo `novaIgra()`, ki naj pripravi vse potrebno za igro. Izbere naj naključno besedo iz `seznamBesed` in jo shrani v `iskanaBeseda`. Poleg tega naj ponastavi barve abecede -- barve vseh črk naj nastavi na belo.

  

Preverite delovanje metod `preberiBesede()` in `novaIgra()` tako, da v metodi `igra()` za klicem metode `novaIgra` dodate izpis iskane besede. Ob vsakem zagonu programa bi se morala izpisati naključna beseda iz seznama besed.

  

  

**3)** Dopolnite metodo `izpisiAbecedo()`. Metoda naj izpiše vse črke v abecedi z ustreznimi barvami. Barva izpisa za posamezno črko je določena v tabeli `barveAbecede`. Pri izpisu si pomagajte z metodo `izpisiZBarvo(char znak, int barva)`, ki znak `znak` izpiše s podano barvo `barva`.  

  

Izpis bo na začetku igre videti tako:

Preostale črke:  A  B  C  Č  D  E  F  G  H  I  J  K  L  M  N  O  P  R  S  Š  T  U  V  Z  Ž 

Tekom igre se bodo barve črk spreminjale glede na namige. Lahko dobimo nekaj takega:  

Preostale črke:  A  B  C  Č  D  E  F  G  H  I  J  K  L  M  N  O  P  R  S  Š  T  U  V  Z  Ž 

Preverite delovanje metode. V ta namen lahko v kodi začasno ročno spremenite barve za nekaj črk v abecedi.

  

  

**4)** Implementirajte metodo `boolean veljavnaBeseda(String beseda)`. Ta naj za podano besedo preveri, ali je veljavna. Beseda je neveljavna (metoda vrne `false`):

- Če je dolžina besede različna od 5. V tem primeru izpišite tudi sporočilo: _"Nepravilna dolžina besede!"_.
- Če beseda vsebuje neznane znake (niso del abecede). V tem primeru izpišite tudi sporočilo: _"V besedi so neveljavni znaki!"_.

Preverite delovanje metode.

  

  

**5)** Dopolnite metodo `int[] pobarvajBesedo(String ugibanaBeseda)`, ki naj določi barve črk ugibane besede. Metoda vrne tabelo celih števil iste dolžine kot beseda. Vsako število v tabeli določa barvo črke na tistem mestu. Pri tem se držite naslednjih (poenostavljenih) pravil igre. Črko ugibane besede pobarvamo z:

- zeleno v primeru, da se ujema s črko na istem mestu v iskani besedi,
- rumeno v primeru, da se enaka črka nahaja na katerem koli drugem mestu v iskani besedi,
- belo v primeru, da te črke ni v iskani besedi.

Poleg tega ustrezno pobarvajte še črke v abecedi s spreminjanjem vrednosti v `barveAbecede`. Barve spremenite le črkam, ki so v ugibani besedi. Pravilne črke označite z zeleno, črke na napačnem mestu z rumeno, s črno pa črke, ki niso v iskani besedi. Pri tem pazite na naslednje: ko črka v abecedi enkrat postane zelena, naj vedno ostane zelena, tudi če pri naslednjem barvanju za isto črko dobimo rumeno barvo.

  

Primer barvanja:

Iskana beseda: **SONCE**

  

Ugibana beseda: **ČESEN**

 Č  E  S  E  N 

Ugibana beseda: **DOMET**

 D  O  M  E  T 

Ugibana beseda: **MORJE**

 M  O  R  J  E 

  

Dopolnite tudi metodo `izpisiBesedo(String ugibanaBeseda, int[] barve)`, ki izpiše pobarvano ugibano besedo. Pri izpisu si lahko spet pomagate z metodo `izpisiZBarvo()`.

  

Preizkusite delovanje vašega programa in skušajte uganiti nekaj besed. Preverite, da se pravilno barvajo tudi črke v abecedi.  

  

  

**DODATNE NALOGE**

  

V osnovni nalogi smo implementirali poenostavljeno verzijo Besedle. Ugibamo lahko tudi besede, ki ne obstajajo (npr. "AEIOU"), poleg tega pa smo pri barvanju črk uporabljali poenostavljena pravila. Zato program dopolnite še z naslednjimi pravili originalne igre.  

  

**6)** **Le resnične besede**. Dopolnite program, da dovoli le ugibanje resničnih besed iz slovarja. Prenesite datoteko ([slovar.txt](https://ucilnica.fri.uni-lj.si/pluginfile.php/188763/mod_assign/intro/slovar.txt)) s slovarjem veljavnih slovenskih besed dolžine 5 in jo shranite v direktorij `viri`. V razred dodajte metodo `void preberiSlovar(String datoteka)`, ki prebere slovar besed v tabelo `slovar`, podobno kot smo hranili seznam besed. Datoteka je v isti obliki kot seznam besed iz 1. naloge.

  

Nato program dopolnite tako, da bo dovolil ugibanje le besed, ki so v slovarju. Dodajte nov pogoj veljavnosti v metodo `boolean veljavnaBeseda(String beseda)`. V primeru, da besede ni v slovarju, izpišite tudi sporočilo: "_Besede ni v slovarju!_".

  

  

**7)** **Pravilno barvanje črk.** Popravite program, da bo uporabljal prava pravila barvanja. V ta namen napišite metodo `int[] pravilnoPobarvajBesedo(String ugibanaBeseda)`. Če imamo več istih črk, naj program pobarva le tolikšno število črk, kot jih vsebuje iskana beseda.  

  

Primer pravilnega barvanja:

Iskana beseda: **DREVO**

Ugibana beseda: **OMELO**

 O  M  E  L  O 

Ugibana beseda: **OTROK**

 O  T  R  O  K 

Problema se je najlažje lotiti tako, da preštejete število pojavitev vseh še neuganjenih (ne-zelenih) črk v iskani besedi in ustrezno omejite število z rumeno pobarvanih črk.  

  

Nadomestite klic metode `pobarvajBesedo()` z novo metodo in preizkusite delovanje.


## REŠITEV


```
package Vaje;  
  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Random;  
import java.util.Scanner;  
  
public class Besedle {  
  
// Konstante barv  
static final int BELA = 0;  
static final int CRNA = 1;  
static final int RUMENA = 2;  
static final int ZELENA = 3;  
  
// ANSI ukazi (za barvni izpis)  
static final String ANSI_RESET = "\u001B[0m";  
static final String ANSI_GREEN_BG = "\u001b[42m";  
static final String ANSI_YELLOW_BG = "\u001b[43m";  
static final String ANSI_WHITE_BG = "\u001b[47;1m";  
static final String ANSI_BLACK_BG = "\u001b[40m";  
static final String ANSI_WHITE = "\u001b[37m";  
static final String ANSI_BLACK = "\u001b[30m";  
  
static final String abeceda = "ABCČDEFGHIJKLMNOPRSŠTUVZŽ"; // Veljavne črke  
static final int MAX_POSKUSOV = 6; // Število poskusov  
  
static String[] seznamBesed; // Seznam vseh možnih besed  
static String[] slovar; //seznam vseh veljavnih besed  
static String iskanaBeseda; // Iskana beseda trenutne igre  
static int[] barveAbecede; // Barve črk pri izpisu abecede  
  
static Scanner sc = new Scanner(System.in);  
  
// Izpiše znak v izbrani barvi  
static void izpisiZBarvo(char znak, int barva) {  
String slog;  
if (barva == ZELENA) {  
slog = ANSI_BLACK + ANSI_GREEN_BG;  
} else if (barva == RUMENA) {  
slog = ANSI_BLACK + ANSI_YELLOW_BG;  
} else if (barva == BELA) {  
slog = ANSI_BLACK + ANSI_WHITE_BG;  
} else {  
slog = ANSI_WHITE + ANSI_BLACK_BG;  
}  
System.out.print(slog + " " + znak + " " + ANSI_RESET);  
}  
  
// Prebere seznam besed iz datoteke  
static void preberiBesede(String datoteka) throws FileNotFoundException {  
Scanner sc = new Scanner(new File(datoteka));  
int stBesed = sc.nextInt(); //Preberemo število besed  
  
seznamBesed = new String[stBesed]; //Naredimo seznam besed  
  
//Preberemo besede in jih shranim v seznamBesed  
for(int i = 0; i < stBesed; i++) {  
seznamBesed[i] = sc.next().toUpperCase();  
}  
  
sc.close();  
}  
  
// Pripravi vse za novo igro  
static void novaIgra() {  
Random rnd = new Random();  
  
iskanaBeseda = seznamBesed[rnd.nextInt(seznamBesed.length)];  
  
barveAbecede = new int[abeceda.length()];  
}  
  
// Izpiše abecedo  
static void izpisiAbecedo() {  
System.out.println();  
System.out.print("Preostale črke: ");  
  
for(int i = 0; i < abeceda.length(); i++) {  
izpisiZBarvo(abeceda.charAt(i), barveAbecede[i]);  
}  
System.out.println();  
}  
  
// Ali je beseda veljavna?  
static boolean veljavnaBeseda(String beseda) {  
  
if(beseda.length() != 5) {  
System.out.println("Neveljavna dolžina besede!");  
return false;  
}  
  
for(int i = 0; i < beseda.length(); i++) {  
if(abeceda.indexOf(beseda.charAt(i)) < 0) {  
System.out.println("V besedi so neveljavni znaki");  
return false;  
}  
}  
  
//Dodatna naloga  
if(!besedaVSlovarju(beseda)) {  
System.out.println("Besede ni v slovarju");  
return false;  
}  
return true;  
}  
  
// Določi barve črk v ugibani besedi  
static int[] pobarvajBesedo(String ugibanaBeseda) {  
int[] barve = new int[ugibanaBeseda.length()];  
  
for(int i = 0; i < ugibanaBeseda.length(); i++) {  
int indeks = abeceda.indexOf(ugibanaBeseda.charAt(i));  
  
//Če je črka v ugibani besedi enaka tisti v iskani besedi jo pobarva zeleno  
if(ugibanaBeseda.charAt(i) == iskanaBeseda.charAt(i)) {  
barve[i] = ZELENA; //pobarva se črka v besedi  
barveAbecede[indeks] = ZELENA; //pobarva se črka v abecedi  
}  
  
//Črka na napačnem mestu --> RUMENA  
else if(iskanaBeseda.indexOf(ugibanaBeseda.charAt(i)) >= 0) {  
barve[i] = RUMENA;  
barveAbecede[indeks] = barveAbecede[indeks] == ZELENA ? ZELENA : RUMENA;  
}  
  
else {  
barveAbecede[indeks] = CRNA;  
}  
}  
  
return barve;  
}  
  
// Izpiši besedo  
static void izpisiBesedo(String ugibanaBeseda, int[] barve) {  
for(int i = 0; i < ugibanaBeseda.length(); i++) {  
izpisiZBarvo(ugibanaBeseda.charAt(i), barve[i]);  
}  
System.out.println();  
}  
  
public static void preberiVSlovar(String datoteka) throws Exception {  
  
Scanner sc = new Scanner(new File(datoteka));  
  
int stBesed = sc.nextInt();  
  
slovar = new String[stBesed];  
  
for(int i = 0; i < stBesed; i++) {  
slovar[i] = sc.next().toUpperCase();  
}  
  
sc.close();  
}  
  
public static boolean besedaVSlovarju(String beseda) {  
for(int i = 0; i < slovar.length; i++) {  
if(slovar[i].equals(beseda)) return true;  
}  
return false;  
}  
public static int[] pravilnoPobarvajBesedo(String ugibanaBeseda) {  
int[] stManjkajočih = new int[abeceda.length()];  
int[] barve = new int[ugibanaBeseda.length()];  
  
for(int i = 0; i < iskanaBeseda.length(); i++) {  
int indeks = abeceda.indexOf(iskanaBeseda.charAt(i));  
  
if(ugibanaBeseda.charAt(i) == iskanaBeseda.charAt(i)) {  
barve[i] = ZELENA;  
barveAbecede[indeks] = ZELENA;  
}  
else {  
stManjkajočih[indeks]++;  
}  
}  
  
for(int i = 0; i < ugibanaBeseda.length(); i++) {  
int indeks = abeceda.indexOf(ugibanaBeseda.charAt(i));  
  
if(barve[i] != ZELENA) {  
if(stManjkajočih[indeks] > 0) {  
stManjkajočih[indeks]--;  
barve[i] = RUMENA;  
barveAbecede[indeks] = barveAbecede[indeks] == ZELENA ? ZELENA : RUMENA;  
}  
  
else {  
barve[i] = BELA;  
barveAbecede[indeks] = Math.max(barveAbecede[indeks], CRNA);  
}  
}  
}  
return barve;  
}  
  
// Izvede eno igro  
static void igra() {  
novaIgra();  
  
int poskus = 1;  
boolean uganil = false;  
while (poskus <= MAX_POSKUSOV) {  
izpisiAbecedo();  
System.out.printf("Poskus %d/%d: ", poskus, MAX_POSKUSOV);  
String ugibanaBeseda = sc.nextLine().toUpperCase();  
  
// Preveri veljavnost  
if (!veljavnaBeseda(ugibanaBeseda))  
continue;  
  
// Pobarvaj crke v besedi (namigi)  
int[] barve = pobarvajBesedo(ugibanaBeseda);  
  
// Izpiši pobarvano besedo  
izpisiBesedo(ugibanaBeseda, barve);  
  
if (ugibanaBeseda.equals(iskanaBeseda)) {  
uganil = true;  
break;  
}  
poskus++;  
}  
  
if (uganil) {  
System.out.printf("Bravo! Besedo si uganil/a v %d poskusih.\n", poskus);  
} else {  
System.out.printf("Žal ti ni uspelo. Pravilna beseda: %s\n", iskanaBeseda);  
}  
}  
  
public static void main(String[] args) throws Exception {  
preberiBesede("src/viri/besedle.txt");  
  
preberiVSlovar("src/viri/slovar.txt");  
  
while (true) {  
igra();  
System.out.print("Nova igra? (d/n): ");  
String odg = sc.nextLine();  
if (odg.toLowerCase().charAt(0) != 'd') {  
break;  
}  
}  
}  
}
```
