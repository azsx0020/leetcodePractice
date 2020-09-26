package com.adohong.leetcode.practice.leavescollection;

/*
叶子状态：
0：表示叶子处在开头的红色部分
1：表示叶子处在中间的黄色部分
2：表示叶子处在结尾的红色部分

f[i][j]  表示第i片为状态j中的叶子时，的最小操作数。

f[0][0] = leaves[0] == 'y'
f[i][0] = f[i - 1][0] + isYellow(i), i > 0

f[0][1] = INT_MAX
f[i][1] = min{f[i-1][0], f[i-1][1]} + isYellow(i), i > 0

f[0][2] = INT_MAX
f[1][2] = INT_MAX
f[i][2] = min{f[i-1][1], f[i-1][2]} + isYellow(i), i > 1

最终求f[n][2]，n为叶子总数
*/

class Solution {

    private static final int INT_MAX = Integer.MAX_VALUE;

    public int minimumOperations(String leaves) {
        int[][] times = new int[leaves.length()][3];
        times[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        times[0][1] = INT_MAX;
        times[0][2] = INT_MAX;
        times[1][2] = INT_MAX;

        for (int i = 1; i < leaves.length(); i++) {
            times[i][0] = times[i - 1][0] + (leaves.charAt(i) == 'y' ? 1 : 0);
            times[i][1] = Math.min(times[i - 1][0], times[i - 1][1]) + (leaves.charAt(i) == 'y' ? 0 : 1);
            if (i > 1) {
                times[i][2] = Math.min(times[i - 1][2], times[i - 1][1]) + (leaves.charAt(i) == 'y' ? 1 : 0);
            }
        }

        return times[leaves.length() - 1][2];
    }

    public static void main(String[] args) {
        String leaves = "rrryyyrryyyrr";
        Solution solution = new Solution();
        solution.minimumOperations(leaves);
    }
}
