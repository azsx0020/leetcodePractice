package com.adohong.leetcode.practice.invertbinarytree;

import com.adohong.leetcode.practice.common.datastructure.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.invertTree()
    }
}
