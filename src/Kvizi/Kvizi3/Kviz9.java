package Kvizi.Kvizi3;

import java.util.Stack;

public class Kviz9 {
    public static int izracunajRPN(String racun) {
        String[] deli = racun.split(" ");
        Stack<Integer> num = new Stack<>();

        for(String del : deli) {
            int a;
            int b;
            switch (del) {
                case "+":
                    a = num.pop();
                    b = num.pop();
                    num.push(b + a);
                    break;
                case "-":
                    a = num.pop();
                    b = num.pop();
                    num.push(b - a);
                    break;
                case "*":
                    a = num.pop();
                    b = num.pop();
                    num.push(b * a);
                    break;
                case "/":
                    a = num.pop();
                    b = num.pop();
                    num.push(b / a);
                    break;
                default:
                    num.push(Integer.parseInt(del));
                    break;
            }
        }
        return num.pop();
    }
    public static void main(String[] args) {
        String rpn = "1 2 3 4 + * +";
        System.out.printf("%s = %d\n", rpn, izracunajRPN(rpn));
    }
}
