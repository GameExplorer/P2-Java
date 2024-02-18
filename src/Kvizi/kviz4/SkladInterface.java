package kviz4;

import java.util.Collections;
import java.util.Stack;

public interface SkladInterface {

    boolean isEmpty(); // je sklad prazen
    void push(Object o); // doda element na vrh sklada
    Object pop(); // vrne element z vrha sklada
    void reverse(); // obrne vrstni red elementov na skladu
}

class Sklad implements SkladInterface {

    Stack<Object> sklad = new Stack<>();

    @Override
    public boolean isEmpty() {
        return sklad.isEmpty();
    }

    @Override
    public void push(Object o) {
        sklad.push(o);
    }

    @Override
    public Object pop() {
        return sklad.pop();
    }

    @Override
    public void reverse() {
        sklad.sort(Collections.reverseOrder());
    }
}

