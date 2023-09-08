**04.05.2023**

[[Predavanje 10 - Vmesniki]]
[[Predavanje 12 - Izjeme]]


#Množice #HashSet #TreeSet #ArrayList 

----

Navadna tabela Array hitrejša od ArrayList-a

Vse tipe ki jih pozna zna urejat

Map - Slovar

put -> za dodajanje

http://lambda.fri.uni-lj.si/P2/kava/kavach8.html

---

# Delo s podatki

Zbirke se med seboj razlikujejo predvsem po tem, na kakšen način so podatki v njih shranjeni (katero podatkovno strukturo uporabljajo). Za različne namene se uporabljajo različne podatkovne strukture, na primer,

-   **Sklad**: na vrh sklada dajemo podatke, iz vrha jih jemljemo. Operacije: dodaj (push), vzemi (pop), jePrazen? (isEmpty?)
-   **Vrsta**: na en konec dajemo, z drugega jemljemo. Operacije: dodaj, vzemi, jePrazna?
-   **Množica**: vrstni red ni pomemben; zanima nas samo prisotnost elementov. Operacije: dodaj, brisi, jeElement?

Glavni slabosti tabele sta: fiksna velikost ter počasno dodajanje podatkov na začetek. Te slabosti lahko z drugimi zbirkami odpravimo.

Java ponuja dva vmesnika za delo z zbirkami: `java.util.Collections` in` java.util.Map`. Prvi je namenjen hranjenju podatkov, po katerih se sklicujemo s celoštevilskim indeksom (podobno kot pri tabeli), drugi pa hranjenju podatkov, kjer za sklicevanje uporabimo nek *ključ* - podatki so v tem primeru tipa (*ključ, vrednost*).

Oba vmesnika imate veliko konkretnih implementacij. Nekatere med njimi so:

Collection    
    Set             <- HashSet    
        SortedSet   <- TreeSet    
    List            <- ArrayList    
                    <- LinkedList    
   
Map                 <- HashMap    
      SortedMap       <- TreeMap

![[Pasted image 20230505174901.png]]

## Vmesnik java.util.Collection

Predvideva osnovne operacije nad zbirkami. Predpisuje naslednje metode:

- boolean add(Object o): Dodaj element v zbirko
- boolean remove(Object o): Odstrani element iz zbirke
- int size(): Vrni velikost zbirke
- boolean contains(Object o): Ali zbirka vsebuje element?
- boolean isEmpty(): Ali je zbirka?
- void clear(): Sprazni zbirko
- iterator iterator(): Omogoča sprehod po vseh elementih zbirke


Razrede, ki implementirajo vmesnik Collection delimo na dva dela - razredi za delo z množicami in razredi za delo s seznami.

Štiri najbolj znani razredi, ki implementirajo vmesnik Collection so: HashSet, TreeSet, ArrayList in LinkedList. Iz uporabniškega stališča je glavna razlika med omenjenimi razredi  

1.  nekateri hranijo elemente v urejenem vrstnem redu, drugi pa ne
2.  hitrost operacij dodaj/išči/briši...


### Množice (Set)

V množici ni duplikatov. Poznamo dve izvedbi množic:  

**HashSet** ..... množica implementirana je s pomočjo zgoščene tabele; elementi niso urejeni (niti ne nastopajo v vrstnem redu, kot smo jih dodajali!).  Urejeni po hash-ih

**SortedSet** ... množica implementirana s pomočjo uravnoteženega binarnega drevesa; elementi so urejeni po abecednem vrstnem redu

![[Pasted image 20230501171135.png]]

### Iterator

Iterator uporabimo za sprehod čez podatke, med sprehodom lahko podatke tudi spreminjamo ali brišemo. Iterator pozna naslednje metode:

- public boolean hasNext(): Ali je na voljo še kakšen podatek?
- public Object next(): Naslednji podatek
- public void remove(): Zbriši trenutni podatek

![[Pasted image 20230501171313.png]]

## Zanka For

![[Pasted image 20230501171407.png]]


### Seznam Elementov (List)

Vmesnik List (podrazred razreda Collection) definira operacije podatkovne strukture seznam. V seznamu so elementi v določenem vrstnem redu. Poznamo pojem i-ti element (podobno kot pri tabeli). Dodatne metode:

