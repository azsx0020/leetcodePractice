package com.adohong.leetcode.practice.wordbreakii;

import com.sun.org.apache.xml.internal.utils.ListingErrorHandler;

import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            dp.add(new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                dp.get(i).add(-1);
            }
            for (int j = 0; j < i; j++) {
                if (dp.get(j).size() > 0 && (wordDict.contains(s.substring(j + 1, i + 1)))) {
                    dp.get(i).add(j);
                }
            }
        }
        if (dp.get(s.length() - 1).size() == 0) return new ArrayList<>();
        return traverseDP(s, dp, s.length() - 1);
    }

    private List<String> traverseDP(String s, List<List<Integer>> dp, int currentIndex) {
        List<String> results = new ArrayList<>();
        if (currentIndex == -1) {
            results.add("");
            return results;
        }
        for (int i = 0; i < dp.get(currentIndex).size(); i++) {
            String tempResult = s.substring(dp.get(currentIndex).get(i) + 1, currentIndex + 1);
            List<String> subResults = traverseDP(s, dp, dp.get(currentIndex).get(i));
            for (int j = 0; j < subResults.size(); j++) {
                results.add((subResults.get(j).equals("") ? "" : subResults.get(j) +  " ") + tempResult);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> results = solution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

}
