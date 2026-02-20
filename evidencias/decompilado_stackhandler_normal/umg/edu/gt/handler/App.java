/*
 * Decompiled with CFR 0.152.
 */
package umg.edu.gt.handler;

import umg.edu.gt.handler.SymbolValidator;

public class App {
    public static void main(String[] args) {
        SymbolValidator validator = new SymbolValidator();
        if (args.length > 0) {
            String expr = args[0];
            System.out.println("Expresion: " + expr);
            System.out.println("Valida: " + validator.isValid(expr));
            return;
        }
        String validExpr = "(a+b) * [c-d]";
        String invalidExpr = "([)]";
        System.out.println(validExpr + " -> " + validator.isValid(validExpr));
        System.out.println(invalidExpr + " -> " + validator.isValid(invalidExpr));
    }
}

