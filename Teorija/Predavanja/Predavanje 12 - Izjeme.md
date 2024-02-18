[[Predavanje 11 - Delo s Podatki]]
[[Predavanje 13 - Datoteke]]

#try-catch-finally #FileInputStream #FileOutputStream 

---

http://lambda.fri.uni-lj.si/P2/kava/kavach7.html

Moramo znati: 
- Comparable
- anonimni razred za primerjavo

# Izjeme: `try-catch-finally`

Med izvajanjem programa lahko pride do posebnih okoliščin kot npr. do napak ali težav. Javin mehanizem izjem omogoča avtomatsko upravljanje s posebnimi okoliščinami. Posebne okoliščine so posledica: višje sile in nepremišljenega programiranja. Izjemne okoliščine so neizbežne, saj na višje sile ne moremo vplivati in pri kompleksnih programih je nemogoče predvidevati vse možnosti (npr. deljenje z 0).

Osnovna ideja izjem:
- Kodo, pri kateri lahko pride do težav, izvršimo v posebnem okolju t.j v **try** bloku
- če pri izvajanju te kode do težav res pride, se izvrši za ta primer predvidena koda (**catch** blok)

```
try {
	//stavki, ki lahko sprožijo izjemo
} catch (TipIzjeme izjema) {
	//stavki za odziv na izjemo
}
//nadaljevanje programa
```

### Izjema je objekt

Izjema v Javi je objekt. Vse izjeme so potomke razreda `java.lang.Throwable`.

Nekatere skupne metode: `int i = 3 / 0`
- public *String* **getMessage()** -> */ zero*
- public *String* **toString()** -> *java.lang.AirthmeticException: / zero*
- public void **printStackTrace()** -> *java.lang.AirthmeticException: / zero at izmeme.Deli.main(Deli.main:7)*

### Drevo izjem

![[Pasted image 20230512101049.png]]

Vse izjeme so potomke enega izmed treh osnovnih razredov:
- `java.lang.Error`
- `java.lang.Exception`
- `java.lang.RuntimeException`

### java.lang.Error

Resne težave. Ni potrebno loviti, ker ne moremo nič storiti.

### java.lang.Exception

Manj resne in bolj obvadljive posebne okoliščine, ker so načeloma popravljive. Program se lahko pripravi na tovrstne izjeme in jih reši (npr. poskus branja datoteke, ki ne obstaja).

### java.lang.RuntimeException

To so izjeme, ki se pojavijo pri običajnem delu (npr. deljenj z nič, delo s tabeli, ko presežemo dovoljeno območje)

Izjem tega tipa **NI POTREBNO** loviti, to lahko storimo in s tem omogočimo nemotemo delovanje programa.

## Preverljive in Nepreverljive Izjeme

Imamo dva tipa izjem:
- **Nepreverljive** in **Preverljive**
Nepreverljive so tiste izjeme, ki jih ni treba preverjati (ni potrebno pisati `try/catch` bloka). Nepreverljive so vse izjeme razredov `Error` in `RuntimeException` in njuni podrazedi.

Preverljive izjeme moramo obvezno preveriti!. Preverljive izjeme lahko obravnavamo na dva načina:
- Izjemo obravnavamo tam, kjer se je zgodila (`try/catch` blok)
- Pustimo, da izjemo obravnava tisti, ki kliče metodo v kateri je do izjeme prišlo (metoda v kateri se lahko pojavi izjema, to napove z rezervirano besedo `throws`).

> Datoteko ne pozabi zapreti po potem, ko jo odpreš drugače izgubiš točke!!


## Blok `finally`

Ukazi v bloku `finally` se izvršijo v vsakem primeru (ne glede na potek dogodkov v `try-catch` bloku). V `finally` bloku sprostimo vse sistemske vire, zapremo datoteke in opravimo ostale ukrepe.

Celotna struktura izgleda takole:

```
try {
		//koda, ki sproži izjemo
} catch ( ... ) {
		//koda, ki se izvede, če do izjeme res pride
} finally {
		//koda, ki se izvede v vsakem primeru
}
```


## Nasledniki razreda: `Throwable`

Če potrebujemo "svoj" razred za sporočanje izjem, ustvarimo podrazred razreda `Exception` (ali katerega od njegovih podrazredov). 
Primer:

```
class DeljenjZNic extends ArithmeticException {
	public String getMessage() {
			return "Deljenje z nič ni dovoljeno";
	}
}
```

### Sprožanje izjem
V programu izjemo sprožimo z ukazom `throw`.

Primer:
```
public static double deli(int x, int y) {
	if (y == 0) throw new DeljenjeZNIc();
	return x/y;
}
```


## Koncept `try-with-resources`
Vir (resource) je vsak objekt, ki implementira vmesnik `java.io.AutoClosable`. Za "zapiranje" vira (`close()`) lahko poskrbi java, če vir iniciliziramo v `try-with-resources` bloku.

![[Pasted image 20230512172532.png]]


