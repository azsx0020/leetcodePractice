package com.adohong.leetcode.practice.createmaximumnumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(nums1.length, k);
        int[] result = new int[]{};

        for (int i = start, j = k - start; i <= end; i++, j--) {
            int[] monotoneStack1 = monotoneStack(nums1, i);
            int[] monotoneStack2 = monotoneStack(nums2, j);

            int[] mergedMonotoneStack = mergeMonotoneStack(monotoneStack1, monotoneStack2);

            if (compare(mergedMonotoneStack, 0, result, 0) > 0) {
                result = mergedMonotoneStack;
            }
        }

        return result;
    }

    private int calculateValue(int[] nums) {
        int result = 0;
        int base = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result += nums[i] * base;
            base *= 10;
        }
        return result;
    }

    private int[] mergeMonotoneStack(int[] monotoneStack1, int[] monotoneStack2) {
        if (monotoneStack1 == null || monotoneStack2 == null) {
            return monotoneStack1 == null ? monotoneStack2 : monotoneStack1;
        }
        int[] result = new int[monotoneStack1.length + monotoneStack2.length];
        int i = 0, j = 0, k = 0;
        for (; i < monotoneStack1.length && j < monotoneStack2.length; k++) {
            if (compare(monotoneStack1, i, monotoneStack2, j) > 0) {
                result[k] = monotoneStack1[i];
                i++;
            } else {
                result[k] = monotoneStack2[j];
                j++;
            }
        }
        if (i < monotoneStack1.length) {
            for (; i < monotoneStack1.length; i++, k++) {
                result[k] = monotoneStack1[i];
            }
        }
        if (j < monotoneStack2.length) {
            for (; j < monotoneStack2.length; j++, k++) {
                result[k] = monotoneStack2[j];
            }
        }
        return result;
    }

    // 看看
    private int compare(int[] monotoneStack1, int i, int[] monotoneStack2, int j) {
        int index1 = i;
        int index2 = j;
        while (index1 < monotoneStack1.length && index2 < monotoneStack2.length) {
            if (monotoneStack1[index1] != monotoneStack2[index2]) {
                return monotoneStack1[index1] - monotoneStack2[index2];
            }
            index1++;
            index2++;
        }
        return monotoneStack1.length - index1 - monotoneStack2.length + index2;

    }

    // remain变量很重要
    private int[] monotoneStack(int[] nums, int n) {
        if (n == 0) {
            return null;
        }
        int remain = nums.length - n;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i != 0 && resultList.size() > 0 && resultList.get(resultList.size() - 1) < nums[i] && remain > 0) {
                resultList.remove(resultList.size() - 1);
                remain--;
            }
            if (resultList.size() < n) {
                resultList.add(nums[i]);
            } else {
                remain--;
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.maxNumber(new int[]{8,0,4,4,1,7,3,6,5,9,3,6,6,0,2,5,1,7,7,7,8,7,1,4,4,5,4,8,7,6,2,2,9,4,7,5,6,2,2,8,4,6,0,4,7,8,9,1,7,0}, new int[]{6,9,8,1,1,5,7,3,1,3,3,4,9,2,8,0,6,9,3,3,7,8,3,4,2,4,7,4,5,7,7,2,5,6,3,6,7,0,3,5,3,2,8,1,6,6,1,0,8,4}, 50);
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
    }
}
