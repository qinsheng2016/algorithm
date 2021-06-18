package com.sqin.algorithm.sort;

import java.util.Arrays;

/*
 * @Author Sheng Qin
 * @Description 使用二分法判断有序数组中某个数是否存在
 * @Date 16:59 2021/6/18
 **/
public class BSExist {

    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        if (sortedArr.length == 1) {
            return sortedArr[0] == num;
        }

        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;

        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] > num) {
                R = mid - 1;
            } else if (sortedArr[mid] < num) {
                L = mid + 1;
            } else {
                return true;
            }
        }
        return sortedArr[L] == num;
    }

    // for test
    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    // for test
    public static int[] generateSortedArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateSortedArr(maxSize, maxValue);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
