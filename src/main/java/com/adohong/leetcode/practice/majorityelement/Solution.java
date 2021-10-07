package com.adohong.leetcode.practice.majorityelement;

// Boyer-Moore 投票算法
// 摩尔投票算法
public class Solution {
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            //count = (num == candidate) ? count++ : count--; count 最后会是几？
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.majorityElement(new int[]{3,3,4});
        System.out.println(result);
    }
}
