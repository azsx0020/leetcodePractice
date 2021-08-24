package com.adohong.leetcode.practice.sortcolors;

// 一次遍历，双指针
public class Solution2 {
    public void sortColors(int[] nums) {
        int pointerZero = 0;
        int pointerOne = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (nums[pointerZero] != 0) {
                    nums[pointerZero] = nums[pointerZero] ^ nums[i];
                    nums[i] = nums[pointerZero] ^ nums[i];
                    nums[pointerZero] = nums[pointerZero] ^ nums[i];
                }
                if (pointerOne > pointerZero && nums[i] == 1 && nums[pointerOne] != 1) {
                    nums[pointerOne] = nums[pointerOne] ^ nums[i];
                    nums[i] = nums[pointerOne] ^ nums[i];
                    nums[pointerOne] = nums[pointerOne] ^ nums[i];
                }
                pointerZero++;
                pointerOne++;
            } else if (nums[i] == 1) {
                if (nums[pointerOne] != 1) {
                    nums[pointerOne] = nums[pointerOne] ^ nums[i];
                    nums[i] = nums[pointerOne] ^ nums[i];
                    nums[pointerOne] = nums[pointerOne] ^ nums[i];
                }
                pointerOne++;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = new int[]{1, 0};
        solution2.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
//        1 0
//        1 0 p0 = 0, p1 = 1
//        0 1 p0 = 0, p1 = 1
//        0 1 p0 = 1, p1 = 2

//        1 2 0
//        1 2 0 p0 = 0, p1 = 1
//        0 2 1 p0 = 1, p1 = 1
//        0 1 2 p0 = 1, p1 = 2


//        2 0 2 1 1 0
//        0 2 2 1 1 0
//        0 1 2 2 1 0 p0 = 1 p1 = 2
//        0 1 1 2 2 0 p0 = 1 p1 = 3
//        0 0 1 2 2 1 p0 = 2 p1 = 4
    }
}
