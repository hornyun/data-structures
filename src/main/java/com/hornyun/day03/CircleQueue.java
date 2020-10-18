package com.hornyun.day03;

/**
 * @author hornyun
 * @date 2020/10/18 10:53 下午
 * 环形队列
 */
public class CircleQueue {
    private int maxSize;
    private int head;
    private int tail;
    private int[] store;


    public CircleQueue(int maxSize) {
        this.maxSize = maxSize+1;
        this.head = 0;
        this.tail = 0;
        this.store = new int[this.maxSize];
    }

    public boolean isFull() {
        return (tail + 1) % maxSize == head;
    }

    public boolean isEmpty(){
        return this.head==tail;
    }

    public void add(int element){
        if (isFull()) {
            throw new RuntimeException("queue is full");
        } else {
            this.store[tail] = element;
            tail++;
            tail = tail%maxSize;
        }
    }

    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else {
            int first = this.store[head];
            this.store[head]=0;
            head++;
            head%=maxSize;
            return first;
        }
    }
    public int size(){
        return (tail+maxSize-head)%maxSize;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is Empty");
        } else {
            return store[head];
        }
    }

    public void show(){
        if (isEmpty()) {
            System.out.println("queue is empty");
        } else {
            System.out.println("--------show--------");
            int length = size()+head;
            for (int i = head; i < length; i++) {
                System.out.printf("%d\t", store[i % maxSize]);
            }
            System.out.println();
            System.out.println("--------show--------");
        }
    }
}
