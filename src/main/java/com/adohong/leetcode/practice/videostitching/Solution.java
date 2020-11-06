package com.adohong.leetcode.practice.videostitching;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, Integer> addAllClips(int[][] clips, int T) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for(int i = 0; i < clips.length; i++) {
            for(int j = clips[i][0]; j < clips[i][1] && j < T; j++) {
                if (resultMap.containsKey(j)) {
                    resultMap.put(j, resultMap.get(j) + 1);
                } else {
                    resultMap.put(j, 1);
                }
            }
        }
        return resultMap;
    }

    private boolean removeClip(int[] clip, Map<Integer, Integer> result, int T) {
        for (int i = clip[0]; i < clip[1] && i < T; i++) {
            if (result.get(i) == 1) return false;
        }
        for (int i = clip[0]; i < clip[1] && i < T; i++) {
            result.put(i, result.get(i) - 1);
        }
        return true;
    }

    private int[][] sortClips(int[][] clips) {
        if (clips.length == 0) return clips;
        int pivot = 0;
        for (int i = 0, j = clips.length - 1; i != j && i >= 0 && j >= 0; ) {
            if (pivot == i) {
                int videoLength = clips[j][1] - clips[j][0];
                int pivotLength = clips[pivot][1] - clips[pivot][0];
                if (videoLength < pivotLength) {
                    int[] tmp = clips[j];
                    clips[j] = clips[pivot];
                    clips[pivot] = tmp;
                    pivot = j;
                } else {
                    j--;
                }
            } else {
                int videoLength = clips[i][1] - clips[i][0];
                int pivotLength = clips[pivot][1] - clips[pivot][0];
                if (pivotLength < videoLength) {
                    int[] tmp = clips[i];
                    clips[i] = clips[pivot];
                    clips[pivot] = tmp;
                    pivot = i;
                } else {
                    i++;
                }
            }
        }
        int[][] subFrontCLips = new int[pivot][2];
        int[][] subEndCLips = new int[clips.length - pivot - 1][2];
        System.arraycopy(clips, 0, subFrontCLips, 0, pivot);
        System.arraycopy(clips, pivot + 1, subEndCLips, 0, clips.length - pivot - 1);

        sortClips(subFrontCLips);
        sortClips(subEndCLips);
        System.arraycopy(subFrontCLips, 0, clips, 0, pivot);
        System.arraycopy(subEndCLips, 0, clips, pivot + 1, clips.length - pivot - 1);
        return clips;
    }

    public int videoStitching(int[][] clips, int T) {
        if ((clips == null || clips.length == 0) && T == 0) return 0;
        if ((clips == null || clips.length == 0) && T != 0) return -1;
        Map<Integer, Integer> result = addAllClips(clips, T);
        for (int i = 0; i < T; i++) {
            if (!result.containsKey(i)) return -1;
        }
        int[][] sortedCLips = sortClips(clips);
        int removedClips = 0;
        for (int i = 0; i < sortedCLips.length; i++) {
            if (removeClip(sortedCLips[i], result, T)) {
                removedClips++;
            }
        }
        return clips.length - removedClips;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] clips = new int[][]{{0, 1}, {1, 2}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int result = solution.videoStitching(clips, 10);
        for (int i = 0; i < clips.length; i++) {

            System.out.println(clips[i][0] + ' ' + clips[i][1]);
        }
        System.out.println(result);


    }
}
