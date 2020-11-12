package com.adohong.leetcode.practice.atoi;

class Solution {

    private String findFirstSign(String s) {
       if (s.charAt(0) == '+' || s.charAt(0) == '-') {
           return s.substring(0, 1);
       }
       return null;
    }

    private String findNumericString(String s, String sign) {
        String wholeString = s;
        if (sign != null) {
            wholeString = s.substring(1);
        }

        int indexOfFirstNumericChar = 0;
        for (int i = 0; i < wholeString.length(); i++) {
            if (wholeString.charAt(i) >= '0' && wholeString.charAt(i) <= '9') {
                indexOfFirstNumericChar = i;
                break;
            }
        }

        String stringStartWithNumbers = wholeString.substring(indexOfFirstNumericChar);

        int indexOfFirstNonNumericChar = stringStartWithNumbers.length();
        for (int i = 0; i < stringStartWithNumbers.length(); i++) {
            if (stringStartWithNumbers.charAt(i) < '0' || stringStartWithNumbers.charAt(i) > '9') {
                indexOfFirstNonNumericChar = i;
                break;
            }
        }


        return stringStartWithNumbers.substring(0, indexOfFirstNonNumericChar);
    }

    public int myAtoi(String s) {
        String noWhiteSpaceString = s.trim();
        if (noWhiteSpaceString.equals("")) return 0;
        String sign = findFirstSign(noWhiteSpaceString);
        char firstChar = noWhiteSpaceString.charAt(0);
        if (sign != null && noWhiteSpaceString.length() > 1) {
            firstChar = noWhiteSpaceString.charAt(1);
        }
        if (firstChar < '0' || firstChar > '9') return 0;

        String numericString = findNumericString(noWhiteSpaceString, sign);

        long numeric = (long) Math.pow(2, 31) - 1;
        if (sign != null && sign.equals("-")) {
            numeric = (long) -Math.pow(2, 31);
        }
        try {
            numeric = Long.parseLong(numericString);
        } catch (NumberFormatException ignored) {
        }

        if (sign != null && sign.equals("-")) {
            if (numeric >= Math.pow(2, 31)) {
                return Integer.MIN_VALUE;
            }
            return (int) (-numeric);
        } else {
            return (int) Math.min(numeric, Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.myAtoi("21474836460");
        System.out.println(result);
    }
}