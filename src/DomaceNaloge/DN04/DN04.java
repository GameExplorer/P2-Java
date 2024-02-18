package DN04;

public class DN04 {
    public static void main(String[] args) {
        args = new String[]{"010000010100001001000011"};

        StringBuilder izpis = new StringBuilder();

        char[] tabela = args[0].toCharArray();

        for(int i = 1; i <= args[0].length(); i++) {
            if(i % 8 == 0) {
                int bin = Integer.parseInt(String.valueOf(izpis), 2);
                char znak = (char) bin;
                System.out.print(znak);
                izpis = new StringBuilder();
            }
            else {
                izpis.append(tabela[i]);
            }
        }
    }
}
