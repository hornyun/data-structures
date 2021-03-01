package com.hornyun.day27;

import lombok.Data;

/**
 * @author hornyun
 * @date 2021/2/25 5:48 PM
 */
@Data
public class HeroBinaryTree {
    private HeroElement root;

    public HeroBinaryTree(HeroElement root) {
        this.root = root;
    }

    public void prePrint() {
        if (this.root != null) {
            root.preIterate();
        }
    }
    public void midPrint() {
        if (this.root != null) {
            root.midIterate();
        }
    }
    public void lastPrint() {
        if (this.root != null) {
            root.lastIterate();
        }
    }
}
