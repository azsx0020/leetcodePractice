package com.adohong.leetcode.practice.threesumclosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDistance = Integer.MAX_VALUE;
        int result = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int newTarget = target - nums[i];
            int k = nums.length - 1;
            for (int j = i + 1; j < k;) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < minDistance) {
                    minDistance = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    result = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] - target > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] - target == 0) {
                    return nums[i] + nums[j] + nums[k];
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.threeSumClosest(new int[]{0, 1, 2}, 3);
        System.out.println(result);
    }

}
