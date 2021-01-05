package com.adohong.leetcode.practice.generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add("()");
            return result;
        }
        for (int i = 1; i <= n/2; i++) {
            List<String> subResult1 = generateParenthesis(i);
            List<String> subResult2 = i == n - i ? subResult1 : generateParenthesis(n - i);
            compositeResult(subResult1, subResult2, result);
        }

        return result;
    }

    private List<String> compositeResult(List<String> subResult1, List<String> subResult2, List<String> result) {
        for (int i = 0; i < subResult1.size(); i++) {
            for (int j = 0; j < subResult2.size(); j++) {
                String tmp1 = subResult1.get(i) + subResult2.get(j);
                String tmp2 = subResult2.get(j) + subResult1.get(i);
                String tmp3 = null;
                if (subResult1.size() == 1) {
                    tmp3 = "(" + subResult2.get(j) + ")";
                }
                if (!result.contains(tmp1)) {
                    result.add(tmp1);
                }
                if (!result.contains(tmp2)) {
                    result.add(tmp2);
                }
                if (tmp3 != null && !result.contains(tmp3)) {
                    result.add(tmp3);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(4);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
