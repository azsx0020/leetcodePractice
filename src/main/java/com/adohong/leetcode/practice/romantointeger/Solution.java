package com.adohong.leetcode.practice.romantointeger;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<String, Integer> romanIntegerMap = new LinkedHashMap<>();
        romanIntegerMap.put("M", 1000);
        romanIntegerMap.put("CM", 900);
        romanIntegerMap.put("D", 500);
        romanIntegerMap.put("CD", 400);
        romanIntegerMap.put("C", 100);
        romanIntegerMap.put("XC", 90);
        romanIntegerMap.put("L", 50);
        romanIntegerMap.put("XL", 40);
        romanIntegerMap.put("X", 10);
        romanIntegerMap.put("IX", 9);
        romanIntegerMap.put("V", 5);
        romanIntegerMap.put("IV", 4);
        romanIntegerMap.put("I", 1);
        for (Map.Entry entry : romanIntegerMap.entrySet()) {
            int count = 0;
            while (s.length() > 0) {
                if (s.indexOf((String) entry.getKey()) == 0) {
                    count++;
                    s = s.substring(((String) entry.getKey()).length());
                } else {
                    break;
                }
            }
            result += count * (int) entry.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.romanToInt("MCMXCIV");
        System.out.println(result);
    }
}
