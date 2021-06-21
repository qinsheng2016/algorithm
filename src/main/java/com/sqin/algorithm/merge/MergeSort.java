package com.sqin.algorithm.merge;

/*
 * @Author Sheng Qin
 * @Description 归并排序
 * @Date 17:43 2021/6/21
 **/
public class MergeSort {

    /**
     * 用递归方式实现归并排序
     *
     * @param arr
     */
    public static void sort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 根据递归时间复杂度公式：O(N * logN)
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int arr[], int L, int R) {
        if (L < R) {
            int M = L + ((R - L) >> 1);
            process(arr, L, M);
            process(arr, M + 1, R);
            merge(arr, L, M, R);
        }
    }

    /**
     * 将已经排序的2部分merge起来
     *
     * @param arr
     * @param L
     * @param M
     * @param R
     */
    public static void merge(int arr[], int L, int M, int R) {
        int help[] = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
