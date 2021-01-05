package com.adohong.leetcode.practice.integertoroman;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        String result = "";
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
            int count = (num / (int)entry.getValue());
            for (int i = 0; i < count; i++) {
                result += entry.getKey();
            }
            num = num % (int)entry.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.intToRoman(1994);
        System.out.println(result);
    }

}
