package com.hornyun.day07;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/22 10:36 下午
 */
@Data
public class SingleLinkedList {

    /**
     * 头节点，无数据域
     */
    private Element head = new Element(null);

    /**
     * 链表长度
     */
    private int length = 0;

    /**
     * 设置一个单链表的添加方法，该方法只能添加元素到尾部
     *
     * @param element
     */
    public void add(Element element) {
        if (element != null) {
            element.setNext(null);
            Element index = head;
            while (index.getNext() != null) {
                index = index.getNext();
            }
            index.setNext(element);
            length++;
        }
    }

    /**
     *
     * @param no
     *
     * @return removed element
     */
    public Element remove(int no) {
        if (length > 0) {
            Element index = this.head;
            while (index.getNext() != null) {
                if (index.getNext().getNo() == no) {
                    Element remove = index.getNext();
                    index.setNext(remove.getNext());
                    length--;
                    return remove;
                }
                index = index.getNext();
            }
        }
        return null;
    }

    /**
     *
     * @param position position
     *
     * @return removed element
     */
    public Element removeByIndex(int position) {
        if (position > 0 && position <= length) {

            Element index = this.head;
            for (int i = 0; i < position-1; i++) {
                index = index.getNext();
            }

            Element removedElement = index.getNext();

            if (removedElement.getNext() != null) {
                index.setNext(removedElement.getNext());
                removedElement.setNext(null);
            } else {
                index.setNext(null);
            }
            length--;
            return removedElement;
        }
        return null;
    }

}
