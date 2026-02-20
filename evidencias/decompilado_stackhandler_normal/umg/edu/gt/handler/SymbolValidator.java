/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  umg.edu.gt.data_structure.stack.LinkedStack
 */
package umg.edu.gt.handler;

import umg.edu.gt.data_structure.stack.LinkedStack;

public class SymbolValidator {
    public boolean isValid(String expr) {
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < expr.length(); ++i) {
            char c = expr.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push((Object)Character.valueOf(c));
            }
            if (c != ')' && c != ']' && c != '}') continue;
            if (stack.isEmpty()) {
                return false;
            }
            char open = ((Character)stack.pop()).charValue();
            if (this.matches(open, c)) continue;
            return false;
        }
        return stack.isEmpty();
    }

    private boolean matches(char open, char close) {
        return open == '(' && close == ')' || open == '[' && close == ']' || open == '{' && close == '}';
    }
}

