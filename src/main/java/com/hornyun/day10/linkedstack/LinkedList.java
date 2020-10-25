package com.hornyun.day10.linkedstack;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/25 11:38 下午
 */
@Data
public class LinkedList {
    private Element head;
    private Element last;

    public LinkedList() {
        this.head = new Element(null);
    }

    public void addElement(Element element) {
        if (this.last == null) {
            last = element;
            head.setNext(element);
            element.setPre(this.head);
        } else {
            element.setPre(this.last);
            this.last.setNext(element);
            this.last = element;
        }
    }

    public Element removeLast() {
        if (this.last == null) {
            return null;
        } else {
            Element pre = this.last.getPre();
            Element result = this.last;
            pre.setNext(null);
            this.last = pre;
            if (this.last.getValue() == null) {
                this.last=null;
            }
            return result;
        }
    }

}
