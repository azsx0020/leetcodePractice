package com.adohong.leetcode.practice.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    results.add(result);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> results = solution.threeSum(new int[]{-1,0,1,2,-1,-4});
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j));
                if (j != results.get(i).size() - 1) {
                    System.out.print(", ");
                } else {
                    System.out.println();
                }
            }
        }
    }
}
