package com.adohong.leetcode.practice.shuzuzhongdenixudui;

public class Solution {

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return 0;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start == end) return;
        int mid = (end - start) / 2 + start;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, mid, start, end);
    }

    private void merge(int[] nums, int mid, int start, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        int indexLeft = 0, indexRight = 0;
        for (int i = start; i <= end; i++) {
            if (i <= mid) {
                left[indexLeft++] = nums[i];
            } else {
                right[indexRight++] = nums[i];
            }
        }
        int indexLeftForMerge = 0;
        int indexRightForMerge = 0;
        int indexForResult = 0;
        while (indexLeftForMerge < indexLeft && indexRightForMerge < indexRight) {
            if (left[indexLeftForMerge] < right[indexRightForMerge]) {
                nums[start + (indexForResult++)] = right[indexRightForMerge++];
            } else {
                nums[start + (indexForResult++)] = left[indexLeftForMerge++];
            }
        }
        if (indexLeftForMerge == indexLeft) {
            for (int i = indexRightForMerge; i < indexRight; i++) {
                nums[start + (indexForResult++)] = right[i];
            }
        }

        if (indexRightForMerge == indexRight) {
            for (int i = indexLeftForMerge; i < indexLeft; i++) {
                nums[start + (indexForResult++)] = left[i];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reversePairs(new int[]{1,6,3,7,9,4,2});
    }
}
