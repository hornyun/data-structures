package com.hornyun.day24;

import com.hornyun.day23.ShellSortMain;

/**
 * @author hornyun
 * @date 2020/11/13 11:50 PM
 */
public class QuickSortMain {
    public static void main(String[] args) {
        int[] test = ShellSortMain.generateArray(80000);
        long begin = System.currentTimeMillis();
        quickSort(test, 0, test.length - 1);
        long costTime = System.currentTimeMillis() - begin;
        System.out.println("QuickSort cost time is : " + costTime + " for eighty thousands record");
    }

    /**
     * 快速排序
     *
     * @param array sort array
     * @param start left index of array
     * @param end   right index of array
     */
    public static void quickSort(int[] array, int start, int end) {
        int pivot = array[start];
        int left = start;
        int right = end;

        while (left < right) {
            //如果left小于right 且 坐标right的值大于初始值pivot 则right--
            while (left < right && array[right] > pivot) {
                right--;
            }
            //同理，只是第一次排列的时候 因为pivot的初始值即为arrary[left]所以第一次必定不会进入该循环。
            while (left < right && array[left] < pivot) {
                left++;
            }
            //假设 arr[left] = 5 arr[right]=5 pivot=5 .left =3 .right =7 。如果不判断arr[left]=arr[right],该排序则会进入死循环
            if (array[left] == array[right] && left < right) {
                left++;
            } else {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        //此时 left == right 跳出循环 并作为锚点 进行下一次左右循环
        //因为left此时为锚点，所以左循环需要 从坐标start 到 left-1 进行quick sort 如果left - 1 =start 则没有进入左循环的必要
        if (left - 1 > start) {
            quickSort(array, start, left - 1);
        }

        //同理
        if (right+1 < end) {
            quickSort(array, right + 1, end);
        }

    }

}
