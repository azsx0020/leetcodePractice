package com.adohong.leetcode.practice.countandsay;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public String countAndSay(int n) {
        String numberString = "1";
        if (n == 1) return numberString;
        for (int i = 2; i <= n; i++) {
            StringBuilder newNumberString = new StringBuilder();
            doCount(numberString, newNumberString);
            numberString = newNumberString.toString();
        }
        return numberString;
    }

    private void doCount(String numberString, StringBuilder newNumberString) {
        for (int i = 0; i < numberString.length();) {
            int countResult = countNumber(numberString.charAt(i) - 48, i, numberString);
            newNumberString.append(countResult);
            newNumberString.append(numberString.charAt(i) - 48);
            i += countResult;
        }
    }

    private int countNumber(int integer, int startIndex, String numberString) {
        int count = 0;
        for (int i = startIndex; i < numberString.length(); i++) {
            if (integer == numberString.charAt(i) - 48) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.countAndSay(30);
        System.out.println(result);
    }
}
