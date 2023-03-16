package predavanje05;



public class TwoDTabele {
    public static void main(String[] args) {
        int n = 10;
        int[][] tabela = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tabela[i][j] = (i * n)+ j + 1;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.printf(" %3d", tabela[i][j]);
            }
            System.out.println();
        }

        int vsota = 0;
        //Leva stran
        for(int
            i = n - 1; i >= 0; i--) {
            vsota += tabela[i][i];
        }

        //desna stran
        for(int i = 0; i < n; i++) {
            vsota += tabela[i][i];
        }

        System.out.printf("Vsota diagonale = %d", vsota);
    }
}
