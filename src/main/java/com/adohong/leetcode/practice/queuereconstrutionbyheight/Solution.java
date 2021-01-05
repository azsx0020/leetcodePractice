package com.adohong.leetcode.practice.queuereconstrutionbyheight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return people;
        List<List<Integer>> peopleList = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < people[i].length; j++) {
                tempList.add(people[i][j]);
            }
            peopleList.add(tempList);
        }
        peopleList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        int[][] result = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < peopleList.size(); i++) {
            if (i == 0) {
                result[peopleList.get(i).get(1)][0] = peopleList.get(i).get(0);
                result[peopleList.get(i).get(1)][1] = peopleList.get(i).get(1);
            } else {
                int limit = 0;
                int index = 0;
                for (index = 0; limit < peopleList.get(i).get(1); index++) {
                    if (result[index][0] >= peopleList.get(i).get(0)) {
                        limit++;
                    }
                }

                for (; index < result.length; index++) {
                    if (result[index][0] == Integer.MAX_VALUE) {
                        break;
                    }
                }
                result[index][0] = peopleList.get(i).get(0);
                result[index][1] = peopleList.get(i).get(1);


            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Solution solution = new Solution();
        int[][] result = solution.reconstructQueue(people);
        for (int i = 0; i < result.length; i++) {
            System.out.print("[");
            for(int j = 0; j < 2; j++) {
                System.out.print(result[i][j]);
                if(j == 0) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
