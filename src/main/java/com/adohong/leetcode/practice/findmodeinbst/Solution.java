package com.adohong.leetcode.practice.findmodeinbst;

import com.adohong.leetcode.practice.common.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

    private Map<Integer, Integer> tranverse(TreeNode root) {
        if (root == null) {
            return new HashMap<>();
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Entry entry : tranverse(root.left).entrySet()) {
            countMap.put((Integer) entry.getKey(),
                Integer.sum(countMap.get(entry.getKey()) == null ? 0 : countMap.get(entry.getKey()), (Integer) entry.getValue()));
        }

        for (Entry entry : tranverse(root.right).entrySet()) {
            countMap.put((Integer) entry.getKey(),
                Integer.sum(countMap.get(entry.getKey()) == null ? 0 : countMap.get(entry.getKey()), (Integer) entry.getValue()));
        }
        countMap.put(root.val, 1 + (countMap.get(root.val) == null ? 0 : countMap.get(root.val)));
        return countMap;
    }

    private static List<CountNode> quickSortMap(List<CountNode> countNodes) {
        Integer pivotKey = 0;
        for (int i = 0, j = countNodes.size() - 1; i < countNodes.size() && j >= 0; ) {
            if (i == j) {
                break;
            }
            if (j > pivotKey) {
                if (countNodes.get(j).count < countNodes.get(pivotKey).count) {
                    countNodes.add(pivotKey, countNodes.get(j));
                    CountNode tempCountNode = countNodes.get(pivotKey + 1);
                    countNodes.remove(pivotKey + 1);
                    countNodes.remove(j);
                    countNodes.add(j, tempCountNode);
                    pivotKey = j;
                    i++;
                    continue;
                }
                j--;
                continue;
            }
            if (i < pivotKey) {
                if (countNodes.get(i).count > countNodes.get(pivotKey).count) {
                    countNodes.add(pivotKey, countNodes.get(i));
                    CountNode tempCountNode = countNodes.get(pivotKey + 1);
                    countNodes.remove(pivotKey + 1);
                    countNodes.remove(i);
                    countNodes.add(i, tempCountNode);
                    pivotKey = i;
                    j--;
                    continue;
                }
                i++;
                continue;
            }
        }
        if (pivotKey > 0) {
            quickSortMap(countNodes.subList(0, pivotKey));
        }
        if (pivotKey + 1 < countNodes.size()) {
            quickSortMap(countNodes.subList(pivotKey + 1, countNodes.size()));
        }
        return countNodes;

    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> countMap = tranverse(root);
        List<CountNode> countNodes = new ArrayList<>();
        for (Entry entry : countMap.entrySet()) {
            countNodes.add(new CountNode((Integer) entry.getKey(), (Integer) entry.getValue()));
        }
        countNodes = quickSortMap(countNodes);
        List<Integer> returnList = new ArrayList<>();
        int maxCount = countNodes.get(countNodes.size() - 1).count;
        for (CountNode countNode : countNodes) {
            if (countNode.count == maxCount) {
                returnList.add(countNode.val);
            }
        }
        int[] ret = new int[returnList.size()];
        for (int i = 0; i < returnList.size(); i++) {
            ret[i] = returnList.get(i);
        }
        return ret;

    }
//    public static void main(String[] args) {
//        List<CountNode> countNodes = new ArrayList<>();
//        countNodes.add(new CountNode(1, 8));
//        countNodes.add(new CountNode(2, 1));
//        countNodes.add(new CountNode(3, 6));
//        countNodes.add(new CountNode(4, 89));
//        countNodes.add(new CountNode(5, 18));
//        countNodes.add(new CountNode(6, 82));
//        countNodes.add(new CountNode(7, 13));
//        countNodes.add(new CountNode(7, 2));
//
//        List<CountNode> sortedCountNodes = quickSortMap(countNodes);
//        System.out.println(sortedCountNodes);
//    }
}

class CountNode {

    Integer val;
    Integer count;

    public CountNode(Integer val, Integer count) {
        this.val = val;
        this.count = count;
    }
}
