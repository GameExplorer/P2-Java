package kviz2;

import java.sql.SQLOutput;

public class BinarnoSestevanje {
    public static void main(String[] args) {
        System.out.println(binarnoSestej("10", "11"));
    }
    public static String binarnoSestej(String s, String b) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += s.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }

}
