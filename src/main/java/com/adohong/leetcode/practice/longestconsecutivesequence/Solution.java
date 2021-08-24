package com.adohong.leetcode.practice.longestconsecutivesequence;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!numsSet.contains(nums[i] - 1)) {
                int numsStart = nums[i];
                int tempLengh = 0;
                while(numsSet.contains(numsStart)) {
                    tempLengh ++;
                    numsStart ++;
                }
                maxLength = Math.max(maxLength, tempLengh);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        System.out.println(result);
    }

    /*
     * 这样做法不行，空间复杂度会很大，占用的空间大小会取决与nums数组中最大的元素。比如，nums为[1, 2, 99999999]，那么也会占用99999999个位的空间。
     * 不满足要求的，会超过内存使用限制的。
     */
//    public int longestConsecutive(int[] nums) {
//        if (nums.length == 0) return 0;
//        int minValue = Integer.MAX_VALUE;
//        int maxValue = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < minValue) {
//                minValue = nums[i];
//            }
//            if (nums[i] > maxValue) {
//                maxValue = nums[i];
//            }
//        }
//        int baseOffset = 0;
//        if (minValue < 0) {
//            baseOffset = Math.abs(minValue);
//        }
//
//        BitSet resultArray = new BitSet(maxValue - Math.min(0, minValue) + 1);
//        for (int i = 0; i < nums.length; i++) {
//            if (resultArray.get(nums[i] + baseOffset) == false) {
//                resultArray.set(nums[i] + baseOffset, true);
//            }
//        }
//        int currentMark = 0;
//        int start = 0;
//        int end = 0;
//        int maxLength = 0;
//        int tempLength = 0;
//
//        for (int i = 0; i < maxValue - Math.min(0, minValue) + 1; i++) {
//            if (currentMark == 0 && resultArray.get(i)) {
//                start = i;
//                end = i;
//                currentMark = 1;
//                tempLength = 0;
//                if (i == maxValue - Math.min(0, minValue)) {
//                    maxLength = Math.max(maxLength, 1);
//                }
//                continue;
//            }
//            if (currentMark == 1 && resultArray.get(i)) {
//                end = i;
//                if (i == maxValue - Math.min(0, minValue)) {
//                    tempLength = end - start + 1;
//                    maxLength = Math.max(maxLength, tempLength);
//                    currentMark = 0;
//                }
//                continue;
//            }
//            if (currentMark == 1 && (!resultArray.get(i))) {
//                tempLength = end - start + 1;
//                maxLength = Math.max(maxLength, tempLength);
//                currentMark = 0;
//                continue;
//            }
//        }
//        return maxLength;
//    }
}
