**23.03.2023**

[[Predavanje 5 - Konstante & Strukturiranje kode]]
[[Predavanje 7 - StdDraw & File]]

#kodiranje_datotek 

----

>Danes smo naredili nalogo iz slajdov "Kodiranje datotek". Napisali smo program, ki je kodiral in dekodiral datoteke v treh različnih algoritmih (XOR, NUM, BASE64). Usrvarili smo več packagov in znotraj packagov smo ustvarili nekaj datotek ter napisali kodo. Uvozili smo zunanjo knjižnico (Apache commons) in jo uporabili za Base64. Profesor je v Netbeansu ustvaril grafično okno (to snov bomo kasneje delali). 


```Scanner sc = new Scanner(imeDatoteke);``` - nepravilen zapis da prebere datoteko

```Scanner sc = new Scanner(new File(imeDatoteke));``` - pravilen zapis da prebere datoteko

Apache Commons