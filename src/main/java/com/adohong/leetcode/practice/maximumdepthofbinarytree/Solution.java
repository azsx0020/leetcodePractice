package com.adohong.leetcode.practice.maximumdepthofbinarytree;

import com.adohong.leetcode.practice.common.datastructure.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return traverseTree(root);
    }

    private int traverseTree(TreeNode root) {
        if (root == null) return 0;
        int levelRight = traverseTree(root.right);
        int levelLeft = traverseTree(root.left);
        return Math.max(levelLeft, levelRight) + 1;
    }
}
