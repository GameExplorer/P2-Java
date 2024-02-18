package DN05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DN05 {
    public static void main(String[] args) {
        args = new String[]{"1234321"};
        List<Character> stevke = new ArrayList<>();
        List<Integer> sest = new ArrayList<>();
        List<Integer> izpis = new ArrayList<>();

        for (String string : args) {
            for (int i = 0; i < string.length(); i++) {
                stevke.add(string.charAt(i));
            }
        }
        for (int i = 0; i < 10; i++) {
            sest.add(Collections.frequency(stevke, Character.forDigit(i, 10)));
        }
        for (int i = 0; i < 10; i++) {
            if (Objects.equals(sest.get(i), Collections.max(sest))) {
                izpis.add(i);
            }
        }

        String vnos = String.join(" ", args);
        String s = izpis.toString().replace("[", "").replace("]", "").replace(",", "");

        if (Collections.max(sest) == 0) System.out.println("V nizu '" + vnos + "' ni stevk");

        else System.out.println("'" + vnos + "' -> " + s + " (" + Collections.max(sest) + ")");
    }

}
