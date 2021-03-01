package com.hornyun.day26;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/11/16 11:54 PM
 * <p>
 * 约瑟夫问题复习
 * 设编号为1，2，3。。。。。。 n的n个人做成一圈，设定编号为（1<=k<=n)的人从1开始报数，数到m的那个人
 * 出列（杀掉），他的下一个位继续从1开始报数，数到m的那个人出列（杀掉）以此类推，直到所有人都出列
 * 由此产生一个出队编号的序列。
 */
public class JosePhuMain {
    public static void main(String[] args) {
        josePhuProblem(5, 1, 2);
    }

    public static void josePhuProblem(int size, int k, int m) {
        CircleLinkedList<Integer> circleLinkedList = new CircleLinkedList<>();
        for (int i = 1; i <= size; i++) {
            circleLinkedList.add(new Element<>(i));
        }
        if (k > 0 && k < size) {
            circleLinkedList.changeHead(k);

            while (circleLinkedList.getHead() != null) {
                Element<Integer> element = circleLinkedList.removeByIndex(m);
                System.out.printf("%d\t", element.getData());
            }
        }
    }
}

@Data
class Element<T> {
    private T data;
    private Element<T> next;

    public Element(T data) {
        this.data = data;
    }
}

@Data
class CircleLinkedList<T> {
    private Element<T> head;


    public boolean isEmpty() {
        return head == null;
    }

    public void add(Element<T> element) {
        if (element == null) {
            throw new RuntimeException("can't add null in" + this.getClass().getSimpleName());
        }
        element.setNext(null);

        if (head == null) {
            head = element;
        } else {
            Element<T> index = head;
            if (index.getNext() == null) {
                index.setNext(element);
                element.setNext(index);
            } else {
                while (!index.getNext().equals(head)) {
                    index = index.getNext();
                }
                index.setNext(element);
                element.setNext(head);
            }
        }
    }

    public Element<T> removeByIndex(int index) {
        if (index <= 0) {
            throw new RuntimeException("can't remove " + index + " position element");
        }
        if (this.head == null) {
            throw new RuntimeException("circleLinkedList is Empty");
        }
        Element<T> result;
        if (this.head.getNext() == null) {
            result = this.head;
            this.head = null;
            return result;
        } else {
            Element<T> removedElement;
            if (index == 1) {
                Element<T> position = this.head;
                while (position.getNext() != this.head) {
                    position = position.getNext();
                }
                this.head =position;
                removedElement = this.head.getNext();
            } else {
                for (int i = 0; i < index - 1; i++) {
                    this.head = this.head.getNext();
                }
                removedElement = this.head.getNext();

            }
            if (removedElement.getNext() == this.head) {
                this.head.setNext(null);
            } else {
                this.head.setNext(removedElement.getNext());
                this.head = this.head.getNext();
                removedElement.setNext(null);
            }
            return removedElement;
        }
    }

    public void showAll() {
        Element<T> element = this.head;
        System.out.println("element show begin");
        if (element != null) {
            do {
                System.out.printf("%s \t", element.getData().toString());
                element = element.getNext();
            } while (element != null && element != head);
            System.out.println();
        }
        System.out.println("element show end");
    }

    public void changeHead(int step) {
        if (step <= 0) {
            throw new RuntimeException("can't run " + step + " step");
        }
        if (head != null) {
            if (head.getNext() != null) {
                for (int i = 0; i < step; i++) {
                    head = head.getNext();
                }
            }
        }
    }
}
