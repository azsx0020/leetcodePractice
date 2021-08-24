package com.adohong.leetcode.practice.binarytreemaximumpathsum;

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
public class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        int leftMaxGain = 0;
        int rightMaxGain = 0;
        if (root.left != null) {
            leftMaxGain = Math.max(maxGain(root.left), 0);
        }
        if (root.right != null) {
            rightMaxGain = Math.max(maxGain(root.right), 0);
        }
        maxSum = Math.max(maxSum, Math.max(leftMaxGain, 0) + root.val + Math.max(rightMaxGain, 0));
        return root.val + Math.max(leftMaxGain, rightMaxGain);
    }
}
