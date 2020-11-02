package com.hornyun.day18;

/**
 * @author hornyun
 * @date 2020/11/2 10:54 PM
 */
public class RecursionMain {
    public static void main(String[] args) {
        recursionPrint(5);
        int factorial = factorial(3);
        System.out.printf("3 factorial is %d",factorial);
    }

    /**
     * 递归打印问题
     * @param count print count
     */
    public static void recursionPrint(int count) {
        if (count > 1) {
            recursionPrint(count - 1);
        }
        System.out.printf("count = %d \n", count);
    }

    /**
     * factorial method
     * @param number first number of factorial
     * @return factorial outcome
     */
    public static int factorial(int number) {
        if (number == 1) {
            return number;
        } else {
            return factorial(number - 1) * number;
        }
    }
}
