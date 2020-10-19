package com.hornyun.day04;

/**
 * @author hornyun
 * @date 2020/10/20 12:06 上午
 */
public class SingleLinkedListMain {
    public static void main(String[] args) {
        HeroElement heroElement1 = new HeroElement(1,"宋江","及时雨");
        HeroElement heroElement2 = new HeroElement(2,"卢俊义","玉麒麟");
        HeroElement heroElement3 = new HeroElement(3,"吴用","智多星");
        HeroElement heroElement4 = new HeroElement(4,"公孙胜","入云龙");
        HeroElement heroElement5 = new HeroElement(5,"林冲","豹子头");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(heroElement1);
        linkedList.add(heroElement5);
        linkedList.add(heroElement3);
        linkedList.add(heroElement2);
        linkedList.add(heroElement4);
        linkedList.add(heroElement5);
        linkedList.showSingleLinkedList();
        linkedList.clear();


    }
}
