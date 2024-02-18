package Kviz1;

public class PitagoroviTrojcki {
    public static void main(String[] args) {
        trikotnik(5);
    }
    private static void trikotnik(int x) {
        for(int a = 1; a <= x; a++) {
            for(int b = 1; b <= x; b++) {
                for(int c = 1; c <= x; c++) {
                    if(a * a + b * b == c * c) {
                        System.out.printf("%d %d %d\n", a,b,c);
                    }
                }
            }
        }
    }
}
