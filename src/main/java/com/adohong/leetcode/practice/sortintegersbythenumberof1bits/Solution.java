package com.adohong.leetcode.practice.sortintegersbythenumberof1bits;

import java.util.*;

class Solution {

    private int countBits(int n) {
        int count = 0;
        for (;n > 0;count++) {
            n &= (n - 1);
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();
        int[] resultInt = new int[arr.length];
        for (int j : arr) {
            resultMap.put(j, countBits(j));
        }
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            integers.add(arr[i]);
        }
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (!resultMap.get(o1).equals(resultMap.get(o2))) {
                    return resultMap.get(o1) - resultMap.get(o2);
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            resultInt[i] = integers.get(i);
        }
        return resultInt;
    }

    public static void main(String[] args) {
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        Solution solution = new Solution();
        solution.sortByBits(arr);
    }
}
