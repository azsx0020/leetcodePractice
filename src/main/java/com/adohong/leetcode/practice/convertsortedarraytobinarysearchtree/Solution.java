package com.adohong.leetcode.practice.convertsortedarraytobinarysearchtree;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int rootIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        int[] leftSubTree = new int[rootIndex];
        int[] rightSubTree = new int[nums.length - 1 - rootIndex];
        for (int i = 0; i < rootIndex; i++) {
            leftSubTree[i] = nums[i];
        }
        for (int i = 0; i < nums.length - 1 - rootIndex; i++) {
            rightSubTree[i] = nums[rootIndex + i + 1];
        }
        root.left = sortedArrayToBST(leftSubTree);
        root.right = sortedArrayToBST(rightSubTree);
        return root;
    }
}
