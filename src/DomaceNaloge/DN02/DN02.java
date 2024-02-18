package DN02;

public class DN02 {
    public static void main(String[] args) {
        String zvezdice = "*";
        int dolzina = 0;
        if (args.length == 0) System.out.println("Napaka pri uporabi programa!");

        else if (args.length == 1) { //za enostavčne argumente
            String arg = args[0];
            dolzina = arg.length() + 4; //+4 za 2 zvezdici na vsako stran
            zvezdice = "*".repeat(dolzina);
            System.out.printf(" %s%n * %s *%n %s", zvezdice, arg, zvezdice);

        } else { //za večstavčne argumente
            StringBuilder sb = new StringBuilder();
            int dolzinaArgumenta = 1; //vključno s presledki
            for (String arg : args) {
                sb.append(arg).append(" ");
                dolzinaArgumenta += arg.length() + 1;
            }
            dolzina = dolzinaArgumenta + 2;
            zvezdice = "*".repeat(dolzina);
            System.out.printf(" %s%n * %s *%n %s", zvezdice, sb.toString().trim(), zvezdice);

        }

    }

}
