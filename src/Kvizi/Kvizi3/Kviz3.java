package Kvizi.Kvizi3;

public class Kviz3 {
    public static boolean jeAnagram(String prvaBeseda, String drugaBeseda, boolean zanemariVelikost) {
        if(prvaBeseda.length() != drugaBeseda.length()) return false;
        if(prvaBeseda.length() == 0) return true;

        if(zanemariVelikost) {
            prvaBeseda = prvaBeseda.toLowerCase();
            drugaBeseda = drugaBeseda.toLowerCase();
        }

        String crka = Character.toString(prvaBeseda.charAt(0));

        if(drugaBeseda.contains(crka)) {
            return jeAnagram(prvaBeseda.substring(1), drugaBeseda.replaceFirst(crka, ""), zanemariVelikost);
        }

        return false;
    }
    public static void main(String[] args) {
        boolean rez = jeAnagram("abac", "caba", false);
        System.out.println(rez);
    }
}
