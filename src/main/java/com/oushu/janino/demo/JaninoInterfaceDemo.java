package com.oushu.janino.demo;

import org.codehaus.janino.ClassBodyEvaluator;
import org.codehaus.janino.Scanner;

import java.io.StringReader;

public class JaninoInterfaceDemo {
    public interface Add {
        int add(int a, int b);
    }

    public static void main(String[] args) {
        try {
            Add f = (Add) ClassBodyEvaluator.createFastClassBodyEvaluator(
                    new Scanner(null, new StringReader("public int add (int a, int b) { return a + b ; }")),
                    Add.class,
                    (ClassLoader) null);
            System.out.println("1 + 2 = " + f.add(1, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
