
**13.3.2023**

[[Vaje 2  - Fakulteta]]
[[Vaje 4 - Besedle]]

#bitni_operatorji  #for_zanka #zanke 

---

[Koda](https://github.com/GameExplorer/P2_Vaje/tree/master/src/vaje03)

 **1)** V razredu Znaki deklarirajte naslednje spremenljivke in tabele:

>Ugotovi kako binarno zapisati P in 2. Primer za P: ```1111100111111000```
 
 Kjer tabela kodeZnakov16bit vsebuje znake abecede, predstavljene s 16 biti. Zapis 0b1111100111111001 je primer binarnega zapisa vrednosti spremenljivke, kjer 0b napove, da gre za binarni zapis, nato pa sledijo biti od tistega z največjo težo proti tistemu z najmanjšo (0b [bit-15] [bit-14] ... [bit-2] [bit-1] [bit-0]). Spodnja shema prikazuje razporeditev bitov v znaku, kjer je 0 najnižji bit, 15 pa najvišji bit:

 Znaki 16-bitne abecede so definirani, kot je prikazano na spodnji sliki:
 ![[Pasted image 20230313095417.png]]


 Primer zapisa črke E:

 >(short)0b1111111010001111;

 Tabelo kodeZnakov16bit dopolnite še z manjkajočima kodama znakov P in 2.


**2)** Definirajte metodo izpisi16bit(short kodaZnaka), ki kot vhodni parameter sprejme 16-bitno kodo znaka in izpiše znak na zaslon.

_Namig: Za lažjo implementacijo metode uporabite bitne operatorje ter s pomočjo bitnega maskiranja preverite vrednost bita na določeni poziciji.  
Vrednost bita na določenem mestu lahko (neodvisno od ostalih bitov) preverimo z bitnim maskiranjem tako, da s pomočjo bitnega operatorja IN (&) ugasnemo vse bite, razen iskanega, ter preverimo rezultat. Pri tem si pomagamo z masko, to je številom, ki ima v bitni predstavitvi na iskanem mestu bit postavljen na 1, vsi ostali biti pa so 0. Če je rezultat (število & maska) enak 0, je iskani bit 0, če pa je rezultat enak maski, je iskani bit 1._

_Poglejmo primer: poiščimo vrednost 4. bita pri številu 157 in pri številu 149 (bita sta zapisana krepko)._

    15710 = 1001**1**1012  
    14910 = 1001**0**1012  
	   maska = 0000**1**0002  (4. bit je postavljen na 1)
   
Primer klica:

	izpisi16bit((short)0b1111100111111001);

Delovanje metode preverite še na znakih P in 2.


**3)** Definirajte metodo izpisi16bit(short[] nizZnakov), ki kot vhodni parameter sprejme tabelo 16-bitnih kod znakov in jih izpiše na zaslon. Pri tem naj dva zaporedna znaka razmakne za en kvadratek (za vsakim izrisanim znakom je en stolpec belih kvadratkov).  

Primer klica:

	izpisi16bit(new short[] {(short)0b1111100011101000, (short)0b1111100111111010, (short)0b1111010001001111});

**4)** Definirajte metodo izpisi16bit(String niz), ki kot vhodni parameter sprejme niz (String) in ga izpiše na zaslon. Pri tem znake v nizu preslika v črke 16-bitno definirane abecede. Če znaka ni v abecedi, namesto njega izpiše znak za presledek. Znake pred izpisom pretvorite v velike črke (kot so zapisane v tabeli abeceda). Pri izpisu predpostavite, da je širina konzole zadostna.

Primer klica:

	izpisi16bit("Programiranje je zakon");

**5)** Med deklaracije razreda dodajte še tabelo:

