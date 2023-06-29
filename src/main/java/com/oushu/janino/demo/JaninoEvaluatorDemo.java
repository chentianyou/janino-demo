package com.oushu.janino.demo;

import org.codehaus.janino.ScriptEvaluator;

public class JaninoEvaluatorDemo {
    public static void main(String[] args) {
        try {
            String content = "System.out.println(\"Hello world!\");";
            ScriptEvaluator evaluator = new ScriptEvaluator();
            evaluator.cook(content);
            evaluator.evaluate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
