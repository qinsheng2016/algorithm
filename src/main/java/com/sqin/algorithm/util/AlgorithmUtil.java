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
        }
    }

    /**
     * 随机生成一个数组，最大长度为maxLength，值在[-maxValue, maxValue]之间
     *
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxLength, int maxValue) {
        int length = (int) (Math.random() * (maxLength + 1));
        int arr[] = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    /**
     * 拷贝一个一模一样的数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int arr[]) {
        if (arr == null) {
            return null;
        }
        int copyArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

}
