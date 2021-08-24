package com.adohong.leetcode.practice.symmetrictree;

import com.adohong.leetcode.practice.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isTreeNodeValEqual(root, root);
    }

    private boolean isTreeNodeValEqual(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        if (root1 == null && root2 == null) return true;
        return root1.val == root2.val && isTreeNodeValEqual(root1.right, root2.left) && isTreeNodeValEqual(root1.left, root2.right);
    }

}
