package com.hornyun.day10.linkedstack;

import com.hornyun.day10.arraystack.ArrayStack;

import java.util.Scanner;

/**
 * @author hornyun
 * @date 2020/10/25 11:24 下午
 */
public class LinkedStackMain {
    public static void main(String[] args) {
        System.out.print("program begin \n\n");
        Scanner scanner = new Scanner(System.in);
        LinkedListStack stack = new LinkedListStack();
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
                    stack.showAll();
                    break;
                default:
                    System.out.println("please input correct instruct");
            }

        }
        
    }
}
