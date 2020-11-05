package com.hornyun.day20;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

/**
 * @author hornyun
 * 冒泡排序
 * @date 2020/11/5 11:54 PM
 */
public class BubbleSortMain {
    public static void bubbleSort(int[] array) {
        if (ArrayUtils.isNotEmpty(array)) {
            int temp = 0;
            boolean flag = true;
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        flag = false;
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
                if (flag) {
                    break;
                } else {
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6};
        System.out.println(ArrayUtils.toString(arr));
        bubbleSort(arr);
        System.out.println(ArrayUtils.toString(arr));

        int[] test = new int[80000];
        Random random = new Random();
        for (int i = 0; i < test.length; i++) {
            test[i] = random.nextInt(80000);
        }
        long l = System.currentTimeMillis();
        bubbleSort(test);
        System.out.println("cost time is " + (System.currentTimeMillis() - l));

    }


}
