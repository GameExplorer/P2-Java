package Kviz1;

import java.util.Arrays;

public class Stik {
    public static void main(String[] args) {
        int[] tabela1 = new int[]{3,6,9,1,3,5};
        int[] tabela2 = new int[]{3,4,6,1,3,8};

        int[] izpis = stik(tabela1, tabela2);
        System.out.println(Arrays.toString(izpis));
    }

    private static int[] stik(int[] tabela1, int[] tabela2) {
        int[] tabela3 = new int[tabela1.length + tabela2.length];
        System.arraycopy(tabela1, 0, tabela3, 0, tabela1.length);
        System.arraycopy(tabela2, 0, tabela3, tabela1.length, tabela2.length);
        return tabela3;
    }
}
