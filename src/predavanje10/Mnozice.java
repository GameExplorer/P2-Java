package predavanje10;

import java.util.HashSet;

public class Mnozice {
    public static void main(String[] args) {
        HashSet<String> dnevi = new HashSet<>();

        dnevi.add("PON");
        dnevi.add("TOR");

        System.out.println(dnevi.size());
        System.out.println(dnevi.contains("TOR"));
        System.out.println(dnevi.add("SRE"));
    }

}