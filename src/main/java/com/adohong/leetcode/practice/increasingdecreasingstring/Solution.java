package com.adohong.leetcode.practice.increasingdecreasingstring;

public class Solution {
    public String sortString(String s) {
        StringBuilder inputString = new StringBuilder(s);
        StringBuilder result = new StringBuilder();
        boolean findSmallest = true;
        boolean switched = true;
        while(inputString.length() > 0) {
            if (findSmallest) {
                int smallestIndex = findSmallestChar(inputString.toString(), switched ? null : result.substring(result.length() - 1));
                if (smallestIndex >= 0) {
                    String smallestChar = inputString.substring(smallestIndex, smallestIndex + 1);
                    if (switched || (smallestChar.compareTo(result.substring(result.length() - 1, result.length())) > 0)) {
                        result.append(smallestChar);
                        inputString.deleteCharAt(smallestIndex);
                        if (switched) {
                            switched = false;
                        }
                    } else {
                        findSmallest = false;
                        switched = true;
                    }
                } else {
                    findSmallest = false;
                    switched = true;
                }

            } else {
                int biggestIndex = findBiggestChar(inputString.toString(), switched ? null : result.substring(result.length() - 1));
                if (biggestIndex >= 0) {
                    String biggestChar = inputString.substring(biggestIndex, biggestIndex + 1);
                    if (switched || biggestChar.compareTo(result.substring(result.length() - 1, result.length())) < 0) {
                        result.append(biggestChar);
                        inputString.deleteCharAt(biggestIndex);
                        if (switched) {
                            switched = false;
                        }
                    } else {
                        findSmallest = true;
                        switched = true;
                    }
                } else {
                    findSmallest = true;
                    switched = true;
                }
            }
        }
        return result.toString();
    }

    private int findBiggestChar(String inputString, String base) {
        int biggestIndex = -1;
        for (int i = 0; i < inputString.length(); i++) {
            if (base == null || inputString.charAt(i) < base.charAt(0)) {
                if (biggestIndex == -1 || inputString.charAt(i) > inputString.charAt(biggestIndex)) {
                    biggestIndex = i;
                }
            }
        }
        return biggestIndex;
    }

    private int findSmallestChar(String inputString, String base) {
        int smallestIndex = -1;
        for (int i = 0; i < inputString.length(); i++) {
            if (base == null || inputString.charAt(i) > base.charAt(0)) {
               if (smallestIndex == -1 || inputString.charAt(i) < inputString.charAt(smallestIndex)) {
                   smallestIndex = i;
               }
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.sortString("spo");
        System.out.println(result);
    }
}
