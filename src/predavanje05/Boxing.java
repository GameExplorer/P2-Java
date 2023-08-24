package predavanje05;

public class Boxing {

    public static void main(String[] args) {
        Integer a;

        //klasika v a shranim objekt tipa Integer
        a = new Integer(5);

        /*v a shranim int (čeprav je a namenjena shranjevanju
        objketov tipa Integer). Java bo poskrbela za "boxing", to
        je za "pretvorbo" iz int v Integer
         */
        a = 5;
        System.out.println(a);
    }
}