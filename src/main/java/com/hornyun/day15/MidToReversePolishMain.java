package com.hornyun.day15;

import com.hornyun.day11.CalculatorMain;

import java.util.Stack;

/**
 * @author hornyun
 * @date 2020/10/30 11:09 PM
 */
public class MidToReversePolishMain {
    public static void main(String[] args) {
        String expression = "1+2*3";
        Stack<String> reversePolishNotationStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);

            if (CalculatorMain.isNumeric(c)) {
                reversePolishNotationStack.push(c + "");
            }else{
                switch (c) {
                    case '(':
                        break;
                    case ')':
                        break;
                    case '+':
                        if (operatorStack.isEmpty()) {

                        }
                        break;
                    case '-':
                        break;
                    case '*':
                        break;
                    case '/':
                        break;
                    default:
                        throw new RuntimeException("can't parse operator");
                }
            }
        }

    }
}
