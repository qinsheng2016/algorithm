package com.sqin.algorithm.eor;

/*
 * @Author Sheng Qin
 * @Description 在一个数组中，找出出现奇数次的数字
 * @Date 0:49 2021/6/19
 **/
public class EvenTimesOddTimes {

    /**
     * @param arr
     * @Description 找出唯一一个奇数次的数
     */
    public static void printOddTimesNum(int arr[]) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        System.out.println(eor);
    }

    /**
     * @param arr
     * @Description 找出2个出现奇数次的数
     */
    public static void printOddTimesNums(int arr[]) {
        int eor = 0;
        // 如果有2个数字a,b出现奇数次，eor = a ^ b
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        // 获得a ^ b得到的结果中，最后边的一个数字1，在这个位置上，a, b肯定是不同的。要么0和1，要么1和0
        // eor最右侧的1，提取出来
        // eor :     0000001010010100
        // rightOne: 0000000000000100
        // -eor == ((~eor) + 1) 取反加1
        int rightOne = eor & (-eor);

        int eor2 = 0;
        // 将数组中的数字分成两部分
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                eor2 ^= arr[i];
            }
        }
        System.out.println(eor2);
        System.out.println(eor ^ eor2);

    }

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 2, 3, 5, 3, 1, 5, 5, 4, 5, 4, 5, 5};
        printOddTimesNum(arr1);

        int[] arr2 = {3, 3, 2, 2, 3, 5, 3, 5, 1, 5, 5, 4, 5, 4, 5, 5};
        printOddTimesNums(arr2);
    }

}
