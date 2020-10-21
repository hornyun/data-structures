package com.hornyun.day06;

import com.hornyun.day04.HeroElement;
import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/21 10:47 下午
 */
@Data
public class DoublyLinkedList {

    /**
     * 头节点，不存放数据,存放位置信息，实例化对象直接赋值
     */
    private Element head = new Element(0, "");


    /**
     * 添加元素
     *
     * @param element element
     */
    public void add(Element element) {

        Element index = this.head;
        while (index.getNext() != null) {
            index = index.getNext();
        }
        index.setNext(element);
        element.setPre(index);
        //清空element可能包含的下一个元素的位置信息。确保 element为双向链表的最后一个数据
        element.setNext(null);
    }

    /**
     * 根据元素的no删除链表中该元素
     *
     * @param no 元素编号
     */
    public void delete(int no) {
        Element index = this.head;
        while (index.getNext() != null) {
            if (index.getNext().getNo() == no) {
                Element next = index.getNext().getNext();
                Element deletedElement = index.getNext();

                index.setNext(next);
                next.setPre(index);

                deletedElement.setPre(null);
                deletedElement.setNext(null);

                System.out.printf("元素编号为[%d]已经删除\n", no);
                return;
            }
            index = index.getNext();
        }
        System.out.printf("链表中不存在元素编号为[%d]的元素\n", no);
    }

    public Element update(int no, String name) {
        Element index = this.head;
        while (index.getNext() != null) {
            if (index.getNext().getNo() == no) {
                String originName = index.getNext().getName();
                System.out.printf("元素编号为[%d]原名称[%s]修改为[%s]\n", no, originName, name);
                index.getNext().setName(name);
                return index.getNext();
            }
            index = index.getNext();
        }
        System.out.printf("链表中不存在元素编号为[%d]的元素\n", no);
        return null;
    }

    public Element find(int no) {
        Element index = this.head;
        while (index.getNext() != null) {
            if (index.getNext().getNo() == no) {
                return index.getNext();
            }
            index = index.getNext();
        }
        System.out.printf("链表中不存在元素编号为[%d]的元素\n", no);
        return null;
    }

    public String showAll() {
        Element index = this.head;
        StringBuilder result = new StringBuilder();
        while (index.getNext() != null) {
            result = result.append(index.getNext().toString()).append("\n");
            index = index.getNext();
        }
        return result.toString();
    }
    HeroElement heroElement1 = new HeroElement(1, "宋江", "及时雨");
    HeroElement heroElement2 = new HeroElement(2, "卢俊义", "玉麒麟");
    HeroElement heroElement3 = new HeroElement(3, "吴用", "智多星");
    HeroElement heroElement4 = new HeroElement(4, "公孙胜", "入云龙");
    HeroElement heroElement5 = new HeroElement(5, "林冲", "豹子头");

    public static void main(String[] args) {
        Element element1 = new Element(1,"宋江");
        Element element2 = new Element(2,"卢俊义");
        Element element3 = new Element(3,"吴用");
        Element element4 = new Element(4,"公孙胜");
        Element element5 = new Element(5,"林冲");

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
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
