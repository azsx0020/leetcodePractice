package com.adohong.leetcode.practice.reversstring;

public class Solution {
    //双指针，为什么不用递归，是因为递归需要List接口的remove和add方法支持，而只是用char数组的话没法弄
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        for (;left <= right; left++, right--) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(s);
    }
}
