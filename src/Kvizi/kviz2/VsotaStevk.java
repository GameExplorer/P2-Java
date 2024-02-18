package kviz2;

public class VsotaStevk {
    public static void main(String[] args) {
        int rez = vsotaStevk("4abc2");
        System.out.println(rez);
    }

    public static int vsotaStevk(String str) {
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                sum = sum + Character.getNumericValue(str.charAt(i));
            }
        }

        if(sum > 1) return sum;
        else return sum;
    }
}
