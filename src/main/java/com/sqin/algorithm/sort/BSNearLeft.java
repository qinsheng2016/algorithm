package com.sqin.algorithm.sort;

import java.util.Arrays;

/*
 * @Author Sheng Qin
 * @Description 使用二分法，在有序数组中，找到大于等于某一个值的最左位置
 * @Date 21:01 2021/6/18
 **/
public class BSNearLeft {

    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1; // 记录最左的index

        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else if (arr[mid] < value) {
                L = mid + 1;
            }
        }
        return index;
    }

    // for test
    public static int test(int[] sortedArr, int value) {
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] >= value) {
                return i;
            }
        }
        return -1;
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
            if (test(arr, value) != nearestIndex(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }

}
