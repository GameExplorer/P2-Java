package Izpiti.Poletni2023.Rok_2;

class Mnozica {
    int elementi;

    Mnozica() {
        elementi = 0; //privzeta vrednost
    }

    Mnozica(int elementi) {
        this.elementi = elementi;
    }

    // dobimo indeks črke
    private static int getIndex(char c) {
        return c - 'a';
    }

    // Doda element v mnozico
    void dodajElement(char znak) {
        elementi = elementi | (1 << getIndex(znak));
    }

    //odstrani element iz mnozice
    void brisiElement(char znak) {
        elementi = elementi & (1 << getIndex(znak));
    }

    //vrne true, če je znak element mnozice
    boolean jeElement(char znak) {
        return (elementi & ((1 << getIndex(znak)))) != 0;
    }

    //vrne seznam elementov mnozice
    public String toString() {
        String result = "";
        for(char z = 'a'; z <= 'z'; z++) {
            if(jeElement(z)) {
                result += (result.isEmpty() ? "" : ",") + z;
            }
        }

        return result;
    }

    //vrne unijo dveh mnozic
    static Mnozica unija(Mnozica m1, Mnozica m2) {
        return new Mnozica(m1.elementi | m2.elementi);
    }

    static Mnozica presek(Mnozica m1, Mnozica m2) {
        return new Mnozica(m1.elementi & m2.elementi);
    }
}
public class Naloga22 {

    public static void main(String[] args) {

        Mnozica m1 = new Mnozica();
        m1.dodajElement('a');
        m1.dodajElement('b');
        m1.dodajElement('c');
        m1.dodajElement('p');

        System.out.println(m1);

        Mnozica m2 = new Mnozica();
        m2.dodajElement('a');
        m2.dodajElement('k');
        m2.dodajElement('l');
        m2.dodajElement('o');
        //m2.jeElement('b');
        //m2.brisiElement('a');

        System.out.println(m2);

        // Izpiše unijo.. vse elemente
        Mnozica m3 = Mnozica.unija(m1, m2);
        System.out.println(m3);

        // Izpiše elemente v preseku
        Mnozica m4 = Mnozica.presek(m1, m2);
        System.out.println(m4);

    }
}
