package com.adohong.leetcode.practice.validpalindrome;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(String s) {
        List<Integer> strInt = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <= 25) {
                strInt.add((int) s.charAt(i));
            } else if (s.charAt(i) - 'A' >= 0 && s.charAt(i) - 'A' <= 25) {
                strInt.add((int) s.charAt(i) + 32);
            } else if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                strInt.add((int) s.charAt(i));
            }
        }
        for (int i = 0; i < strInt.size() / 2; i++) {
            if (!strInt.get(i).equals(strInt.get(strInt.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome("race a car");
        System.out.println(result);
    }
}
