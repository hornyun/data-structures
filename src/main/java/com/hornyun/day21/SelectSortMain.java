package com.hornyun.day21;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hornyun
 * @date 2020/11/9 11:27 PM
 */
public class SelectSortMain {
    public static void main(String[] args) {
        int[] arr = {6, 3, 4, 2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        Random random = new Random();
        int[] test = new int[80000];
        for (int i = 0; i < 80000; i++) {
            int i1 = random.nextInt(80000);
            test[i] = i1;
        }
        long l = System.currentTimeMillis();
        selectSort(test);
        System.out.println("costTime is " + (System.currentTimeMillis() - l));
    }

    public static void selectSort(int[] arr) {

        if (ArrayUtils.isNotEmpty(arr)) {
            int minIndex;
            int min;
            for (int i = 0; i < arr.length - 1; i++) {
                minIndex = i;
                min = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (min > arr[j]) {
                        minIndex = j;
                        min = arr[j];
                    }
                }
                if (minIndex != i) {
                    arr[minIndex] = arr[i];
                    arr[i] = min;
                }
            }
        }
    }
}
