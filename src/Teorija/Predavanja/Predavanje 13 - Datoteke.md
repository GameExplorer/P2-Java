[[Predavanje 12 - Izjeme]]
[[Predavanje 14 - GUI]]

#copy #FileInputStream #FileOutputStream #DataInputStream #DataOutputStream #StreamReader #StreamWriter #Serializable

---
http://lambda.fri.uni-lj.si/P2/kava/kavach9.html

# Delo z Datotekami

Razred `File` omogoča sistemsko neodvisen dostop do datotečnega sistema. 
Objekt razreda `File` uporabljamo za delo z datotekami in **NE** za delo z vsebino datotek!

`File` lahko predstavlja *datoteko* ali *direktorij*.

## Kako ustvarim objekt razreda `File`
![[Pasted image 20230512180512.png]]

## Nekatere metode

![[Pasted image 20230512180530.png]]

### Izpis velikosti datoteke

Primer izpisa velikosti datoteke: 

```
File f = new File(args[0]);
if (!f.exists()) System.out.printf("Datoteka '%s' ne obstaja! ", args[0]);
else System.out.printf("Velikost datoteke '%s' je %d bajtov", args[0], f.length());
```

## Podatkovni tokovi

Za delo z datotekami java uporablja tokove. Pozna vhodne (branje) in izhodne (pisanje) tokove. Vsak vhodni tok im svoj izvor (datoteka, od koder podatki izvirajo), vsak izhodni tok ima svoj ponor (datoteka, kamor se podatki pišejo).

Razlika med tabelo in tokom podatkov?
- tabela: v vsakem hipu enako hitro dobimo katerikoli posnetek
- tok: v nekem hipu lahko beremo le trenutni podatek


![[Pasted image 20230512181044.png]]
![[Pasted image 20230512181055.png]]
![[Pasted image 20230512181300.png]]

![[Pasted image 20230512181325.png]]

### Nekatere implementacije razredov `InputStream` in `OutputStream`

![[Pasted image 20230512181402.png]]

## FileInputStream in FileOutputStream

![[Pasted image 20230512181434.png]]

###  `FileInputStream` 
- če datoteka s katero želimo povezati tok, ne obstaja, konstruktor vrže izjemo `FileNotFoundException`

### `FileOutputStream`
- če datoteka že obstaja se bo ob klicu konstruktorja resetirala (vsebina se ne pobriše)
- pri nekaterih konstruktorjih lahko izberemo opcijo *append* (dodajanje podatkov v datoteko)
- če želimo pisati v datoteko, pa za to nimamo pravic, konstruktor vrže izjemo `SecurityException`


# Copy
![[Pasted image 20230522120343.png]]


# DataInputStream & DataOutputStream

Tokove tipa data uporabljamo za branje in pisanje javanskih osnovnih podatkovnih tipov (`boolean, char, byte, short, int, long, float, double, String`) v zlogovni obliki

**PISANJE:**
- `boolean` se zapiše z enim zlogom kot 0 ali 1
- `char` se zapiše z dvema zlogoma
- `int` se zapšie s štirimi zlogi

**BRANJE:**
- ukaz za branje prebere primerno število zlogov (odvisno od tipa - za vsak tip imamo svoj ukaz) in jih pretvori v podatek ustreznega tipa,

DataInputStream in DataOutputStream sta ovojna tokova to pomeni, da ju vedno uporabimo v kombinaciji z nekim drugim tokom.

**KONSTRUKTORJI:**
- `public DataInputStream (InputStream in)`
- `public DataOutputStream (OutputStream out)`

### DataOutputStream - uporaba
![[Pasted image 20230522121622.png]]

### DataInputStream - uporaba
![[Pasted image 20230522121701.png]]



# BufferedInputStream & BufferedOutputStream

Sta ovojna tokova, ki jih uporabljamo za **povečanje hitrosti** branja/pisanja. Ker sta ovojna tokova, ju vedno uporabimo v kombinaciji z nekim drugim tokom.

![[Pasted image 20230522122736.png]]


# Serializacija in deserializacija objektov

Serializacija objektov je postopek, ki omogoča pretvorbo objektov v zaporedje zlogov. Deserializacija je postopek za generiranje objektov iz (pravilnega) zaporedja zlogov. 
Objekt, ki ga želimo serializirati, mora implementirati vmesnik `Serializable`. 

![[Pasted image 20230522124011.png]]

# ObjectInputStream & ObjectOutputStream

Tok `ObjectInputStream` uporabljamo za serializacijo objektov in zapis v zlogovno datoteko.
Tok `ObjectOutputStream`  uporabljamo za deserializacijo objektov, zapisanih v zlogovnih datotekah.

![[Pasted image 20230522124315.png]]

# Znakovni tok

Znakovni tokovi se uporabljajo za branje/pisanje podatkov, ki so shranjeni v znakovni obliki, npr. v besedilnih datotekah s končnici `.txt`.
Velikost podatka v znakovni datoteki je odvisen od načina kodiranja.

![[Pasted image 20230522125154.png]]

## Načini kodiranja

![[Pasted image 20230522125219.png]]

Za branje in pisanje **znak po znaku** uporabim `InputStreamReader` in `OutputStreamWriter`
Za formatirano branje in pisanje uporabim `Scanner` in `PrintWriter`

Ne glede na izbrani način branja in pisanja, vedno imam možnost nastavitve privzetega načina kodiranja znakov.

# InputStreamReader in OutputStreamWriter

Tokova `InputStreamReader` in `OutputStreamWriter` uporabljamo za branje/pisanje znakov datoteke.
Za kodiranje posrkbi java (java ve kdaj mora prebrati 1 ali 2 bajta npr.). Če uporabnik kodiranja ne določi eksplicitno se uporabi sistemsko privzeti način.

![[Pasted image 20230522125622.png]]

# Scanner

Razred Scanner se uporablja za branje besedila in za razbijanje prebranega besedila na posamezne dele. Pri razbijanju besedila se uporablja ločilo (delimiter). Privzeta ločila so: tabulator, presledek, nova vrsta.
Posamezni deli besedila se lahko avtomatsko pretvorijo v javanske primitvne tipe.

![[Pasted image 20230522130329.png]]

# PrintWriter

Je ovojni tok, ki se uporablja za formatiran izpis besedila. Izpisuje primitvne javanske tipe v tekstovni obliki. Za kodiranje podatkov poskrbi oviti tok.

![[Pasted image 20230522130549.png]]

![[Pasted image 20230522130615.png]]


# Branje iz drugih virov

![[Pasted image 20230522130652.png]]

