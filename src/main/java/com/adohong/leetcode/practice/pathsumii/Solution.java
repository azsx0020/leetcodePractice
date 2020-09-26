package com.adohong.leetcode.practice.pathsumii;

import com.adohong.leetcode.practice.common.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<PathSum> traversal(TreeNode root, int sum) {
        List<PathSum> pathSums = new ArrayList<>();
        if (root == null) {
            return pathSums;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            pathSums.add(new PathSum(path, sum));
            return pathSums;
        }
        pathSums.addAll(traversal(root.left, sum - root.val));
        pathSums.addAll(traversal(root.right, sum - root.val));

        for(PathSum pathSum : pathSums) {
            pathSum.path.add(0, root.val);
            pathSum.sum = sum;
        }

        return pathSums;
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<PathSum> pathSums = traversal(root, sum);
        List<List<Integer>> rets = new ArrayList<>();
        for(PathSum pathSum : pathSums) {
            rets.add(pathSum.path);
        }
        return rets;
    }
}

class PathSum {
    List<Integer> path;
    Integer sum;

    public PathSum(List path, Integer sum) {
        this.sum = sum;
        this.path = path;
    }
}
