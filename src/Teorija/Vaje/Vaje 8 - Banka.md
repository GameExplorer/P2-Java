
[[Vaje 7 - Telefonski Imenik]]
[[Vaje 9 - Kodiranje]]


#abstraktni_razred #razredi #oop #super #toString

---
Povezava do kode: [Koda](https://github.com/GameExplorer/P2_Vaje/tree/master/src/vaje08/Banka)

# Povzetek

Lahko imamo **protected** konstruktor

```
protected Racun(String stevilka) {
	this.stanje = 0.0;
	this.stevilka = stevilka;
}
```

**toString()**

Uporabljamo za izpis. Lahko ga pokličemo v ostale razrede in spremenimo izpis.
Primer:

```
return String.format("Račun %s %s: %.2f EUR", this.stevilka, opisRacuna(), this.stanje)
```

Vračanje stringa v returnu uporabimo `return String.format`

**super**

Se sklicuje na super razred (očeta) objekotv.

**dodajObresti**
Vsem varčevalnim računom pripiše obresti. S stem se spremenijo stanja na varčevalnih računih.

```
public void dodajObresti() {
	for(int i = 0; i < steviloRacunov; i++) {
			if(racuni[i] instanceof VarcevalniRacun) {
				((VarcevalniRacun) racuni[i]).dodajObresti();
			}
		}
}
```

# Navodila

**1)** Dopolnite abstraktni razred `Racun`. Implementirajte metodi `boolean polog(double znesek)` in `boolean dvig(double znesek)`; prva položi, druga pa dvigne določen znesek z računa. Pri tem se ustrezno spremeni stanje računa (stanje na računu je lahko tudi negativno). Metodi naj preverita, da je znesek pravilne oblike (večji od 0). Če znesek ni ustrezen, naj vrneta `false`.

  

Implementirajte tudi metodo `toString()`, ki naj opiše račun z nizom oblike `"Račun <stevilka> (<opis>): <stanje> EUR"`, kjer `<stevilka>` predstavlja številko računa, `<stanje>` stanje na računu, `<opis>` pa opis računa, ki ga dobimo s klicem metode `opisRacuna()`. Le-to bomo implementirali v razširitvah razreda `Racun` in bo vračala opis računa, ki se bo razlikoval glede na tip računa.

  

**2)** Ustvarite razred `VarcevalniRacun`, ki naj bo razširitev razreda `Racun`. Ta bo predstavljal varčevalni račun z obrestmi. Zato naj dodatno vsebuje še privatni atribut `double obresti`, ki bo določal obrestno mero, ter metodo `void dodajObresti()`, ki bo obračunala obresti in jih dodala na stanje računa (stanje na računu naj poveča za `stanje * obresti`). Ustrezno implementirajte tudi konstruktor razreda, da bo omogočal nastavitev obrestne mere. Implementirajte tudi metodo `opisRacuna()`, ki se uporablja pri izpisovanju računa. Metodo dopolnite na tak način, da bo izpis računa izgledal takole:

  

>Račun SI56 7823 4563 8346 123 (varčevalni, obrestna mera: 1,34%): 128,86 EUR

**3)** Ustvarite še razred `TekociRacun`, ki naj bo prav tako razširitev razreda `Racun`. Ta bo predstavljal tekoči račun z omejitvijo zneska dviga. V razred zato dodajte še atribut `double limit`, ki bo določal, največ koliko denarja lahko dvignemo z enim dvigom (z metodo `dvig()`). V primeru, da poskušamo dvigniti večjo vsoto, kot je določen limit, naj bo dvig neuspešen (metoda vrne `false`). Ustrezno spremenite še konstruktor razreda in metodo `opisRacuna()`, da bo izpis naslednje oblike:

  

>Račun SI56 0010 4321 1234 135 (tekoči, limit: 250,00 EUR): 86,29 EUR

**4)** V paketu `banka` ustvarite razred `Banka`, ki bo hranil vse račune določene banke. Vse račune, tako tekoče kot varčevalne, hranimo v tabeli `Racun[] racuni`, ki je atribut tega razreda. Banka ima lahko največ 500 računov (zakonska omejitev za male banke :), trenutno število računov v banki pa določa atribut `steviloRacunov`. V razred dodajte metodi `boolean dodajTekociRacun(String stevilka, double limit)` in `boolean dodajVarcevalniRacun(String stevilka, double obresti)`, ki v banko dodata ustrezna računa. V primeru, da v banki že obstaja račun s to številko, naj se račun ne doda, metoda pa vrne `false`.

Dodajte še metodi `void izpisiRacune()` in `void izpisiRacune(boolean varcevalni)`, ki izpišeta vse račune oziroma vse varčevalne (parameter je `true`) ali tekoče (parameter je `false`) račune v banki. Na koncu naj se izpiše tudi število izpisanih računov.  

  

Delovanje banke (in napisanih metod) testirajte z uporabo razreda `Upravljanje`.  

  

_Namig_: Ali je račun tekoči ali varčevalni, lahko preverite z operatorjem `instanceof`.  

  

**5)** V razred `Banka` dodajte še naslednje metode:  

-   `boolean dvig(String stevilka, double znesek)` in `boolean polog(String stevilka, double znesek)`, ki izvedeta dvig oziroma polog določenega zneska na račun s podano številko. V primeru da računa s to številko ni v banki, naj metodi vrneta `false`.
-   `void dodajObresti()`, ki prišteje obresti vsem varčevalnim računom na banki.

Testirajte delovanje napisanih metod v aplikaciji `Upravljanje`. Preverite delovanje obračunavanja obresti in omejitve dviga pri tekočem računu.

**DODATNA NALOGA**

**6)** V razred `Banka` dodajte metodo `void sortirajRacune(String polje, boolean padajoce)`, ki bo uredila račune glede na podano polje `polje`. Če je polje `"stevilka"`, naj račune uredi glede na njihovo številko (po abecedi), če pa je polje `"stanje"`, naj jih uredi glede na stanje na računu. Smer urejanja je določena s parametrom `padajoce`. Če je `true`, naj se računi uredijo padajoče glede na podano polje, sicer pa naraščajoče.

_Namig_: Dva niza znakov (tip `String`) lahko med seboj primerjate po velikosti (po abecedi) z metodo `compareTo()`. Klic `niz1.compareTo(niz2)` vrne pozitivno celo število, če je `niz1` večji od `niz2`, oziroma negativno celo število, če je `niz1` manjši od `niz2`. Če sta niza enaka, metoda vrne 0.




