package com.hornyun.day07;

/**
 * @author hornyun
 * @date 2020/10/22 11:02 下午
 */
public class JosephuProblemMain {

    public static SingleLinkedList getSortedList(int size) {
        if (size >= 0) {
            SingleLinkedList result = new SingleLinkedList();
            for (int i = 1; i <= size; i++) {
                Element element = new Element(i);
                result.add(element);
            }
            return result;
        }
        return null;
    }

    /**
     * 设编号为1，2，3。。。。。。 n的n个人做成一圈，设定编号为（1<=k<=n)的人从1开始报数，数到m的那个人
     * 出列（杀掉），他的下一个位继续从1开始报数，数到m的那个人出列（杀掉）以此类推，直到所有人都出列
     * （penta kill）由此产生一个出队编号的序列。
     *
     * @param linkedList list
     * @param position k( 1<=k<=n)
     * @param sequence 序列
     * @param m m
     * @return 序列
     */
    public static String removeElement(SingleLinkedList linkedList, int position, int m,String sequence) {
        if (linkedList.getLength() != 0) {
            if (linkedList.getLength() > 1) {
                int i = (position+(m%linkedList.getLength()-1))%linkedList.getLength();
                i = i==0?linkedList.getLength():i;
                Element remove = linkedList.removeByIndex(i);
                sequence = sequence + "\t" + remove.getNo();
                if (linkedList.getLength() < i) {
                    position = 1;
                } else {
                    position = i;
                }
               return removeElement(linkedList, position, m, sequence);
            } else {
                return sequence + "\t" + linkedList.getHead().getNext().getNo();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        SingleLinkedList sortedList = getSortedList(5);
        String s = removeElement(sortedList, 2, 3, "");
        System.out.println(s);
    }
}
