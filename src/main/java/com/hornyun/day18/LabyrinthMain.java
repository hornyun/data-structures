package com.hornyun.day18;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author hornyun
 * @date 2020/11/2 11:43 PM
 */
public class LabyrinthMain {
    public static void main(String[] args) {
        int[][] ints = generateLabyrinth();
        arrayToString(ints);
        step(ints, 1, 1);
        arrayToString(ints);
    }

    /**
     * create Labyrinth
     * 1 represent wall
     * 0 represent pass
     *
     * @return labyrinth
     */
    public static int[][] generateLabyrinth() {
        int[][] result = new int[8][7];
        for (int i = 0; i < 8; i++) {
            result[i][0]=1;
            result[i][6]=1;
        }
        for (int i = 0; i < 7; i++) {
            result[0][i] = 1;
            result[7][i] = 1;
        }

        result[3][1] = 1;
        result[3][2] = 1;

        return result;
    }

    public static void arrayToString(int[][] array) {
        if (ArrayUtils.isNotEmpty(array)) {
            for (int[] ints : array) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.printf(" %d ", ints[j]);
                }
                System.out.println();
            }
        }
    }
    /**
     * Labyrinth problem
     *
     * @param map map
     * @param i row
     * @param j column
     * @return boolean of can pass
     */
    public static boolean step(int[][] map, int i, int j) {
        if (i==6&&j==5) {
            map[i][j] = 2;
            return true;
        } else if(map[i][j]==0) {
            map[i][j]=2;
            if (step(map, i + 1, j)) {
                return true;
            } else if (step(map, i,j+1)) {
                return true;
            } else if (step(map, i - 1, j)) {
                return true;
            } else if (step(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else{
            return false;
        }
    }
}
