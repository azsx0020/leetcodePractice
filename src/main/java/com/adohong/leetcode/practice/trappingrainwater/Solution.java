package com.adohong.leetcode.practice.trappingrainwater;

public class Solution {

    public int trap(int[] height) {
        if (height.length <= 1) return 0;
        int[] monoStack = new int[height.length];
        int stackSize = 0;
        int result = 0;
        int firstNotZeroHeightIndex = findFirstNotZeroHeightIndex(height);
        if (firstNotZeroHeightIndex == -1) {
            return 0;
        }
        while (stackSize == 0 || monoStack[stackSize - 1] < height.length - 1) {
            int startIndex = stackSize == 0 ? firstNotZeroHeightIndex + 1 : monoStack[stackSize - 1] + 1;
            for (int i = 0; i < height.length; i++) {
                monoStack[i] = -1;
            }
            stackSize = 0;
            for (int i = startIndex; i < height.length; i++) {
                if (stackSize == 0 || height[i] >= height[monoStack[stackSize - 1]]) {
                    monoStack[stackSize++] = i;

                }
            }
            result += calculateWater(monoStack, height, startIndex - 1, stackSize);
        }
        return result;

    }

    private int findFirstNotZeroHeightIndex(int[] height) {
        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    private int calculateWater(int[] monoStack, int[] nums, int startIndex, int stackSize) {
        int totalResult = 0;
        int warterLimit = Math.min(nums[startIndex], nums[monoStack[stackSize - 1]]);
        int start = startIndex + 1;
        for (int i = 0; i < stackSize; i++) {
            int result = 0;
            for (int j = start; j < monoStack[i]; j++) {
                if (nums[j] < warterLimit) {
                    result += warterLimit - nums[j];
                }
            }
            totalResult += result;
            start = monoStack[i];
            warterLimit = Math.max(warterLimit, nums[monoStack[i]]);
        }
        return totalResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int trap = solution.trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap);
    }
}
