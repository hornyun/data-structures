package com.hornyun.day27;

/**
 * @author hornyun
 * @date 2021/4/8 10:37 AM
 */
public class FeiBoMain {
    public static void main(String[] args) {
        int num = getNum(3);
        System.out.println(num);
    }

    public static int getNum(int n) {
        if (n ==1 || n==2) {
            return 1;
        }
        if(n>2) {
            return getNum(n - 1)+getNum(n-2);
        }
        return -1;
    }
}
