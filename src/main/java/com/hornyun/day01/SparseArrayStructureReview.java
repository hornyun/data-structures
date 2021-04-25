package com.hornyun.day01;

/**
 * @author hornyun
 * @date 2021/4/25 9:58 PM
 */
public class SparseArrayStructureReview {
    /**
     * 稀疏数组的应用场景：棋盘的压缩，节约存储空间
     */
    public static int[][] compressArray(int[][] array) {
        if (array != null && array.length > 0) {
            //记录元素的多少
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] != 0) {
                        count++;
                    }
                }
            }
            //确认稀疏数组第一行 0=长 1=宽 2=元素数量
            int[][] result = new int[count + 1][3];
            result[0][0] = array.length;
            result[0][1] = array[0].length;
            result[0][2] = count;
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] != 0) {
                        index++;
                        result[index][0] = i;
                        result[index][1] = j;
                        result[index][2] = array[i][j];

                    }
                }
            }
            return result;

        }
        return null;
    }
}
