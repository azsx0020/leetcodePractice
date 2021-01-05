package com.adohong.leetcode.practice.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> traverse(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j) != nums.get(i)) {
                    tmpList.add(nums.get(j));
                }
            }
            if (tmpList.size() > 0) {
                result.addAll(addElementToLists(nums.get(i), traverse(tmpList)));
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums.get(i));
                result.add(tmp);
            }
        }
        return result;
    }

    private List<List<Integer>> addElementToLists(int n, List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).add(n);
        }
        return lists;
    }


    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        return traverse(numsList);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3, 4});
        for (int i = 0; i < result.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j));
                if (j != result.get(i).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

    }
}
