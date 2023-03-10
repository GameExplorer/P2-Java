package predavanje04;

public class PrestejBite {
    public static void main(String[] args) {
        int x = 47;

        int stBitov = prestejBite(x);

        System.out.printf("Število prižganih bitov v številu %d je %d%n", x, stBitov);
    }

    private static int prestejBite(int x) {
        int biti = 0;
        while( x != 0) {
            if((x & 1) == 1) biti++;

            x = x >> 1;
        }
        return biti;
    }
}
