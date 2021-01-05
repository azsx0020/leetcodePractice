package com.adohong.leetcode.practice.sortcharactersbyfrequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        List<Map.Entry> entries = new ArrayList<Map.Entry>();
        for (Map.Entry entry : map.entrySet()) {
            entries.add(entry);
        }
        entries.sort(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return ((Integer) o1.getValue()).compareTo((Integer) o2.getValue());
            }
        });
        for (int i = entries.size() - 1; i >= 0; i--) {
            int count = (int)entries.get(i).getValue();
            while(count > 0) {
                result.append(entries.get(i).getKey());
                count--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.frequencySort("Aabb");
        System.out.println(result);
    }
}
