package kviz2;

import java.util.HashSet;

public class VsotaSkupnihCifer {
    public static void main(String[] args) {
        System.out.print(vsotaSkupnihCifer(13, 30));
    }

    public static int vsotaSkupnihCifer(int a, int b) {
        int vsota = 0;

        String stavekA = Integer.toString(a);
        String stavekB = Integer.toString(b);

        HashSet<Integer> upostevana = new HashSet<>();

        for(int i = 0; i < stavekA.length(); i++) {
            for(int j = 0; j < stavekB.length(); j++) {
                int trenutenA = Character.getNumericValue(stavekA.charAt(i));
                int trenutenB = Character.getNumericValue(stavekB.charAt(j));

                if(trenutenA == trenutenB && !upostevana.contains(trenutenA)) {
                    vsota += trenutenA;
                    upostevana.add(trenutenA);
                }
            }
        }

        return vsota;
    }
}
