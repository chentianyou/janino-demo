package com.oushu.janino.demo;

import org.codehaus.janino.ScriptEvaluator;

public class JaninoClassDemo {
    public static class BaseClass {
        private final String baseId;

        public BaseClass(String baseId) {
            this.baseId = baseId;
        }

        @Override
        public String toString() {
            return "BaseClass{" +
                    "baseId='" + baseId + '\'' +
                    '}';
        }
    }

    public static class DerivedClass extends BaseClass {
        private final String name;

        public DerivedClass(String baseId, String name) {
            super(baseId);
            this.name = name;
        }

        @Override
        public String toString() {
            return super.toString() + " DerivedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        try {
            ScriptEvaluator evaluator = new ScriptEvaluator();
            evaluator.setReturnType(String.class);
            evaluator.cook("import com.oushu.janino.demo.JaninoClassDemo.BaseClass;\n"
                    + "import com.oushu.janino.demo.JaninoClassDemo.DerivedClass;\n"
                    + "BaseClass o = new DerivedClass(\"1\", \"oushu\");\n"
                    + "return o.toString();\n");
            String rst = (String) evaluator.evaluate(null);
            System.out.println(rst);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
