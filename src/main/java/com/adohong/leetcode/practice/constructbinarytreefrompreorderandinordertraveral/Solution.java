package com.adohong.leetcode.practice.constructbinarytreefrompreorderandinordertraveral;

import com.adohong.leetcode.practice.common.datastructure.TreeNode;
import sun.reflect.generics.tree.Tree;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        int rootIndex = 0;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        int[] preorderLeftSubTree = new int[rootIndex];
        for (int i = 0; i < rootIndex; i++) {
            preorderLeftSubTree[i] = preorder[i + 1];
        }
        int[] preorderRightSubTree = new int[preorder.length - 1 - rootIndex];
        for (int i = 0; i < preorder.length - rootIndex - 1; i++) {
            preorderRightSubTree[i] = preorder[i + rootIndex + 1];
        }
        int[] inorderLeftSubTree = new int[rootIndex];
        for (int i = 0; i < rootIndex; i++) {
            inorderLeftSubTree[i] = inorder[i];
        }
        int[] inorderRightSubTree = new int[preorder.length - 1 - rootIndex];
        for (int i = 0; i < inorder.length - rootIndex - 1; i++) {
            inorderRightSubTree[i] = inorder[i + rootIndex + 1];
        }
        root.left = buildTree(preorderLeftSubTree, inorderLeftSubTree);
        root.right = buildTree(preorderRightSubTree, inorderRightSubTree);
        return root;
    }
}