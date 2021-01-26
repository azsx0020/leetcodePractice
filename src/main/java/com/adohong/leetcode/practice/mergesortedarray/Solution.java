package com.adohong.leetcode.practice.mergesortedarray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0) return;
        List<Integer> result = new ArrayList<>();


        int i = 0;
        int j = 0;
        for (; result.size() < m + n && i < m && j < n;) {
            if (nums1[i] >= nums2[j]) {
                result.add(nums2[j]);
                j++;
            } else {
                result.add(nums1[i]);
                i++;
            }
        }
        if (result.size() != m + n) {
            if (i < m) {
                for (int k = i; k < m; k++) {
                    result.add(nums1[k]);
                }
            } else {
                for (int k = j; k < n; k++) {
                    result.add(nums2[k]);

                }
            }
        }
        for (int k = 0; k < result.size(); k++) {
            nums1[k] = result.get(k);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {0};
        solution.merge(nums1, 0, new int[]{1},1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
