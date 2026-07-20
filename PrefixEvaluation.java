import java.util.*;

public class Main {

    public static int evaluatePrefix(String expression) {

        Stack<Integer> stack = new Stack<>();

        String[] exp = expression.trim().split("\\s+");
// int this prefix case , we dont do from left ot right 
//prefix : evaluation happens from right to left
//postfix : evaluation happens from left to right 

//so in this case, we dont reverse the given expression it causes errors
//so traverse from the last and use the same postfix logic
        for (int i = exp.length - 1; i >= 0; i--) {

            String s = exp[i];

            if (Character.isDigit(s.charAt(0))) {
                stack.push(Integer.parseInt(s));
            } else {

                int x = stack.pop();
                int y = stack.pop();

                switch (s.charAt(0)) {
                    case '+':
                        stack.push(x + y);
                        break;

                    case '-':
                        stack.push(x - y);
                        break;

                    case '*':
                        stack.push(x * y);
                        break;

                    case '/':
                        stack.push(x / y);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "+ 5 * 3 4";
        System.out.println(evaluatePrefix(exp));
    }
}
