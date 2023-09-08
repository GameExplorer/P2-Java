
**06.04.2023**

[[Predavanje 7 - StdDraw & File]]
[[Predavanje 9 - Dedovanje]]

#oop #razredi  #getSet #Konstruktor

---

http://lambda.fri.uni-lj.si/P2/kava/kavach6.html

# Teorija

Objekt obravnavamo kot "paket" podatkov

**Naloga**: Napiši program, ki prebere in shrani podakte (ime in ID) o 3 študentih

**Slaba rešitev:** za vsakega študenta potrebujemo dve spremenljivki za 3 študente torej ustvarimo 6 spremenljivk če bi imeli 100 študentov bi imeli 200 spremenljivk kar je preveč in upočasni iskanje

**Boljša rešitev:** ustvarimo nov tip (razred Student), ki bo hranil podatke o enem študentu, nato ustvarimo 3 spremenljivke: ```Student s1 s2 s3;```

![[Pasted image 20230407144304.png]]

**Dodatna izboljšava:** ustvarimo tabelo: ```Student[] studenti = new Student[5];```


Razred je zgolj vzorec, ki jo uporabim za ustvarjanje objektov je nekakšno navodilo kako ustvariti objekt.

Če želim ustvariti **objekte** uporabim rezervirano besede ```new```. Z ``` new ``` rezerviram pomnilnik za vse spremenljivke, ki so deklarirane v razredu.

Objekt imenujemo tudi *instanca* ali *primerek* razreda

V programu imamo lahko več objektov istega razreda.

Podatko v objektu so shranjeni v **atributih** (spremenljivke). Do podatkov dostopam z uporabo pike:
```student.ime="Lojze"```


## Ustvarjanje objekta - Konstruktor

Konstruktor:
- Podoben metodi, vendar ni običajna metoda
- Se kliče ob ustvarjanju objekta (ob uporabi ukaza ```new```)
- Ima isto ime kot razred
- Ne vrača rezultata (niti *void* ne)

> Razred ima lahk več konstruktorjev. **Vsi imajo enako ime vendar različno število in tip parametrov.** Časa izvajanja konstruktorja je najpremernejši čas za inicializacijo atributov. 

V vsakem razredu obstaja vsaj en konstruktor, če programer ne definira konstruktorja prevajalnik avtomatsko doda "Privzeti konstuktor".

### Privzet Konstruktor 

Če uporabnik ne definira nobenega konstruktorja prevajalnik doda privzet konstruktor (konstruktor brez parametrov)

Vendar pozor:
> Če uporabnik definira konstruktor s parametri, prevajalnik **NE DODA** privzetega konstruktorja, zato konstruktor brez parametrov **NE OBSTAJA**. 

![[Pasted image 20230407150730.png]]

![[Pasted image 20230407151131.png]]


## Skrivanje podatkov

Če ne želimo da bi vsi dostopali do podatkov torej da ne bi lahko vsi spreminjali vrednosti spremenljivk lahko se izognemo tako, da atribute skrijemo dostop do njih pa omogčimo le preko metod.

### Set in Get


- Metoda za spreminjanje vrednosti atributa ```X``` se imenuje ```setX()```

- Metoda za dostop do atributa ```X``` se imenuje ```getX()``` (oz. ```ìsX()```, če je atribut tipa ```bolean```)

Skupno ime za te metode je **getter/setter**

Osnovna ideja skrivanja podatkov in enkapsulaacije:

>Vsi ne statični atributi v razredu so skriti dostop do njih je omogčen preko getterjev in setterjev

![[Pasted image 20230407193403.png]]

## This in This()

**This:**
- uporabljamo za sklicevanje na trenutni objekt
- lahko uporabljamo le v metodah, ki niso statične
- preberemo kot "jaz"
- uporabljamo zato, da preprečimo konflikte z imeni

![[Pasted image 20230407193446.png]]

**This()**:
- uporabljamo za klic drugega konstruktorja
- uporabljamo samo v konstruktorju

![[Pasted image 20230407193910.png]]