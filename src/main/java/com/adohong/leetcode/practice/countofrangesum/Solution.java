package com.adohong.leetcode.practice.countofrangesum;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0 || nums == null || lower > upper) {
            return 0;
        }
        long[] numsSum = calculateSum(nums);
        return countRangeRecursive(numsSum, 0, nums.length - 1, lower, upper);

    }

    private long[] calculateSum(int[] nums) {
        long[] result = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = nums[i];
            } else {
                result[i] = result[i - 1] + nums[i];
            }
        }
        return result;
    }

    private int countRangeRecursive(long[] numsSum, int start, int end, int lower, int upper) {
        int count = 0;
        if (start == end) {
            if (numsSum[start] >= lower && numsSum[start] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = start + (end - start) / 2;

        count += countRangeRecursive(numsSum, start, mid, lower, upper);
        count += countRangeRecursive(numsSum, mid + 1, end, lower, upper);
        count += merge(numsSum, start, end, mid, lower, upper);
        return count;
    }

    private int merge(long[] numsSum, int start, int end, int mid, int lower, int upper) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        long[] result = new long[end - start + 1];
        int index = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (numsSum[leftIndex] <= numsSum[rightIndex]) {
                result[index++] = numsSum[leftIndex];
                leftIndex++;
            } else {
                result[index++] = numsSum[rightIndex];
                rightIndex++;
            }
        }
        if (leftIndex == mid + 1) {
            for (; rightIndex <= end;) {
                result[index++] = numsSum[rightIndex++];
            }
        } else if (rightIndex == end + 1) {
            for (; leftIndex <= mid;) {
                result[index++] = numsSum[leftIndex++];
            }
        }
        int count = 0;
        int windowStart = start;
        int windowEnd = start;
        for (int i = mid + 1; i <= end; i++) {
            long min = numsSum[i] - upper;
            long max = numsSum[i] - lower;
            while(windowEnd <= mid + 1 && numsSum[windowEnd] <= max) {
                windowEnd++;
            }
            while(windowStart <= mid + 1 && numsSum[windowStart] < min) {
                windowStart++;
            }
            count += windowEnd - windowStart;
        }
        for (int i = start; i <= end; i++) {
            numsSum[i] = result[i - start];
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647}, -564, 3864);
        System.out.println(result);
    }
}
