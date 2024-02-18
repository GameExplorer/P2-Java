[[DN 8 - Planeti]]
[[DN 6 - Kontrolna vsota BSD]]
#FILE 

---
#### Naloga 0 - Ustvari metodo main() (1 točka)  

Ustvarite razred DN07, v katerem je metoda main(). Prvi argument ob klicu programa je število med 1 in 9, ki določa, katera metoda naj se izvede. Drugi argument določa izhodiščni direktorij v katerem bo program iskal datoteke, na katerih se bo izvedla metoda. Pri nekaterih nalogah nato sledijo še dodatni argumenti, ki vplivajo na delovanje metode.  

  

V programu ustvarite spremenljivko File z direktorijem, podanim v 2. argumentu programa.  

  

#### 1. Naloga - izpis datotek v podanem direktoriju (1 točka)  

Napišite metodo  `izpisi_datoteke(File f)`, ki kot argument sprejme ustvarjen File in z njegovo pomočjo in izpiše vse datoteke v podanem direktoriju.

##### Izpis lastnosti datotek  

Metodo dopolnite tako, da za vsako datoteko dodatno izpišete njeno velikost v kilobajtih in ali gre za direktorij ali običajno datoteko.  Rezultate izpišite v tabeli z uporabo metode printf.

Primer izpisa:

`java DN07 1 ./naloga_datoteke  `
  

```
       besedilo1.txt            Datoteka     0.025  
       besedilo2.txt            Datoteka     0.039  
       besedilo3.txt            Datoteka     0.017  
       besedilo4.txt            Datoteka     0.044  
       besedilo5.txt            Datoteka     0.909  
               mapa1                Mapa     0.000  
               mapa2                Mapa     4.096  
         program.exe            Datoteka     0.069
```


#### 2. Naloga - Izpis največje datoteke (1 točki)

Napišite metodo `najvecja_datoteka(File f)`, ki v podanem direktoriju prebere vse datoteke in med njimi poišče in izpiše največjo in najmanjšo, skupaj z njunima velikostima.  V primeru, da imata dve datoteki enako velikost naj metoda izpiše tisto, ki je v seznamu datotek prva.

Primer izpisa:

`Java DN07 2 ./naloga_datoteke  `
  

```
besedilo5.txt 0.909  
besedilo3.txt 0.017  
```

#### 3. Naloga - Izpis vsebine datotek (2 točki)

Napišite metodo` izpis_vsebine(File f, int n)`, ki poleg imen datotek za vsako tekstovno datoteko izpiše prvih n vrstic njene vsebine. Če datoteka ni tekstovna (ime se ne konča z .txt), poleg imena zapišite "(ni tekstovna datoteka)". Če datoteka je tekstovna, v novi vrstici z zamikom 4ih presledkov izpišite prvih n vrstic vsebine, kjer je n podan kot tretji argument programa. Če datoteka vsebuje manj kot n vrstic izpišite vse vrstice datoteke.  
  
Primer pravilnega izpisa:

`java DN07 3 ./naloga_datoteke 3`  
  

```
besedilo1.txt  
    Prvo besedilo.  
    besedilo.  
besedilo2.txt  
    Drugo besedilo.  
    1+2  
    4*5  
besedilo3.txt  
    Tretje besedilo  
besedilo4.txt  
    text1.txt  
    text2.txt  
    text3.txt  
besedilo5.txt  
    Java je objektno usmerjeni, prenosljivi programski jezik, ki ga je razvil James Gosling s sodelavci v podjetju Sun Microsystems. Projekt, ki se je v začetku (leta 1991) imenoval Oak (hrast), je bil razvit kot zamenjava za C++. Jave ne smemo zamenjevati z jezikom JavaScript, ki ima podobno ime, ter podobno, C-jevsko skladnjo. Različica Java 1.0 je bila objavljena leta 1996, zadnja različica je 11.0 (april 2019). Javo vzdržuje in posodablja Oracle - Sun Microsystems.  
      
    Tolmač za javo je vgrajen v večino spletnih brskalnikov, s tem se javanski programčki (applet) lahko izvajajo kot del HTML dokumenta.  
program.exe (ni tekstovna datoteka)  
```

  

#### 4. Naloga - Kopiranje datotek (1 točka)

