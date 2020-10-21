package com.hornyun.day05;

import com.hornyun.day04.HeroElement;
import com.hornyun.day04.SingleLinkedList;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hornyun
 * @date 2020/10/20 11:17 下午
 */
public class PracticeSingleLinkedListMain {
    /**
     * problem1: 求链表中有效数据的个数
     */
    public static int getLinkedListSize(SingleLinkedList linkedList) {
        HeroElement index = linkedList.getHead();
        int length = 0;
        while (index.getNext() != null) {
            length++;
            index = index.getNext();
        }
        return length;
    }

    /**
     * 查找单链表中倒数第k个节点
     * 思路：遍历链表求出链表长度l，然后取出l-k 个元素，即为结果
     *
     * @param reverseIndex 倒数第k个节点
     * @return 节点元素
     */
    public static HeroElement getHeroElementByReverseIndex(SingleLinkedList linkedList, int reverseIndex) {
        HeroElement result = null;
        if (linkedList != null) {
            HeroElement index = linkedList.getHead();
            int size = getLinkedListSize(linkedList);
            if (reverseIndex > 0 && reverseIndex <= size) {
                for (int i = 0; i <= size - reverseIndex; i++) {
                    index = index.getNext();
                }
                result = index;
            }
        }
        return result;
    }

    /**
     * 问题三 反转列表 ？？ 存在问题
     *
     * @param linkedList
     * @return
     */
    public static SingleLinkedList reverseLinkedList(SingleLinkedList linkedList) {
        int linkedListSize = getLinkedListSize(linkedList);
        if (linkedListSize > 1) {
            SingleLinkedList result = new SingleLinkedList();
            HeroElement index = linkedList.getHead();
            while (index.getNext() != null) {
                HeroElement element = copyHeroElement(index.getNext());
                if (result.getHead().getNext() == null) {
                    result.getHead().setNext((element));
                } else {
                    HeroElement first =  result.getHead().getNext();
                    result.getHead().setNext(element);
                    element.setNext(first);
                }
                index = index.getNext();
            }
            return result;
        } else {
            return linkedList;
        }
    }

    public static HeroElement copyHeroElement(HeroElement element) {
        return new HeroElement(element.getNo(), element.getName(), element.getNickname());
    }

    /**
     * 从尾巴到头打印链表
     *
     * @param
     */
    public static String reversePrintLinkedList(HeroElement element,String message) {
        if (element.getNext() != null) {
            if (StringUtils.isNoneBlank(message)) {
                message = element.toString() + " " + message;
            }else{
                message = element.toString();
            }
            return reversePrintLinkedList(element.getNext(), message);
        }else{
            return element.toString()+" "+message;
        }
    }

//    private static String print(HeroElement element,String elementInfo) {
//        if (element.getNext() != null) {
//            element = element.getNext();
//            return print(element,elementInfo);
//        } else {
//            return element.toString()+" "+elementInfo;
//        }
//    }

    public static void main(String[] args) {

        SingleLinkedList linkedList = generateList();
        linkedList.showSingleLinkedList();
//        int linkedListSize = getLinkedListSize(generateList());
//        System.out.printf("get size is %d\n", linkedListSize);

//
//        HeroElement heroElementByReverseIndex = getHeroElementByReverseIndex(linkedList, 2);
//        linkedList.showSingleLinkedList();
//        System.out.printf("get reverse [%d] element is %s\n",2,heroElementByReverseIndex.toString());

//        linkedList.showSingleLinkedList();
//        System.out.println("----------分隔符------------");
//        SingleLinkedList reverseLinkedList = reverseLinkedList(linkedList);
//        reverseLinkedList.showSingleLinkedList();

        String print = reversePrintLinkedList(linkedList.getHead().getNext(), null);
        System.out.println(print);
    }

    /**
     * 快速生产一个链表
     *
     * @return
     */
    public static SingleLinkedList generateList() {
        SingleLinkedList result = new SingleLinkedList();
        HeroElement heroElement1 = new HeroElement(1, "宋江", "及时雨");
        HeroElement heroElement2 = new HeroElement(2, "卢俊义", "玉麒麟");
        HeroElement heroElement3 = new HeroElement(3, "吴用", "智多星");
        HeroElement heroElement4 = new HeroElement(4, "公孙胜", "入云龙");
        HeroElement heroElement5 = new HeroElement(5, "林冲", "豹子头");
        result.add(heroElement1);
        result.add(heroElement2);
        result.add(heroElement3);
        result.add(heroElement4);
        result.add(heroElement5);
        return result;
    }
}
