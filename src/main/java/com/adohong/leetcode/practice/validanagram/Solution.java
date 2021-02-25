package com.adohong.leetcode.practice.validanagram;

import java.util.HashSet;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] nums = new int[26];
        s.chars().forEach(c -> nums[c - 'a']++);
        t.chars().forEach(c -> nums[c - 'a']++);
        for (int i = 0; i < 26; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
