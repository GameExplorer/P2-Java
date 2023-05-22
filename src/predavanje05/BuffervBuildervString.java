package predavanje05;

public class BuffervBuildervString {
    public static void main(String[] args) {
        String a = "";
        long zacetek = System.currentTimeMillis();

        for(int i = 0; i < 300000; i++) {
            a = a + "a";
        }
        long trajanje = System.currentTimeMillis() - zacetek;
        System.out.printf("Lepljenje 300.000 nizov z uporabo Stringa: %.2f s\n", trajanje / 1000.0);


        zacetek = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100000000; i++) {
            sb.append("a");
        }

        trajanje = System.currentTimeMillis() - zacetek;
        System.out.printf("Lepljenje 1.000.000 nizov z uporabo StringBUilder: %.2f s\n", trajanje / 1000.0);
    }
}