- boolean get(int index): Vrne element pri danem indeksu
- boolean set(int index, Object elm): Spremeni element pri danem indeksu
- boolean add(int index, Object elm): Doda element na točno določeno mesto
- boolean remove(int index): Odstrani element
- int indexOf(Object elm): Vrne indeks elementa
- ListIterator listIterator(): Omogoča sprehod čez podatke

Med razredi, ki implementirajo vmesnik List se najpogosteje uporablja razred `ArrayList`. Uporabljamo ga na podoben način kot navadno tabelo (vsak element ima svoj **indeks** in dodajamo lahko na določeno mesto (*set*) ali na konec (*add*)). Prednosti `ArrayLista`-a je ta da na začetku nam ni treba navesti velikost seznama ter elemente lahko pobrišemo (`remove`).

## Slovarji - vmesnik java.util.Map

Slovar je zbirka podatkov, v kateri do posameznega podatka dostopamo preko ključa. V slovarju torej hranimo pare (*ključ, vrednost*). Razlika med slovarjem in tabelo: pri tabeli do posameznega elementa dostopamo preko celoštevilskega indeksa `(a[i])`, pri slovarju pa preko ključa (simbolično bi to lahko zapisali kot `a[kljuc]`), pri čemer je ključ poljuben objekt. Ključi morajo biti enolično določeni (t.j. enemu ključu lahko pripada samo ena vrednost). Kljuci se medseboj primerjajo z metodo `equals` - dva ključa sta enaka, če velja `key1.equals(key2)`.

Osnovne metode:
- public int size(): velikost zbirke
- public boolean isEmpty(): ali je zbirka prazna?
- public boolean containsKey(Object key): ali zbirka vsebuje dani ključ?
- public boolean containsValue(Object value): ali zbirka vsebune dano vrednost?
- public Object get(Object key): Vrne vrednost pri danem ključu
- public Object put(Object key, Object value): Nastavi vrednost pri danem ključu
- public Object remove(Object key): Odstrani vrednost pri danem ključu
- public Set keySet(): Vrne množice vseh ključev v zbirki
- public Collection values(): Vrne množico vseh vrednosti v zbirki

## Urejanje podatkov: `Comparable` & `Comparator`

Java zna urediti zbirko le v primeru, da zna podatke med seboj primerjati. 
Java  zna primerjati:
- podatke primitivnih tipov (int, double, char, ...)
- podatke tipov, ki imajo implementiran vmesnik `Comparable` (tudi `String`)

### Comparable
Če želimo primerjati objekte razreda `Oseba` glede na njihovo višino, razred `Oseba` napišemo takole:
```
class Oseba implements Comparable { 
	String ime;
	int visina; 
	public int compareTo(Oseba o) { 
		return new Integer(this.visina).compareTo(o.visina);
	 } 
	}
// … uporaba (na primer v main metodi): 
ArrayList osebe = new ArrayList(); 
osebe.add(…); 
Collections.sort(osebe);
```

### Comparator
Urejamo lahko tudi tako, da ob klicu metode `sort()` podamo objekt razreda `Comparator`

```
ArrayList osebe = new ArrayList(); 
osebe.add(. . . ); 
Collections.sort(osebe, new Comparator() { 
	public int compare(Oseba o1, Oseba o2) { 
		return o1.ime.compareTo(o2.ime);
		}
 });
```

## Razbitje niza na dele

Niz bi radi razbili na posamezne komponente (podniz1, podniz2, ...). Problem lahko rešimo vsaj na dva načina:

-   z uporabo metode `split` in
-   z uporabo `StringTokenizer`-ja.

```ad-code
title: split

String a="Micka:Kovaceva";   

String podnizi[] = a.split(":");   

System.out.println(podnizi[0]); // Micka
```

```ad-code
title: StringTokenizer


     String a="Micka:Kovaceva";   

     StringTokenizer stk = new StringTokenizer(a, ":");   

     while (stk.hasMoreElements())   

            System.out.println(stk.nextElement());
 ```

Uporablja se ga podobno kot `iterator` le, da gre za starejšo obliko sprehoda čez podatke (podatke med sprehodom ne moremo spreminjati!)


## Orodja za delo z zbirkami

Metode iz razreda `java.util.Collections`:
- sort(List l)
- max(Collection c)
- min(Collection c)
- replaceAll(List l, Object o, Object no)
- swap(List l, int i, int j)