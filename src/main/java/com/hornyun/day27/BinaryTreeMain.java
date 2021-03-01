package com.hornyun.day27;

/**
 * @author hornyun
 * @date 2021/2/25 5:46 PM
 */
public class BinaryTreeMain {
    public static void main(String[] args) {
        HeroElement root = new HeroElement(1, "宋江");
        HeroElement element1 = new HeroElement(2, "卢俊义");
        HeroElement element2 = new HeroElement(3, "吴用");
        HeroElement element3 = new HeroElement(4, "林冲");
        HeroElement element4 = new HeroElement(5, "武松");

        root.setLeft(element1);
        root.setRight(element2);
        element2.setLeft(element3);
        element2.setRight(element4);

        HeroBinaryTree binaryTree = new HeroBinaryTree(root);

        binaryTree.prePrint();
        System.out.println("-------------------");
        binaryTree.midPrint();
        System.out.println("-------------------");
        binaryTree.lastPrint();
    }
}
