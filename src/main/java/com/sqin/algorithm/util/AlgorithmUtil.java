package com.sqin.algorithm.util;

/*
 * @Author Sheng Qin
 * @Description 算法工具类，用于swap, generate Array等等功能
 * @Date 21:46 2021/6/19
 **/
public class AlgorithmUtil {

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
            System.out.println();
        }
    }

}
