**30.04.2023**

[[Predavanje 9 - Dedovanje]]
[[Predavanje 11 - Delo s Podatki]]

#interfaces #awt

----

# Vmesniki

Vmesnik je podoben abstraktnemu razredu.

![[Pasted image 20230430104649.png]]

*Poleg podpisov metod lahko abstraktni razred vsebuje implementacije drugih metod, vmesnik pa ne!*

Z `implements` Funkcija v glavi razreda smo se obvezali, da bomo v tem razredu napisali VSE metode, ki jih predvideva vmesnik (če tega ne storimo, prevajalnik kode ne bo prevedel); v našem primeru moramo v razredu Sinus napisati metodi `vrednost()` in `odvod()`.

Vmesnik vsebuje LE podpise funkcije in nobene konkretne implementacije (za razliko od abstraktnega razreda, kjer je poleg abstraktnih metod lahko tudi katera, ki ni abstraktna, kot na primer izracunajNiclo), zato kode za računanje ničle NE moremo napisati znotraj vmesnika Funkcije. Napisati moramo svoj razred,

![[Pasted image 20230430104832.png]]

