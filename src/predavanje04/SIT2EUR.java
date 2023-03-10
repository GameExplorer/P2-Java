package predavanje04;

public class SIT2EUR {
    public static void main(String[] args) {
        args = new String[] {"EUR", "1"};

        if(args.length != 2) {
            System.out.println("Premalo ali preveč argumentov");
            System.exit(1);
        }

        if(args[0].equals("SIT")) {
            double sit = Double.parseDouble(args[1]);
            double euro = sit / 239.64;
            System.out.printf("%.2f SIT = %.2f EURO", sit, euro);
        }

        if(args[0].equals("EUR")) {
            double euro = Double.parseDouble(args[1]);
            double sit = euro * 239.64;
            System.out.printf("%.2f EURO = %.2f SIT", euro, sit);
        }


    }
}
