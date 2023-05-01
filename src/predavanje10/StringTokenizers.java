package predavanje10;

import java.util.StringTokenizer;

public class StringTokenizers {
    public static void main(String[] args) {
        String a = "Micka:Kovaceva";
        String[] podniz = a.split(":");
        System.out.println(podniz[0]);
        System.out.println();

        //Razbije stavek na več delov
        StringTokenizer stk = new StringTokenizer(a, ":");
        while (stk.hasMoreElements()) {
            System.out.println(stk.nextElement());
        }

        System.out.println();
        String b = "Zemlja Luna Mars Venera";
        StringTokenizer stk1 = new StringTokenizer(b, " ");
        while(stk1.hasMoreElements()) {
            System.out.println(stk1.nextElement());
        }
    }
}
