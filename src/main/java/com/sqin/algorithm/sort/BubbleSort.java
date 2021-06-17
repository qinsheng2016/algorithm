package com.sqin.algorithm.sort;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 0:18 2021/6/18
 **/
public class BubbleSort {

    /**
     * 冒泡排序的流程
     * 从0 - N-1的位置，找到最大值，放到第N-1个位置
     * 从0 - N-2的位置，找出最小值，放到第N-2个位置
     * 一直到N-(N-1)
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[e] < arr[i]) {
                    swap(arr, e, i);
                }
            }
        }
    }

    // 额外空间复杂度O(1)
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
