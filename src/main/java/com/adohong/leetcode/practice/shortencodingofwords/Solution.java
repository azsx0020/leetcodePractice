package com.adohong.leetcode.practice.shortencodingofwords;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) return 0;
        List wordsList = Arrays.asList(words);
        String result = "";
        int[] indexes = new int[words.length];
        Collections.sort(wordsList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (int i = 0; i < wordsList.size(); i++) {
            result += wordsList.get(i);
            result += "#";
        }
        for (int i = 0; i < wordsList.size(); i++) {
            int index = isSuffixOfOthers(wordsList, i);
            if (index > 0) {
               result = result.replaceFirst(wordsList.get(i) + "#", "");
            }
        }
        return result.length();
    }

    private int isSuffixOfOthers(List<String> wordList, int index) {
        for (int i = index + 1; i < wordList.size(); i++) {
            if (isSuffix(wordList.get(index), wordList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSuffix(String s, String s1) {
        int index = s1.lastIndexOf(s);
        return index != -1 && index + s.length() == s1.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.minimumLengthEncoding(new String[]{"time", "atime", "btime"});
        System.out.println(result);
    }
}
