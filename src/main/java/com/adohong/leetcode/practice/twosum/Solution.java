package com.adohong.leetcode.practice.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        List<Integer> retList = new ArrayList<Integer>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < numsList.size(); i++) {
            int firstElement = numsList.get(i);
            retList.add(firstElement);
            Integer secondElement = findSum(numsList.subList(i + 1, numsList.size()), target - firstElement);
            if (null != secondElement) {
                retList.add(i + secondElement + 1);
                return retList.stream().mapToInt(integer->integer).toArray();
            } else {
                retList.clear();
            }
        }
        return new int[2];
    }

    private Integer findSum(List<Integer> nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return nums.indexOf(num);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 4};
        Solution solution = new Solution();
        solution.twoSum(input, 6);
    }
}
