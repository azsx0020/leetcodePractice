package com.adohong.leetcode.practice.sortarraybyparityii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                listA.add(A[i]);
            } else {
                listB.add(A[i]);
            }
        }
        int[] result = new int[A.length];
        for (int i = 0, j = 0, k = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                result[i] = listA.get(j++);
            } else {
                result[i] = listB.get(k++);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        Solution solution = new Solution();
        int[] result = solution.sortArrayByParityII(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(result[i]);
        }
    }
}
