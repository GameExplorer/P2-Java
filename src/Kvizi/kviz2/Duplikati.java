package kviz2;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Duplikati {
    public static void main(String[] args) {
        int[] rez = duplikati(new int[]{1, 2, 3, 4, 5, 6, 6, 7});
        System.out.println(Arrays.toString(rez));
    }

    public static int[] duplikati(int[] tabela) {
        LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<>();
        for (int i : tabela) {
            map.put(i, Boolean.TRUE);
        }
        int[] nova_tabela = new int[map.size()];
        int j = 0;
        for (int i : map.keySet()) {
            nova_tabela[j++] = i;
        }
        return nova_tabela;
    }
}
