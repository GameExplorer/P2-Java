package kviz3;

public class RPN {
    public static void main(String[] args) {
        String rpn = "1 2 3 4 + * +";
        System.out.printf("%s = %d\n", rpn, izracunajRPN(rpn));
    }

    public static int izracunajRPN(String racun) {
        String[] deli = racun.split(" ");
        java.util.Stack<Integer> st = new java.util.Stack<>();

        int a, b;
        for (String del : deli) {
            switch (del) {
                case "+" -> {
                    a = st.pop();
                    b = st.pop();
                    st.push(b + a);
                }
                case "-" -> {
                    a = st.pop();
                    b = st.pop();
                    st.push(b - a);
                }
                case "*" -> {
                    a = st.pop();
                    b = st.pop();
                    st.push(b * a);
                }
                case "/" -> {
                    a = st.pop();
                    b = st.pop();
                    st.push(b / a);
                }
                default -> st.push(Integer.parseInt(del));
            }
        }
        return st.pop();
    }
}
