package com.hornyun.day25;

import java.util.Scanner;

/**
 * @author hornyun
 * @date 2020/11/15 11:23 PM
 */
public class CircleQueueReview {
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
                        orderQueue.push(element);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int poll = orderQueue.pop();
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

class CircleQueue {
    private int[] store;
    int size;
    int head;
    int tail;

    public CircleQueue(int size) {
        if (size <= 0) {
            throw new RuntimeException("can't create circle queue which size is " + size);
        }
        this.size = size + 1;
        store = new int[this.size];

    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("I'm empty circle Queue");
        } else {
            int result = store[head];
            head = (head + size + 1) % size;
            return result;
        }
    }

    public void push(int element) {

        if (!isFull()) {
            this.store[tail] = element;
            tail = (++tail) % size;
        } else {
            throw new RuntimeException("circle queue is full");
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return store[head];
        } else {
            throw new RuntimeException("can't get element from empty circleQueue");
        }
    }

    public void show() {
        int length = (tail + size - head) % size;
        for (int i = head; i < head + length; i++) {
            System.out.printf("\t %d \t", store[i % size]);
        }
        System.out.println();
    }
}
