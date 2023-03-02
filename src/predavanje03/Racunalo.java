package predavanje03;

public class Racunalo {
    public static void main(String[] args) {
        if(args.length != 2) System.out.println("Uporaba: java racunalo x y");
        else {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);
            double xy = x + y;
            System.out.printf("%.2f + %.2f = %.2f", x,y,xy); //lahko pretvorimo v %s pa dobimo originalne argumente
        }
    }
}
