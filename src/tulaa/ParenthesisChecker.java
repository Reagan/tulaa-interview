package tulaa;

import java.util.Vector;

public class ParenthesisChecker {

    public static void main(String[] args) {
        ParenthesisChecker checker = new ParenthesisChecker();
        System.out.println(checker.validate("()[]{}"));
        System.out.println(checker.validate("([)]"));
        System.out.println(checker.validate("()"));
        System.out.println(checker.validate("(]"));
    }

    public String validate(String parenthesis) {
        if (validateParenthesis(parenthesis))
            return String.format("%s is valid", parenthesis);
        else
            return String.format("%s is not valid", parenthesis);
    }

    private boolean validateParenthesis(String str) {
        if (null != str || str == "") {
            Vector stack = new Vector();
            for (char c : str.toCharArray()) {
                if (c == '[' || c == '(' || c == '{')
                    stack.add(c);

                if (c == ']' && (stack.size() <= 0 || (char) stack.remove(stack.size() - 1) != '[')) return false;
                if (c == '}' && (stack.size() <= 0 || (char) stack.remove(stack.size() - 1) != '{')) return false;
                if (c == ')' && (stack.size() <= 0 || (char) stack.remove(stack.size() - 1) != '(')) return false;
            }
        }
        return true;
    }
}
