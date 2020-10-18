package com.hornyun.day03;


import com.hornyun.day02.OrderQueue;

import java.util.Scanner;

/**
 * @author hornyun
 * @date 2020/10/17 12:12 上午
 * 顺序队列的测试
 */
public class QueueMain {
    public static void main(String[] args) {
        CircleQueue orderQueue = new CircleQueue(3);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("-----------------");
            System.out.println("s(show): 展示队列");
            System.out.println("a(add): 添加元素");
            System.out.println("g(get): 取出头元素");
            System.out.println("p(peek): 展示头元素");
            System.out.println("e(exit): 退出程序");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    orderQueue.show();
                    System.out.println();
                    break;
                case 'a':
                    System.out.println("输入元素：");
                    int element = scanner.nextInt();
                    try {
                        orderQueue.add(element);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int poll = orderQueue.poll();
                        System.out.println("取出的元素为： " + poll);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int peek = orderQueue.peek();
                        System.out.println("头元素为： " + peek);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    System.out.println("未知命令");
                    break;
            }
        }
        System.out.println("程序结束");
    }
}
