
[[Vaje 10 - Prijatelji]]
[[Vaje 12 - Iskanje Slik]]

#copy #FileInputStream #FileOutputStream #DataInputStream #DataOutputStream #StreamReader #StreamWriter #Serializable 

---

**1)** V razredu `Kodiranje` implementirajte še (de)šifriranje tekstovnih datotek. Dodajte metodi `void zakodiranjeTekstovneDatoteke(String vhodnaDatoteka, String izhodnaDatoteka)` in `void odkodiranjeTekstovneDatoteke(String vhodnaDatoteka, String izhodnaDatoteka)`. Prva šifrira datoteko z imenom `vhodnaDatoteka` in rezultat zapiše v datoteko z imenom `izhodnaDatoteka`, druga pa podano vhodno datoteko dešifrira in rezultat zapiše v podano izhodno datoteko. Pri tem naj metodi uporabljata kodirnik `kodirnik`, ki je atribut tega razreda. Šifriranje naj se izvaja po en znak naenkrat (iz vhodne datoteke naj metoda prebere znak, ga šifrira in izpiše v izhodno datoteko). Branje in pisanje znakov v/iz datoteke implementirajte s pomočjo podatkovnih tokov `FileReader` in `FileWriter`.

_Opomba:_ Ne pozabite na ustrezno obravnavo izjem!

V metodi `main()` razreda `Sporocila` preverite delovanje šifriranja tekstovnih datotek. Ustvarite datoteko s poljubnim besedilom ter jo šifrirajte in dešifrirajte.

**2)** V razredu `Kodiranje` implementirajte tudi (de)šifriranje binarnih (zlogovnih) datotek. Dodajte metodi `void zakodiranjeBinarneDatoteke(String vhodnaDatoteka, String izhodnaDatoteka)` in `void odkodiranjeBinarneDatoteke(String vhodnaDatoteka, String izhodnaDatoteka)`, ki datoteko z imenom `vhodnaDatoteka` kodirata oz. dekodirata v datoteko z imenom `izhodnaDatoteka`. Pri tem naj metodi uporabljata kodirnik `kodirnik` in kodiranje izvajata po en bajt (zlog) naenkrat (iz vhodne datoteke naj prebere bajt, ga zakodira in izpiše v izhodno datoteko). Branje in pisanje bajtov v/iz datoteke implementirajte s pomočjo podatkovnih tokov `FileInputStream` in `FileOutputStream`.

_Opomba:_ Ne pozabite na ustrezno obravnavo izjem!

V metodi `main()` razreda `Sporocila` preverite delovanje kodiranja binarnih datotek z implementiranima metodama. V projekt dodajte poljubno sliko in jo poskusite zakodirati. Zakodirano sliko nato poskusite odkodirati. Dobite originalno sliko? Preizkusite še kodiranje besedilnih datotek. Ustvarite datoteko s poljubnim besedilom ter jo kodirajte in dekodirajte. Dobite enak rezultat kot v nalogi **1)**? Zakaj ja/ne?

**3)** V projekt dodajte še paket `izjeme` in v njem implementirajte razred `IzjemaDatoteke`, ki zajema preverljive izjeme pri delu z datotekami. Dodajte ustrezen konstruktor, ki nastavi sporočilo izjeme (ki ga vrne metoda `getMessage()`).

Dopolnite metode za (de)šifriranje datotek (tekstovnih in binarnih) v razredu `Kodiranje` tako, da bodo ob napakah pri branju/pisanju sprožile novo izjemo tipa `IzjemaDatoteke` z ustreznim sporočilom. Obravnavajte naslednje možne napake:

1. Vhodne ali izhodne datoteke ni mogoče najti (ustrezna vhodna oz. izhodna datoteka ne obstaja).
2. Pri branju/pisanju iz/v datoteko je prišlo do napake.
3. Binarna datoteka sicer obstaja, a ni ustreznega dovoljenja za dostop.

_Nasvet:_ Preverite, kakšne izjeme lahko sprožijo metode za delo z datotekami in v katerih primerih.

V metodi `main()` razreda `Sporocila` dodajte ustrezno lovljenje izjem pri (de)šifriranju datotek (blok `try-catch`). Izjemo obravnavajte tako, da izpišete sporočilo (uporabite metodo `getMessage()`).

Preverite delovanje napisanega programa.

---

**DODATNA NALOGA**

**4)** V razredu `Kodiranje` implementirajte še (de)šifriranje tekstovnih datotek z uporabo podatkovnih tokov `DataInputStream` in `DataOutputStream`, kjer se šifriranje izvaja po en znak naenkrat s pomočjo metode za branje oz. pisanje znakov `readChar()` oz. `writeChar()`. Poskrbite tudi za ustrezno lovljenje izjem ter za proženje izjeme `IzjemaDatoteke`.

Preverite delovanje napisanih metod. Ali je rezultat enak kot pri (de)šifriranju tekstovnih datotek v nalogi 1)? Zakaj?

Preverite delovanje napisanih metod tudi na binarnih datotekah, npr. na sliki. Ali pri dešifriranju zašifrirane slike dobite nazaj originalno sliko? Zakaj?