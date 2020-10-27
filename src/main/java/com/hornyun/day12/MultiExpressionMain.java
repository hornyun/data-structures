package com.hornyun.day12;

import com.hornyun.day11.CalculatorMain;
import com.hornyun.day11.Stack;

/**
 * @author hornyun
 * @date 2020/10/27 11:30 PM
 * 多位数计算
 */
public class MultiExpressionMain {

    public static void main(String[] args) {
        String expression = "20+70*4-30";
        StringBuilder cache = new StringBuilder();
        Stack digitalStack = new LinkedListStack();
        Stack operatorStack = new LinkedListStack();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (CalculatorMain.isNumeric(c)) {
                cache.append(c);
                while (true) {
                    i++;
                    if (i < expression.length()) {
                        if (CalculatorMain.isNumeric(expression.charAt(i))) {
                            cache.append(expression.charAt(i));
                        } else {
                            i--;
                            digitalStack.push(Integer.parseInt(cache.toString()));
                            cache = new StringBuilder();
                            break;
                        }
                    } else {
                        if (!"".equals(cache.toString())) {
                            digitalStack.push(Integer.parseInt(cache.toString()));
                        }
                        break;
                    }
                }
            } else {
                CalculatorMain.executeCalculate(digitalStack, operatorStack, c);
            }
        }
        int last = digitalStack.pop();
        int first = digitalStack.pop();
        char operator = (char) operatorStack.pop();
        int calculate = CalculatorMain.calculate(first, last, operator);

        System.out.println("calculate is "+calculate);

    }
}
