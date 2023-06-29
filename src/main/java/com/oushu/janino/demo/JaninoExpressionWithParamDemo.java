package com.oushu.janino.demo;

import org.codehaus.janino.ExpressionEvaluator;

public class JaninoExpressionWithParamDemo {
    public static void main(String[] args) {
        try {
            // 首先定义一个表达式模拟器ExpressionEvaluator
            ExpressionEvaluator ee = new ExpressionEvaluator();

            // 定义一个算术表达式，表达式中有2个int类型参数a和b
            String expression = "2 * (a + b)";
            ee.setParameters(new String[]{"a", "b"}, new Class[]{int.class, int.class});

            // 设置表示的返回结果类型为int
            ee.setExpressionType(int.class);

            // 编译定义的表达式
            ee.cook(expression);

            // 输入a、b参数执行时间的表达式计算过程
            for (int i = 1; i < 6; i++) {
                int result = (Integer) ee.evaluate(new Object[]{i, i + 1});
                System.out.println(i + " --> " +expression + "=" + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
