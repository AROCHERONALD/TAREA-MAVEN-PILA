/*
 * Decompiled with CFR 0.152.
 */
package umg.edu.gt.handler;

import umg.edu.gt.handler.a;

public class App {
    public static void main(String[] stringArray) {
        a a2 = new a();
        if (stringArray.length > 0) {
            String string = stringArray[0];
            System.out.println("Expresion: " + string);
            System.out.println("Valida: " + a2.a(string));
            return;
        }
        String string = "(a+b) * [c-d]";
        String string2 = "([)]";
        System.out.println(string + " -> " + a2.a(string));
        System.out.println(string2 + " -> " + a2.a(string2));
    }
}

