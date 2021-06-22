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

    /**
     * 归并排序，使用迭代的方式
     *
     * @param arr
     */
    public static void mergeSort2(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mergeSize = 1;
        int N = arr.length;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int M = mergeSize + L - 1;
                // 左组已经不够了，增加步长进行下一步。
                if (M >= N) {
                    break;
                }
                // 右组不够，R = N - 1, 右组够，R = mergeSize + M
                int R = Math.min(mergeSize + M, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }

            // 防溢出，防止mergeSize超过整数最大值的一半
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }
}