```
  private static final long[] kodeZnakov64bit = {
        0b0001100000100100010000100100001001111110010000100100001011100111L,
        0b1111110001000010010001000111111001000001010000010100000111111110L,
        0b0011110001000010100000011000000010000000100000010100001000111100L,
        0b1111110001000010010000010100000101000001010000010100001011111100L,
        0b1111111101000001010000000111110001000000010000000100000111111111L,
        0b1111111101000001010000010100100001111000010010000100000011100000L,
        0b0011111101000001100000001001111110010001100000010100000100111110L,
        0b1110011101000010010000100111111001000010010000100100001011100111L,
        0b1111111100010000000100000001000000010000000100000001000011111111L,
        0b0011111100000100000001000000010011000100100001001000010001111000L,
        0b1110111101000100010010000111000001001000010001000100001011100111L,
        0b1110000001000000010000000100000001000000010000010100000111111111L,
        0b1100011101101010010100100101001001000010010000100100001011100111L,
        0b1100011101100010010100100100101001000110010000100100001011100111L,
        0b0011110001000010100000011000000110000001100000010100001000111100L,
        0b0,                                                                 // TODO: dodaj znak P
        0b0111111010000001100000011000000110000001100010010111111000001000L,
        0b1111111001000001010000010100000101111110010001000100001011100111L,
        0b0111110110000011100000010111110000000010100000011100000110111110L,
        0b1111111110001001000010000000100000001000000010000000100000011100L,
        0b1110011110000001100000011000000110000001100000011000000101111110L,
        0b1110011101000010010000100100001000100010001001000001010000001000L,
        0b1110011101000010010000100100001001010010010100100101001000101100L,
        0b1110011101000010001001000001100000100100001001000100001011100111L,
        0b1110011101000010001001000001010000001000000010000000100000011100L,
        0b1111111110000010100001000000100000010000001000010100000111111111L,
        0b0011110001000010100001011000100110010001101000010100001000111100L,
        0b0011000001010000000100000001000000010000000100000001000011111111L,
        0b0,                                                                // TODO: dodaj znak 2
        0b0111111010000001100000010000111000000001100000011000000101111110L,
        0b0000011000001010000100100010001001000010111111110000001000000111L,
        0b1111111110000001100000001111111000000001100000011000000101111110L,
        0b0111111010000001100000001111111010000001100000011000000101111110L,
        0b1111111110000001000000100000010000001000000100000001000000111000L,
        0b0111111010000001100000010111111010000001100000011000000101111110L,
        0b0111111010000001100000011000000101111111000000011000000101111110L,
        0
    };
```

ki vsebuje znake abecede, predstavljene s 64 biti (enako kot zgoraj predstavljen 16-bitni zapis; "L" na koncu pove, da je zapis v obliki tipa long), kot prikazuje spodnja shema, kjer je 0 najnižji bit, 63 pa najvišji bit:

|   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|
|63|62|61|60|59|58|57|56|
|55|54|53|52|51|50|49|48|
|47|46|45|44|43|42|41|40|
|39|38|37|36|35|34|33|32|
|31|30|29|28|27|26|25|24|
|23|22|21|20|19|18|17|16|
|15|14|13|12|11|10|9|8|
|7|6|5|4|3|2|1|0|

  

Znaki 64-bitne abecede so definirani, kot je prikazano na spodnji sliki:


Primer zapisa črke A:

0b0001100000100100010000100100001001111110010000100100001011100111L

V tabeli kodeZnakov64bit definirajte tudi manjkajoča znaka P in 2.

  

**6)** Definirajte metodo izpisi64bit(long kodaZnaka), ki kot vhodni parameter sprejme 64-bitno kodo znaka in izpiše znak na zaslon.

Primer klica:

izpisi64bit(0b0001100000100100010000100100001001111110010000100100001011100111L);

izpiše črko A:

