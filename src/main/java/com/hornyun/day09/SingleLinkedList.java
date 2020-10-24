package com.hornyun.day09;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/24 11:07 下午
 */
@Data
public class SingleLinkedList {

    private BoyElement first = null;

    private BoyElement last = null;

    public SingleLinkedList() {
    }

    public void addElement(BoyElement element) {
        if (first == null) {
            this.first = element;
            this.last = element;
        } else {
            if (first == last) {
                first.setNext(element);
                element.setNext(first);
                last = element;
            } else {
                last.setNext(element);
                last = element;
                element.setNext(first);
            }
        }
    }

    public void showAll() {
        if (first == null) {
            return;
        }
        if (first.getNext() == null) {
            System.out.println(first);
        } else {
            BoyElement index = first;
            while (true) {
                if (index.getNext() == first) {
                    System.out.println(index);
                    break;
                }
                System.out.println(index);
                index = index.getNext();
            }
        }
    }

    public int remove() {
        if (this.first == null) {
            throw new RuntimeException("the list is empty");
        } else if (this.first == this.last) {
            int no = this.first.getNo();
            this.first = null;
            this.last = null;
            return no;
        } else {
            BoyElement removed = this.first;
            if (removed.getNext() == this.getLast()) {
                removed.setNext(null);
                this.setFirst(this.last);
            } else {
                this.last.setNext(removed.getNext());
                this.first = this.last.getNext();
                removed.setNext(null);
            }
            return removed.getNo();
        }
    }
}
