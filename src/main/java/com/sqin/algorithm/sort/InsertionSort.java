package com.sqin.algorithm.sort;

/*
 * @Author Sheng Qin
 * @Description 插入排序
 * @Date 0:26 2021/6/18
 **/
public class InsertionSort {

    /**
     * 插入排序的流程
     * 确定0 - 1位置的排序
     * 确定0 - 2位置的排序
     * 确定0 - N-1位置的排序
     *
     * @param arr
     */
    public static void sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }


    // 额外空间复杂度0
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
