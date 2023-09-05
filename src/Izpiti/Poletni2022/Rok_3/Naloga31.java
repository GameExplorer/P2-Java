package Izpiti.Poletni2022.Rok_3;

/**
 * Vrne tabelo indeksov, ki je urejena po padajočih ocenah ali po imenih študentov v primeru istih imen
 */
public class Naloga31 {
    /**
     * Metoda uredi študente po njihovih ocenah ali po imenih v primeru istih imen
     * @param studenti .. studenti
     * @param ocene .. ocene
     * @return .. vrne tabelo urejenih elementov
     */
    private static int[] uredi(String[] studenti, int[] ocene) {
        int[] tabela = new int[studenti.length];

        for(int i = 0; i < tabela.length; i++) { //zapišemo i-tega študenta v tabelo
            tabela[i] = i;
        }

        for(int i = 0; i < tabela.length; i++) { //beremo vrstice in stolpce
            for(int j = 0; j < tabela.length; j++) {
                //primerja studente na podlagi njihovih ocen in abecednega reda imen, če student[j] večji od student[i] je pogoj resničen
                //primerja ocene studentov, prvi pogoj je da je student[j] večji od i-tega
                //drugi pa če imata oceni pogleda njuni imeni
                if(ocene[tabela[j]] > ocene[tabela[i]] || ocene[tabela[j]] == ocene[tabela[i]] && studenti[tabela[i]].compareTo(studenti[tabela[j]]) > 0) {
                    //če je j pred i se izvede izmenjava med njima
                    int tmp = tabela[i];
                    tabela[i] = tabela[j];
                    tabela[j] = tmp;
                }
            }
        }
        return tabela;
    }

    public static void main(String[] args) {
        args = new String[]{"3", "Micka", "Ana", "Polde", "8", "10", "9"};
        int n = Integer.parseInt(args[0]);

        String[] studenti = new String[n];
        int[] ocene = new int[n];

        for(int i = 0; i < n; i++) {
            studenti[i] = args[i + 1];
            ocene[i] = Integer.parseInt(args[n + i + 1]);
        }

        int[] urejeni = uredi(studenti, ocene);

        for(int i = 0; i < urejeni.length; i++) {
            System.out.printf("%2d %s, ocena %d %n", i + 1, studenti[urejeni[i]], ocene[urejeni[i]]);
        }
    }
}
