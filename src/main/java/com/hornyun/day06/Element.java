package com.hornyun.day06;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/21 10:47 下午
 */
@Data
public class Element {
    private int no;
    private String name;
    private Element pre;
    private Element next;

    public Element(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Element{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
