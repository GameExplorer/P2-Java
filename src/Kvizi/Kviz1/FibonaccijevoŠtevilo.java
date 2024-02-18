package Kviz1;

public class FibonaccijevoŠtevilo {
    public static void main(String[] args) {
        System.out.println(jeFibonaccijevo(13));
    }
    private static boolean jeFibonaccijevo(int n) {
        if(n < 0) {
            System.out.println("Napaka: Negativen n");
            return false;
        }

        else if(n == 0 || n == 1) return true;
        else {
            int a = 0;
            int b = 1;
            int c = 0;
            for(int i = 0; i < n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            if(c == n) return true;
            else return false;
        }

    }
}
