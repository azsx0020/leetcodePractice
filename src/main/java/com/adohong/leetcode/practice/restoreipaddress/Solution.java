package com.adohong.leetcode.practice.restoreipaddress;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() <= 3 || s.length() > 12) {
            return new ArrayList<>();
        }
        return restoreIpAddressesRecursive(s, 4);

    }

    private List<String> restoreIpAddressesRecursive(String s, int leftSegmentCount) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        if (leftSegmentCount == 1) {
            if ((s.length() > 1 && s.charAt(0) == '0') || Integer.valueOf(s) > 255) {
                return new ArrayList<>();
            } else {
                List<String> result = new ArrayList<>();
                result.add(s);
                return result;
            }
        }
        int num1 = Integer.valueOf(s.substring(0, 1));
        int num2 = Integer.MAX_VALUE;
        int num3 = Integer.MAX_VALUE;
        if (s.charAt(0) != '0') {
            if (s.length() >= 2) {
                num2 = Integer.valueOf(s.substring(0, 2));
            }
            if (s.length() >= 3) {
                num3 = Integer.valueOf(s.substring(0, 3));
            }
        }
        List<String> results = new ArrayList<>();
        List<String> subResult1 = restoreIpAddressesRecursive(s.substring(1), leftSegmentCount - 1);
        if (subResult1 != null) {
            for (int i = 0; i < subResult1.size(); i++) {
                results.add(String.valueOf(num1) + "." + subResult1.get(i));
            }
        }
        if (num2 <= 255) {
            List<String> subResult2 = restoreIpAddressesRecursive(s.substring(2), leftSegmentCount - 1);
            if (subResult2 != null) {
                for (int i = 0; i < subResult2.size(); i++) {
                    results.add(String.valueOf(num2) + "." + subResult2.get(i));
                }
            }
        }


        if (num3 <= 255) {
            List<String> subResult3 = restoreIpAddressesRecursive(s.substring(3), leftSegmentCount - 1);
            if (subResult3 != null) {
                for (int i = 0; i < subResult3.size(); i++) {
                    results.add(String.valueOf(num3) + "." + subResult3.get(i));
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> results = solution.restoreIpAddresses("101023");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
