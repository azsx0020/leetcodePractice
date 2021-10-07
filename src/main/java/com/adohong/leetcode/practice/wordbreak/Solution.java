package com.adohong.leetcode.practice.wordbreak;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = false;
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i] = wordDict.contains(s.substring(0, i + 1));
            if (dp[i]) continue;
            for (int j = 0; j < i; j++) {
                if (dp[j] && (wordDict.contains(s.substring(j + 1, i + 1)))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }


    // exceed time limit
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if(s.length() == 0) return true;
//        for (int i = 0; i < wordDict.size(); i++) {
//            int startIndex = 0;
//            int appearIndex = -1;
//            if (s.length() < wordDict.get(i).length()) continue;
//            while((s.length() - startIndex >= wordDict.get(i).length()) && (appearIndex = s.indexOf(wordDict.get(i), startIndex)) >= 0) {
//                boolean resultLeft = wordBreak(s.substring(0, appearIndex), wordDict);
//                if (!resultLeft) {
//                    startIndex++;
//                    continue;
//                }
//                boolean resultRight = wordBreak(s.substring(appearIndex + wordDict.get(i).length(), s.length()), wordDict);
//                if (!resultRight) {
//                    startIndex++;
//                    continue;
//                }
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        com.adohong.leetcode.practice.wordbreak.Solution solution = new com.adohong.leetcode.practice.wordbreak.Solution();
        boolean results = solution.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        System.out.println(results);
    }
}
