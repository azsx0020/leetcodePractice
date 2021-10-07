package com.adohong.leetcode.practice.missingranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            addResult(result, lower - 1, upper + 1);
            return result;
        }
        if (lower < nums[0]) {
            addResult(result, lower - 1, nums[0]);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) continue;
            addResult(result, nums[i], nums[i + 1]);
        }
        if (nums[nums.length - 1] < upper) {
            addResult(result, nums[nums.length - 1], upper + 1);
        }
        return result;
    }

    private void addResult(List<String> result, int num1, int num2) {
        String temp = null;
        if (num1 + 1 == num2- 1) {
            temp = String.valueOf(num1 + 1);
        } else {
            temp = String.valueOf(num1 + 1) + "->" + String.valueOf(num2 - 1);
        }
        result.add(temp);
    }

    // 这样是不行的，upper如果是1000000000，就会内存占用超过限制
//    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
//        List<String> result = new ArrayList<>();
//        boolean[] array = new boolean[upper - lower + 1];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = false;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= lower && nums[i] <= upper) {
//                array[nums[i] - lower] = true;
//            }
//        }
//        int startIndex = -1;
//        int endIndex = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == false) {
//                if (startIndex == -1) {
//                    startIndex = i;
//                    endIndex = i;
//                    if (i == array.length - 1) {
//                        String temp = startIndex == endIndex ? String.valueOf(startIndex + lower) : String.valueOf(startIndex + lower) + "->" + String.valueOf(endIndex + lower);
//                        result.add(temp);
//                        break;
//                    }
//                } else {
//                    endIndex = i;
//                    if (i == array.length - 1) {
//                        String temp = startIndex == endIndex ? String.valueOf(startIndex + lower) : String.valueOf(startIndex + lower) + "->" + String.valueOf(endIndex + lower);
//                        result.add(temp);
//                        break;
//                    }
//                }
//            } else {
//                if (startIndex != -1 && endIndex != -1) {
//                    String temp = startIndex == endIndex ? String.valueOf(startIndex + lower) : String.valueOf(startIndex + lower) + "->" + String.valueOf(endIndex + lower);
//                    result.add(temp);
//                    startIndex = -1;
//                    endIndex = -1;
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> missingRanges = solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
        for (int i = 0; i < missingRanges.size(); i++) {
            System.out.println(missingRanges.get(i));
        }
    }
}
