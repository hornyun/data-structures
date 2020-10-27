package com.hornyun.day11;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/26 10:49 PM
 */
@Data
public class ArrayStack implements Stack{
    private int top;
    private int[] store;
    private int size;

    public ArrayStack(int maxSize) {
        if (maxSize < 1) {
            throw new RuntimeException("can't create stack which size < 1");
        }
        top=-1;
        store = new int[maxSize];
        this.size = maxSize;
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("can't pop element because of stack is empty");
        }
        int result = store[top];
        store[top]=0;
        top--;
        return result;
    }

    @Override
    public void push(int addedElement) {
        if (isFull()) {
            throw new RuntimeException("can't push element into stack because of stack is full");
        } else {
            top++;
            store[top] = addedElement;
        }
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
            System.out.print("stack is [");
            int index = top;
            while (index > -1) {
                System.out.printf("%d, ", store[index]);
                index--;
            }
            System.out.print("] \n");
        }
    }
}
