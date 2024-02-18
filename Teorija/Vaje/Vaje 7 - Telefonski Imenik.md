
[[Vaje 6 - Igre na 15]]
[[Vaje 8 - Banka]]

#razredi #branje_datotek  #Konstruktor #getSet 

----

Na osebnem računalniku želimo imeti telefonski imenik. Napišite program, ki bo prebral podatke iz datoteke ter ustvaril telefonski imenik s pomočjo razredov. 

*Pri vnosu lokacije 'imenik.txt' je potrebno podati celotno pot /src/.../imenik.txt.*

Povezava do kode: [Koda](https://github.com/GameExplorer/P2_Vaje/tree/master/src/vaje07)

# Povzetek

### Skrivanje podatkov

```ad-code
title: Skrivanje podatkov (primer)

private String ime
```

Za dostop do podatkov uporabimo **Getterje/Setterje**

```ad-code
title: Primer getterja

public String getIme() { return ime; }
```

```ad-code
title: Primer setterja

public void setIme(String ime1) { priimek = priimek1; }
```

### Konstruktor

Konstruktor, ki nastavi vrednosti vseh atributov

```ad-code
title: Konstruktor

public Oseba(String ime, String priimek, String kraj, String telefonska, boolean mobilni) {


this.ime = ime; 

....

this.mobilni=mobilni;
}
```

### Branje iz datotek

```
int i = 0;
while(i < st && sc.hasNextLine())
```

### Split podatkov (array)

```ad-code
title: Primer

String[] deli = sc.nextLine().split(", ");
```

### EqualsIgnoreCase

`equalsIgnoreCase` ignorira velikost velikih/malih črk

### For enchanced

`for (int i = 0; i < oseba.length; i++) == for(Oseba oseba : osebe)`


# Navodila

**1)** Ustrezno dopolnite razred `Oseba`, da bo hranil podatke posamezne osebe. Razred naj hrani ime, priimek, kraj in telefonsko številko osebe (vsi ti atributi so tipa `String`) ter spremenljivko, ki pove, ali je podana telefonska številka mobilna ali ne (tip `boolean`). V razred dodajte tudi konstruktor, ki nastavi vrednosti vseh atributov. Po potrebi dopišite še druge metode. Pazite tudi na primerna dostopna določila za vse atribute in metode.  

**2)** V razred `Imenik` dodajte atribut `Oseba[]` `osebe`, kjer bomo hranili osebe v imeniku. Dodajte tudi metodo `boolean preberiOsebe(String vir)`, ki prebere osebe iz datoteke `vir`, kreira nove osebe ter jih hrani v tabeli `osebe`. Ob uspešnem branju oseb naj metoda vrne `true`, v primeru neuspešno prebranih podatkov (npr. če ni uspešno prebranih toliko oseb, kot je navedeno na začetku datoteke) pa naj vrne `false`. Po potrebi v razred dodajte še druge atribute in/ali metode.  

**3)** V razred `Imenik` dodajte metodo `void izpisiImenik()`, ki izpiše vse osebe v imeniku v naslednji obliki:
```Osebe v imeniku (11):
 Miha Novak, Ljubljana: 040 399 393 (mobilni)
 Maja Ferk, Maribor: 040 339 393 (mobilni)
 Simona Novak, Celje: 03 559 3933
 Tilen Novak, Ljubljana: 031 366 939 (mobilni)
 Majda Novak, Ljubljana: 01 325 2283
 Lada Pečnik, Ljubljana: 041 366 939 (mobilni)
 Teo Novak, Koper: 040 397 839 (mobilni)
 Jenny Smith, London: +44 20 3022 4517
 Jonny Walker, Dublin: +353 1 321 4567
 Margaret Flower, Blackrock: +353 86 803 1243 (mobilni)
 Mici Pečnik, Ljubljana: 01 479 2321
 ```
 _Opomba_: Pri izpisu posamezne osebe si pomagajte z metodo `String toString()`, ki jo dodajte v razred `Oseba`. Metoda naj vrne niz s podatki osebe v obliki, kot je prikazana zgoraj.

