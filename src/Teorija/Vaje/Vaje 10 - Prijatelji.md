[[Vaje 9 - Kodiranje]]
[[Vaje 11 - Kodiranje 2]]

---

**1)** Najprej napišite razred `Prijatelj`, ki opisuje enega prijatelja (eno osebo). Vsak prijatelj ima svoje ime in unikatno številko (številka se dodeli samodejno, prvi prijatelj dobi številko 1, vsak naslednji pa za ena večjo številko). Definirajte ustrezen konstruktor, ki nastavi prijateljevo ime in številko. V razredu hranimo tudi zbirko vseh prijateljev, katerim ta prijatelj dolguje določeno vsoto (ker moramo hraniti par <prijatelj, dolg>, bomo uporabili slovar, kjer je ključ prijatelj, vrednost pa znesek dolga: `Map<Prijatelj, Double> dolguje`). Na začetku je slovar prazen (ni dolgov).

Dodajte tudi metodo `String toString()`, ki vrne opis prijatelja naslednje oblike (za prijatelja z imenom Janez in zaporedno številko 11):

 [011] Janez

Po potrebi v razredu definirajte tudi ustrezne _getterje_ in/ali druge uporabne metode.

**2)** Dodajte razred `Dolgovi`, ki hrani seznam vseh prijateljev (objekte razreda `Prijatelj`).

V razred dodajte tudi metodo `void preberiPrijatelje(File datoteka)`, ki iz podane datoteke prebere podatke o prijateljih in jih shrani v seznam. Ime vsakega prijatelja je zapisano v svoji vrstici. Ime prijatelja je lahko sestavljeno tudi iz več imen (npr. Ana Marija). Primer datoteke s podatki o prijateljih je [_prijatelji.txt_](https://ucilnica.fri.uni-lj.si/pluginfile.php/189678/mod_assign/intro/prijatelji.txt?time=1682069740415).  

V razred dodajte še metodo `izpisi()`, ki izpiše vse prijatelje. Primer izpisa:

 [001] Ana Marija
 [002] Berta
 [003] Oliver mlajši
 [004] Davor

Preverite delovanje napisane kode tako, da dodate še razred `CistiRacuni` in v njegovi metodi `main()` najprej ustvarite objekt tipa `Dolgovi`, nad njim pokličete metodo za branje podatkov o prijateljih iz datoteke ter na koncu izpišete vse prijatelje z metodo `izpisi()`.

**3)** V razred `Dolgovi` dodajte tudi metodo `void preberiDolgove(File datoteka)`, ki iz podane datoteke prebere podatke o trenutnih dolgovih. V datoteki je v vsaki vrstici zapisan en dolg, in sicer trije podatki, ločeni s podpičji: ime prijatelja dolžnika, ime prijatelja upnika ter znesek dolga (v evrih). Primer:

 Franci;Esmeralda;17.3

pomeni, da Franci dolguje Esmeraldi 17,30 EUR.

Če je dolgovan znesek negativen, to pomeni, da sta upnik in dolžnik zamenjana. Primer:

 Franci;Esmeralda;-17.3

pomeni, da Esmeralda dolguje Franciju 17,30 EUR.

Primer datoteke s podatki o dolgovih je [_dolgovi.txt_](https://ucilnica.fri.uni-lj.si/pluginfile.php/189678/mod_assign/intro/dolgovi.txt?time=1682069766034).

_Opomba_: Če je vrstica v datoteki nepopolna (ne vsebuje navedenih treh podatkov), jo ignorirajte in nadaljujte z branjem. Enako naredite tudi v primeru, če prebranega imena ni v seznamu vseh prijateljev.  

_Nasvet_: Dolg dodamo v tako, da prijatelju, ki dolguje nekemu drugemu prijatelju, dodamo slednjega (skupaj z zneskom) v slovar `dolguje`. Zato v razred `Prijatelj` dodajte še metodo `void dodajDolg(Prijatelj p, double znesek)`, ki poskrbi za dodajanje prijatelja - upnika in zneska dolga (par `<p,znesek>`) v slovar `dolguje`. Pri tem upoštevajte, da morda dolg do prijatelja `p` že obstaja in se z novim dolgom le poveča (ne pa prepiše).

**4)** V razredu `Dolgovi` dopolnite metodo `izpisi()` tako, da bo pri vsakem izpisanem prijatelju dopisala tudi seznam vseh prijateljev, katerim ta prijatelj dolguje, in v oklepajih tudi znesek dolga. Če prijatelj nima dolgov, naj metoda to izpiše. Primer izpisov ([vsi izpisi](https://ucilnica.fri.uni-lj.si/pluginfile.php/189678/mod_assign/intro/izpis.txt?time=1682070789300)):

 [001] Ana Marija ima dolgove do naslednjih prijateljev:
   --> [012] Kaja (5,30 EUR)
   --> [008] Franci (3,15 EUR)
   --> [002] Berta (5,00 EUR)

[002] Berta nima dolgov.

V metodo `main()` razreda `CistiRacuni` dodajte še branje podatkov o dolgovih in izpis vseh podatkov o prijateljih z uporabo nadgrajene metode `izpisi()`.

_Nasvet_: Za lažji izpis dopolnite razred `Prijatelj` z metodo `String vrniOpisZDolgovi()`, ki poleg številke in imena prijatelja v niz doda tudi vse prijatelje, ki jim ta prijatelj dolguje, skupaj z zneskom dolga. To metodo nato uporabite pri izpisu prijatelja namesto metode `toString()`.

**5)** V razred `Dolgovi` dodajte še metodo `Set<Prijatelj> vrniBrezDolga()`, ki vrne množico vseh prijateljev, ki nimajo dolgov.

Delovanje metode preverite s klicem v metodi `main()` razreda `CistiRacuni` in ustreznim izpisom (imen prijateljev, ki nimajo dolgov, oziroma izpisa, da imajo vsi prijatelji dolgove). Pri tem naj bo izpis prijateljev urejen po imenih (naraščajoče po abecedi).

_Nasvet_: Uporabite ustrezno (urejeno) zbirko, za pravilno delovanje pa mora razred `Prijatelj` implementirati vmesnik `Comparable`.

---

**DODATNI NALOGI**

**6)** Metodo `izpisi()` dopolnite tako, da bodo izpisani prijatelji kot tudi njihovi upniki urejeni po imenih (naraščajoče po abecedi).

_Nasvet_: V metodo `izpisi()` dodajte sortiranje seznama `vsiPrijatelji`, ki ga lahko izvedete s klicem metode `Collections.sort()`. Metodi morate podati ustrezen komparator, ki ga lahko definirate tudi kot anonimni notranji razred. Urejanje seznama upnikov po abecedi pa najlažje dosežete z uporabo ustrezne (urejene) zbirke.

**7)** V razred `Dolgovi` dodajte še metodo, ki za vsakega prijatelja izpiše njegov skupen dolg (tj. koliko dolguje vsem ostalim prijateljem skupaj). Izpis naj urejen padajoče po znesku skupnega dolga. Na koncu naj izpiše še skupen znesek dolgov vseh prijateljev.  

Tudi delovanje te metode preverite s klicem v metodi `main()` razreda `CistiRacuni` in ustreznim izpisom.