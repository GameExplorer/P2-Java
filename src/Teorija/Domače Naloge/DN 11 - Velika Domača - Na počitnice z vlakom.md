
[[DN 12 - Pretvorba v velike črke]]
[[DN 10 - Najdaljši skupni podniz]]

#interfaces  #razredi #dedovanje #comparable 

----
# Na počitnice z vlakom

Evropske železnice EuroRail so za prihajajoče poletje pripravile posebno ponudbo za raziskovanje evropskih krajev z vlakom. Ponudba zajema ugodne cene voženj z vlaki med različnimi kraji, vendar pa v ponudbo niso vključene vse železniške povezave med kraji (kot dobri trgovci so s popustom ponudili le tiste povezave, ki so poleti manj zasedene). Za lažjo promocijo in predstavitev ponudbe, predvsem pa za lažje načrtovanje poti, so si zamislili računalniški program. A tu so naleteli na težavo, saj nihče med njimi ni dovolj vešč programiranja za realizacijo tega programa. Direktor železnic se je tako spomnil na znanko, ki je asistentka pri predmetu Programiranje 2. "Ta bo že znala realizirati zahtevan program," si je mislil. A asistentki ni prav nič dišalo opraviti to zamudno nalogo, pa je delo enostavno preložila na študente P2.

Program, ki ga želijo pri evropskih železnicah, bo namenjen načrtovanju poti z vlakom. Vključuje vse kraje, ki so zajeti v omenjeni poletni ponudbi, ter vlake, ki vozijo med temi kraji (a le tiste vlake, ki so vključeni v ponudbo). Zajema tudi podatke o trajanju posameznih voženj in njihovi ceni. Vse vožnje z vlakom so enosmerne, saj niti ni nujno, da je povratna vožnja sploh vključena v ponudbo (npr. če je v ponudbi vožnja iz kraja A v kraj B, to še ne pomeni, da je v ponudbi tudi povratna vožnja iz kraja B v kraj A - morda se v sklopu ponudbe sploh ne moremo vrniti nazaj v kraj A).

## 1. naloga (5 točk)

Za rešitev problema najprej pripravimo potrebne podatke in "zgradimo" železniško omrežje. Omrežje vsebuje seznam vseh krajev iz ponudbe in seznam vseh vlakov, ki povezujejo te kraje. Implementiramo ustrezne razrede in preberemo podatke iz datotek. Za kontrolo vse podatke tudi izpišemo.

_Podrobnejša navodila naloge_:

Ustvarite razred `DN11` (v datoteki `DN11.java`) in v njem metodo `main()`.

#### Razredi za predstavitev železniškega omrežja

Napišite razred `Kraj`, ki predstavlja eno mesto v železniškem omrežju poletne ponudbe. Vsak kraj ima ime (ki je lahko sestavljeno tudi iz več besed, npr. _Novo mesto_) in dvočrkovno mednarodno kratico države, v kateri se kraj nahaja (npr. SI za Slovenijo). Dodajte tudi metodo `toString()`, ki izpiše podatke o kraju (za obliko izpisa glejte _Izpis podatkov_).

Napišite razred `Vlak`, ki predstavlja vlak iz poletne ponudbe, ki povezuje dva kraja. Atributi tega razreda so identifikacijska oznaka vlaka (največ šestmestno zaporedje črk in številk, npr. _RG123_), začetni in končni kraj, ki ju povezuje ta vlak (tipa `Kraj`), ter trajanje vožnje v minutah (tip `int`).

V razred `Kraj` dodajte še seznam vseh vlakov, ki vozijo iz tega kraja v sosednje kraje (`List<Vlak> odhodi`). Ob ustvarjanju novega kraja naj bo ta seznam prazen, vlake boste dodali kasneje, ob branju podatkov o vlakih (pravzaprav šele v 2. nalogi).

