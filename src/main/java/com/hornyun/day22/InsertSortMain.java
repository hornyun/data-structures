package com.hornyun.day22;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hornyun
 * @date 2020/11/10 11:20 PM
 */
public class InsertSortMain {

    public static void main(String[] args) {
        int[] array = {12, 4, 6, 3};
        insertSort(array);
        System.out.println(Arrays.toString(array));

        Random random = new Random();
        int[] test = new int[80000];
        for (int i = 0; i < 80000; i++) {
            test[i] = random.nextInt(80000);
        }
        long l = System.currentTimeMillis();
        insertSort(test);
        System.out.println("cost time is " + (System.currentTimeMillis() - l));

    }

    /**
     * 插入排序
     *
     * @param sortArray the array needed sorting
     */
    public static void insertSort(int[] sortArray) {
        if (ArrayUtils.isNotEmpty(sortArray)) {
            int sortValue;
            int moveIndex;
            for (int i = 0; i < sortArray.length - 1; i++) {
                sortValue = sortArray[i + 1];
                moveIndex = i;
                while (moveIndex >= 0 && sortArray[moveIndex] > sortValue) {
                    sortArray[moveIndex + 1] = sortArray[moveIndex];
                    moveIndex--;
                }
                moveIndex++;
                if (moveIndex != i + 1) {
                    sortArray[moveIndex] = sortValue;
                }
            }
        }
    }
}
