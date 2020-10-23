package com.hornyun.day08;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/23 11:18 下午
 */
@Data
public class Element {
    private int no;

    private Element next;

    public Element(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Element{" +
                "no=" + no +
                '}';
    }
}
