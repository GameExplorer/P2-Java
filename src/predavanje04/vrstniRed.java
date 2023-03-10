package predavanje04;

public class vrstniRed {
    public static void main(String[] args) {
        int t[] = new int[]{1,2,3};

        int i = 0;

        t[i++] = 5;
        System.out.println(t[0]);
        System.out.println(t[1]);
        System.out.println(i);
    }
}
