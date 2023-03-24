package predavanje05;

public class Tabela {
    public static void main(String[] args) {
        //ta inicializacija se lahko uporablja le v isti vrstici kot deklaracija
        int[] t = {1,2,3};

        int[] t1;
        //to no gre
        //t1 = {4,5,6};

        t1 = new int[]{4,5,6};
    }
}
