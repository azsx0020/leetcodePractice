package com.adohong.leetcode.practice.magicsequence;

public class Solution {
    public boolean isMagic(int[] target) {
        if (target.length == 1) return true;
        int[] source = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            source[i] = i + 1;
        }
        int[] afterFirstRoundChange = doOneRoundChange(source, 0);
        int possibleK = 0;
        for (int i = 0; i < afterFirstRoundChange.length; i++) {
            if (afterFirstRoundChange[i] != target[i]) {
                if (i == 0) {
                    return false;
                }
                possibleK = i;
                break;
            }
        }
        if (possibleK == 0) return true;
        return canWork(target, possibleK, source);

    }

    private boolean canWork(int[] target, int possibleK, int[] source) {
        int times = target.length % possibleK == 0 ? target.length / possibleK : target.length / possibleK + 1;
        for (int i = 0; i < times; i++) {
            source = doOneRoundChange(source, i * possibleK);
        }
        for (int i = 0; i < target.length; i++) {
            if (source[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] doOneRoundChange(int[] target, int startIndex) {
        int[] result = new int[target.length];
        int[] numbersInOddPos = new int[target.length - startIndex];
        for (int i = 0; i < startIndex; i++) {
            result[i] = target[i];
        }
        int indexEven = 0;
        int indexOdd = 0;
        for (int i = startIndex; i < target.length; i++) {
            if ((i - startIndex + 1) % 2 == 0) {
                result[startIndex + indexEven] = target[i];
                indexEven++;
            } else {
                numbersInOddPos[indexOdd++] = target[i];
            }
        }
        for (int i = 0; i < indexOdd; i++) {
            result[startIndex + indexEven] = numbersInOddPos[i];
            indexEven++;
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        boolean magic = solution.isMagic(new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,51,55,59,63,67,53,57,61,65,69});
        boolean magic = solution.isMagic(new int[]{2,4,3,1,5});
        System.out.println(magic);
    }



}
