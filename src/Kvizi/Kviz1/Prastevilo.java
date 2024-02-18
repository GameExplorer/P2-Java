package Kviz1;

public class Prastevilo {
    public static void main(String[] args) {

        System.out.println(jePrastevilo(244327));
    }

    private static boolean jePrastevilo(int n) {
        if(n < 0) return false;
        else {

            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0) return false;

            }
        }
        return true;
    }
}
