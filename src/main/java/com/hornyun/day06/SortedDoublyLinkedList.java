package com.hornyun.day06;

import com.hornyun.day04.HeroElement;
import lombok.Data;

/**
 *
 * 重载方法add 实现双向链表按顺序添加
 * @author hornyun
 * @date 2020/10/21 10:47 下午
 */
@Data
public class SortedDoublyLinkedList extends DoublyLinkedList {
    /**
     * 添加元素
     *
     * @param element element
     */
    @Override
    public void add(Element element) {

        Element index = this.getHead();
        while (index.getNext() != null) {
            if (index.getNext().getNo() > element.getNo()) {

                index.getNext().setPre(element);
                element.setNext(index.getNext());

                index.setNext(element);
                element.setPre(index);
                return;
            }
            index = index.getNext();
        }
        index.setNext(element);
        element.setPre(index);
        //清空element可能包含的下一个元素的位置信息。确保 element为双向链表的最后一个数据
        element.setNext(null);

    }


    public static void main(String[] args) {
        Element element1 = new Element(1, "宋江");
        Element element2 = new Element(2, "卢俊义");
        Element element3 = new Element(3, "吴用");
        Element element4 = new Element(4, "公孙胜");
        Element element5 = new Element(5, "林冲");

        SortedDoublyLinkedList doublyLinkedList = new SortedDoublyLinkedList();
        doublyLinkedList.add(element1);
        doublyLinkedList.add(element3);
        doublyLinkedList.add(element4);
        doublyLinkedList.add(element2);
        doublyLinkedList.add(element5);
        System.out.println("----add----\n" + doublyLinkedList.showAll());

        doublyLinkedList.delete(1);
        doublyLinkedList.delete(1);
        doublyLinkedList.delete(1);
        System.out.println("----remove----\n" + doublyLinkedList.showAll());

        doublyLinkedList.update(1, "idle");
        doublyLinkedList.update(2, "鸡你太美");

        System.out.println("----update----\n" + doublyLinkedList.showAll());

        System.out.println("----find----\n" + doublyLinkedList.find(1));
        System.out.println("----find----\n" + doublyLinkedList.find(2));

    }
}
