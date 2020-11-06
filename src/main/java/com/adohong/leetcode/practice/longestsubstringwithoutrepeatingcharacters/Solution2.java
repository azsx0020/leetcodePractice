package com.adohong.leetcode.practice.longestsubstringwithoutrepeatingcharacters;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        LinkedHashSet<Character> currentLongest = new LinkedHashSet<>();
        LinkedHashSet<Character> longest = new LinkedHashSet<>();
        int longestSize = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!currentLongest.add(s.charAt(i)) || i == s.length() - 1) {
                if (currentLongest.size() > longestSize) {
                    longestSize = currentLongest.size();
                    longest.clear();
                    longest.addAll(currentLongest);
                }
                Iterator iterator = currentLongest.iterator();
                while(!iterator.next().equals(s.charAt(i))) {
                    iterator.remove();
                }
                iterator.remove();
                currentLongest.add(s.charAt(i));
            }
        }
        return longest.size();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.lengthOfLongestSubstring("aabaab!bb");
        System.out.println(result);
    }
}
