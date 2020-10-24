package com.hornyun.day09;

/**
 * @author hornyun
 * @date 2020/10/24 11:15 下午
 */
public class JosephuMain {
    /**
     * 产生n个孩的单行环形队列
     *
     * @param number account of boys
     * @return linked list of boys
     */
    public static SingleLinkedList getBoyList(int number) {
        if (number < 1) {
            System.out.printf("can't create boy list which size < %d \n", number);
            return null;
        } else {
            SingleLinkedList linkedList = new SingleLinkedList();
            for (int i = 1; i <= number; i++) {
                linkedList.addElement(new BoyElement(i));
            }
            return linkedList;
        }
    }

    public static void main(String[] args) {
        getOutedBoysNo(5, 1, 2);
    }

    /**
     * get outed boys nos
     *
     * @param size size of boys
     * @param k begin k
     * @param m walk m steps
     */
    public static void getOutedBoysNo(int size,int k,int m) {
        if (size < 1||k>size) {
            return;
        }
        SingleLinkedList boyList = getBoyList(size);

        assert boyList != null;

        System.out.print("the outed boys sequence is ");
        for (int i = 0; i < k - 1; i++) {
            if (boyList.getFirst() == boyList.getLast()) {
                int remove = boyList.remove();
                System.out.println(remove);
                return;
            } else {
                boyList.setFirst(boyList.getFirst().getNext());
                boyList.setLast(boyList.getLast().getNext());
            }
        }

        while (true) {
            for (int i = 0; i < m - 1; i++) {
                if (boyList.getFirst() == boyList.getLast()) {
                    int remove = boyList.remove();
                    System.out.printf("\t%d\n", remove);
                    return;
                } else {
                    boyList.setFirst(boyList.getFirst().getNext());
                    boyList.setLast(boyList.getLast().getNext());
                }
            }
            int remove = boyList.remove();
            System.out.printf("\t%d", remove);
        }
    }


}
