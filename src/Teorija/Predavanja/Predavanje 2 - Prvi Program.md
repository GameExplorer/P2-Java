
**23.2.2023**

*Prvi program*


[[Predavanje 1 - Uvod v Javo]]
[[Predavanje 3 - Metode, Random]]

#zanke #argumenti #spremenljivke #tabele #formatiranIzpis

---

[Koda s predavanj](https://github.com/GameExplorer/javaPredavanja/tree/master/src/predavanje01)

```
Zanimivosti: 
-> """ -> blok za text output
-> chcp 65001 => utf-8
-> Locale: https://www.javatpoint.com/post/java-locale
```

http://lambda.fri.uni-lj.si/P2/kava/kavach2.html

*Rant o domači nalogi*

Naredili smo:
> Obresti
> Java je zakon
> Cene Srecke
> Statistika
> Stetje
> Args


### Prvi program 
Napisali smo preprost program: Obresti.java
Večkratni izpis s for zanko: "Java je ZAKON!""


Metoda ```main()```: 
* javanski razredi so izvedljivi, le v primeru, da vsebujejo metodo main
* ```main()``` je glavna vstopna točka programa ob zagonu razreda se izvede ta metoda
* če ```main()``` metoda manjka, razreda ne moremo izvesti, lahko pa iz njega naredimo objekt
* glava metode ```main()``` ima vedno tako obliko => ```public static void main(String[] args)```



#### Spremenljivke in tipi

Java je **strogo tipiziran jezik**: vsaka spremenljivka ima točno določen tip. 
Osnovni (atomarni) javanski tipi: **char, byte, short, int, long, float, double, boolean**. Za delo z nizi uporabljamo razred **String**.

Javanska spremenljivka potrebuje deklaracijo (podamo tip).
```int i; ```

Ob deklaraciji lahko inicializiramo spremenljivko

### Formatiran izpis:
- Formati izpisa: decimalno število %d 
- realno število %f 
- znak %c 
- niz %s 
- celo število v osmiškem sistemu %o 
- celo število v šesnajstiškem sistemu %x, %X

>**printf( %[zamik].[na koliko mest zaokrožim]f)**

printf - formatira glede na lokalne nastavitve 
println - ni občutljiv

Za vajo smo naredili *Srecke.java*



### **Osnovno o nizih**
>Niz je objekt razreda **String**
  Dolžino niza dobimo s klice metode **length()**
i-to črko niza dobimo z metodo **charAt(i)**

**String je objekt!**
V pogojnem stavku ```ìf```  primerjamo dva stringa z metodo ```equals();```


Nekaj metod: 
- ```substr(), indexOf(), replaceAll(), isEmpty(), split(), trim(),...```

V primeru [Statistika](https://github.com/GameExplorer/javaPredavanja/blob/master/src/predavanje02/Statistika.java) smo uporabili nekaj metod za zgled.


### **Osnovno o tabelah**

>Tabela je osnovna javanska podatkovna struktura v kateri lahko hranimo več podatkov **istega** tipa.

**Deklaracija tabele:** ```tip[] ime_tabele;```
**Elementi tabele:** ```tabela[0], tabela[1],...```
**Število elementov v tabeli:** ```tabela.length```
**Zadnji element tabele:** ```tabela[tabela.length-1]```


>Ko tabelo ustvarimo ji določimo velikost, kasneje se veliko tabele **ne da spreminjati**

Tabelo **ustvarimo** z ukazom new:
```int[] tabela = new int[10];
String[] nizi = new String[5];
```


### **Argumenti programa**
Kako vnašat argumente, ki nam bodo pomagali pri domačih nalogah. Izpis argumentov. Na kratko o DN2.

>Argumente v Intellij vnašamo v "Edit configuration". Zraven "Run" gumba

Argumenti so: ```args[0], args[1],... args[args.length-1]```


