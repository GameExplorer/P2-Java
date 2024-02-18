package Kviz1;

public class vsotaPrvihPrastevil {
    public static void main(String[] args) {
        jePrastevilo(10);
        System.out.println(vsotaPrvih(10));
    }

    private static boolean jePrastevilo(int n) {
        if(n < 0) return false;
        else {

            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0) return false;

            }
        }
        return true;
    }
    private static int vsotaPrvih(int n) {
        int vsota = 0;
        int stPrastevil = 0;
        int kandidat = 2;

        while (stPrastevil < n) {
            boolean jePrastevilo = true;
            for (int delitelj = 2; delitelj <= Math.sqrt(kandidat); delitelj++) {
                if (kandidat % delitelj == 0) {
                    jePrastevilo = false;
                    break;
                }
            }
            if (jePrastevilo) {
                vsota += kandidat;
                stPrastevil++;
            }
            kandidat++;
        }
        return vsota;
    }
}

