package com.adohong.leetcode.practice.medianoftwosortedarrays;


// 如果nums1.size + nums2.size = m 为奇数，则中位数下标为m/2，如果为偶数，那么中位数为(nums[m/2 - 1] + nums[m/2])/2
// 以奇数为例：
//      k = m/2 + 1
//      在nums1中找k/2 - 1下标对应的数
//      在nums2中找k/2 - 1下标对应的数
//      那么min(nums1[k/2 - 1], nums2[k/2 - 1])，最多有k - 2个数比它小， 所以可以排除掉k/2个元素。
//      排除掉k/2个元素后，重新计算k
//      如果k/2 - 1 大于 nums1.length - 1, 则取nums1.length - 1
//      如果k == 1时，那么min(nums1[0], nums2[0])就是要找的数


public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        int k = (nums1.length + nums2.length) / 2;
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (findMthElelement(nums1, nums2, k) + findMthElelement(nums1, nums2, k + 1)) / 2.0;
        } else {
            return findMthElelement(nums1, nums2, k + 1);
        }
    }

    private int findMthElelement(int[] nums1, int[] nums2, int k) {
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }
            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            if (nums1[Math.min(index1 + k / 2 - 1, nums1.length - 1)] >= nums2[Math.min(index2 + k / 2 - 1, nums2.length - 1)]) {
                int oldIndex2 = index2;
                index2 = Math.min(index2 + k / 2, nums2.length);
                k -= (index2 - oldIndex2);
                continue;
            }
            if (nums2[Math.min(index2 + k / 2 - 1, nums2.length - 1)] > nums1[Math.min(index1 + k / 2 - 1, nums1.length - 1)]) {
                int oldIndex1 = index1;
                index1 = Math.min(index1 + k / 2, nums1.length);
                k -= (index1 - oldIndex1);
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[2];
        int[] nums2 = new int[2];
        nums1[0] = 0;
        nums1[1] = 0;
        nums2[0] = 0;
        nums2[1] = 0;
        Solution solution = new Solution();
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
