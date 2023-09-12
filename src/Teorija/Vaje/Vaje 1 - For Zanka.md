
**27.2.2023**

[[Vaje 2  - Fakulteta]]

#zanke #gnezdne_zanke 

---

[Koda](https://github.com/GameExplorer/P2_Vaje/tree/master/src/Vaje01)

Pri nalogah, ki smo jih delali smo uporabljali ```for``` zanko. Naredili smo izpise pravokotnika, trikotnika in romba. 

Opravljene naloge: 
- [x] Pravokotniki
- [x] Trikotniki
- [x] Romb
- [x] Smreke
- [x] Dodatni izzivi

**1) Pravokotniki**

a) Napišite metodo

   `static void pravokotnikStevil(int sirina, int visina);`

ki na zaslon izpiše pravokotnik števil velikosti _sirina_ x _visina_, kot prikazuje primer. Pri številih, ki so večja od 10, naj izpiše le enice (glej primer pri točki b).

Primer: ob klicu *pravokotnikStevil(7,3)*; naj metoda izpiše:


```
1111111
2222222
3333333
```


Napišite tudi metodo *main()*, v kateri pokličete metodo *pravokotnikStevil()* z različnimi parametri in tako preverite njeno delovanje.

b) Metodo *pravokotnikStevil()* spremenite tako, da bo enaka števila izpisovala po stolpcih.

Primer: ob klicu pravokotnikStevil(12,3); naj metoda izpiše:


```
123456789012
123456789012
123456789012
```


c) Napišite metodo

   `static void pravokotnik(int odmik, int sirina, int visina);`

ki na zaslon z znaki _X_ izriše pravokotnik velikosti _sirina_ x _visina_. Pravokotnik naj bo od roba odmaknjen za _odmik_ mest (presledkov).

Primer: ob klicu *pravokotnik(5,7,3)*; naj metoda izriše tak lik:

     XXXXXXX
     XXXXXXX
     XXXXXXX

Nasvet: Namesto presledkov lahko najprej izpisujete pike (.), da boste videli, če vam program izpiše pravo število presledkov (oziroma pik).

**2) Trikotniki**

a) Napišite metodo

   `static void trikotnikStevil(int visina);`

ki na zaslon izriše trikotnik stevil z višino _visina_, kot prikazuje primer. Pri številih, ki so večja od 10, naj izpiše le enice (glej primer pri nalogi 1b). Trikotnik višine _v_ naj ima _v_ vrstic, v zadnji vrstici pa _v_ enakih števil.

Primer: ob klicu *trikotnikStevil(3)*; naj metoda izpiše:


```
1
22
333
```


b) Metodo *trikotnikStevil()* spremenite tako, da bo enaka števila izpisovala po stolpcih.

Primer: ob klicu *trikotnikStevil(3)*; naj metoda izpiše:


```
1
12
123
```


c) Napišite metodo

   `static void trikotnikStevilObrnjen(int visina);`

ki na zaslon izriše obrnjen trikotnik števil, kjer so v vsaki vrstici enaka števila.

Primer: ob klicu *trikotnikStevilObrnjen(3)*; naj metoda izpiše:


```
333
22
1

```

d) Metodo *trikotnikStevilObrnjen()* spremenite tako, da bo enaka števila izpisovala po stolpcih.

Primer: ob klicu *trikotnikStevilObrnjen(3)*; naj metoda izpiše:


```
123
12
1
```


e) Napišite metodo

   `static void trikotnikStevil(int visina);`

ki na zaslon izpiše številski trikotnik z višino _visina_. Trikotnik višine _v_ naj ima _v_ vrstic, v zadnji vrstici pa 2_v_ - 1 števil.

Primer: ob klicu *trikotnikStevil(5)*; naj metoda izpiše:

    1
	   123
	  12345
	 1234567
	123456789

f) Napišite metodo

   `static void trikotnik(int odmik, int visina);`

ki na zaslon z zvezdicami (znak *) izriše trikotnik z višino _visina_. Trikotnik višine _v_ naj ima _v_ vrstic, v zadnji vrstici pa 2_v_ - 1 znakov. Trikotnik naj bo od roba odmaknjen za _odmik_ mest (tj. zadnja vrstica je od roba odmaknjena za _odmik_).

Primer: ob klicu trikotnik(5,3); naj metoda izriše tak lik:

       *
      ***
     *****

ob klicu trikotnik(1,5); pa naj izriše tak lik:

		  *
			***
	   *****
	  *******
	 *********

g) Napišite metodo

   `static void trikotnikObrnjen(int odmik, int visina);`

ki na zaslon izriše trikotnik, kot je opisan v nalogi f), le da je trikotnik obrnjen (postavljen na glavo, vrh je spodaj).

Primer: ob klicu *trikotnikObrnjen(1,5)*; naj metoda izriše tak lik:

	 *********
	  *******
	   *****
	    ***
	     *

**3) Rombi**

Napišite metodo

   `static void romb(int odmik, int velikost);`

