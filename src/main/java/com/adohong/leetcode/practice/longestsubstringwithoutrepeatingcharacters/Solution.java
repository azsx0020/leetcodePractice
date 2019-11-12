package com.adohong.leetcode.practice.longestsubstringwithoutrepeatingcharacters;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int longestSize = 0;
        Map<Character, Integer> longestSubstringCurrently = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (null != longestSubstringCurrently.get(c)) {
                Iterator<Entry<Character, Integer>> iter = longestSubstringCurrently.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<Character, Integer> entry = iter.next();

                    if (entry.getKey().equals(c)) {
                        iter.remove();
                        break;
                    }
                    iter.remove();
                }
            }
            longestSubstringCurrently.put(c, 1);
            if (longestSize < longestSubstringCurrently.size()) {
                longestSize = longestSubstringCurrently.size();
            }
        }
        return longestSize;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("acdfeac"));
    }
}