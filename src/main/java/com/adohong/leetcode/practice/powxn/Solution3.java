package com.adohong.leetcode.practice.powxn;

import com.adohong.leetcode.practice.groupanagrams.Solution;

// 思路：
// 以2的77次方为例。2 + 2^4 + 2^8 + 2^64
// 77 = 38 * 2 + 1, 额外的乘了一个2
// 19 = 2 * 9 + 1, 额外的乘了一个2，因为在此后还经历了两次平方，19 -> 38 -> 77, 所以此次额外乘的2最终相当于额外乘了2^4
// 9 = 2 * 4 + 1, 额外的乘了一个2， 因为在此后还经理了三次平方，9 -> 19 -> 38 -> 77, 所以此次额外乘的2最终相当于额外乘了2^8
// 另外，最初的2，经历了6次平方，1 -> 2 -> 4 -> 9 -> 19 -> 38 -> 77, 所以最初的2最终相当于额外乘了2^64
// 77 的二进制码为1001101，2^77 = 2^64 + 2^8 + 2^4 + 2, 刚好与二进制的77的为1的位相对应
// 时间复杂度O(logn)，空间复杂度O(1)
public class Solution3 {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0d) return 1;
        if (x == 0) return 0;
        long absN = Math.abs((long)n);
        double result = 1.0d;
        double accumulateFactor = x;
        while(absN > 0) {
            if (absN % 2 == 1) {
                result *= accumulateFactor;
            }
            accumulateFactor *= accumulateFactor;
            absN /= 2;
        }
        return n > 0 ? result : (1.0d / result);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        double result = solution3.myPow(2.00000, -2147483648);
        System.out.println(result);
    }
}
