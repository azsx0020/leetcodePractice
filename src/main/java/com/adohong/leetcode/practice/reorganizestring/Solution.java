package com.adohong.leetcode.practice.reorganizestring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Character, Integer> calculateFrequency(String s) {
        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (resultMap.get(s.charAt(i)) == null) {
                resultMap.put(s.charAt(i), 1);
            } else {
                resultMap.put(s.charAt(i), resultMap.get(s.charAt(i)) + 1);
            }
        }
        return resultMap;
    }

    private void placingCharacters(Map<Character, Integer> map, int spaceLeft, StringBuilder result) {
        char charToPlace = findCharacterWithMaxFrequency(map);
        if (charToPlace == ' ' || map.get(charToPlace) > spaceLeft || 2 * map.get(charToPlace) - 1 > spaceLeft) {
            return;
        }
        int index = result.length();
        for (int i = 0; i < map.get(charToPlace); i++) {
            result.append(charToPlace);
        }

        int gapNums = map.get(charToPlace) - 1;
        map.remove(charToPlace);

        while (findCharacterWithMaxFrequency(map) != ' ' && gapNums != 0) {
            char charWithMaxFrequeency = findCharacterWithMaxFrequency(map);
            if (gapNums - map.get(charWithMaxFrequeency) >= 0) {
                insertToGap(result, index, charWithMaxFrequeency, map.get(charWithMaxFrequeency));
                index += 2 * map.get(charWithMaxFrequeency);
                gapNums = gapNums - map.get(charWithMaxFrequeency);
                map.remove(charWithMaxFrequeency);
            } else {
                insertToGap(result, index, charWithMaxFrequeency, gapNums);
                map.put(charWithMaxFrequeency, map.get(charWithMaxFrequeency) - gapNums);
                gapNums = 0;
            }

        }
        int spLeft = 0;
        for (Map.Entry entry : map.entrySet()) {
            spLeft += (int) entry.getValue();
        }
        placingCharacters(map, spLeft, result);
    }

    private void insertToGap(StringBuilder result, int index, char charWithMaxFrequeency, Integer integer) {
        for (int i = 0; i < integer; i++) {
            result.insert(2 * i + 1 + index, charWithMaxFrequeency);
        }
    }

    private char findCharacterWithMaxFrequency(Map<Character, Integer> map) {
        char charWithMaxFrequeency = ' ';
        int maxFrequency = Integer.MIN_VALUE;
        for (Map.Entry entry : map.entrySet()) {
            if (map.get(entry.getKey()) > maxFrequency) {
                maxFrequency = (int) entry.getValue();
                charWithMaxFrequeency = (char) entry.getKey();
            }
        }
        return charWithMaxFrequeency;
    }

    public String reorganizeString(String S) {
        Map<Character, Integer> map = calculateFrequency(S);
        StringBuilder result = new StringBuilder();
        placingCharacters(map, S.length(), result);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.reorganizeString(
            "aaab");
        System.out.println(result);
    }
}
