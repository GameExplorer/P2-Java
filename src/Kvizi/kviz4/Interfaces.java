package kviz4;

public class Interfaces {
    public static void main(String[] args) {
        SkladInterface s = new Sklad();

        s.push(1);
        s.push(2);
        s.push(3);

        s.reverse();

        s.push("a");
        s.push("b");
        s.push("c");

        while (!s.isEmpty())

            System.out.print(s.pop());


    }
}
