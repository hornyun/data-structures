package com.hornyun.day01;


import org.apache.commons.lang3.ArrayUtils;

/**
 * @author hornyun
 * @date 2020/10/15 11:38 下午
 * <p>
 * 稀疏组数的解压与压缩
 */
public class SparseArrayStructure {

    /**
     * 二维数组 转 稀疏数组
     *
     * @param source 转换数据源
     * @return 稀疏数组
     */
    private static int[][] transferSparseArray(int[][] source) {
        if (source != null && source.length > 0) {
            int sum = 0;
            for (int[] ints : source) {
                for (int anInt : ints) {
                    if (anInt != 0) {
                        sum++;
                    }
                }
            }

            int[][] result = new int[sum + 1][3];
            result[0][0] = source.length;
            result[0][1] = source[0].length;
            result[0][2] = sum;

            int count = 0;
            for (int i = 0; i < source.length; i++) {
                for (int j = 0; j < source[i].length; j++) {
                    if (source[i][j] != 0) {
                        count++;
                        result[count][0] = i;
                        result[count][1] = j;
                        result[count][2] = source[i][j];
                    }
                }
            }
            return result;
        }
        return null;
    }

    /**
     * decompress spares array
     *
     * @param source sparse array
     * @return origin array
     */
    private static int[][] parseSparseArray(int[][] source) {
        if (source != null && source.length > 0) {
            int[] returnStruct = source[0];
            int[][] returnData = new int[returnStruct[0]][returnStruct[1]];
            for (int i = 1; i < source.length; i++) {
                returnData[source[i][0]][source[i][1]] = source[i][2];
            }
            return returnData;

        }
        return null;
    }

    public static int[][] generateTest() {
        int[][] transferData = new int[11][11];
        transferData[1][2] = 1;
        transferData[2][3] = 2;
        return transferData;
    }

    public static void main(String[] args) {
        int[][] transferData = generateTest();
        int[][] sparseArray = transferSparseArray(transferData);
        String res = ArrayUtils.toString(sparseArray);
        System.out.println("原数组： " + ArrayUtils.toString(transferData));
        System.out.println();
        System.out.println();
        System.out.println("稀疏数组： " + res);
        System.out.println();
        System.out.println();
        System.out.println("还原数组： " + ArrayUtils.toString(parseSparseArray(sparseArray)));
    }

}
