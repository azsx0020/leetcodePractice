package com.adohong.leetcode.practice.freedomtrail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int findRotateSteps(String ring, String key) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            result.add(new ArrayList<>(Collections.nCopies(ring.length(), Integer.MAX_VALUE)));
        }
        for (int i = 0; i < key.length(); i++) {
            // 初始状态
            if (i == 0) {
                int fromIndex = 0;
                while (fromIndex < ring.length()
                        && ring.indexOf(key.substring(i, i + 1), fromIndex) >= 0) {
                    int index = ring.indexOf(key.substring(i, i + 1), fromIndex);
                    result.get(i).set(index, Math.min(index, ring.length() - index) + 1);
                    fromIndex = index + 1;
                }
            } else {
                // 状态转移方程
                int fromIndex = 0;
                while (fromIndex < ring.length() && ring.indexOf(key.substring(i, i + 1), fromIndex) >= 0) {
                    int minSteps = Integer.MAX_VALUE;
                    int index = ring.indexOf(key.substring(i, i + 1), fromIndex);
                    // 这里之前用了
                    // for (Integer integer: result.get(i - 1)  这种循环，当获取integer的index的时候，用了result.get(i - 1).indexOf(integer)，
                    // 这样是错误的，当list里有两个连续的一样的数字时，indexOf永远返回第一个数字。
                    for (int j = 0; j < result.get(i - 1).size(); j++) {
                        if (!result.get(i - 1).get(j).equals(Integer.MAX_VALUE)) {
                            if (minSteps > Math.min(Math.abs(index - j), ring.length() - Math.abs(index - j)) + result.get(i - 1).get(j) + 1) {
                                minSteps = Math.min(Math.abs(index - j), ring.length() - Math.abs(index - j)) + result.get(i - 1).get(j) + 1;
                            }
                        }
                    }
                    result.get(i).set(index, minSteps);
                    fromIndex = index + 1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (Integer integer : result.get(key.length() - 1)) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int min = solution.findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx");
        System.out.println(min);
    }
}