_Nasvet:_ Pravilno delovanje branja in izpisa imenika preverite z zagonom programa `Upravljanje`. Ker vse potrebne metode še niso implementirane, njihove klice zakomentirajte (v komentar postavite celo kodo pod določenim _case_ stavkom) ali pa v razred `Imenik` dodajte manjkajoče metode, ki imajo zaenkrat še prazno telo oz. v njem le stavek return (minimalno potrebno, da se program prevede).  

**4)** V razred `Imenik` dodajte še metodo `Oseba vrniOseboPoImenu(String ime)`, ki poišče in vrne osebo s podanim imenom. Če iskane osebe ne najde v imeniku, naj vrne `null`. V primeru, da je v imeniku več oseb z istim imenom, naj metoda vrne prvo najdeno osebo. Pri iskanju naj ne razlikuje med velikimi in malimi črkami.  

**5)** Dodajte tudi metodo `void izpisiOsebePoTelefonski(String delnaTelefonska)`, ki poišče in izpiše vse osebe z dano telefonsko številko. Iskanje naj bo mogoče tudi prek delnega ujemanja telefonske številke -- izpiše vse osebe, katerih telefonska številka vsebuje podani niz. Če nobena oseba ne ustreza iskalni poizvedbi, naj metoda izpiše "_Iskani telefonski številki ne ustreza nobena oseba._".

**DODATNA NALOGA**

**6)** Dodajte še metodo `void izpisiIskaneOsebe(String iskalniNiz)`, ki omogoča splošno iskanje oseb v imeniku po vseh njihovih podatkih. Iskanje naj izvede prek iskalnega niza, ki je lahko sestavljen iz več besed. Metoda poišče in izpiše vse osebe, ki med podatki vsebujejo vse iskane besede. Če nobena oseba ne ustreza iskalni poizvedbi, naj metoda izpiše "_Poizvedbi ne ustreza nobena oseba._". Pri iskanju ne razlikujte med velikimi in malimi črkami.

Primeri:

Poizvedba: "novak ljubljana"

```
Miha Novak, Ljubljana: 040 399 393 (mobilni)
Tilen Novak, Ljubljana: 031 366 939 (mobilni)
Majda Novak, Ljubljana: 01 325 2283
 ```
_Namig_: Pri iskanju si lahko pomagate s prej implementirano metodo `toString()`, ki vrne niz z vsemi podatki osebe.

# Oseba

* Razred Oseba hrani podatke o imenu, priimku, kraju, telefonski številki in ali je telefonska številka mobilna ali ne.  
* Podatke smo skrili in uporabili getterje/setterje da smo lahko dostopali do njih  
* Ustvarili smo konstruktor OSeba, ki nastavi vrednosti vseh atributov  
* toString() metoda je pa za formatiran izpis

# Imenik

V imeniku imamo različne metode

## preberiOsebe
* Prebere seznam oseb iz datoteke in jih shrani v tabelo. Če datoteka ne obstaja sproži izjemo  
* @param vir - pot do datoteke  
* @return - true če je branje oseb uspešno; false sicer  
* @throws FileNotFoundException če datoteka ne obstaja vrne izjemo
  
## izpisiImenik
* Izpiše podatke o osebi

## vrniOsebePoImenu
* V imeniku poišče osebo z imenom ime. Pri tem ne upošteva velikih/malih črk  
* @param ime ime iskane osebe  
* @return Prva najdena oseba z imenom ime. null, če osebe z imenim ime ni v imeniku

## izpisiOsebePoTelefonski
* Poišče in izpiše podatke oseb, katerih telefonska se začne z delnaTelefonska - delno ujemanje  
* telefonske številke. Če nobena oseba ne ustreza iskani telefonski izpiše ustrezno sporočilo  
* @param delnaTelefona celotna ali začetni del telefonske

## izpisiIskaneOsebe
* Poišče in izpiše osebe, ki ustrezajo iskanemu nizu, išče po vseh podatkih osebe. Če nobena oseba ne ustreza  
* iskanemu nizu izpiše ustrezno sporočilo  
* @param iskaniNiz iskani niz, lahko je tudi več besed


# Upravljanje
* Vsebuje main metodo in izpisiNavodila(). V main metodi se izvedejo različne mmetode glede na podani vnos.



