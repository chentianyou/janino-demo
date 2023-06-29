package com.oushu.janino.demo;

import org.codehaus.janino.ExpressionEvaluator;

public class JaninoExpressionDemo {
    public static void main(String[] args) {
        try {
            String express = "(1+2)*3";
            ExpressionEvaluator evaluator = new ExpressionEvaluator();
            evaluator.cook(express);
            Object rst = evaluator.evaluate(null);
            System.out.println(express + "=" + rst);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
