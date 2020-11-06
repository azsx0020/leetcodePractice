package com.adohong.leetcode.practice.twosum;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (nums[i] >= target && nums[i] != 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (a + b == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
