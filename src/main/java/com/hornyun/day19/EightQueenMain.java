package com.hornyun.day19;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/11/3 11:31 PM
 */
@Data
public class EightQueenMain {

    private final int maxSize = 8;
    private final int[] outcome = new int[maxSize];
    private int count=0;
    private int checkTimes = 0;

    public void check(int n) {
        if (n == maxSize) {
            count++;
            print();
        } else {
            for (int i = 0; i < maxSize; i++) {
                outcome[n] = i;
                if (judge(n)) {
                    check(n + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        EightQueenMain eightQueenMain = new EightQueenMain();
        eightQueenMain.check(0);
        System.out.println("total solution counts: " + eightQueenMain.getCount());
        System.out.println("total execute judgement: " + eightQueenMain.getCheckTimes());
    }

    public void print() {
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("%d ", outcome[i]);
        }
        System.out.println();
    }

    public boolean judge(int n) {
        checkTimes++;
        for (int i = 0; i < n; i++) {
            if (outcome[i] == outcome[n] || Math.abs(i - n) == Math.abs(outcome[i] - outcome[n])) {
                return false;
            }
        }
        return true;
    }

}
