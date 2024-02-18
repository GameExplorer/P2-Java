package kviz3;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(jeAnagram("abc", "BCA", true));
    }
    public static boolean jeAnagram(String prvaBesede, String drugaBesede, boolean zanemariVelikost) {
        if(prvaBesede.length() != drugaBesede.length()) return false;
        if(prvaBesede.length() == 0) return true;

        if(zanemariVelikost) {
            prvaBesede = prvaBesede.toLowerCase();
            drugaBesede = drugaBesede.toLowerCase();
        }

        String crka = Character.toString(prvaBesede.charAt(0));

        if(drugaBesede.contains(crka)) return jeAnagram(prvaBesede.substring(1), drugaBesede.replaceFirst(crka, ""), zanemariVelikost);

        return false;
    }
}
