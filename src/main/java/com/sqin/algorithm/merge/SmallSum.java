package com.sqin.algorithm.merge;

import com.sqin.algorithm.util.AlgorithmUtil;

/*
 * @Author Sheng Qin
 * @Description 求一个数组的小和
 * @Date 21:54 2021/6/22
 **/
public class SmallSum {

    public static int getSmallSum(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int arr[], int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr, L, M) +
                process(arr, M + 1, R) +
                merge(arr, L, M, R);
    }

    /**
     * 归并排序的merge过程中，将小和相加。
     *
     * @param arr
     * @param L
     * @param M
     * @param R
     * @return
     */
    public static int merge(int arr[], int L, int M, int R) {
        int help[] = new int[R - L + 1];
        int i1 = L;
        int i2 = M + 1;
        int index = 0;
        int sum = 0;
        while (i1 <= M && i2 <= R) {
            sum += arr[i1] < arr[i2] ? (R - i2 + 1) * arr[i1] : 0;
            // 相同值的时候，先放右边，以防漏算
            help[index++] = arr[i1] < arr[i2] ? arr[i1++] : arr[i2++];
        }
        while (i1 <= M) {
            help[index++] = arr[i1++];
        }
        while (i2 <= R) {
            help[index++] = arr[i2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L++] = help[i];
        }
        return sum;
    }

    public static int testSmallSum(int arr[]) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    sum += arr[j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxLength = 100;
        int maxValue = 100;
        for (int i = 0; i < testTime; i++) {
            int arr1[] = AlgorithmUtil.generateRandomArray(maxLength, maxValue);
            int arr2[] = AlgorithmUtil.copyArray(arr1);
            int sum1 = getSmallSum(arr1);
            int sum2 = testSmallSum(arr2);
            if(sum1 != sum2){
                System.out.println("Error!");
            }
        }
        System.out.println("Nice!");
    }

}
