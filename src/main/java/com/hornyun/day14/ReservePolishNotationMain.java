package com.hornyun.day14;

import com.hornyun.day11.CalculatorMain;
import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * @author hornyun
 * @date 2020/10/29 11:52 PM
 * @description 逆波兰表达式 计算类
 */

public class ReservePolishNotationMain {

    public static void main(String[] args) {
        int i = calculateReservePolishExpression("2 3 + 1 -");
        System.out.println("calculate expression is " + i);
    }

    public static int calculateReservePolishExpression(String expression) {
        if (StringUtils.isBlank(expression)) {
            throw new ArithmeticException("can't calculate empty expression");
        }else{
            String[] elements = expression.split(" ");
            Stack<Integer> digits = new Stack<>();

            for (String element : elements) {
                boolean digit = PolishNotationMain.isDigit(element);
                if (digit) {
                    digits.push(Integer.parseInt(element));
                } else {
                    Integer first = digits.pop();
                    Integer last = digits.pop();
                    int calculate = CalculatorMain.calculate(first, last, element.charAt(0));
                    digits.push(calculate);
                }
            }
            return digits.get(0);
        }
    }
}
