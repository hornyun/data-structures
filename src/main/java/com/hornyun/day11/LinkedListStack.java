package com.hornyun.day11;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/26 11:06 PM
 */
@Data
public class LinkedListStack implements Stack{
    private LinkedList store;

    public LinkedListStack() {
        this.store = new LinkedList();
    }

    @Override
    public void push(int value) {
        this.store.addElement(new Element(value));
    }

    @Override
    public int pop() {
        Element element = this.store.removeLast();
        if (element == null) {
            throw new RuntimeException("can't pop element from empty stack");
        } else {
            return element.getValue();
        }

    }

    public static void main(String[] args) {
        System.out.println((int)'9');
    }

    @Override
    public void show() {
        if (store.getIndex() == null) {
            System.out.println("stack is Empty");
        } else {
            Element index = store.getIndex();
            System.out.print("stack is [");
            while (true) {
                System.out.printf("%d, ", index.getValue());
                index = index.getPre();
                if (index == null) {
                    break;
                }
            }
            System.out.print("]\n");
        }

    }

    @Override
    public boolean isEmpty() {
        return store.getIndex() == null;
    }
}
