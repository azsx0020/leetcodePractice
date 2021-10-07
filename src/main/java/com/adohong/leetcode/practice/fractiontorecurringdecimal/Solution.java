package com.adohong.leetcode.practice.fractiontorecurringdecimal;

import java.util.HashMap;
import java.util.Map;

// hard
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        boolean isNegative = false;
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            isNegative = true;
        }
        String numeratorString = String.valueOf(numerator);
        long denomiatorLongAbs = Math.abs((long) denominator);
        numeratorString = numeratorString.replace("-", "");
        int yuNumber = Integer.MIN_VALUE;
        int index = 0;
        boolean hasDot = false;
        Map<Integer, Integer> indexMap = new HashMap<>();
        String result = new String();
        String tempNumerator = "";
        while((tempNumerator == "" || Integer.valueOf(tempNumerator) != 0) || (index != numeratorString.length() && !hasDot)) {

            if (index <= numeratorString.length() - 1) {
                tempNumerator += numeratorString.substring(index, index + 1);
            } else {
                if (!indexMap.containsKey(Integer.valueOf(tempNumerator))) {
                    indexMap.put(Integer.valueOf(tempNumerator), result.length() - 1);
                } else {
                    int firstApearIndex = indexMap.get(Integer.valueOf(tempNumerator));
                    result = new StringBuilder(result).insert(firstApearIndex + 1, '(').append(")").toString();
                    break;
                }
                tempNumerator += "0";
            }

            Long tempResult = Long.parseLong(tempNumerator) / denomiatorLongAbs;
            yuNumber = (int)(Long.parseLong(tempNumerator) % denomiatorLongAbs);
            if (!hasDot && yuNumber > 0 && index == numeratorString.length() - 1) {
                result += String.valueOf(tempResult) + ".";
                hasDot = true;
            } else if((tempResult != 0 || (tempResult == 0 && !result.isEmpty()) )) {
                result += String.valueOf(tempResult);
            }
            tempNumerator = String.valueOf(yuNumber);
            index++;
        }
        if (isNegative && !result.equals("0")) {
            result = new StringBuilder(result).insert(0, "-").toString();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(500, 10);
        System.out.println(result);
    }
}


// 500 10
// 22  7
// 2147483647 37