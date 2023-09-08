
**2.3.2023**

[[Predavanje 2 - Prvi Program]]
[[Predavanje 4 - Podatkovni tipi & Konstante]]

#branje_datotek #branje_iz_tipkovnic #pretvorba_tipov #naključna_števila

---

[Koda s predavanj](https://github.com/GameExplorer/javaPredavanja/tree/master/src/predavanje03)

http://lambda.fri.uni-lj.si/P2/kava/kavach2.html

```Zanimivosti:
ASCII 
```

**Naredili smo:**
- Stetje
- Racunalo
- Loto
- Ocene
- Uporabnik

### Metode

Povedali smo nekaj o metodah in njihovi uporabi.

### Pretvorba tipov.

	Integer.ToString in Integer.parseInt



### Naključna števila

a + rnd.NextInt(b - a + 1) => Integer
x + (y - x) * nextDouble() => realna števila

### Branje iz tipkovnice

Scanner, System.in, klic raznih metod (nextInt(), nextLine(), next(), nextDouble())

/ => kaj deliš in s čem deliš

### Branje iz datotek

args[0] => za DN odpiranje datoteke
throws Exception => za pravilno branje datotek
**Datoteko na koncu obvezno zaprem!**

### Domača Naloga
sc.hasNextLine => dokler imamo vrstico bomo brali datoteko 
4 => nextInt da veš velikost tabele, next() v for zanki prebereš tabelo. S pomočjo teh besed zgeneriraš geslo z Random generatorjem b.(nextInt(4)) => 3 iz te besede moraš vzeti naključno crko (besede[b.length]) ki ti pove indeks te besede in izpišeš c-to črko te besede charAt. 
