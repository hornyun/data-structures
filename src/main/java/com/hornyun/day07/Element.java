package com.hornyun.day07;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/22 10:36 下午
 */
@Data
public class Element {
    private Integer no;
    private Element next;

    public Element(Integer no) {
        this.no = no;
    }
}
