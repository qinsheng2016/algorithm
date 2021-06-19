package com.sqin.algorithm.eor;

import com.sqin.algorithm.util.AlgorithmUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * @Author Sheng Qin
 * @Description 在一个数组中，找出唯一一个出现K次的数字，其他数字均出现M次，其中K<M
 * @Date 11:44 2021/6/19
 **/
public class KM {

    public static int onlyKTimes(int arr[], int k, int m) {
        int t[] = new int[32]; // 32位的空数组
        int a = 1;
        for (int i = 0; i < arr.length; i++) {
            // 将i数字，换成32位的，分别与32个位置上的1进行与运算，如果结果是1，说明这个位置上的数字为1，在t[]的这个位置上+1
            // arr[i]: 00000000000101010011010101100101
            // a@1 :   00000000000000000000000000000001
            // a@2 :   00000000000000000000000000000010
            // 进行与运算，如果
            for (int j = 0; j < 32; j++) {
                if ((arr[i] & (a << j)) == (a << j)) {
                    t[j]++;
                }
            }
        }
        int ans = 0;
        int b = 1;
        // 经过以上运算，在32位的int数组中，可以获得大概为[....................10, 25, 17]这样的数组。
        for (int x = 0; x < 32; x++) {
            if (t[x] % m != 0) {
                ans |= (b << x);
            }
        }
        return ans;
    }

    public static int[] generateRandomArray(int k, int m) {
        // 总共有几种数字，随机生成，最少为2种数字
        int kinds = (int) (Math.random() * 10) + 2;

        // 数组总长度为k次 + 剩余种类(kinds-1) * m次
        int arr[] = new int[k + (kinds - 1) * m];

        // 定义一个HashSet，用来存储已经存放的数字，以防重复加入相同的数字
        Set set = new HashSet<>();
        // 出现的k次的数字，随机产生出来，在[-range - range]
        int kTimesNum = randomNumber(100);
        set.add(kTimesNum);
        kinds--;
        // 给数组填值
        int index = 0;
        for (; index < k; index++) {
            arr[index] = kTimesNum;
        }
        // 给其他数字填值
        while (kinds != 0) {
            int mTimesNum;
            do {
                mTimesNum = randomNumber(100);
            } while (set.contains(mTimesNum));
            set.add(mTimesNum);
            kinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = mTimesNum;
            }
        }
        // 打乱数组中的元素顺序
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * (arr.length));
            AlgorithmUtil.swap(arr, i, j);
        }
        return arr;
    }

    public static int randomNumber(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }

    public static void main(String[] args) {

        System.out.println("Start");
        for (int i = 0; i < 100000; i++) {
            int a = (int) (Math.random() * 9) + 1; // a 是1-9
            int b = (int) (Math.random() * 9) + 1; // b 是1-9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k == m) {
                m++;
            }
            int arr[] = generateRandomArray(k, m);
            int ans = onlyKTimes(arr, k, m);
            int ans2 = test(arr, k, m);
            if (ans != ans2) {
                System.out.println("Error");
            }
        }
        System.out.println("Succeed");
    }

    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

}