Ker so v poletno ponudbo vključeni vlaki dveh vrst, regionalni in ekspresni, dodajte še razreda `RegionalniVlak` in `EkspresniVlak`, oba sta razširitvi razreda `Vlak`. Vsi regionalni vlaki vozijo s povprečno hitrostjo 50 km/h, cena vozovnice pa je odvisna od prevožene razdalje in znaša 0,068 € za vsak prevožen kilometer. Oba podatka naj bosta shranjena kot atributa razred `RegionalniVlak`. Podobno tudi vsi ekspresni vlaki vozijo z enako povprečno hitrostjo 110 km/h, cena za prevožen kilometer poti pa je 0,154 €. Vendar je pri vozovnici za ekspresni vlak potrebno še doplačilo, ki je odvisno od posameznega vlaka - podatek o višini doplačila dodajte med atribute (tip `double`).

V razred `Vlak` dodajte še abstraktni metodi `String opis()` in `double cenaVoznje()`; potrebovali ju boste pri izpisu podatkov o posameznih vlakih. Prva metoda vrne niz z opisom vrste vlaka, to je "regionalni" za regionalne vlake in "ekspresni" za ekspresne vlake. Druga metoda pa izračuna in vrne končno ceno vozovnice.

V razred `Vlak` dodajte tudi metodo `toString()`, ki izpiše vse podatke o vlaku (za obliko izpisa glejte _Izpis podatkov_).

Napišite še razred `EuroRail`, ki predstavlja celotno železniško omrežje, ki je vključeno v poletno ponudbo. Kot atributa naj vsebuje zbirko vseh krajev in zbirko vseh vlakov, ki so zajeti v poletni ponudbi.

Atributi vseh razredov naj bodo privatni, po potrebi pa dodajte getterje za dostop do njih. Dopišite tudi ustrezne konstruktorje za nastavljanje vrednosti atributov. Po potrebi lahko v razrede dodate tudi druge atribute in/ali metode.

#### Branje podatkov

