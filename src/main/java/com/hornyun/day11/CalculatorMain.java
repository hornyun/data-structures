package com.hornyun.day11;

/**
 * @author hornyun
 * @date 2020/10/26 11:10 PM
 * 栈的实际应用：
 * 使用栈来实现综合计算器-自定义优先级，要求输入一个表达式字符串，使用栈结构来得到计算结果
 * 例如：3+2*6-2，2+2*6-2，7*2*2-5+1-5+3 (数值<10)
 * 思路：讲优先级低的押入栈底，优先级高的放入栈顶，从而达到优先级高的数值先计算的目的，如果后加入的优先级低于栈顶的，则先将栈顶的
 * 元素计算从而降低优先级
 */
public class CalculatorMain {

    public static void main(String[] args) {
        String test1 = "3+2*6-2";
        System.out.println("last calculate is " + getCalculatingValue(test1));

    }

    public static int getCalculatingValue(String expression) {
        int length = expression.length();

        Stack digitalStack = new ArrayStack(100);
        Stack operatorStack = new LinkedListStack();

        for (int i = 0; i < length; i++) {
            char charAt = expression.charAt(i);
            if (charAt >= 48 && charAt <= 57) {
                digitalStack.push(charAt - '0');
            } else {
                executeCalculate(digitalStack, operatorStack, charAt);
            }
        }
        int last = digitalStack.pop();
        int first = digitalStack.pop();
        char pop =(char) operatorStack.pop();
        return calculate(first, last, pop);
    }
    private static void executeCalculate(Stack digitalStack, Stack operatorStack, char currentOperator) {
        Character preOperator;
        try {
            preOperator = (char) operatorStack.pop();
        } catch (Exception e) {
            preOperator = null;
        }

        if (preOperator == null) {
            operatorStack.push((int) currentOperator);
        } else if (compare(currentOperator, preOperator) > 0) {
            operatorStack.push(preOperator);
            operatorStack.push(currentOperator);
        } else {
            int last = digitalStack.pop();
            int first = digitalStack.pop();
            int calculate = calculate(first, last, preOperator);
            digitalStack.push(calculate);
            executeCalculate(digitalStack, operatorStack, currentOperator);
        }

    }

    /**
     * return operator priority
     *
     * @param operator1 operator 1
     * @param operator2 operator 2
     * @return > return 1 < return -1 = return 0
     */
    private static int compare(char operator1, char operator2) {
        int priority1;
        int priority2;
        return getLevel(operator1) - getLevel(operator2);
    }

    private static int getLevel(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new IllegalStateException("Unexpected operator: " + operator);
        }
    }

    private static int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("can't divide zero");
                }
                return num1 / num2;
            default:
                throw new RuntimeException("unknown operator is " + operator);
        }
    }
}
