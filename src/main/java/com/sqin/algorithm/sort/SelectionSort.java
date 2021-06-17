package com.sqin.algorithm.sort;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 22:19 2021/6/17
 **/
public class SelectionSort {

    /**
     * 选择排序的流程
     * 从0 - N-1的位置，找出最小值，放到第0个位置
     * 从1 - N-1的位置，找出最小值，放到第1个位置
     * 一直到n = N-1
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }


        /*
         * 交换次数过多

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }*/
    }

    // 额外空间复杂度O(1)
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
