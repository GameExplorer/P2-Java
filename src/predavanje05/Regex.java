package predavanje05;

public class Regex {
    public static void main(String[] args) {
        String a = "prva.druga.tretja";
        String[] deli = a.split(".");

        for (int i = 1; i < deli.length; i++) {
            System.out.println(deli[i]);
        }
    }
}