⬜⬜⬜⬛⬛⬜⬜⬜
⬜⬜⬛⬜⬜⬛⬜⬜
⬜⬛⬜⬜⬜⬜⬛⬜
⬜⬛⬜⬜⬜⬜⬛⬜
⬜⬛⬛⬛⬛⬛⬛⬜
⬜⬛⬜⬜⬜⬜⬛⬜
⬜⬛⬜⬜⬜⬜⬛⬜
⬛⬛⬛⬜⬜⬛⬛⬛

S to metodo izpišite tudi znaka P in 2.

  

**7)** Definirajte metodo izpisi64bit(long[] nizZnakov), ki kot vhodni parameter sprejme tabelo 64-bitnih kod znakov in jih izpiše na zaslon.

Primer klica:

izpisi64bit(new long[] {0b1111111101000001010000010100100001111000010010000100000011100000L, 0b0011000001010000000100000001000000010000000100000001000011111111L});

izpis:

⬛⬛⬛⬛⬛⬛⬛⬛⬜⬜⬜⬛⬛⬜⬜⬜⬜⬜
⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬛⬜⬜⬜⬜⬜
⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜
⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜
⬜⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜
⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜
⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜
⬛⬛⬛⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬛⬛⬛⬜

  

**8)** Definirajte metodo izpisi64bit(String niz), ki kot vhodni parameter sprejme niz (String) in ga izpiše na zaslon. Pri tem znake v nizu preslika v črke 64-bitno definirane abecede. Če znaka ni v abecedi, namesto njega izpiše znak za presledek. Znake pred izpisom pretvorite v velike črke. Pri izpisu predpostavite, da je širina konzole zadostna.

Primer klica:

izpisi64bit("P2 je super");

izpis:

⬛⬛⬛⬛⬛⬛⬛⬜⬜⬜⬛⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬛⬜⬛⬛⬛⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬜⬛⬜⬛⬛⬛⬜⬜⬛⬛⬛⬜⬛⬛⬛⬛⬛⬛⬛⬜⬜⬛⬛⬛⬛⬛⬛⬛⬛⬜⬛⬛⬛⬛⬛⬛⬛⬜⬜
⬜⬛⬜⬜⬜⬜⬜⬛⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬛⬛⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜
⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜
⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜
⬜⬛⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬜⬛⬛⬛⬛⬛⬛⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬛⬜⬜
⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜
⬜⬛⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬜⬜⬜⬜⬜⬛⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜
⬛⬛⬛⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬜⬜⬜⬜⬛⬛⬛⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬛⬛⬛⬛⬛⬜⬜⬜⬛⬛⬛⬛⬛⬛⬜⬜⬛⬛⬛⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬛⬛⬛⬜⬛⬛⬛⬜⬜⬛⬛⬛⬜

  

**9)** Preverite delovanje programa še za spodnja dva klica:

izpisi64bit(4342219536296657468L);

izpisi64bit(1746410238858002085L);

za izpis naslednjih dveh znakov:

⬜⬜⬛⬛⬛⬛⬜⬜
⬜⬛⬜⬜⬜⬜⬛⬜
⬛⬜⬛⬜⬛⬜⬜⬛
⬛⬜⬛⬜⬛⬜⬜⬛
⬛⬜⬜⬜⬜⬛⬜⬛
⬛⬜⬛⬛⬛⬜⬜⬛
⬜⬛⬜⬜⬜⬜⬛⬜
⬜⬜⬛⬛⬛⬛⬜⬜

in

⬜⬜⬜⬛⬛⬜⬜⬜
⬜⬜⬛⬛⬛⬛⬜⬜
⬜⬛⬛⬛⬛⬛⬛⬜
⬛⬛⬜⬛⬛⬜⬛⬛
⬛⬛⬛⬛⬛⬛⬛⬛
⬜⬜⬛⬛⬛⬛⬜⬜
⬜⬛⬛⬛⬛⬛⬛⬜
⬛⬜⬛⬜⬜⬛⬜⬛

Kaj pa izpiše spodnji klic metode?

    izpisi64bit(-36525672788885761L);



