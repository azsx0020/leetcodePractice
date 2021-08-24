package com.adohong.leetcode.practice.validatebinarysearchtree;

import com.adohong.leetcode.practice.common.datastructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        int[] result = valid(root);
        return result[0] <= result[1];
    }

    private int[] valid(TreeNode root) {
        int[] minMaxleft = null;
        int[] minMaxRight = null;
        if (root.left != null) {
            minMaxleft = valid(root.left);
        }
        if (root.right != null) {
            minMaxRight = valid(root.right);
        }
        if ((minMaxleft != null && minMaxleft[0] > minMaxleft[1]) || (minMaxRight != null && minMaxRight[0] > minMaxRight[1])) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        if ((minMaxleft == null || minMaxleft[1] < root.val) && ( minMaxRight == null || minMaxRight[0] > root.val)) {
            return new int[]{minMaxleft == null ? root.val : minMaxleft[0], minMaxRight == null ? root.val : minMaxRight[1]};
        } else {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
    }
}
