package com.hornyun.day10.linkedstack;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/25 11:37 下午
 */
@Data
public class LinkedListStack {
    private LinkedList store;

    public boolean isEmpty() {
        return store.getLast()==null;
    }

    public LinkedListStack() {
        this.store = new LinkedList();
    }

    public void push(int element) {
        this.store.addElement(new Element(element));
    }

    public int pop() {
        Element element = this.store.removeLast();
        if (element == null) {
            throw new RuntimeException("stack is Empty");
        }
        return element.getValue();
    }

    public void showAll() {
        Element index = store.getLast();
        if (index == null) {
            System.out.println("stack is Empty");
            return;
        }
        while (true) {
            System.out.println(index.getValue());
            if (index.getPre() == null || index.getPre().getValue() == null) {
                break;
            } else {
                index = index.getPre();
            }
        }
    }
}

