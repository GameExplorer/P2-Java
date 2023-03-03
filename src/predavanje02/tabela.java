package predavanje02;

public class tabela {
    public static void main(String[] args) {
        int[] tabela = {2,3,5,6,7,7};
        String[] besede = {"Danes", "je", "cetrtek"};
        for(int i = 0; i < tabela.length - 1; i++) {
            System.out.println(tabela[i]);
        }

        for(int i = 0; i < besede.length; i++) {
            System.out.print(besede[i]+ " ");
        }
    }
}
