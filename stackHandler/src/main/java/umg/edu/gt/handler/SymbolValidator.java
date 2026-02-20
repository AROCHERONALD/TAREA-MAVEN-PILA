package umg.edu.gt.handler;

import umg.edu.gt.data_structure.stack.LinkedStack;

public class SymbolValidator {

    public boolean isValid(String expr) {
        LinkedStack<Character> stack = new LinkedStack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;

                char open = stack.pop();

                if (!matches(open, c)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}