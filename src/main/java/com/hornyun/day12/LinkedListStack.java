package com.hornyun.day12;

import com.hornyun.day11.Stack;

/**
 * @author hornyun
 * @date 2020/10/27 11:16 PM
 */
public class LinkedListStack implements Stack {

    private final LinkedList store;

    public LinkedListStack() {
        this.store = new LinkedList();
    }

    @Override
    public void push(int element) {
        store.add(new Element(element));
    }

    @Override
    public int pop() {
        try {
            Element element = store.removeLast();
            return element.getValue();
        } catch (Exception e) {
            throw new RuntimeException("stack is Empty");
        }
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        System.out.print("stack is [");
        Element element = store.getLast();
        while (true) {
            System.out.printf(" %d ", element.getValue());
            element = element.getPre();
            if (element == null) {
                break;
            }
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty() {
        return this.store.getLast() == null;
    }
}
