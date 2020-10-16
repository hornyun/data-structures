package com.hornyun.day02;

/**
 * @author hornyun
 * @date 2020/10/16 11:54 下午
 * 顺序队列的实现
 */

public class OrderQueue {
    private int maxSize;
    private int head;
    private int tail;
    private int[] store;

    public OrderQueue(int maxSize) {
        this.maxSize = maxSize;
        this.head = -1;
        this.tail = -1;
        this.store = new int[maxSize];
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public boolean isFull() {
        return this.tail == this.maxSize-1;
    }

    public void add(int element) {
        if (!this.isFull()) {
            tail++;
            this.store[tail] = element;
        } else {
            System.out.println("队列已满，无法添加");
        }
    }

    public int poll() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，无法取值");
        }else {
            head++;
            return store[head];
        }
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，无法取值");
        }else {
            return store[head+1];
        }
    }

    public void showQueue() {
        if (this.isEmpty()) {
            System.out.println("队列为空");
        }else{
            System.out.println("队列元素： ");
            for (int i = head; i < tail; i++) {
                System.out.printf(store[i + 1]+"\t");
            }
        }
    }
}
