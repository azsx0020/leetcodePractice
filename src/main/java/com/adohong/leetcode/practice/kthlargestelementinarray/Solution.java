package com.adohong.leetcode.practice.kthlargestelementinarray;

public class Solution {

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = start;
        int pivotValue = nums[pivot];
        for (int i = pivot, j = nums.length - 1; i < j; ) {
            if (i == pivot) {
                while (nums[j] >= pivotValue && i < j) {
                    j--;
                }
                if (i == j) {
                    break;
                }
                nums[pivot] = nums[j];
                pivot = j;
            } else {
                while (nums[i] < pivotValue && i < j) {
                    i++;
                }
                if (i == j) {
                    break;
                }
                nums[pivot] = nums[i];
                pivot = i;
            }
        }
        nums[pivot] = pivotValue;
        quickSort(nums, start, pivot);
        quickSort(nums, pivot + 1, end);
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int kthLargest = solution.findKthLargest(nums, 2);
        System.out.println(kthLargest);

    }
}
