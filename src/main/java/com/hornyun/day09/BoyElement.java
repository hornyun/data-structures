package com.hornyun.day09;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/24 11:05 下午
 */
@Data
public class BoyElement {
    private int no;

    private BoyElement next;

    public BoyElement(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "BoyElement{" +
                "no=" + no +
                '}';
    }
}
