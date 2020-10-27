package com.hornyun.day12;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/27 11:18 PM
 */
@Data
public class LinkedList {
    private Element last;

    public LinkedList() {
    }

    public void add(Element element) {
        if (element == null) {
            return;
        }
        if (last == null) {
            last = element;
            element.setPre(null);
        }else{
            element.setPre(last);
            last = element;
        }
    }

    public Element removeLast() {
        Element last = this.last;
        if (last == null) {
            throw new RuntimeException("Linked list is empty");
        } else {
            this.last = last.getPre();
            last.setPre(null);
            return last;
        }
    }
}
