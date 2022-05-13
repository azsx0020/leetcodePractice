package com.adohong.leetcode.practice.mergesort;

import java.util.Arrays;

public class Solution {

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        // merge sorting on left
        sort(nums, left, mid);
        // merge sorting on left
        sort(nums, mid + 1, right);
        // do merge
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        // compare 2 numbers from right/left side, put smaller one to temp array
        while (p1 <= mid && p2 <= right) {
            temp[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        // put the rest numbers to temp array
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[i++] = nums[p2++];
        }
        // copy the result to the original array
        for (i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 47, 23, 7, 99, 125, 54, 2, 109, 78};
        mergeSort(array);

        System.out.println(Arrays.toString(array));
    }
}

