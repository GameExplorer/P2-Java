package Kviz1;

public class KvadratnaEnacba {
    public static void main(String[] args) {
        nicli(1,2,1);
    }
    private static void nicli(int a, int b, int c) {
        double x1 = 0, x2 = 0;

        if(a != 0) {
            double D = Math.pow(b, 2) - 4 * a * c;
            double equation1 = (-b + Math.sqrt(D)) / (2 * a);
            double equation2 = (-b - Math.sqrt(D)) / (2 * a);
            if (D > 0) {
                x1 = equation1;
                x2 = equation2;
                System.out.printf("x1=%.2f, x2=%.2f", x1, x2);
            }
            else if(D == 0) {
                x1 = equation1;
                x2 = equation1;
                System.out.printf("x1=%.2f, x2=%.2f", x1, x2);
            }
            else if(D < 0) {
                System.out.println("Napaka: nicli enacbe ne obstajata\n");
                x1 = equation1;
                x2 = equation1;
            }
        }
    }
}
