package com.hornyun.day08;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/23 11:18 下午
 */
@Data
public class CircleSingleLinkedList {
    private Element head;

    private int length=0;

    public CircleSingleLinkedList(Element head) {
        if (head == null) {
            throw new RuntimeException("can't set null on head of CircleSingeLinkedList");
        }
        this.head = head;
        length++;
    }

    public void add(Element element) {
        Element index = head;
        while (index.getNext() != null && index.getNext().getNo() != head.getNo()) {
            index = index.getNext();
        }
        index.setNext(element);
        element.setNext(head);
        length++;
    }

    /**
     * remove index position element
     *
     * @param index index
     * @return removed element
     */
    public Element remove(int index){
        if (index < 1 || index > length) {
            throw new RuntimeException("can't not removed " + index + " index element,because list size is " + length);
        } else {
            if (index != 1) {
                for (int i = 1; i < index - 1; i++) {
                    head = head.getNext();
                }
                Element removedElement = head.getNext();
                head.setNext(removedElement.getNext());
                head = head.getNext();
                removedElement.setNext(null);
                length--;
                return removedElement;
            } else {
                Element indexElement = this.getHead();
                for(int i =0;i<this.getLength()-1;i++){
                    indexElement = indexElement.getNext();
                }
                if (length > 2) {
//                    indexElement.getNext().
                }
                return null;
            }

        }
    }

    public void showAll() {
        Element element = this.head;
        for (int i = 1; i <= length; i++) {
            System.out.printf("%d index element number is %d\n",i,element.getNo());
            element = element.getNext();
        }
    }
}
