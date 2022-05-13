package com.adohong.leetcode.practice.courseschedule;

// 拓扑排序： 深度优先遍历 + 三种状态：未遍历，在遍历，已经完成遍历

// 有环的图，是没有拓扑排序结果的。

public class Solution {


    private boolean dfs(int[] status, int index, int[][] prerequisites) {
        if (status[index] == -1) {
            status[index] = 0;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == index) {
                    if(!dfs(status, prerequisites[i][0], prerequisites)) {
                        return false;
                    };
                }
            }
            status[index] = 1;
        } else if (status[index] == 0) {
            return false;
        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            status[i] = -1;
        }
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(status, i, prerequisites)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.canFinish(10, new int[][]{{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {7, 8}, {4, 9}});
        System.out.println(result);
    }





}
