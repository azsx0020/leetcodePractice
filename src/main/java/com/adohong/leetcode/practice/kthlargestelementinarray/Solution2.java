package com.adohong.leetcode.practice.kthlargestelementinarray;


public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        buildHeap(nums);
        return getKthLargestElement(nums, k);
    }

    private int getKthLargestElement(int[] nums, int k) {
        int limit = nums.length;
        for (int i = 0; i < k - 1; i++) {
            nums[0] = nums[limit - 1];
            limit--;
            adjust(nums, 0, limit);

        }
        return nums[0];

    }

    private void buildHeap(int[] nums) {

        int start = nums.length / 2 - 1;
        for (int i = start; i >= 0; i--) {
            adjust(nums, i, nums.length);
        }

    }

    private void adjust(int[] nums, int i, int limit) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2 > limit - 1 ? -1 : 2 * i + 2;

        int max = nums[leftChild] > nums[i] ? leftChild : i;
        max = rightChild != -1 && nums[rightChild] > nums[max] ? rightChild : max;
        int temp = nums[i];
        nums[i] = nums[max];
        nums[max] = temp;
        if (max != i && max <= limit / 2 - 1) {
            adjust(nums, max, limit);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int kthLargest = solution.findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }



}
