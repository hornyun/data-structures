package com.hornyun.day16;

import com.hornyun.day11.CalculatorMain;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hornyun
 * @date 2020/10/30 11:09 PM
 */
public class MidToReversePolishMain {
    public static void main(String[] args) {
        // 1+((2+3)*4)-5
        String expression = "1+((2+3)*4)-5";

        String polishNotation = getPolishNotation(splitToList(expression));
        System.out.println("expression is " + expression);
        System.out.println("polish notation is " + polishNotation);
    }

    /**
     * transform mid notation list to polish notation
     *
     * @param midNotationExpression min notation expression
     * @return polish expression
     */
    public static String getPolishNotation(List<String> midNotationExpression) {
        Stack<String> polishNotation = new Stack<>();
        Stack<String> cacheStack = new Stack<>();

        if (CollectionUtils.isEmpty(midNotationExpression)) {
            throw new RuntimeException("can't transform empty list to polish notation");
        } else {
            for (String element : midNotationExpression) {
                if (CalculatorMain.isNumeric(element.charAt(0))) {
                    polishNotation.push(element);
                } else {
                    switch (element) {
                        case "(":
                            cacheStack.push(element);
                            break;
                        case ")":
                            while (true) {
                                String peek = cacheStack.peek();
                                if ("(".equals(peek)) {
                                    cacheStack.pop();
                                    break;
                                } else {
                                    polishNotation.push(cacheStack.pop());
                                }
                            }
                            break;
                        case "+":
                        case "-":
                        case "/":
                        case "*":
                            if (cacheStack.isEmpty()) {
                                cacheStack.push(element);
                            } else if ("(".equals(cacheStack.peek())) {
                                cacheStack.push(element);
                            } else if (CalculatorMain.compare(element.charAt(0), cacheStack.peek().charAt(0)) > 0) {
                                cacheStack.push(element);
                            } else {
                                do {
                                    String pop = cacheStack.pop();
                                    polishNotation.push(pop);
                                    if (cacheStack.isEmpty() || CalculatorMain.compare(element.charAt(0), cacheStack.peek().charAt(0)) > 0) {
                                        cacheStack.push(element);
                                        break;
                                    }
                                } while (true);
                            }
                            break;
                        default:
                            throw new RuntimeException("can't parse operator is " + element);
                    }
                }
            }
            if (!cacheStack.isEmpty()) {
                for (String operator : cacheStack) {
                    polishNotation.push(operator);
                }
            }
            StringBuilder builder = new StringBuilder();
            for (String element : polishNotation) {
                builder.append(element);
            }
            return builder.toString();
        }

    }

    /**
     * split expression to List
     *
     * @param expression expression
     * @return element list
     */
    public static List<String> splitToList(String expression) {
        if (StringUtils.isBlank(expression)) {
            throw new RuntimeException("expression can't be empty");
        }
        List<String> result = new ArrayList<>();
        int i = 0;
        StringBuilder joint = new StringBuilder();
        do {
            char element = expression.charAt(i);
            if (CalculatorMain.isNumeric(element)) {
                joint.append(element);
            } else {
                if (StringUtils.isNotBlank(joint.toString())) {
                    result.add(joint.toString());
                    joint = new StringBuilder();
                }
                result.add(Character.toString(element));
            }
            i++;
        } while (i < expression.length());
        if (StringUtils.isNotBlank(joint.toString())) {
            result.add(joint.toString());
        }
        return result;
    }
}
