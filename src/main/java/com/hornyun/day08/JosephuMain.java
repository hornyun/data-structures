package com.hornyun.day08;

/**
 * @author hornyun
 * @date 2020/10/23 11:31 下午
 */
public class JosephuMain {

    public static Element takeElement(int no, CircleSingleLinkedList linkedList) {
       return linkedList.remove(no);
    }

    public static CircleSingleLinkedList generateList(int size) {
        if (size < 1) {
            return null;
        } else {
            CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList(new Element(1));
            for (int i = 2; i <= size; i++) {
                circleSingleLinkedList.add(new Element(i));
            }
            return circleSingleLinkedList;
        }
    }
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = generateList(5);
        circleSingleLinkedList.showAll();
        String sequence = getSequence(circleSingleLinkedList, 2, 3);
        System.out.println(sequence);
    }

    public static String getSequence(CircleSingleLinkedList linkedList, int k, int m) {
        for (int i = 1; i < k; i++) {
            linkedList.setHead(linkedList.getHead().getNext());
        }
        StringBuilder builder = new StringBuilder();

        while (linkedList.getLength() > 0) {
            int length = linkedList.getLength();
            int index = m;
            if (m > length) {
                index = m%length;
                index = index == 0 ? length : index;
            }
            builder.append(linkedList.remove(index)).append("\t");
        }

        return builder.toString();
    }
}
