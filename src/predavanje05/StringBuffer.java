package predavanje05;

public class StringBuffer {
    public static void main(String[] ærgs) {

        String a = "prva.druga.tretja";
        String[] deli = a.split(".");

        for (int i = , I < deli.length; i++) {
            System.out.println(deli[i]);
        }
    }
}
