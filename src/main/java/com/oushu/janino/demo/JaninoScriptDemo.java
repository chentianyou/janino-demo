package com.oushu.janino.demo;

import org.codehaus.janino.ScriptEvaluator;

public class JaninoScriptDemo {
    public static void main(String[] args) {
        try {
            ScriptEvaluator evaluator = new ScriptEvaluator();
            // 定义两个名为arg1、arg2的参数，并指定类型
            evaluator.setParameters(new String[]{"arg1", "arg2"}, new Class[]{String.class, int.class});
            String script = "static void method1(String a) {\n" +
                    "  System.out.println(\"run in method1 with parameter:\" + a);\n" +
                    "}\n" +
                    "\n" +
                    "static void method2(int b) {\n" +
                    "  System.out.println(\"run in method2 with parameter:\"+b);\n" +
                    "}\n" +
                    "\n" +
                    "method1(arg1);\n" +
                    "method2(arg2);";
            // 编译代码
            evaluator.cook(script);
            // 传入相应类型的参数，执行代码
            evaluator.evaluate(new Object[]{"aaa", 666});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
