package com.hornyun.day04;

/**
 * @author hornyun
 * @date 2020/10/19 11:45 下午
 */
public class SingleLinkedList {

    private final HeroElement head = new HeroElement(0, "", "");

    public HeroElement getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public void add(HeroElement element) {
        if (element != null) {
            //清空节点元素可能包含的链表结构
            element.setNext(null);

            HeroElement next = head;
            boolean flag = false;
            while (true) {
                if (next.getNext() == null) {
                    break;
                }

                //完成练习题，去掉按号入座的排序功能
                else if (next.getNext().getNo() > element.getNo()) {
                    flag = true;
                    break;
                }
                else if (next.getNext().getNo() == element.getNo()) {
                    System.out.printf("[%s]好汉已经添加\n", element.getNickname());
                    break;
                } else {
                    next = next.getNext();
                }
            }

            if (flag) {
                element.setNext(next.getNext());
                next.setNext(element);
            } else {
                next.setNext(element);
            }
        }
    }

    public void clear() {
        this.head.setNext(null);
    }

    public void delete(int no) {
        HeroElement element = head;
        boolean flag = true;
        while (true) {
            if (element.getNext() == null) {
                System.out.printf("列表中不存在[%d]号好汉\n", no);
                break;
            } else if (element.getNext().getNo() == no) {
                HeroElement next = element.getNext();
                if (element.getNext().getNext() != null) {
                    element.setNext(next.getNext());
                } else {
                    element.setNext(null);
                }
                next.setNext(null);
                break;
            } else {
                element = element.getNext();
            }
        }
    }

    public void update(HeroElement hero) {
        HeroElement element = head;
        while (true) {
            if (element.getNext() == null) {
                break;
            } else if (element.getNext().getNo() == hero.getNo()) {
                element.getNext().setName(hero.getName());
                element.getNext().setNickname(hero.getNickname());
                break;
            } else {
                element = element.getNext();
            }
        }
    }

    public HeroElement find(int no) {
        HeroElement index = head;

        while (true) {
            if (index.getNext() == null) {
                System.out.println("单向链表中并不存在该元素");
                return null;
            } else if (index.getNext().getNo() == no) {
                return index.getNext();
            } else {
                index = index.getNext();
            }
        }
    }

    public void showSingleLinkedList() {
        HeroElement index = head;
        while (true) {
            if (index.getNext() == null) {
                break;
            } else {
                System.out.println(index.getNext());
                index = index.getNext();
            }
        }
    }
}
