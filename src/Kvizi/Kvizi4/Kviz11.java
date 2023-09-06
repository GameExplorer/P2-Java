package Kvizi.Kvizi4;

import java.util.Collections;
import java.util.Stack;

interface SkladInterface {
    public boolean isEmpty(); // Ali je prazen?
    public void push(Object o); // doda element na vrh sklada
    public Object pop(); // vrne element z vrha sklada
    public void reverse(); // obrne vrstni red elementov na skladu
}

class Sklad implements SkladInterface {
    Stack<Object> sklad = new Stack<>();

    public boolean isEmpty() {
        return sklad.isEmpty();
    }

    public void push(Object o) {
        sklad.push(o);
    }

    public Object pop() {
        return sklad.pop();
    }

    public void reverse() {
        sklad.sort(Collections.reverseOrder());
    }
}
public class Kviz11 {
    public static void main(String[] args) {
        SkladInterface s = new Sklad();
        s.push(1);
        s.push(2);
        s.push(3);
        s.reverse();

        s.push("a");
        s.push("b");
        s.push("c");

        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
    }
}
