package com.adohong.leetcode.practice.longestsubstringwithoutrepeatingcharacters;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int[] mark = new int[256];
        for (int i = 0; i < 256; i++) {
            mark[i] = -1;
        }
        int pre = -1;
        int cur = -1;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            pre = Math.max(pre, mark[s.charAt(i)]);
            cur = i - pre;
            length = Math.max(length, cur);
            mark[s.charAt(i)] = i;
        }
        return length;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int result = solution3.lengthOfLongestSubstring("aabaab!bb");
        System.out.println(result);

    }
}
