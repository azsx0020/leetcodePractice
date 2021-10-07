package com.adohong.leetcode.practice.maximumproductsubarray;


// 动态规划，思路好想出来，细节处理比较麻烦
public class Solution {
    public int maxProduct(int[] nums) {
        int[] minProduct = new int[nums.length];
        int[] maxPorduct = new int[nums.length];
        if (nums[0] >= 0) {
            maxPorduct[0] = nums[0];
            minProduct[0] = Integer.MIN_VALUE;
        } else {
            minProduct[0] = nums[0];
            maxPorduct[0] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxPorduct[i] = maxPorduct[i - 1] == Integer.MIN_VALUE ? nums[i] : Math.max(maxPorduct[i - 1] * nums[i], nums[i]);
                minProduct[i] = minProduct[i - 1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : minProduct[i - 1] * nums[i];
            } else {
                maxPorduct[i] = minProduct[i - 1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : minProduct[i - 1] * nums[i];
                minProduct[i] = maxPorduct[i - 1] == Integer.MIN_VALUE ? nums[i] : Math.min(maxPorduct[i - 1] * nums[i], nums[i]);
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (minProduct[i] > result) {
                result = minProduct[i];
            }
            if (maxPorduct[i] > result) {
                result = maxPorduct[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxProduct(new int[]{2,3,-2,4});
        System.out.println(result);
    }
}
