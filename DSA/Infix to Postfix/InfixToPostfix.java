import java.util.Stack;

public class InfixToPostfix {
    public String solve(String A) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < A.length(); i++) {

            char c = A.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }

            if (c == '(') {
                s.push(c);
            }

            if (c == ')') {
                while (!s.isEmpty() && s.peek() !='(') {
                    postfix.append(s.pop());
                }
                s.pop(); //discard '(' in postfix
            }

            if (isOperator(c)) {
                System.out.println(precedence(c) + "-" + c);
                while(!s.isEmpty() && precedence(c) <= precedence(s.peek())){
                    postfix.append(s.pop());
                }
                s.push(c);
            }
        }

        while(!s.isEmpty()){
            postfix.append(s.pop());
        }

        return postfix.toString();
    }

    public boolean isOperator(char c){
        return c=='+' || c=='-' || c=='*' || c=='/' || c=='^';
    }

    public int precedence(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default :
                return -1;
        }
    }
    public static void main(String[] args) {
        InfixToPostfix solve = new InfixToPostfix();
        System.out.println(solve.solve("A+B/(a*z)+b"));
    }
}

