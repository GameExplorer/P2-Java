package DN06;

public class DN06 {
    //Kontrolna vsota BSD
    public static int bsdChecksum(String niz) {
        int checksum = 0;

        for(int i = 0; i < niz.length(); i++) {
            checksum = (checksum >> 1) + ((checksum & 1) << 15);
            checksum += niz.charAt(i);
            checksum &= 0xffff;
        }
        return checksum;
    }

    /**
     * Metoda prejme niz in vrne prvi po abecedi večji niz
     * @param niz - dobljeni niz
     * @return - return
     */
    public static String povecaj(String niz) {
        int z = niz.length() - 1;

        //poiščem prvo črko od zadaj, ki je različna od z ...
        while(z >= 0) {
            //če taka črka obstaja, jo povečam, vse črke za njo pa postavim na 'a'
            if(niz.charAt(z) < 'z')
                return niz.substring(0,z) + ((char)(niz.charAt(z)+1)) + "a".repeat(niz.length()-z-1);
            else z -= 1;
        }
        //če taka črka ne obstaja, večjega niza te dolžine ni, zato vrne null
        return null;
    }
    /**
     *
     * @param args - argument
     */
    public static void main(String[] args) {
        args = new String[]{"pomlad"};

        if (args.length != 1) {
            System.out.println("Program potrebuje en argument");
            System.exit(0);
        }

        String niz = args[0];
        int csNiz = bsdChecksum(niz);

        //začnem z nizom, ki je enako dolg kot 1. argument in je sestavljen iz samih 'a'-jev
        String trNiz = "a".repeat(niz.length());

        while (trNiz != null) {
            //izracunam BSD trenutnega niza
            int csTr = bsdChecksum(trNiz);
            // in ga primerjam z BSD 1. argumenta, če sta enaka, niz izpišem
            if (!trNiz.equals(niz) && csTr == csNiz) {
                System.out.println(trNiz);
                return;
            }
            // sicer niz povecam in nadaljujem z iskanjem
            trNiz = povecaj(trNiz);
        }
    }
}
