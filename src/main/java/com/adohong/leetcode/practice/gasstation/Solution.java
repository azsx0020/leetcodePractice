package com.adohong.leetcode.practice.gasstation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return traverseGasStation(gas, cost);

    }

    private int traverseGasStation(int[] gas, int[] cost) {
        int startPoint = 0;
        int gasleft = 0;
        for (int i = 0; i < gas.length; i++) {
            gasleft += gas[(startPoint + i) % gas.length];
            gasleft -= cost[(startPoint + i) % cost.length];
            if (gasleft < 0) {
                if (i + startPoint >= (gas.length - 1)) {
                    return -1;
                }
                startPoint = startPoint + i + 1;
                gasleft = 0;
                i = -1;
                continue;
            }
        }
        return startPoint;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        Solution solution = new Solution();
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
