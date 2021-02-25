package com.adohong.leetcode.practice.multiplystrings;

public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num1.equals("0")) {
            return "0";
        }
        String chengshu = num1.length() < num2.length() ? num2 : num1;
        String beichengshu = num1.equals(chengshu) ? num2 : num1;
        String result = "0";
        for (int i = beichengshu.length() - 1; i >= 0; i--) {
            String multiplyResult = multiplyBySingleNumber(chengshu, beichengshu.substring(i, i + 1));
            if (!multiplyResult.equals("0")) {
                for (int j = 0; j < beichengshu.length() - i - 1; j++) {
                    multiplyResult = "0" + multiplyResult;
                }

            }

            result = addString(result, multiplyResult);
        }
        return new StringBuilder(result).reverse().toString();
    }

    private String addString(String total, String multiplyResult) {
        if (total.equals("0")) {
            return multiplyResult;
        } else if (multiplyResult.equals("0")) {
            return total;
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        int jinwei = 0;
        for (; index < total.length() && index < multiplyResult.length(); index++) {
            int a = total.charAt(index) - '0';
            int b = multiplyResult.charAt(index) - '0';
            int sumResultInt = a + b + jinwei;
            result.append((char)(sumResultInt % 10 + '0'));
            jinwei = sumResultInt / 10;
        }
        while (index < total.length()) {
            int sumRsultInt = total.charAt(index++) - '0' + jinwei;
            result.append((char)(sumRsultInt % 10 + '0'));
            jinwei = sumRsultInt / 10;
        }

        while (index < multiplyResult.length()) {
            int sumRsultInt = multiplyResult.charAt(index++) - '0' + jinwei;
            result.append((char)(sumRsultInt % 10 + '0'));
            jinwei = sumRsultInt / 10;
        }
        if (jinwei > 0) {
            result.append((char) (jinwei + '0'));
        }
        return result.toString();

    }

    private String multiplyBySingleNumber(String chengshu, String beichengshu) {
        StringBuilder result = new StringBuilder();
        if (beichengshu.equals("0")) {
            return "0";
        }
        int beichengshuInt = beichengshu.charAt(0) - '0';
        int jinwei = 0;
        for (int i = chengshu.length() - 1; i >= 0; i--) {
            int chengshuInt = chengshu.charAt(i) - '0';
            int multiplyResultInt = chengshuInt * beichengshuInt + jinwei;
            jinwei = multiplyResultInt / 10;
            result.append((char)('0' + (multiplyResultInt % 10)));
        }
        if (jinwei > 0) {
            result.append((char)('0' + jinwei));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.multiply("123456789", "987654321");
        System.out.println(result);
        System.out.println(result.length());
    }

}