ki na zaslon izriše romb s stranico _velikost_. Romb velikosti _v_ naj ima 2_v_ - 1 vrstic, v srednji, najdaljši vrstici pa ima 2_v_ - 1 znakov. Romb (tj. srednja vrstica) naj bo od roba odmaknjen za _odmik_ mest.

Primer: ob klicu romb(2,5); naj metoda izriše tak lik:

      *
     ***
    *****
	   *******
	  *********
	   *******
    *****
     ***
      *

**4) Smreke**

Napišite metodo

   `static void smreka(int velikost);`

ki na zaslon izriše smreko velikosti _velikost_. Krošnjo smreke velikosti _v_ sestavlja _v_ trikotnikov. Vrh krošnje smreke je trikotnik višine 2, vsak naslednji trikotnik pa je za 2 večji od trikotnika nad njim. Deblo smreke je pravokotnik višine 2_v_ in širine _v_ (če je _v_ liho število) oz. _v_ + 1 (če je _v_ sodo število). Pri izrisu smreke si pomagajte z metodami, ki ste jih že napisali v predhodnih nalogah.

Primer: ob klicu *smreka(3)*; naj metoda izriše tak lik:

     *
    ***
     *
    ***
	   *****
	  *******
     *
    ***
	   *****
	  *******
	 *********
	***********
    XXX
    XXX
    XXX
    XXX
    XXX
    XXX

Primer: ob klicu *smreka(4)*; naj metoda izriše tak lik:

       *
      ***
       *
      ***
     *****
    *******
       *
      ***
     *****
    *******
	   *********
	  ***********
       *
      ***
     *****
    *******
	   *********
	  ***********
	 *************
	***************
     XXXXX
     XXXXX
     XXXXX
     XXXXX
     XXXXX
     XXXXX
     XXXXX
     XXXXX

---

**DODATNI IZZIVI**

**A)** Napišite metodo

   `static void rombA(int odmik, int velikost);`

ki na zaslon z znaki _lojtrca_ in _presledek_ (_#_ ), oba skupaj vzamemo kot en "izrisan znak", izriše romb s stranico _velikost_. Romb velikosti _v_ naj ima 2_v_ - 1 vrstic, v srednji, najdaljši vrstici pa ima 2_v_ - 1 znakov (tj. dvojnih znakov lojtrca in presledek). Romb naj bo od roba odmaknjen za _odmik_ mest (eno mesto je dvojni presledek).

Primer: ob klicu *romb(1,5)*; naj metoda izriše tak lik:

          # 
        # # # 
      # # # # # 
    # # # # # # # 
	# # # # # # # # # 
    # # # # # # # 
      # # # # # 
        # # # 
          # 

**B)** Napišite metodo

   `static void rombPrazen(int odmik, int velikost);`

ki na zaslon izriše kvadrat z rombom v sredini. Velikost kvadrata je 2_velikost_ - 1, notranji romb pa je ustrezno za ena manjše velikosti. Zunanji kvadrat naj bo od roba odmaknjen za _odmik_ mest.

Primer: ob klicu *rombPrazen(3,5)*; naj metoda izriše tak lik:

      # # # # # # # # # 
      # # # #   # # # # 
      # # #       # # # 
      # #           # # 
      #               # 
      # #           # # 
      # # #       # # # 
      # # # #   # # # # 
      # # # # # # # # #

**C)** Napišite metodo

   `static void iks(int velikost);`

ki na zaslon izriše znak _X_, sestavljen iz pravokotnikov velikosti 5 x 3 (glej primera spodaj).

_Nasvet:_ Napišite metodo dvaPravokotnika(int odmik, int sirina, int visina, int razmik), ki izriše dva enako velika pravokotnika na podanem razmiku, ter jo skupaj z metodo pravokotnik() uporabite pri risanju črke _X_.

Primer: ob klicu *iks(3)*; naj metoda izriše tak lik:

```

XXXXX               XXXXX
XXXXX               XXXXX
XXXXX               XXXXX
     XXXXX     XXXXX
     XXXXX     XXXXX
     XXXXX     XXXXX
          XXXXX
          XXXXX
          XXXXX
     XXXXX     XXXXX
     XXXXX     XXXXX
     XXXXX     XXXXX
XXXXX               XXXXX
XXXXX               XXXXX
XXXXX               XXXXX
```

Primer: ob klicu *iks(4)*; naj metoda izriše tak lik:
```
XXXXX                         XXXXX
XXXXX                         XXXXX
XXXXX                         XXXXX
     XXXXX               XXXXX
     XXXXX               XXXXX
     XXXXX               XXXXX
          XXXXX     XXXXX
          XXXXX     XXXXX
          XXXXX     XXXXX
               XXXXX
               XXXXX
               XXXXX
          XXXXX     XXXXX
          XXXXX     XXXXX
          XXXXX     XXXXX
     XXXXX               XXXXX
     XXXXX               XXXXX
     XXXXX               XXXXX
XXXXX                         XXXXX
XXXXX                         XXXXX
XXXXX                         XXXXX
```
