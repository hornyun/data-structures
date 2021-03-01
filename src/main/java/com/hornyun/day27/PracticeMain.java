package com.hornyun.day27;

/**
 * @author hornyun
 * @date 2021/3/1 12:56 PM
 * 二叉树查找指定节点
 * 请分别使用三种遍历方式查找heroNo=5的节点（前、中、后序），并分析每种方式的查找次数
 */
public class PracticeMain {


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

        findHeroByPre(4, root);
        findHeroByMid(4, root);
        findHeroByLast(4, root);

    }

    public static HeroElement findHeroByPre(int heroNo, HeroElement hero) {
        if (hero != null) {
            System.out.println("前序比较");
            if (hero.getNo() == heroNo) {
                return hero;
            }
            if (hero.getLeft() != null) {
                HeroElement heroByPre = findHeroByPre(heroNo, hero.getLeft());
                if (heroByPre != null) {
                    return heroByPre;
                }
            }
            if (hero.getRight() != null) {
                HeroElement heroByPre = findHeroByPre(heroNo, hero.getRight());
                if (heroByPre != null) {
                    return heroByPre;
                }
            }
        }
        return null;
    }

    public static HeroElement findHeroByMid(int heroNo, HeroElement hero) {
        if (hero != null) {

            if (hero.getLeft() != null) {
                HeroElement heroByMid = findHeroByMid(heroNo, hero.getLeft());
                if (heroByMid != null) {
                    return heroByMid;
                }
            }
            System.out.println("中序比较");
            if (hero.getNo() == heroNo) {
                return hero;
            }
            if (hero.getRight() != null) {
                HeroElement heroByMid = findHeroByMid(heroNo, hero.getRight());
                if (heroByMid != null) {
                    return heroByMid;
                }
            }
        }
        return null;
    }
    public static HeroElement findHeroByLast(int heroNo, HeroElement hero) {
        if (hero != null) {
            if (hero.getLeft() != null) {
                HeroElement heroByLast = findHeroByLast(heroNo, hero.getLeft());
                if (heroByLast != null) {
                    return heroByLast;
                }
            }
            if (hero.getRight() != null) {
                HeroElement heroByLast = findHeroByLast(heroNo, hero.getRight());
                if (heroByLast != null) {
                    return heroByLast;
                }
            }
            System.out.println("后序比较");
            if (hero.getNo() == heroNo) {
                return hero;
            }
        }
        return null;
    }

}
