
**03.04.2023**

[[Vaje 5 - Nakupovalni Seznam]]
[[Vaje 7 - Telefonski Imenik]]

#StdDraw #metode #for_zanka 

----

Pri vajah smo delali z knjižnico StdDraw in delno naredili igro15. 

```
Igra je premičnica (ploščice premikamo po igralnem polju), sestavlja pa jo 15 oštevilčenih ploščic na mreži 4 x 4. Eno mesto je prazno, kar nam omogoča premikanje ploščic. Ploščice v naši igri premikamo tako, da s pomočjo smernih puščic premikamo prazno polje. Cilj igre je, da ploščice postavimo po vrsti od 1 do 15.
```

Povezava do kode: [Koda](https://github.com/GameExplorer/P2_Vaje/blob/master/src/Igra15.java)

![[Pasted image 20230416163957.png]]


# Navodila

#### NALOGE

Za igranje igre manjkajo posamezne metode, ki poskrbijo za logiko igre in grafični izris. Glave vseh metod so že definirane, manjka pa koda v telesih metod. Po potrebi napišite še dodatne metode, ki vam bodo v pomoč pri rešitvi problema.  

**1)** Implementirajte metodo novaIgra(), ki pripravi vse potrebno za začetek igre. Najprej ustvari okno in igralno površino, na kateri bo potekala igra. Velikost igralne površine (število ploščic) določa konstanta STEVILO_POLJ, velikost ene ploščice pa konstanta STRANICA_KVADRATKA. Med posameznimi ploščicami je še za DEBELINA_ROBA prostora, prav toliko pa so ploščice tudi oddaljene od roba igralne površine. Iz tega lahko izračunamo tudi velikost igralne površine, ki jo določa konstanta VELIKOST. Širina okna je tako enaka VELIKOST, višina okna pa mora biti še nekoliko večja, saj bomo nad igralno površino izpisovali še število narejenih potez: konstanta GLAVA določa, koliko prostora namenimo temu izpisu.

V metodi novaIgra() pokličite metodo napolniStevilke() (glej opis pod točko 2), ki nastavi začetno postavitev številk, ter metodo izrisiPolja(), ki poskrbi za izris ploščic na igralni površini (glej točko 3).

_Opomba 1_: Ker bomo v igri premikali prazno polje, bomo za lažje delo koordinati praznega polja shranili v ločeno spremenljivko, tabelo indeksPrazne, kjer prvi element tabele pove vrstico, drugi pa stolpec, v katerem se nahaja prazna ploščica. Vrstice in stolpce štejemo od 0 naprej (indeksi!) ter od zgoraj navzdol oz. od leve proti desni. Pri pravilni rešitvi igre velikosti 4x4 ima ta tabela vrednost {3,3}.  

_Opomba 2_: Trenutno stanje igralnega polja (postavitev številk v mreži) bomo hranili v 2D tabeli polja. Številka STEVILKA_PRAZNEGA (število 16 pri mreži 4x4) predstavlja prazno polje (tj. polje, ki ga premikamo s pomočjo smernih tipk).

_Namig_: Igralna površina je lahko privzeta velikost okna (ali pa z metodo setCanvasSize() ustvarite okno želene velikosti). Z metodo setXScale() oz. setYScale() ustrezno nastavite razpon koordinatnega sistema v oknu na 0 do VELIKOST oz. VELIKOST+GLAVA (privzeto je med 0.0 in 1.0, kar za naše risanje ni najbolj uporabno).

_Nasvet_: Za boljši (bolj gladek) prikaz premikanja ploščic uporabite dvojno medpomnenje (double buffering) za izris nove slike. Vključite ga tako, da pokličete metodo enableDoubleBuffering(), najbolje kar po vzpostavitvi igralne površine. Vsako risanje (izris ploščic s številkami ali izpise) potem najprej naredite v medpomnilnik, ki je v ozadju (ni prikazan), ko risanje zaključite, pa ga prikažete s pomočjo metode show(). Sledi naj še klic metode pause(POCAKAJ), ki poskrbi za kratko prekinitev, da se igra ne izvaja prehitro.

**2)** Implementirajte metodo napolniStevilke(), ki pripravi začetno stanje številk v mreži in torej ustrezno napolni 2D tabelo polja. Začetne vrednosti za igro 4x4 določa tabela zacetnoStanje, ki jo morate le prepisati v tabelo polja. (Boljši izziv za igranje igre pa je, če ploščice naključno premešamo - to bomo naredili v dodatni nalogi.)

