package com.adohong.leetcode.practice.binarytreeinordertraversal;

import com.adohong.leetcode.practice.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            if (stack.peek().left != null) {
                stack.push(stack.peek().left);
            } else {
                TreeNode topTreeNode = stack.peek();
                result.add(topTreeNode.val);
                stack.pop();
                if (topTreeNode.right != null) {
                    stack.push(topTreeNode.right);
                } else {
                    while(!stack.empty()) {
                        TreeNode topTreeNode1 = stack.peek();
                        result.add(topTreeNode1.val);
                        stack.pop();
                        if (topTreeNode1.right != null) {
                            stack.push(topTreeNode1.right);
                            break;
                        }
                    }
                }
            }
        }
        return result;


    }
}