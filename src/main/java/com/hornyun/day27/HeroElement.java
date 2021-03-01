package com.hornyun.day27;

import lombok.Data;

/**
 * @author hornyun
 * @date 2021/2/25 5:47 PM
 */
@Data
public class HeroElement {
    private int no;
    private String name;
    private HeroElement left;
    private HeroElement right;

    public HeroElement(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroElement{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preIterate() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preIterate();
        }
        if (this.right != null) {
            this.right.preIterate();
        }
    }

    public void midIterate() {
        if (this.left != null) {
            this.left.midIterate();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midIterate();
        }
    }

    public void lastIterate() {
        if (this.left != null) {
            this.left.lastIterate();
        }
        if (this.right != null) {
            this.right.lastIterate();
        }
        System.out.println(this);
    }


}
