
**13.04.2023**

[[Predavanje 8 - OOP]]
[[Predavanje 10 - Vmesniki]]

#izpeljani_razredi #dedovanje #abstract 

----


## Izpeljani razredi & Dedovanje

Za izhodišče izberem **obstoječ razred** in ustvarim njegovega »**naslednika**«.
Naslednik ima vse lastnosti (metode in atribute) **ENAKE** kot izhodiščni razred.
Dokler naslednika ne spremenim, se od izhodiščnega razreda razlikuje le po imenu;

![[Pasted image 20230413095737.png]]

### Primer dedovanja

Naloga: Napiši program za vodenje podatkov o knjigah v knjižnici:
- knjižnica ima dva tipa knjig: *leposlovje* in *strokovne knjige*;
- o strokovnih knjigah vodimo naslednje podatke: avtor, naslov, leto izdaje ter indeks ključnih besed;
- o leposlovnih knjigah vodimo naslednje podatke: avtor, naslov, leto izdaje ter seznam mnenj bralcev.
	
![[Pasted image 20230413100001.png]]


Izhodiščni razred imenujemo prednik, oče, nadrazred (angl. *super class*).
Izpeljani razred imenujemo potomec sin, podrazred (angl. *sub class*) 

**Nekaj lastnosti: **
- iz razreda lahko izpeljemo poljubno mnogo podrazredov; 
- podrazredi imajo iste atribute in metode kot nadrazred; 
- v podrazredu lahko dodamo atribute, napišemo nove in spremenimo obstoječe metode. 
  

**Tip objektov:**
- objekt razreda A je tipa A; 
- če je razred B izpeljan iz razreda A (`class B extends A`), potem so objekti razreda B tipa A **IN** B:  
	- objekt razreda `StrokovnaKnjiga` je tipa `Knjiga` in `StrokovnaKnjiga`. 

Tip objekta preverim z operatorjem `instanceof`. 

```ad-code
title: Primer instanceof

Knjiga k = new StrokovnaKnjiga(…); 

System.out.println(k instanceof Strokovno); // true

System.out.println(k instanceof Knjiga); // true 

System.out.println(k instanceof Leposlovje); // false

```


## Praoče object

Vsi razredi v Javi so potomci razreda `Object`. Ob deklaraciji razreda prevajalnik sam doda besedi `extends Object`. Na vseh javanskih objektih lahko kličemo metode, ki so jih podedovali od praočeta. Ena od teh je tudi metoda `toString()`, ki jo poznajo vsi objekti. 

```ad-note
title: Zanimiva posledica

Z metodo `println()` lahko izpisujemo poljubne objekte (izpisalo se bo tisto, kar vrne njegova metoda `toString()`)
```


![[Pasted image 20230413100312.png]]


Na vrhu hierarhije je `Object`

```ad-note
title: Lepo napisani razred vsebujejo

- privatne atribute
- get in set
- kontrustor (enega ali več)
- metoda toString

```

## Abstraktne metode

V Java kontekstu beseda *abstraktno* pomeni, da nekaj ni (v celoti) definirano. Metoda je abstraktna, če poznamo njen podpis, telo metoda pa ni na voljo.
Abstraktni razred je razred, v katerem je vsaj ena od metod abstraktna. Iz abstraktnega razreda ne moremo narediti objektov.

Primer uporabe 1:
- razred `Knjiga` nam služi le kot nadrazed, iz katerega sta izpeljana dva podrazreda.
- izdelovanje objektov tipa `Knjiga` ni smiselno - vedno izdelamo bodisi `Leposlovje` bodisi `StrokovnaKnjiga`
- kako bi preprečili, da uporabnik ne bi (recimo po pomoti) izdelal objekta razreda Knjiga?
	- Odg: tako, da razred Knjiga proglasimo za abstrakten
	
Primer uporabe 2:
- V razredu `Knjiga` je metoda `getPodrobnosti()` tam zato, da jo lahko kličemo v metodi `izpis()`, 
- dejansko implementacijo metode `getPodrobnosti()` bodo priskrbeli podrazredi. 
- V razredu Knjiga se moram torej samo zavedati, da bo taka metoda nekoč obstajala - potrebujem samo definicijo podpisa metode brez implementacije.
- Metodam, ki niso v celoti definirane, pravimo "abstraktne metode", definiramo pa jih takole:
	- `abstract String getPodrobnosti()`
	  
Primer:

![[Pasted image 20230414203344.png]]

## Anonimni notranji razred

Anonimni notranji razred je **razred za enkratno uporabo**. 
V fazi "izdelave" objekta lahko razred spremenimo oz. prilagodimo -> nastane anonimni notranji razred:  
- nadomestiomo lahko vse ne-statične metode
- spremenimo lahko vrednost atributom

![[Pasted image 20230414204312.png]]

![[Pasted image 20230414204333.png]]