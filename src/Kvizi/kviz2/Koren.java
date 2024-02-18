package kviz2;

public class Koren {
    public static void main(String[] args) {
        System.out.println(koren(10,2));

    }

    public static double koren(int x, int d) {
        double decimal = x / 2.0;
        double epsilon = 1.0 / Math.pow(10, d);

        while (Math.abs(decimal * decimal - x) >= epsilon) {
            decimal = (decimal + x / decimal) / 2.0;
        }

        return decimal;
    }

}
