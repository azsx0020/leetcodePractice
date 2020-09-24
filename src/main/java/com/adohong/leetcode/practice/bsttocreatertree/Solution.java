package com.adohong.leetcode.practice.bsttocreatertree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Vex> buildVexes(TreeNode treeNode) {
        Vex vex = new Vex();
        vex.number = treeNode.val;
        vex.treeNode = treeNode;
        List<Vex> vexes = new ArrayList<>();
        vexes.add(vex);
        if (treeNode.left != null) {
            vexes.addAll(buildVexes(treeNode.left));
        }
        if (treeNode.right != null) {
            vexes.addAll(buildVexes(treeNode.right));
        }
        return vexes;
    }

    private int sumBeforeNode(TreeNode treeNode, List<Vex> vexes) {
        int sum = treeNode.val;
        for (Vex vex : vexes) {
            if (vex.treeNode.val > treeNode.val) {
                sum += vex.treeNode.val;
            }
        }
        return sum;
    }

    private TreeNode buildCreaterTree(TreeNode treeNode) {
        if (treeNode == null) return  treeNode;
        List<Vex> vexes = buildVexes(treeNode);
        vexes.forEach(vex -> vex.number = sumBeforeNode(vex.treeNode, vexes));
        vexes.forEach(vex -> vex.treeNode.val = vex.number);
        return treeNode;
    }

    public TreeNode convertBST(TreeNode root) {
        return buildCreaterTree(root);
    }

}

class Vex {

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    TreeNode treeNode;
    int number;
}


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
