import java.util.*;

public class RedundantBraces {
    public boolean braces(String A) {
        Stack<Character> s = new Stack<>();
        for (int i = 0 ; i < A.length(); i++) {
            char c = A.charAt(i);
            if(c == ' ')
            continue;
            if( c == '(' || c == '+' || c == '-' || c == '*' || c == '/')
            s.push(c);
            else if(c == ')') {
                if (s.peek() == '(')
                return false;
                else {
                    while(!s.isEmpty() && s.peek() != '(') {
                        s.pop();
                    }
                    s.pop();
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        RedundantBraces r = new RedundantBraces();
        System.out.println(r.braces("((a+b))"));
    }
}