import java.util.Stack;

public class Postfix {

    public static int evaluate(String exp) {

        Stack<Integer> stack = new Stack<>();

//if we take an char array then 2 digits numbers are split into two single digits like "22" --> "2" ,"2"
//that why we taking a string array that splits the expression 
      
        String[] tokens = exp.split(" ");

        for (String token : tokens) {
//in array every index having string so that we checking charAt(0) is digit or not
//if it is digit then push on to the stack
                if (Character.isDigit(token.charAt(0)){
                stack.push(Integer.parseInt(token));
            }

//if it is operator then pop the 2 elements 
            else {

                int b = stack.pop();
                int a = stack.pop();

                switch (token) {

                    case "+":
                        stack.push(a + b);
                        break;

                    case "-":
                        stack.push(a - b);
                        break;

                    case "*":
                        stack.push(a * b);
                        break;

                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String exp = "12 3 + 4 *";

        System.out.println(evaluate(exp));
    }
}
