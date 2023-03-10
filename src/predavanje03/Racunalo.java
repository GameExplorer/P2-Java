package predavanje03;

public class Racunalo {
    public static void main(String[] args) {
        args = new String[]{"3","4"};
        if(args.length != 2) {
            System.out.println("Uporaba: java racunalo x y");
            System.exit(1);
        }
        else {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);
            double xy = x + y;
            System.out.printf("%.2f + %.2f = %.2f", x,y,xy); //lahko pretvorimo v %s pa dobimo originalne argumente
        }
    }
}
