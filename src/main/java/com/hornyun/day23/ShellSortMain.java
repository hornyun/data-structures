package com.hornyun.day23;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hornyun
 * @date 2020/11/12 10:42 PM
 */
public class ShellSortMain {


    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
        long before = System.currentTimeMillis();
        shellSort2(generateArray(80000));
        System.out.println("cost time is " + (System.currentTimeMillis() - before));
    }

    public static int[] generateArray(int size) {
        Random random = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(80000);
        }
        return result;
    }

    public static void shellSort1(int[] array) {
        if (ArrayUtils.isNotEmpty(array)) {
            int temp;
            int divider = 2;
            for (int interval = array.length / divider; interval > 0; interval /= divider) {
                for (int i = interval; i < array.length; i++) {
                    for (int j = i - interval; j >= 0; j -= interval) {
                        if (array[j] > array[j + interval]) {
                            temp = array[j];
                            array[j] = array[j + interval];
                            array[j + interval] = temp;
                        }
                    }
                }
            }
        }
    }

    public static void shellSort2(int[] array) {
        if (ArrayUtils.isNotEmpty(array)) {
            int divider = 2;
            for (int interval = array.length / divider; interval > 0; interval /= divider) {
                for (int i = interval; i < array.length; i++) {
                    int index = i;
                    int temp = array[index];

                    while (index - interval >= 0 && temp < array[index - interval]) {
                        array[index] = array[index - interval];
                        index -= interval;
                    }
                    array[index] = temp;
                }
            }
        }
    }
}
