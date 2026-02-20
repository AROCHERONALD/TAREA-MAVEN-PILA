/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  umg.edu.gt.data_structure.stack.LinkedStack
 */
package umg.edu.gt.handler;

import umg.edu.gt.data_structure.stack.LinkedStack;

public class a {
    public boolean a(String string) {
        LinkedStack linkedStack = new LinkedStack();
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                linkedStack.push((Object)Character.valueOf(c));
            }
            if (c != ')' && c != ']' && c != '}') continue;
            if (linkedStack.isEmpty()) {
                return false;
            }
            char c2 = ((Character)linkedStack.pop()).charValue();
            if (this.a(c2, c)) continue;
            return false;
        }
        return linkedStack.isEmpty();
    }

    private boolean a(char c, char c2) {
        return c == '(' && c2 == ')' || c == '[' && c2 == ']' || c == '{' && c2 == '}';
    }
}

