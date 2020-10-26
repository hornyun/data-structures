package com.hornyun.day11;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/26 11:00 PM
 */
@Data
public class Element {
    private int value;

    private Element pre;

    public Element(int value) {
        this.value = value;
    }
}
