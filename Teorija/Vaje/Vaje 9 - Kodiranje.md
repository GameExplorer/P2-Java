[[Vaje 8 - Banka]]
[[Vaje 10 - Prijatelji]]

#interfaces  #kodiranje 

----

[Koda z rešitvami](https://github.com/GameExplorer/P2_Vaje/tree/master/src/vaje09)

**Cezarjev algoritem** je eden najpreprostejših načinov šifriranja. Gre za zamenjavo črk, kjer originalno črko zamenjamo s črko, ki je v abecedi nekaj mest za njo. Koliko mest, pa določa ključ za šifriranje, ki je celo število (lahko je tudi negativno število - v tem primeru gledamo mesta pred črko). Tako se pri ključu 2 črka 'a' zamenja s črko 'c', saj je ta črka dve mesti naprej v abecedi. Pri ključu -2 pa bi se črka 'c' zamenjala s črko 'a'. Postopek lahko opišemo tudi takole: _črka_ → _črka_+_k_ po modulu _n_, kjer je _n_ velikost abecede, _k_ pa ključ šifriranja. V splošnem lahko algoritem uporabimo za zamenjavo poljubnih znakov, kjer njihovo zaporedje (abecedo) določa zaporedje kod znakov.

**XOR kodiranje** poznate že s predavanj. Gre za simetrično šifriranje, ki šifrira podatke s pomočjo gesla in bitnega operatorja XOR (^).

Vse razrede, ki jih potrebujemo za implementacijo kodiranja, bomo postavili v paket `kodirniki`. V paketu `aplikacija` pa bomo imeli program `Sporocila`, ki bo izvedel šifriranje s pomočjo izbranega kodirnika.

**1)** Najprej v paketu `kodirniki` napišite vmesnik `Kodirnik`, ki opisuje kodiranje. V njem definirajte metode:

1.  `int zakodiraj(int vrednost)`, ki bo zakodirala eno vrednost (znak) in vrnila zakodirano vrednost,
2.  `int odkodiraj(int vrednost)`, ki bo odkodirala eno kodirano vrednost (znak) in vrnila odkodirano vrednost ter
3.  `void ponastavi()`, ki bo ponastavila stanje kodirnika (za kodirnike, pri katerih je kodiranje odvisno od stanja).

**2)** V paket `kodirniki` dodajte tudi razred `CezarjevAlgoritem`, ki implementira vmesnik `Kodirnik`. Razred naj za šifriranje uporabi Cezarjev algoritem.

1.  V razred `CezarjevAlgoritem` dodajte atribut `int zamik`, s katerim je določen ključ šifriranja (zamik znakov).
2.  Implementirajte ustrezen konstruktor, ki poskrbi za nastavitev vrednosti ključa šifriranja. Upoštevajte, da je lahko zamik tudi negativen.
3.  Smiselno implementirajte metode `zakodiraj()`, `odkodiraj()` in `ponastavi()`. Predpostavite, da v metodah `zakodiraj()` in `odkodiraj()` v parametru `vrednost` dobite številsko vrednost znaka, ki ga želimo (de)šifrirati. Znak šifriramo tako, da mu prištejemo ključ šifriranja. Metodo `ponastavi()` lahko pustite prazno, saj Cezarjev algoritem nima stanja (vse znake šifriramo na enak način, neodvisno od vrstnega reda v besedilu).

**3)** V paket dodajte še razred `Kodiranje`, ki omogoča uporabo kodirnikov za šifriranje in dešifriranje besedila (niza znakov).  

1.  V razred dodajte atribut `Kodirnik kodirnik`, ki določa kodirnik, s katerim bomo šifrirali besedila.  
2.  Implementirajte konstruktor, ki nastavi želeni kodirnik.  
3.  Definirajte metodi `String zakodiranjeBesedila(String besedilo)` in `String odkodiranjeBesedila(String besedilo)`, ki šifrirata/dešifrirata podano besedilo z nastavljenim kodirnikom. Pazite, da pred začetkom šifriranja oz. dešifriranja ponastavite stanje kodirnika.

