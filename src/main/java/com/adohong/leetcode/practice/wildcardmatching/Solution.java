package com.adohong.leetcode.practice.wildcardmatching;

import java.util.ArrayList;
import java.util.List;

// time exceeded
public class Solution {
    public boolean isMatch(String s, String p) {
        List<String> possibleLeftStrings = new ArrayList<>();
        possibleLeftStrings.add(s);
        return isMatchRecursive(possibleLeftStrings, p);


    }

    private boolean isMatchRecursive(List<String> possibleLeftStrings, String p) {
        for (String possibleLeftString : possibleLeftStrings) {
            List<String> possibleLeftStringsNextRound = new ArrayList<>();
            if (doMatch(possibleLeftString, p, possibleLeftStringsNextRound)) {
                if ( p.length() == 0 || (isMatchRecursive(possibleLeftStringsNextRound, p.substring(1)))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean doMatch(String s, String p, List<String> possibleLeftStrings) {
        if (p.length() == 0) return s.length() == 0;
        char c = p.charAt(0);
        if (s.length() != 0 && ((c == '?') || (c == s.charAt(0)))) {
            possibleLeftStrings.add(s.substring(1));
            return true;
        } else if (c == '*') {
            for (int i = 0; i <= s.length(); i++) {
                possibleLeftStrings.add(s.substring(i));
            }
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isMatch("abcabczzzde", "*abc???de*");
        System.out.println(result);
    }
}
