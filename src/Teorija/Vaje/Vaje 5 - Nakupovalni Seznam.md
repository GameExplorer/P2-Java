**10.04.2023**

[[Vaje 4 - Besedle]]
[[Vaje 6 - Igre na 15]]

#switch #razredi #extracted

----


> Koda z vaj: [Koda](https://github.com/GameExplorer/P2_Vaje/tree/master/src/vaje05)

# Seznam
V seznamu je nekaj metod, ki omogočajo delovanje programa in ki jih pokličemo v razredu ```NakupovalniSeznam```. 

Na začetku razreda deklariramo tabelo v katero hranimo elemente seznama in dolžino, ki pove trenutno število elementov v tabeli.

Metoda ``` narediSeznam(int n)``` ustvari seznam velikosti n. Če seznam že obstaja ne ustvari novega.  ```n``` nam pove največjo velikost seznama.

Metoda ``` uniciSeznam()``` uniči seznam tako, da ta ne obstaja več, izbriše vse njegove elemente.

Metoda ```dolzinaSeznama() ``` vrne dolžino seznama, če seznam obstaja.

Metoda ```dodajNaKonecSeznama(String element)``` doda nov element na konec seznama. Če seznam ne obstaja ali če je že poln, elementa ne doda in vrne *false*.

Metoda ``` dodajVSeznam(String element, int mesto)``` doda nov element v seznam na mesto 'mesto'. Mesta štejemo od 1 naprej. Če seznam ne obstaja ali če je poln, elementa ne doda in vrne *false*.

Metoda ```odstraniIzSeznama(int mesto)``` odstrani element na mestu 'mesto' iz seznama. Če takega elementa ni v seznamu vrne *null*. Mesto je lahko med 1 in vključno velikostjo seznama.

Metoda ```izpisSeznamaNacin(boolean velikiIzpis)``` je pomožna metoda za izpis seznama. Izpiše vse elemente trenutnega seznama. Način izpisa elementov je odvisen od podanega parametra *velikiIzpis*. Če seznam ne obstaja izpiše napako.

Izpiše vse elemente trenutnega seznama. Če seznam ne obstaja izpiše napako.
```public static void izpisiSeznam() { izpisSeznamaNacin( false); }```

Izpiše vse elemente trenutnega seznama, pri izpisu elementov uporabi znake 64-bitne abecede. Če seznam ne obstaja, izpiše napako.
```public static void izpisiSeznam64Bit() { izpisSeznamNacin(true); }```



# Nakupovalni Seznam
V razredu sta dve metodi. 
```izpisiNavodila()``` ki nam izpiše navodila ko jo pokličemo in metoda ``` main```. V metodi main se izvede switch ukaz, ki izvede metode iz razreda Seznam na podlagi vnešene številke ali pa čr vneseno h, ki nam izpiše ukaze in q, ki pa zapre program.

Na dnu programa smo uporabili ```extracted() ```, zato da imamo manj kode v case stavkih. Deluje pa isto kot če bi imeli napisano kodo. ``` void ``` ne vrača vrednosti ostali pa imajo ``` return```. 

Primer: 
```private static boolean extracted7() { return vaje05.Zbirke.Seznam.uniciSeznam(); }```


# Znaki

Razred hrani kodo iz vaje [[Vaje 3 - Pikčasti Znaki]].







