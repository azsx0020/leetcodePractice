package com.adohong.leetcode.practice.largestnumber;

public class Solution {
    public String largestNumber(int[] nums) {
        String result = "";
        sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            result += String.valueOf(nums[i]);
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0' && i != result.length() - 1) {
                result = result.replaceFirst("0", "");
                i--;
            } else {
                break;
            }
        }
        return result;
    }

    public void sort(int[] nums, int start, int end) {
        if (start == end || start > end) return;
        int pivot = start;
        int i = start;
        int j = end;
        while(i < j) {
            if (i != pivot) {
                while (compare(nums[i], nums[pivot]) >= 0 && i < j) {
                    i++;
                }
                if (compare(nums[i], nums[pivot]) < 0) {
                    int temp = nums[pivot];
                    nums[pivot] = nums[i];
                    nums[i] = temp;
                    pivot = i;
                }

            } else {
                while (compare(nums[j], nums[pivot]) < 0) {
                    j--;
                }
                int temp = nums[pivot];
                nums[pivot] = nums[j];
                nums[j] = temp;
                pivot = j;
            }
        }
        sort(nums, start, pivot - 1);
        sort(nums, pivot + 1, end);
    }

    private int compare(int a, int b) {
        long sa = 10;
        while (a >= sa) {
            sa *=10;
        }
        long sb = 10;
        while(b >= sb) {
            sb *=10;
        }
        long ra = a * sb + b;
        long rb = b * sa + a;
        if (ra > rb) return 1;
        if (ra == rb) return 0;
        return -1;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{111311,1113};
        String result = solution.largestNumber(nums);
        System.out.println(result);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
