package Izpiti.Poletni2022.Rok_1;

import java.util.Arrays;

public class Naloga11 {

    public static void premakni(int[] tabela) {
        //poišči najmanjši element v tabeli
        int najmanjsi = tabela[0]; // vzamemo prvi element

        for(int i = 0; i < tabela.length; i++) { //sprehodim se po elementih
            if(tabela[i] < najmanjsi) { //če je i-ti element v tabeli manjši od najmanjšega ...
                najmanjsi = tabela[i]; // potem ga shranim v najmanjši
            }
        }

        // ciklično rotiraj elemente tabele, dokler prvi element ni enak najmanjšemu elementu
        while(tabela[0] != najmanjsi) {
            int tmp = tabela[0]; // zalasno shranimo prvi element
            for(int i = 1; i < tabela.length; i++) { //ne rabim od 0 ker je prvi element v tabeli
                tabela[i - 1] = tabela[i]; //za eno nazaj zapišem elemente.. če je bila 2 na indeksu 3 npr. je sedaj na indeksu 2
            }
            tabela[tabela.length - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        args = new String[]{"3", "5", "-1", "404", "11", "5", "-5", "9"};
        int[] tabela = new int[args.length]; //tabela, ki bo velika za dolzino args
        for(int i = 0; i < args.length; i++) { //sprehod po argumentih
            tabela[i] = Integer.parseInt(args[i]); //convertam v int in zapišem v tabelo
        }

        System.out.printf("Vhodna tabela: %s %n", Arrays.toString(tabela));
        premakni(tabela);
        System.out.printf("Rotirana tabela: %s %n", Arrays.toString(tabela));
    }
}
