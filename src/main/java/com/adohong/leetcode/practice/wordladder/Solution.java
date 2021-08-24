package com.adohong.leetcode.practice.wordladder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int beginIndex = wordList.size();
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) {
                beginIndex = i;
            }
        }
        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        int[] pathCount = new int[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            pathCount[i] = 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(beginIndex);
        while(!queue.isEmpty()) {
            int tempStartIndex = queue.poll();
            for (int i = 0; i < wordList.size(); i++) {
                if ((i != tempStartIndex) && pathCount[i] == 0 && i != beginIndex && canReach(wordList.get(tempStartIndex), wordList.get(i))) {
                    pathCount[i] = pathCount[tempStartIndex] + 1;
                    queue.add(i);
                }
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                return pathCount[i] == 0 ? 0 : pathCount[i] + 1;
            }
        }

        return 0;

    }

    private boolean canReach(String wordFrom, String wordTo) {
        int diferentCount = 0;
        for (int i = 0; i < wordFrom.length(); i++) {
            if (wordFrom.charAt(i) != wordTo.charAt(i)) {
                diferentCount++;
            }
        }
        return diferentCount <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> arrayList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int result = solution.ladderLength("hit", "cog", arrayList);
        System.out.println(result);
    }
}

/**
 *  下面的算法是错的，做的不是真正的广度遍历，是有问题的。
 *              a
 *          b        c
 *                       d
 *                           e
 *  如上例，b也指向e，实际上a到e的最短距离是2（a -> b -> e)，
 *  但是如果按照下面的算法，可能出现的结果是先遍历了a，c，d，e（当a, c, d, e 在wordlist中按顺序排列时，就会出现这种情况），然后再遍历b。
 *  在遍历b时，因为e已经被遍历过，因此b->e的路径会被忽略。因此，算出的最短路径就会是错误的（a -> c -> d -> e)
 */

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int endIndex = -1;
//        for (int i = 0; i < wordList.size(); i++) {
//            if (wordList.get(i).equals(endWord)) {
//                endIndex = i;
//            }
//        }
//        if (endIndex == -1) return 0;
//        int[] pathCount = new int[wordList.size()];
//        for (int i = 0; i < wordList.size(); i++) {
//            pathCount[i] = 0;
//        }
//
//        boolean shouldContinue = true;
//        while(shouldContinue) {
//            shouldContinue = false;
//            for (int i = 0; i < wordList.size(); i++) {
//                if (pathCount[i] != 0 || i == endIndex) continue;
//                if (canReach(endWord, wordList.get(i))) {
//                    pathCount[i] = 1;
//                    shouldContinue = true;
//                } else {
//                    int minCount = Integer.MAX_VALUE;
//                    for (int j = 0; j < wordList.size(); j++) {
//                        if (pathCount[j] != 0 && canReach(wordList.get(j), wordList.get(i))) {
//                            minCount = Math.min(minCount, pathCount[j] + 1);
//                        }
//                    }
//                    pathCount[i] = (minCount == Integer.MAX_VALUE ? 0 : minCount);
//                    shouldContinue = shouldContinue || (pathCount[i] != 0);
//                }
//            }
//        }
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < wordList.size(); i++) {
//            if (canReach(beginWord, wordList.get(i)) && pathCount[i] != 0) {
//                result = Math.min(result, pathCount[i] + (wordList.get(i).equals(beginWord) ? 1 : 2));
//            }
//        }
//        return (result == Integer.MAX_VALUE) ? 0 : result;
//
//    }
//
//    private boolean canReach(String wordFrom, String wordTo) {
//        int diferentCount = 0;
//        for (int i = 0; i < wordFrom.length(); i++) {
//            if (wordFrom.charAt(i) != wordTo.charAt(i)) {
//                diferentCount++;
//            }
//        }
//        return diferentCount <= 1;
//    }