**4)** V paketu `aplikacija` napišite razred `Sporocila` in v njegovi metodi `main()` preverite delovanje Cezarjevega algoritma. Najprej ustvarite kodirnik tipa `CezarjevAlgoritem` in objekt tipa `Kodiranje`, ki mu nastavite ustvarjeni kodirnik. Nato poskusite šifrirati in dešifrirati poljubno besedilo. Izpišite šifriran in dešifriran niz. Dobite enako besedilo, kot ste ga vnesli? Šifriranje preizkusite z različnimi vrednostmi ključa (tudi z vrednostjo 0).

**5)** Napišite razred `XORAlgoritem`, ki implementira vmesnik `Kodirnik`. Razred naj implementira XOR kodiranje. Šifriranje podatkov poteka tako, da se _i_-ti znak besedila XOR-a z _i_-tim znakom gesla. Ker so gesla ponavadi krajša kot besedilo, so indeksi ključa vzeti po modulu _n_, kjer je _n_ dolžina gesla.

1.  V razred `XORAlgoritem` dodajte atribut `String geslo`, s katerim je določen ključ oz. geslo, uporabljeno pri šifriranju. Po potrebi dodajte še dodatne atribute, ki predstavljajo trenutno stanje kodirnika (npr. trenutni znak gesla, ki ga uporabimo za šifriranje).
2.  Napišite konstruktor, ki nastavi vrednost gesla.
3.  Smiselno implementirajte metode `zakodiraj()`, `odkodiraj()` in `ponastavi()`. Predpostavite, da v metodah `zakodiraj()` in `odkodiraj()` v parametru `vrednost` dobite številsko vrednost znaka, ki ga želimo (de)šifrirati. V metodah ustrezno posodobite stanje kodirnika (stanje pove, kateri zaporedni znak gesla uporabimo za šifriranje). V metodi `ponastavi()` poskrbite, da ponastavite začetno stanje kodirnika.

Preverite delovanje XOR kodiranja, tako da v metodi `main()` razreda `Sporocila` nadomestite Cezarjev kodirnik z novo implementiranim XOR kodirnikom.

**DODATNI NALOGI**

**6)** Da povečamo varnost šifriranja, bomo implementirali še en način šifriranja. Napišite razred `KombiniraniKodirnik`, ki prav tako implementira vmesnik `Kodirnik`. S tem razredom bomo predstavili kombinirano šifriranje, kjer bomo združili moči večih kodirnikov. V razred dodajte atribut `Kodirnik[] kodirniki`, ki bo vseboval seznam kodirnikov, ki jih kombiniramo. Kombiniran kodirnik naj pri (de)šifriranju vsakega znaka izbere naključen kodirnik iz tabele `kodirniki` in znak šifrira z njim. Da lahko sporočilo tudi uspešno dešifriramo, moramo poskrbeti, da bo vrstni red kodirnikov enak pri šifriranju in dešifriranju. V ta namen dodajte v razred še atribut `long seme`, ki bo določal začetno seme (_seed_) naključnostnega generatorja. Dodajte konstruktor, ki ustrezno nastavi vse atribute. Ustrezno implementirajte metode `zakodiraj()`, `odkodiraj()` in `ponastavi()`. Poskrbite, da v metodi `ponastavi()` ustrezno ponastavite stanje kombiniranega kodirnika. Po klicu te metode mora kodirnik delovati natanko enako kot na začetku, ko smo ga prvič uporabili. Po potrebi lahko v razred dodate še dodatne atribute.

Preizkusite delovanje kombiniranega kodiranja v razredu `Sporocila`, tako da uporabite dva kodirnika: `XORAlgoritem("programiranje")` in `CezarjevAlgoritem(0)`. Cezarjev algoritem z zamikom 0 je pravzaprav kodirnik, ki besedilo ohranja nespremenjeno. Zato mora tak kombiniran kodirnik približno polovico znakov ohraniti istih, polovico pa jih šifrira z XOR algoritmom. Preverite, če z dešifriranje šifriranega sporočila dobite nazaj originalno sporočilo.

**7)** Z uporabo kombiniranega kodirnika poskusite implementirati še kodirnik, ki deluje na naslednji način:

-   z verjetnostjo 50 % znak kodira s kodirnikom XOR in geslom `"programiranje"`,
-   z verjetnostjo 50 % pa znak kodira s kodirnikom, kjer zamik izbere naključno iz nabora {-2, -1, 1, 2}.