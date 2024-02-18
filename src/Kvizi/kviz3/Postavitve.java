package kviz3;

public class Postavitve {
    public static void main(String[] args) {
        System.out.println(steviloPostavitev(4));
    }
    public static int steviloPostavitev(int n) {
        int[] cols = new int[n];
        return steviloPostavitevHelper(0, cols, n);
    }

    private static int steviloPostavitevHelper(int row, int[] cols, int n) {
        if (row == n) {
            // Končali smo postavitev kraljic
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (jeDozvoljenaPostavitev(row, col, cols)) {
                cols[row] = col;
                count += steviloPostavitevHelper(row + 1, cols, n);
            }
        }
        return count;
    }
    private static boolean jeDozvoljenaPostavitev(int row, int col, int[] cols) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(cols[i] - col);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }
}