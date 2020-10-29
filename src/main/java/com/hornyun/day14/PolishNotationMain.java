package com.hornyun.day14;

import com.hornyun.day11.CalculatorMain;
import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * @author hornyun
 * @date 2020/10/29 10:48 PM
 * @description 波兰表达式 计算
 */
public class PolishNotationMain {
    public static void main(String[] args) {
        //expression = "(3+4)-4*(1+2)";
        String expression = "- + 3 4 * 4 + 1 2";
        //expression = 1-(2+3)
        //String expression = "- 1 + 2 3";
        System.out.println(calculatePolishNotation(expression));
    }

    public static int calculatePolishNotation(String expression) {
        Stack<String> digits = new Stack<>();
        String[] elements = expression.split(" ");
        for (int i = elements.length; i > 0; i--) {
            String elemnt = elements[i-1];
            if (isDigit(elemnt)) {
                digits.push(elemnt);
            }else{
                String first = digits.pop();
                String last = digits.pop();
                int calculate = CalculatorMain.calculate(Integer.parseInt(first), Integer.parseInt(last), elemnt.charAt(0));
                digits.push(calculate + "");
            }
        }
        return Integer.parseInt(digits.get(0));
    }

    public static boolean isDigit(String checksum) {
        if (StringUtils.isBlank(checksum)) {
            throw new RuntimeException("can't check empty string ");
        } else {
            char c = checksum.charAt(0);
            return c >= 48 && c <= 57;
        }
    }
}
