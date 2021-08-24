package com.adohong.leetcode.practice.binarytreelevelordertraversal;

import com.adohong.leetcode.practice.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        while(!queue.isEmpty()) {
            if (currentLevelCount > 0) {
                TreeNode temp = queue.poll();
                if (result.size() == currentLevel) {
                    result.add(new ArrayList<>());
                }
                result.get(currentLevel).add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                    nextLevelCount++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    nextLevelCount++;
                }
                currentLevelCount--;
            } else {
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                currentLevel++;
            }
        }
        return result;
    }
}
