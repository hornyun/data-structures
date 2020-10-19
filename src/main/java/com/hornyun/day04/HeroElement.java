package com.hornyun.day04;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/19 11:43 下午
 */
@Data
public class HeroElement {

    private int no;
    private String name;
    private String nickname;
    private HeroElement next;

    public HeroElement(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroElement{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
