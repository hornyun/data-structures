package com.hornyun.day12;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/27 11:18 PM
 */
@Data
public class Element {
    private Integer value;
    private Element pre;

    public Element(Integer value) {
        this.value = value;
    }
}
