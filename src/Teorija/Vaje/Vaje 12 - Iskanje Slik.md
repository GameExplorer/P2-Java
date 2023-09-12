
[[Vaje 11 - Kodiranje 2]]
[[Vaje 10 - Prijatelji]]

#GUI 

---

**Opis formata PNG:**

V formatu PNG zapisane datoteke imajo točno določeno strukturo. Na začetku datoteke je 8 bajtov dolg podpis formata (_signature_): `89 50 4E 47 0D 0A 1A 0A` (zapisano šestnajstiško). Podpis pove, da gre za datoteko tipa PNG. Podpisu sledi več kosov (_chunks_) različnih tipov, ki opisujejo metapodatke in vsebino slike. Posamezni kosi so sestavljeni iz 4 polj:

![[Pasted image 20230903224256.png]]
  

Polje dolžina opisuje dolžino podatkov (v bajtih) v temu kosu. Sledijo 4 bajti, ki opisujejo tip kosa. Poznamo 18 različnih tipov kosov. Od tega so naslednji kosi obvezno prisotni v vsaki datoteki s sliko:

- **IHDR**: glava slike. To je vedno prvi kos v datoteki. Vsebuje tudi podatke o širini in višini slike.
- **IDAT**: vsebina slike. Teh kosov je lahko več.
- **IEND**: označuje konec slike.

Sledijo podatki kosa. V primeru **IHDR** podatki vsebujejo tudi informacijo o širini (prvi 4 bajti) in višini (naslednji 4 bajti) slike. Na koncu kosa je še koda CRC, ki se uporablja za preverjanje in odpravljanje pokvarjenih bitov v kosu.  


Primer zapisa začetka datoteke primer.png v HEX (šestnajstiškem) formatu:


```
89 50 4E 47 0D 0A 1A 0A 00 00 00 0D 49 48 44 52  
00 00 03 00 00 00 02 80 08 06 00 00 00 2B 46 1F  
E2 00 00 00 04 67 41 4D 41 00 00 B1 8F 0B FC 61  
05 00 00 00 09 70 48 59 73 00 00 12 72 00 00 12  
```


Z rdečim ozadjem je označen podpis PNG formata. Sledi prvi kos. Njegova dolžina je določena s 4 bajti (svetlo modra). V našem primeru je dolžina 13. Sledi tip kosa (rumeno ozadje). V našem primeru gre za tip IHDR (`49 48 44 52` v ASCII). Sledijo podatki kosa (13 bajtov, modro ozadje). Z rdečo in rumeno sta označena podatka o širini in višini slike. Iz podatkov lahko razberemo, da gre za sliko velikosti 768 x 640. Sledijo še drugi podatki, nato pa CRC koda (zeleno ozadje). Nato v datoteki sledijo še drugi PNG kosi.  

  

**Naloga:**

**1)** Napišite razred `Slika`, ki bo hranil podatke o sliki in vseboval statične metode za prepoznavanje in branje slikovnih datotek. V razred dodajte atributa `String pot` in `String tip`, ki predstavljata pot do slikovne datoteke in njen tip (npr. PNG, JPEG, GIF) ter atributa `int sirina` in `int visina`, ki bosta vsebovala informacije o velikosti slike.  



Dodajte dva konstruktorja (oba nastavita vrednosti atributov `pot` in `tip`). Enega bomo uporabili v primeru, da poznamo tudi velikost slike (širina in višina), drugega pa v primeru, da te informacije nimamo. V drugem primeru nastavite širino in višino na 0, kar naj označuje neznano velikost.  


V razredu implementirajte še metodo `toString()`, da bo izpis objekta naslednje oblike:

`<pot>: Slika <tip> (<sirina> x <visina>)`

V primeru, da velikost slike ni znana (=0), oklepaj z velikostjo izpustite.  

  

**2)** V razred `Slika` dodajte statično metodo `boolean jePNG(String vhodnaDatoteka)`, ki naj preveri, če je podana vhodna datoteka tipa PNG. Preverjanje naredi tako, da prebere prvih nekaj bajtov datoteke (podpis) in preveri, če se ujemajo s podpisom PNG datotek (opisano zgoraj). Preverite delovanje metode na [testni PNG datoteki](https://ucilnica.fri.uni-lj.si/pluginfile.php/174643/mod_assign/intro/primer.png?time=1683843575568) in na poljubni drugi datoteki, ki ni tipa PNG.  

  

**3)** V razred dodajte še statično metodo `Slika` `preberiPNG(String vhodnaDatoteka)`, ki prebere podatke o datoteki tipa PNG in vrne objekt tipa `Slika` z vsemi podatki. Iz formata PNG izluščite podatke o širini in višini slike (glej opis formata). Za tip slike nastavite vrednost `"PNG"`. Preverite delovanje metode na testni datoteki.  

  

**4)** Napišite razred `IskanjeSlik`, ki bo omogočal iskanje slikovnih datotek. Vsebuje naj atribut `ArrayList<Slika> slike`, kjer bo hranil najdene slike. V razred dodajte metodo `void preisci(String pot)`, ki naj preišče podan direktorij in vse najdene slike doda v seznam `slike`. Za vsako datoteko preverite, če je tipa PNG, z metodo `Slika.jePNG(datoteka)`. V primeru da gre za PNG datoteko, preberite tudi njene podatke (širina, višina). Metoda naj rekurzivno preišče tudi vse poddirektorije.  

  

Dodajte še metodo `void izpisi()`, ki naj izpiše vse najdene datoteke s slikami. Preverite delovanje iskanja slik tako, da napišete statično metodo `main()`, kjer izvedete iskanje slik in izpišete rezultate. Uporabite lahko testni direktorij ([arhiv.zip](https://ucilnica.fri.uni-lj.si/pluginfile.php/174643/mod_assign/intro/arhiv.zip?time=1683843152786)), ki vsebuje več PNG slik (tudi nekaj skritih).  

  

**5)** Dopolnite metodo `izpisi()` tako, da izpis uredi po naslednjem vrstnem redu:

- Slike naj bodo urejene po velikosti od najmanjše do največje. Za velikost slike vzemite skupno število pikslov (širina * višina).
- V primeru da je več slik enake velikosti, jih uredite po njihovi poti, po abecednem vrstnem redu.

  

---

**DODATNA NALOGA**

  

**6)** V razred `Slika` dodajte še metodi `boolean jeJPEG(String vhodnaDatoteka)` in `boolean jeGIF(String vhodnaDatoteka)`, ki preverita, če je vhodna datoteka tipa JPEG ali GIF. Datoteke tipa JPEG imajo podpis (se začnejo z) `FF D8 FF`, datoteke tipa GIF pa `47 49 46 38`. Poln seznam podpisov pogostih datotek lahko najdete na [Wikipedii](https://en.wikipedia.org/wiki/List_of_file_signatures).

  

**Namig**: Da se izognete podvajanju kode, lahko implementirate pomožno metodo `boolean preveriPodpis(String vhodnaDatoteka, int[] podpis)`, ki preveri, če se podpis datoteke (tj. začetek datoteke) ujema s podpisom `podpis`. Podpise znanih formatov lahko hranite v konstantnih statičnih spremenljivkah v razredu `Slika` (npr. `Slika.JPEG`).

  

Dopolnite metodo `preisci()` v razredu `IskanjeSlik`, da za vsako datoteko preveri še nove formate slik. Slike, ki ustrezajo formatu JPEG ali GIF, dodajte na seznam najdenih slik. Ker za datoteke JPEG in GIF nismo implementirali branja velikosti, nastavite velikost slike na neznano.