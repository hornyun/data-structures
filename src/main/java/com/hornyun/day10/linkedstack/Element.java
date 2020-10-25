package com.hornyun.day10.linkedstack;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/25 11:37 下午
 */
@Data
public class Element {
    private Integer value;
    private Element next;
    private Element pre;

    public Element(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value=" + value +
                '}';
    }
}
