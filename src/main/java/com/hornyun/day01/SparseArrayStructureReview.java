package com.hornyun.day01;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author hornyun
 * @date 2021/4/25 9:58 PM
 */
public class SparseArrayStructureReview {
    public static int[][] compressArray(int[][] origin) {
        if (origin == null || origin.length == 0) {
            throw new IllegalArgumentException("method param is incorrect");
        }
        int xLength = origin.length;
        int yLength = origin[0].length;
        int distinct = 0;
        for (int[] ints : origin) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    distinct++;
                }
            }
        }
        int[][] result = new int[distinct + 1][3];

        result[0][0] = xLength;
        result[0][1] = yLength;
        result[0][2] = distinct;

        int index = 1;
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[i].length; j++) {
                if (origin[i][j] != 0) {
                    result[index][0] = i;
                    result[index][1] = j;
                    result[index][2] = origin[i][j];
                    index++;
                }
            }
        }
        return result;
    }

    public static int[][] decompressArray(int[][] origin) {
        if (origin == null || origin.length == 0) {
            throw new IllegalArgumentException("can't depress empty array");
        }

        int[][] result = new int[origin[0][0]][origin[0][1]];

        for (int i = 1; i < origin.length; i++) {
            result[origin[i][0]][origin[i][1]] = origin[i][2];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = SparseArrayStructure.generateTest();
        System.out.printf("origin array is %s \n", ArrayUtils.toString(ints));
        int[][] compressArray = compressArray(ints);
        System.out.printf("compress array is %s \n", ArrayUtils.toString(compressArray));
        int[][] origin = decompressArray(compressArray);
        System.out.printf("origin array is %s \n", ArrayUtils.toString(origin));

    }
}
