package com.hornyun.day10.arraystack;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/25 10:59 下午
 * 数组模拟栈的实现
 */
@Data
public class ArrayStack {
    private int size;
    private int[] store;
    private int top;

    public ArrayStack(int size) {
        if (size < 1) {
            throw new RuntimeException("can't create size < " + size + " stack");
        }
        this.size = size;
        this.store = new int[size];
        top=-1;
    }

    public boolean isFull() {
        return this.top == size - 1;
    }

    public boolean isEmpty() {
        return this.top==-1;
    }

    /**
     * 存数据
     *
     * @param element
     */
    public void push(int element) {
        if (isFull()) {
            throw new RuntimeException("stack out of bound");
        }
        top++;
        store[top] = element;
    }

    /**
     * 取数据
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int result = store[top];
        store[top]=0;
        top--;
        return result;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] is %d \n", i, store[i]);
        }
    }
}
