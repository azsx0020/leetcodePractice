package com.adohong.leetcode.practice.bashuzifanyichengzifuchuan;

public class Solution {
    public int translateNum(int num) {
        if (num < 100) {
            if (num > 25 || num < 10) {
                return 1;
            } else {
                return 2;
            }
        }
        String numStr = String.valueOf(num);
        int firstSingle = Integer.valueOf(numStr.substring(0, 1));
        int firstDouble = Integer.valueOf(numStr.substring(0, 2));
        int count1 = translateNum(Integer.valueOf(numStr.substring(1, numStr.length())));
        int count2 = 0;
        if (firstDouble <= 25) {
            count2 = translateNum(Integer.valueOf(numStr.substring(2, numStr.length())));
        }
        return count1 + count2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.translateNum(12258);
        System.out.println(result);
    }
}
