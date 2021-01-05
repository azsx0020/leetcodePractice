package com.adohong.leetcode.practice.maximumgap;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int[] lsdRadixSort(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        int base = 1;
        while(max >= base) {
            lists.forEach(list -> list.clear());
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < numsList.size(); i++) {
                    int digit = numsList.get(i) / base % 10;
                    lists.get(digit).add(numsList.get(i));
            }
            for (int i = 0; i < 10; i ++) {
                if (lists.get(i).size() > 0) {
                    tempList.addAll(lists.get(i));
                }
            }
            numsList = tempList;

            base = base * 10;


        }
        int[] result = new int[nums.length];
        for (int i = 0; i < numsList.size(); i++) {
            result[i] = numsList.get(i);
        }
        return result;
    }

    public int maximumGap(int[] nums) {
        int[] result = lsdRadixSort(nums);
        int maxGap = 0;
        for (int i = 0; i < result.length - 1; i++) {
            int gap = result[i + 1] - result[i];
            if (gap > maxGap) {
                maxGap = gap;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10000000};
        Solution solution = new Solution();
        int maximumGap = solution.maximumGap(nums);
        System.out.println(maximumGap);
    }
}