Direktor EuroRaila je že pripravil tudi dve testni datoteki za preizkušanje delovanja programa. Prva datoteka ([kraji.txt](https://ucilnica.fri.uni-lj.si/pluginfile.php/174139/mod_assign/intro/kraji.txt)) vsebuje opise vseh krajev, in sicer ime kraja in kodo države, oba podatka sta ločena s podpičjem (;). Podatki o vsakem kraju so zapisani v svoji vrstici.

V drugi datoteki ([povezave.txt](https://ucilnica.fri.uni-lj.si/pluginfile.php/174139/mod_assign/intro/povezave.txt)) pa so zbrani podatki o vlakih. Podatki vsakega vlaka so zapisani v svoji vrstici in tudi tu so posamezni podatki ločeni s podpičjem (;). Po vrsti so podatki naslednji: identifikacijska oznaka vlaka, začetni kraj, končni kraj, trajanje vožnje (v obliki xx minut, če je vožnja krajša od ene ure, oziroma xx.yy pri daljših vožnjah, ki trajajo xx ur in yy minut). Za ekspresne vlake pa je dodan še podatek o doplačilu pri vozovnici, in sicer v evrih na dve decimalki.

Primer:


```
 RG715;Ljubljana;Maribor;2.24
 IC123;Ljubljana;Kranj;22;2.50
```


Prva vrstica opisuje regionalni vlak RG715 iz Ljubljane v Maribor, ki vozi 2 uri in 24 minut. Druga vrstica pa opisuje ekspresni vlak (prepoznamo ga po podatku o dodatku na ceno karte) IC123 iz Ljubljane v Kranj, ki vozi 22 minut, pri ceni karte pa se obračuna še dodatek v višini 2,50 €.

V razred `EuroRail` dodajte metodo `boolean preberiKraje(String imeDatoteke)`, ki iz podane datoteke prebere podatke o krajih ter jih zapiše v zbirko krajev (ta je atribut razreda `EuroRail`). Metoda vrne `true`, če je bilo branje uspešno, oziroma `false`, če je pri branju prišlo do napake.

**Opomba**: Če pri branju naletite na vrstico, ki ne vsebuje vseh zahtevanih podatkov, jo preskočite in podatke berete dalje. Podobno lahko zanemarite tudi podatke o kraju, ki ima enako ime kot kraj, ki se že nahaja v zbirki krajev. Vsi kraji imajo namreč različna imena.

V razred `EuroRail` dodajte še metodo `boolean preberiPovezave(String imeDatoteke)`, ki iz podane datoteke prebere podatke o vlakih ter jih zapiše v zbirko vlakov, ki je atribut razreda `EuroRail`. Pri tem bodite pozorni, da boste ustvarili pravo vrsto vlaka (`RegionalniVlak` ali `EkspredniVlak`). Metoda vrne `true`, če je bilo branje uspešno, oziroma `false`, če je pri branju prišlo do napake.

**Opomba**: Če pri branju naletite na vrstico, ki ne vsebuje vseh zahtevanih podatkov, če se kraja, ki ju povezuje vlak, ne nahajata oba v zbirki krajev ali pa če je začetni kraj isti kot končni kraj, lahko tako vrstico preskočite in podatke berete dalje.

**Pozor**: Ne pozabite na ustrezno obravnavo izjem, ki se lahko sprožijo pri branju datotek!

#### Izpis podatkov

V razred `EuroRail` dodajte metodo `izpisiKraje()`, ki izpiše vse prebrane kraje (uporabite metodo `toString()` razreda `Kraj`). Izpis kraja naj bo tak kot v naslednjem primeru:


```
Kraji, povezani z vlaki:
Ljubljana (SI)
Zagreb (HR)
Novo mesto (SI)
```


Dodajte še metodo `izpisiPovezave()`, ki izpiše vse prebrane vlake s pripadajočimi podatki o trajanju vožnje in ceni vozovnice (uporabite metodo `toString()` razreda `Vlak`). Izpis naj bo tak kot v naslednjem primeru:


```
Vlaki, ki povezujejo kraje:
Vlak RG715 (regionalni) Ljubljana (SI) -- Maribor (SI) (2.24h, 8.16 EUR)
Vlak IC123 (ekspresni) Ljubljana (SI) -- Kranj (SI) (22 min, 8.71 EUR)
```


#### Poganjanje programa

Program poženete s pomočjo metode `main()` razreda `DN11`, ki naj izvede ustrezen del programa glede na prvi argument (to je številka naloge). Če je kot prvi argument podano število `1`, program prebere podatke o krajih (ime datoteke s podatki je drugi argument) in o povezavah (tretji argument) ter prebrane podatke shrani v ustrezno strukturo, kot je opisano zgoraj. Nato naj izpiše podatke o vseh krajih in o vseh vlakih v železniškem omrežju. Vrstni red izpisa naj bo enak vrstnemu redu v vhodnih datotekah.

Oblika izpisa je prikazana v naslednjem primeru. Ob klicu:

`java DN11 1 kraji.txt povezave.txt`

program izpiše:


```
Kraji, povezani z vlaki:
Ljubljana (SI)
Zagreb (HR)
Novo mesto (SI)
Kranj (SI)
Jesenice (SI)
Maribor (SI)
Split (HR)
Dunaj (AT)
Beljak (AT)

Vlaki, ki povezujejo kraje:
Vlak RG715 (regionalni) Ljubljana (SI) -- Maribor (SI) (2.24h, 8.16 EUR)
Vlak IC123 (ekspresni) Ljubljana (SI) -- Kranj (SI) (22 min, 8.71 EUR)
Vlak IC124 (ekspresni) Kranj (SI) -- Jesenice (SI) (32 min, 11.83 EUR)
Vlak RG812 (regionalni) Maribor (SI) -- Zagreb (HR) (3.16h, 11.11 EUR)
Vlak IC312 (ekspresni) Zagreb (HR) -- Ljubljana (SI) (2.18h, 41.96 EUR)
Vlak IC125 (ekspresni) Jesenice (SI) -- Beljak (AT) (36 min, 15.36 EUR)
Vlak EC55 (ekspresni) Beljak (AT) -- Dunaj (AT) (4.29h, 77.75 EUR)
Vlak RG1234 (regionalni) Dunaj (AT) -- Maribor (SI) (3.42h, 12.58 EUR)
Vlak IC523 (ekspresni) Zagreb (HR) -- Split (HR) (6.21h, 113.87 EUR)
Vlak RG7959 (regionalni) Beljak (AT) -- Kranj (SI) (1.03h, 3.57 EUR)
Vlak RG1122 (regionalni) Ljubljana (SI) -- Novo mesto (SI) (1.34h, 5.33 EUR)

```

## 2. naloga (3 točke)

Podatke o vsakem kraju dopolnimo z vlaki, ki iz kraja vozijo v sosednje kraje. Za kontrolo izpišemo vse podatke o krajih, vključno z odhodi vlakov.

_Podrobnejša navodila naloge_:

#### Odhodi vlakov

Pri planiranju poti moramo za vsak kraj vedeti, kateri vlaki vozijo iz tega kraja v sosednje kraje. Zato v razred `Kraj` dodajte tudi metodo `boolean dodajOdhod(Vlak vlak)`, ki podan vlak doda na seznam odhodov iz tega kraja (ta atribut ste v razred dodali že v 1. nalogi). Metoda vrne `true`, če je vlak uspešno dodan, oziroma `false`, če je vlak že na seznamu odhodov in zato ni bil dodan. Ustrezen klic te metode vključite tudi v metodo `preberiPovezave()` razreda `EuroRail` (za vsak ustvarjen vlak poskrbite, da ga dodate na seznam odhodov ustreznega kraja).

V razred `EuroRail` dodajte metodo, ki poskrbi za izpis krajev z vsemi podatki, vključno z vlaki, ki svojo pot začnejo v tem kraju. Metodo `main()` razreda `DN11` dopolnite tako, da bo pri drugi nalogi (prvi argument je 2) poklicala to to metodo za izpis krajev z vsemi podatki.

Primer. Ob klicu:

`java DN11 2 kraji.txt povezave.txt`

program izpiše naslednji rezultat:

```
Kraji in odhodi vlakov:
Ljubljana (SI)
odhodi vlakov (3):
 - Vlak RG715 (regionalni) Ljubljana (SI) -- Maribor (SI) (2.24h, 8.16 EUR)
 - Vlak IC123 (ekspresni) Ljubljana (SI) -- Kranj (SI) (22 min, 8.71 EUR)
 - Vlak RG1122 (regionalni) Ljubljana (SI) -- Novo mesto (SI) (1.34h, 5.33 EUR)
  
Zagreb (HR)
odhodi vlakov (2):
 - Vlak IC312 (ekspresni) Zagreb (HR) -- Ljubljana (SI) (2.18h, 41.96 EUR)
 - Vlak IC523 (ekspresni) Zagreb (HR) -- Split (HR) (6.21h, 113.87 EUR)
  
Novo mesto (SI)
odhodi vlakov (0):
  
Kranj (SI)
odhodi vlakov (1):
 - Vlak IC124 (ekspresni) Kranj (SI) -- Jesenice (SI) (32 min, 11.83 EUR)

Jesenice (SI)
odhodi vlakov (1):
 - Vlak IC125 (ekspresni) Jesenice (SI) -- Beljak (AT) (36 min, 15.36 EUR)

Maribor (SI)
odhodi vlakov (1):
 - Vlak RG812 (regionalni) Maribor (SI) -- Zagreb (HR) (3.16h, 11.11 EUR)

Split (HR)
odhodi vlakov (0):

Dunaj (AT)
odhodi vlakov (1):
 - Vlak RG1234 (regionalni) Dunaj (AT) -- Maribor (SI) (3.42h, 12.58 EUR)

Beljak (AT)
odhodi vlakov (2):
 - Vlak EC55 (ekspresni) Beljak (AT) -- Dunaj (AT) (4.29h, 77.75 EUR)
 - Vlak RG7959 (regionalni) Beljak (AT) -- Kranj (SI) (1.03h, 3.57 EUR)
```

**Namig**: V razred `Kraj` dodajte novo metodo, ki poskrbi za ustrezen izpis imena kraja in države (klic metode `toString()` razreda `Kraj`) ter vseh odhodov vlakov (klic metode `toString()` razreda `Vlak`).

## 3. naloga (4 točke)

Za lažje iskanje in pregled nad podatki izpisane kraje uredimo.

_Podrobnejša navodila naloge_:

#### Urejen izpis

Pri izpisu več krajev je izpis bolj pregleden, če so kraji urejeni po abecedi. Dopolnite razred `EuroRail` še z metodo, ki poskrbi za urejen izpis podatkov o krajih (in odhajajočih vlakih). Posamezni kraji naj bodo urejeni po državah (po abecedi kratice države), kraji v isti državi pa naj bodo tudi urejeni po abecedi. Uredite tudi izpis vlakov pri posameznem kraju tako, da bodo urejeni po padajoči ceni vozovnice.

**Opomba**: Seznam lahko uredimo s pomočjo metode `Collections.sort()`, za urejeno množico in slovar pa lahko uporabimo kar ustrezno urejeno zbirko (`TreeSet` ali `TreeMap`). Pri urejanju moramo tudi določiti, kako primerjamo dva kraja (oziroma dva vlaka); uporabimo lahko objekt razreda `Comparator` ali pa primerjavo določimo kar v razredu `Kraj` (oziroma `Vlak`) z implementacijo vmesnika `Comparable`. (Slednje se v naši nalogi izkaže kot bolj uporabno.)

Metodo `main()` razreda `DN11` dopolnite tako, da bo za tretjo nalogo (prvi argument je 3) izpisala kraje na urejen način.

Primer. Ob klicu:

`java DN11 3 kraji.txt povezave.txt`

program izpiše naslednji rezultat:


```
Kraji in odhodi vlakov (po abecedi):
Beljak (AT)
odhodi vlakov (2):
 - Vlak EC55 (ekspresni) Beljak (AT) -- Dunaj (AT) (4.29h, 77.75 EUR)
 - Vlak RG7959 (regionalni) Beljak (AT) -- Kranj (SI) (1.03h, 3.57 EUR)

Dunaj (AT)
odhodi vlakov (1):
 - Vlak RG1234 (regionalni) Dunaj (AT) -- Maribor (SI) (3.42h, 12.58 EUR)

Split (HR)
odhodi vlakov (0):

Zagreb (HR)
odhodi vlakov (2):
 - Vlak IC523 (ekspresni) Zagreb (HR) -- Split (HR) (6.21h, 113.87 EUR)
 - Vlak IC312 (ekspresni) Zagreb (HR) -- Ljubljana (SI) (2.18h, 41.96 EUR)

Jesenice (SI)
odhodi vlakov (1):
 - Vlak IC125 (ekspresni) Jesenice (SI) -- Beljak (AT) (36 min, 15.36 EUR)

Kranj (SI)
odhodi vlakov (1):
 - Vlak IC124 (ekspresni) Kranj (SI) -- Jesenice (SI) (32 min, 11.83 EUR)

Ljubljana (SI)
odhodi vlakov (3):
 - Vlak IC123 (ekspresni) Ljubljana (SI) -- Kranj (SI) (22 min, 8.71 EUR)
 - Vlak RG715 (regionalni) Ljubljana (SI) -- Maribor (SI) (2.24h, 8.16 EUR)
 - Vlak RG1122 (regionalni) Ljubljana (SI) -- Novo mesto (SI) (1.34h, 5.33 EUR)

Maribor (SI)
odhodi vlakov (1):
 - Vlak RG812 (regionalni) Maribor (SI) -- Zagreb (HR) (3.16h, 11.11 EUR)

Novo mesto (SI)
odhodi vlakov (0):
```


## 4. naloga (4 točke)

Za planiranje kratkega izleta iz domačega kraja nas zanima, do katerih krajev se lahko pripeljemo v sklopu ponudbe. Izpišemo vse možne destinacije.

_Podrobnejša navodila naloge_:

#### Kratek izlet

Potnike bo sigurno zanimalo, kam se lahko v okviru poletne ponudbe odpeljejo iz domačega kraja. Seveda je prestopanje med vlaki utrujajoče, zato se bomo pri izletu omejili na največ _k_ prestopanj. V razred `Kraj` dodajte še metodo `Set<Kraj> destinacije(int k)`, ki za ta kraj poišče množico vseh krajev, ki so dosegljivi z največ _k_ prestopanji.

Metodo `main()` razreda `DN11` dopolnite tako, da bo za četrto nalogo (prvi argument je 4) izpisala imena krajev (in kratico države), do katerih lahko pridemo iz podanega kraja (zadnji argument) z največ podanim številom prestopanj (četrti argument). Pri tem naj bo izpis krajev urejen kot pri 3. nalogi.

**Pozor**: Ime kraja je lahko sestavljeno iz več besed. Bodite pozorni, da ga pravilno razberete iz argumentov programa. Če podanega kraja ni v zbirki krajev, naj program izpiše "NAPAKA: podanega kraja (_ime kraja_) ni na seznamu krajev.".

Primer. Ob klicu:

`java DN11 4 kraji.txt povezave.txt 3 Ljubljana`

program izpiše naslednji rezultat:


```
Iz kraja Ljubljana (SI) lahko z max 3 prestopanji pridemo do naslednjih krajev:  
Beljak (AT)  
Dunaj (AT)  
Split (HR)  
Zagreb (HR)  
Jesenice (SI)  
Kranj (SI)  
Maribor (SI)  
Novo mesto (SI)

```

Ob klicu:

`java DN11 4 kraji.txt povezave.txt 1 Novo mesto`

pa dobimo naslednji izpis:

`Iz kraja Novo mesto (SI) ni nobenih povezav.`

Še primer neznanega kraja. Ob klicu:

`java DN11 4 kraji.txt povezave.txt 1 Zgornji Duplek na Kokri`

dobimo naslednji izpis:

`NAPAKA: podanega kraja (Zgornji Duplek na Kokri) ni na seznamu krajev.`

## 5. naloga (4 točke)

Podatke o vlakih preberemo iz binarne datoteke.

_Podrobnejša navodila naloge_:

#### Binarni format

Direktor EuroRaila se je spomnil, da ima nekatere podatke o vlakih tudi v starem programu, ki podatke shranjuje v binarnih datotekah. In tudi te podatke moramo znati prebrati v našem programu. Format zapisa podatkov je naslednji:

- podatki za vsak vlak so zapisni v 12 zaporednih bajtih;
- prvih 6 bajtov določa oznako vlaka, ki je sestavljena iz ASCII črk in števk (glej primer spodaj); vsak bajt je ASCII koda enega znaka (črke ali števke); če je oznaka vlaka krajša od 6 znakov, so na koncu dodani presledki;
- naslednji bajt določata indeks začetnega kraja; indeks kraja se določi pri branju podatkov o krajih, in sicer ima prvi prebrani kraj iz datoteke indeks 1, vsak naslednji pa za eno večji indeks;
- sledi en bajt za indeks končnega kraja;
- naslednja 2 bajta določata čas vožnje v minutah;
- zadnja 2 bajta pa določata doplačilo za ekspresni vlak v centih; če je vlak regionalni, je doplačilo nič (torej sta bajta enaka `0x00 0x00`).

Poglejmo primer zapisa podatkov za regionalni vlak RG715 iz Ljubljane v Maribor, ki vozi 2 uri in 24 minut. Podatki so zapisani kot:

`0x52 0x47 0x37 0x31 0x35 0x20 0x01 0x06 0x00 0x90 0x00 0x00`

Prvih 6 bajtov pomeni oznako vlaka (vsak bajt je ASCII koda enega znaka v oznaki vlaka), ki je v našem primeru `RG715_` (na koncu je še presledek, ki smo ga tu označili s podčrtajem). Kako smo dobili to oznako? Poglejmo primer prve črke: `0x52` je 82 desetiško, ASCII znak s kodo 82 pa je `R`. Podobno določimo tudi ostale znake, zadnji znak pa je presledek - koda 32 ali `0x20` (oznaka je dolga le 5 znakov, zato je na koncu en presledek).  
Naslednji (sedmi) bajt določa indeks kraja, iz katerega odpelje ta vlak (`0x01` pomeni prvi kraj v datoteki s kraji, to je Ljubljana). Naslednji (osmi) bajt določa indeks kraja, kamor pelje ta vlak (`0x06` pomeni šesti kraj v datoteki s kraji, to je Maribor). Deveti in deseti bajt (`0x00 0x90`) določata čas vožnje v minutah, torej 144 minut (009016 = 14410). Zadnja dva bajta pa določata doplačilo, ki ga v primeru regionalnega vlaka ni, torej je 0 (`0x00 0x00`).

Poglejmo še primer zapisa ekspresnega vlaka IC123 iz Ljubljane v Kranj, ki vozi 22 minut, pri ceni karte pa se obračuna še dodatek v višini 2,50 €:

`0x49 0x43 0x31 0x32 0x33 0x20 0x01 0x04 0x00 0x16 0x00 0xFA`

Podatke interpretiramo podobno kot pri regionalnem vlaku (oznaka vlaka je `IC123_`, indeksa krajev 1 in 4, trajanje vožnje pa 22 minut), le da imamo tu določen tudi znesek doplačila v centih (torej celo število), ki je zapisan v zadnjih dveh bajtih (`0x00 0xFA` je 25010, torej je dodatek 250 centov ali 2,50 €).

**Namig**: za lažje reševanje naloge dodajte v razred `Kraj` še atribut `int id`, ki bo hranil zaporedno številko kraja (številka naj se samodejno pripiše vsakemu novo ustvarjenemu kraju).

Metodo `main()` razreda `DN11` dopolnite tako, da bo za peto nalogo (prvi argument je 5) prebrala podatke o krajih iz tekstovne datoteke, podatke o vlakih pa iz binarne datoteke ([povezave.bin](https://ucilnica.fri.uni-lj.si/pluginfile.php/174139/mod_assign/intro/povezave.bin?time=1683406263357)). Nato naj izpiše vse vlake.

Tako na primer ob klicu:

`java DN11 5 kraji.txt povezave.bin`

program izpiše naslednji rezultat:


```
Vlaki, ki povezujejo kraje:  
Vlak RG715 (regionalni) Ljubljana (SI) -- Maribor (SI) (2.24h, 8.16 EUR)  
Vlak IC123 (ekspresni) Ljubljana (SI) -- Kranj (SI) (22 min, 8.71 EUR)  
Vlak IC124 (ekspresni) Kranj (SI) -- Jesenice (SI) (32 min, 11.83 EUR)  
Vlak RG812 (regionalni) Maribor (SI) -- Zagreb (HR) (3.16h, 11.11 EUR)  
Vlak IC312 (ekspresni) Zagreb (HR) -- Ljubljana (SI) (2.18h, 41.96 EUR)  
Vlak IC125 (ekspresni) Jesenice (SI) -- Beljak (AT) (36 min, 15.36 EUR)  
Vlak EC55 (ekspresni) Beljak (AT) -- Dunaj (AT) (4.29h, 77.75 EUR)  
Vlak RG1234 (regionalni) Dunaj (AT) -- Maribor (SI) (3.42h, 12.58 EUR)  
Vlak IC523 (ekspresni) Zagreb (HR) -- Split (HR) (6.21h, 113.87 EUR)  
Vlak RG7959 (regionalni) Beljak (AT) -- Kranj (SI) (1.03h, 3.57 EUR)  
Vlak RG1122 (regionalni) Ljubljana (SI) -- Novo mesto (SI) (1.34h, 5.33 EUR)
```
