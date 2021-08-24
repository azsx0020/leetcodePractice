package com.adohong.leetcode.practice.palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s.length() == 0) return results;
        for (int i = 0; i < s.length(); i++) {

            String subString = s.substring(0, i + 1);
            boolean isPalindrome = true;
            for (int j = 0; j < subString.length() / 2; j++) {
                if (subString.charAt(j) != subString.charAt(subString.length() - j - 1)) {
                    isPalindrome = false;
                }
            }
            if (isPalindrome) {
                List<List<String>> subResults = partition(s.substring(i + 1, s.length()));
                for (int j = 0; j < subResults.size(); j++) {
                    List<String> temp = new ArrayList<>();
                    temp.add(subString);
                    temp.addAll(subResults.get(j));
                    results.add(temp);
                }
                if (subResults.size() == 0) {
                    List<String> temp = new ArrayList<>();
                    temp.add(subString);
                    results.add(temp);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> results = solution.partition("aab");
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
