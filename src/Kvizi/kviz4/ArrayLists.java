package kviz4;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLists {
    public static void main(String[] args) {
            ArrayListPlus alp1 = new ArrayListPlus();

        alp1.set(3, "3");

        alp1.set(4, "4");

        alp1.set(1, "1");

        System.out.println(alp1); // ;1;;3;4

        ArrayListPlus alp2 = new ArrayListPlus(";b;c;;;;g");

        System.out.println(alp2); //;b;c;;;;g


        ArrayListPlus alp3 = new ArrayListPlus(";b;c;;;;g");

        alp3.set(0, "a");

        alp3.set(4, "e");

        System.out.println(alp3); // a;b;c;;e;;g

    }
}

class ArrayListPlus extends ArrayList<String> {
    ArrayListPlus() { super(); }

    ArrayListPlus(String elements) {
        super();
        String[] elementi = elements.split(";");
        this.addAll(Arrays.asList(elementi));
    }

    public String set(int index, String element) {
        if(index >= this.size()) {
            for(int i = 0; i < index; i++) {
                if(i >= this.size()) this.add("");
                else if(this.get(i) == null) this.set(index, "");
            }
            this.add(element);
            return element;
        }
        return super.set(index, element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String value : this ) {
            sb.append(String.format("%s;", value));
        }
        return sb.toString().substring(0,sb.length() - 1);
    }

}
