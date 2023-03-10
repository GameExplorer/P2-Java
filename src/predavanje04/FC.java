package predavanje04;

public class FC {
    public static void main(String[] args) {
        double f = 0;
        double c = 0;

        args = new String[]{"100","20","5"};

        if(args.length != 3) {
            System.out.println("Napačna dolžina argumentov");
            System.exit(1);
        }

        int sp_meja = Integer.parseInt(args[0]);
        int zg_meja = Integer.parseInt(args[1]);
        int korak = Integer.parseInt(args[2]);

        System.out.println(" Fahrenheit (F) | Celzij (C)");
        System.out.println("-----------------------------");

        for(int i = zg_meja; i <= sp_meja ; i+= korak) {
            f = i;
            c = (f - 32) / 1.8;
            System.out.printf("%7.2f         | %6.2f%n", f,c);
        }
    }
}
