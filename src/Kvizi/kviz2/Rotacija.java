package kviz2;

import java.util.Arrays;

public class Rotacija {
    public static void main(String[] args) {
        int[] tabela = new int[] {1,2,3,4,5,6};
        rotiraj(tabela, 2);
        System.out.println(Arrays.toString(tabela));
    }

    public static void rotiraj(int[] tabela, int k) {
        for(int i = 0; i < k; i++) {
            int tmp = tabela[0];
            for(int j = 0; j < tabela.length - 1; j++) {
                tabela[j] = tabela[j+1];
            }
            tabela[tabela.length - 1] = tmp;
        }
    }
}
