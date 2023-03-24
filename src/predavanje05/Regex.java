package predavanje05;

public class Regex {
    public static void main(String[] args) {
        String a = "prva.druga.tretja";
        String[] deli = a.split("."); //razbijanje po piki

        for (int i = 1; i < deli.length; i++) {
            System.out.println(deli[i]);
        }

        String b = "x   y      z";
        //za razbijanje po enem ali več presledkov uporabimo +

        String[] delil = b.split(" +");
        for(int i = 0; i < delil.length; i++) {
            System.out.println(delil[i]);
        }
    }
}
