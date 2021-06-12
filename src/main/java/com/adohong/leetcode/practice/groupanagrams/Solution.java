package com.adohong.leetcode.practice.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        int[][] marks = new int[strs.length][26];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < 26; j++) {
                marks[i][j] = 0;
            }
        }
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                marks[i][str.charAt(j) - 'a'] += 1;
            }
        }
        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < marks.length; i++) {
            StringBuilder tempStr = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < marks[i][j]; k++) {
                    tempStr.append(((char) (97 + j)));
                }
            }
            List<String> storedStrList = result.get(tempStr.toString());
            if (storedStrList == null) {
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                result.put(tempStr.toString(), strList);
            } else {
                storedStrList.add(strs[i]);
            }
        }
        List<List<String>> resultStrs = new ArrayList<>();
        result.forEach((key, value) -> resultStrs.add(value));
        return resultStrs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams(new String[]{"dgggggg", "gdddddd"});
        lists.forEach(list -> {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        });
    }
}