Napišite metodo `kopiraj_datoteko(String vhodnaDatoteka, String izhodnaDatoteka)`, ki vsebino tekstovne datoteke, podane v 3. argumentu programa zapiše v datoteko, podano v 4. argumentu programa. Če datoteka iz 4. argumenta še ne obstaja, jo ustvarite. Če datoteke že obstaja, najprej preverite, ali je prazna. V primeru, da datoteka že vsebuje besedilo, izpišite napako ("Napaka pri kopiranju, datoteka že vsebuje besedilo)

Za kopiranje ne smete uporabiti obstoječih metod (kot na primer Files.copy()).

  

Primer klica:

`java DN07 4 ./naloga_datoteke besedilo1.txt mapa1/besedilo1_kopija.txt  `

Imena datotek v argumentih so relativna na 2. podani argument (v zgornjem primeru se besedilo1.txt nahaja v direktoriju ./naloge_datoteke)  

  
#### 5. Naloga - Združevanje datotek (2 točki)

Napišite metodo `zdruzi_datoteko(File direktorij, String izhodnaDatoteka)`, ki združi vsebino tekstovnih datotek v direktoriju, podanem v 2. argumentu programa in jih zapiše v datoteko, podano v 3. argumentu programa. Vrstni red besedil naj bo enak tistemu, ki ga vrne metoda list(). Če direktorij ne vsebuje tekstovnih datotek izpišite napako ("Direktorij ne vsebuje tekstovnih datotek.). Vrstni red besedil naj bo enak vrstnemu redu, ki ga vrne razred File.

Primer izpisa:

Ob klicu java` DN07 5 ./naloga_datoteke zdruzeno.txt` naj program v datoteko zdruzeno.txt zapiše:
  

```
Prvo besedilo.  
besedilo.  
Drugo besedilo.  
1+2  
4*5  
Text.  
1-2+3  
Tretje besedilo  
text1.txt  
text2.txt  
text3.txt  
1+2+3+4+5-1  
Java je objektno usmerjeni, prenosljivi programski jezik, ki ga je razvil James Gosling s sodelavci v podjetju Sun Microsystems. Projekt, ki se je v začetku (leta 1991) imenoval Oak (hrast), je bil razvit kot zamenjava za C++. Jave ne smemo zamenjevati z jezikom JavaScript, ki ima podobno ime, ter podobno, C-jevsko skladnjo. Različica Java 1.0 je bila objavljena leta 1996, zadnja različica je 11.0 (april 2019). Javo vzdržuje in posodablja Oracle - Sun Microsystems.  
  
Tolmač za javo je vgrajen v večino spletnih brskalnikov, s tem se javanski programčki (applet) lahko izvajajo kot del HTML dokumenta.  
  
Z javo se da programirati tudi aplikacije na mobilnih telefonih (J2ME) in pametnih telefonih z operacijskim sistemom Android.  
  
Javo lahko namestimo tudi na mikroprocesroje ARM in sicer po ne tako prijaznem postopku, ki ga lahko najdemo na spletni strani najdeni v poglavju Zunanje povezave   
```


#### 6. Iskanje po datotekah (3 točke)

Napišite metodo najdiVDatotekah(File f, String iskanNiz), ki v vseh tekstovnih datotekah direktorija, podanega v 2. argumentu programa poišče besedo oziroma niz, podan v 3. argumentu programa. Za vsako datoteko, ki vsebuje niz, izpišite:

- ime datoteke
- številko vrstice, v kateri se niz nahaja
- celotno vrstico, v kateri se nahaja niz

Če ena datoteka vsebuje več pojavitev niza, potem ustrezno izpišite vsako vrstico, v kateri se niz nahaja. Primer izpisa:

`java DN07 6 ./naloga_datoteke besedilo  `


```
besedilo1.txt 1: Prvo besedilo.  
besedilo1.txt 2: besedilo.  
besedilo2.txt 1: Drugo besedilo.  
besedilo3.txt 1: Tretje besedilo
```


#### 7. Naloga - Drevesni izpis datotek (3 točke)

Napišite metodo `drevo(File f)`, ki poleg datotek v podanem direktoriju v drevesni obliki izpiše še datoteke v vseh direktorijh, in poddirektorijih. Izpis metode naj bo strukturiran tako, da so datoteke v globjih poddirektorijih ustrezno zamaknjene. Da bodo pri izpisu direktoriji ločeni od datotek, pred njihovim imenom dodajte znak '/'. Primer izpisa:

`java DN07 7 ./naloga_datoteke  `

```
/naloga_datoteke  
    besedilo1.txt  
    besedilo2.txt  
    besedilo3.txt  
    besedilo4.txt  
    besedilo5.txt  
    /mapa1  
        besedilo.txt  
        java_logo.png  
    /mapa2  
        /mapa3  
            besedilo_mapa3.txt  
        neveljavni_program.java  
        program.java  
        program.py  
    program.exe  
```


#### 8. Naloga - Iskanje in reševanje matematičnih izrazov (2 točki)

Napišite metodo `resiMatematicneIzraze(File f)`, ki v besedilih tekstovnih datotek poišče in izračuna matematične izraze. Da naloga ne bo pretežka, se bomo omejili le na majhen del matematičnih izrazov, in sicer takšne, ki:  

- vsebujejo le števila od 0 do 9
- vsebujejo le operaciji seštevanja in odštevanja (+ in -)
- nimajo oklepajev ali presledkov

  
V direktoriju poiščite vse tekstovne datoteke, ki vsebujejo vrstice s takšnimi izrazi. Omejite se le na vrstice, ki vsebujejo samo matematični izraz (brez katerega drugega besedila). Za vsako datoteko, ki izraz vsebuje, izpišite ime datoteke, nato pa v novih vrsticah z zamikom dveh presledkov še vsak izraz in njegovo vsoto. Če datoteka ne vsebuje takšnega matematičnega izraza, izpišite le ime datoteke. Namig: Za računanje izrazov lahko z metodo charAt(i) berete vrstico znak po znak. Veljavni matematični izrazi bodo v prvem znaku vedno vsebovali števko med 0 in 9, nato pa izmenjajoče operator + ali - in spet števko. Če je znak števka lahko preverite z metodo Character.getNumericValue(char).  
  
Primer izpisa:

`java DN07 8 ./naloga_datoteke  `


```
besedilo1.txt  
besedilo2.txt  
  1+2=3  
  1-2+3=2  
besedilo3.txt  
besedilo4.txt  
  1+2+3+4+5-1=14  
besedilo5.txt

```

#### 9. Izpiši n navečjih  - 4 točke

Napišite metodo nNajvecjih(File f, int n), ki v podanem direktoriju in vseh poddirektorijih izpiše n največjih datotek, urejenih po velikosti in njihove velikosti. Če je več datotek enako velikih, tiste z enako velikostjo izpišite v takšnem zaporedju, kot so urejene v metodi list(). Metode ne rešite z urejanjem celotnega seznama. Prav tako ne uporabljajte metod, ki že implementirajo metode urejanja (na primer Arrays.sort()).  
  
Primer izpisa:

`java DN07 9 ./naloga_datoteke 3  `


```
java_logo.png 9755  
besedilo5.txt 909  
program.java 73
```
