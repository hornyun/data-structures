package com.hornyun.day10.arraystack;

import java.util.Scanner;

/**
 * @author hornyun
 * @date 2020/10/25 11:24 下午
 */
public class ArrayStackMain {
    public static void main(String[] args) {
        System.out.print("\n\n");
        System.out.println("please input stack size");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        ArrayStack stack = new ArrayStack(i);
        while (true) {
            System.out.println("输入push添加数据");
            System.out.println("输入pop删除");
            System.out.println("输入show展示栈");
            System.out.println("输入exit退出程序");
            System.out.println("\n\n");

            String instruct = scanner.next();
            switch (instruct) {
                case "pop":
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("输入要加入的元素");
                    int input = scanner.nextInt();
                    try {
                        stack.push(input);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    return;
                case "show":
                    stack.show();
                    break;
                default:
                    System.out.println("please input correct instruct");
            }

        }
        
    }
}