_Namig_: Pri tem ne pozabite ustrezno nastaviti vrednosti za koordinati praznega polja (tabela indeksPrazne).

**3)** Implementirajte tudi metodo izrisiPolja(), ki poskrbi za prikaz vseh ploščic s števili. Števila izpiše s pisavo PISAVA_STEVILKE in barvo BARVA_STEVILKE. Če se število nahaja na svojem mestu (tam, kjer mora biti pri pravilni rešitvi), naj bo barva ploščice BARVA_OZADJA_PRAVILNE, sicer pa BARVA_OZADJA. Prazno ploščico narišite v barvi BARVA_PRAZNE.

Za izpis števila potez uporabite pisavo PISAVA_GLAVA v črni barvi. Niz NAPIS določa, kaj naj se izpiše pred številom potez.

_Nasvet_: Če uporabljate dvojno medpomnenje (double buffering) novo sliko narišete v medpomnilnik, ki ni prikazan. Celo sliko najprej pobrišete z metodo clear(), nato pa poskrbite za izris ploščic s števili in izpis trenutnega števila potez v glavi. Ko je nov izris pripravljen, ga prikažete s klicem metode show() in metode pause(2*POCAKAJ), ki z upočasnitvijo igre poskrbi za bolj mehke prehode in boljšo igralsko izkušnjo pri uporabi smernih tipk.

**4)** Implementirajte tudi metodo naslednjaPoteza(), ki preveri, katera tipka na tipkovnici je pritisnjena in temu primerno premakne prazno ploščico, če je premik seveda možen. Podrobnosti o ukazu za branje s tipkovnice isKeyPressed() lahko najdete v dokumentaciji. Ob pritisku na tipko ESC naj se igra prekine.

_Opomba_: Prazne ploščice ne moremo premakniti izven mreže igralnega polja. Če se npr. ploščica nahaja na levem robu mreže (v prvem stolpcu mreže) in jo želimo premakniti levo, tak premik ni možen in v tem primeru se ignorira pritisk na tipko levo: ob pritisku na tipko se ne zgodi nič, le igra naj se za trenutek ustavi - klic metode pause(POCAKAJ).

_Namig_: Ob uspešno izvedeni potezi ne pozabite povečati števca potez. Za novo stanje igre tudi preverite, če je dosežena pravilna rešitev (glej opis metode v nalogi 5); v tem primeru spremenite vrednost spremenljivke igranje na false, kar omogoči končanje igre v metodi main.

_Nasvet_: Za premik v vsako smer napišite pomožno metodo, ki poskrbi za preverjanje, ali je premik možen, in za izvedbo premika.

**5)** Dopišite še metodo preveriResitev(), ki preveri, ali postavljena števila v mreži predstavljajo pravilno rešitev igre (torej so števila postavljena po vrsti od 1 do STEVILKA_PRAZNEGA).

**6)** Dodajte še metodo konecIgre(), ki v glavi izpiše besedilo ob koncu igre ter število potrebnih potez za rešitev. Za izpis naj uporabi pisavo PISAVA_GLAVA v črni barvi. Niz KONEC določa, kaj naj se izpiše pred številom potez.

---

#### DODATNA NALOGA

**7)** Metodo napolniStevilke() dopolnite tako, da bo omogočala nastavitev začetnega stanja igre na dva načina. Zato metodi dodajte še parameter boolean nakljucno, ki določa način nastavitve začetnega stanja igre. Če je vrednost parametra false, naj metoda uporabi enostavnejši način priprave začetnega stanja, ki smo ga implementirali že v nalogi 2. Drugi način (ko je parameter metode true) pa začetno stanje števil določi naključno.

Ker povsem naključna postavitev števil v mrežo lahko privede do nerešljive postavitve (to pomeni, da iz tega stanja ne moremo priti do pravilne rešitve), naj metoda števila postavi na naslednji način: 1) najprej števila postavi po vrsti kot v pravilni rešitvi, 2) nato naključno izbere dovolj veliko število N (npr. med 500 in 1500) ter 3) N-krat naključno izbere eno izmed štirih smeri premika prazne ploščice in premakne prazno ploščico (če je premik seveda možen). Na ta način začetna števila v mreži premešamo tako, da je z ustreznimi potezami možno dobiti rešitev.