package com.adohong.leetcode.practice.cangraphbebipartite;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isBipartite(int[][] graph) {
        List<Vex> vexList = new ArrayList<Vex>();

        for(int i = 0; i < graph.length; i++) {
            vexList.add(new Vex(i, null));
        }
        for(int i = 0; i < graph.length; i++) {
            dFSMarkColor(graph, vexList, i, "red");
        }
        vexList.forEach(vex -> System.out.println(vex.getColor()));
        return canBeBipartite(graph, vexList);
    }

    private boolean canBeBipartite(int[][] graph, List<Vex> vexList) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (vexList.get(i).getColor().equals(vexList.get(graph[i][j]).getColor())) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dFSMarkColor(int[][] graph, List<Vex> vexList, int index, String color) {
        if (graph.length == 0 || vexList.get(index).getColor() != null) return;
        vexList.get(index).setColor(color);
        color = (color.equals("red") ? "blue" : "red");
        for (int i = 0; i < graph[index].length; i++) {
                dFSMarkColor(graph, vexList, graph[index][i], color);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = new int[][]{{1},{0},{4},{4},{2,3}};

        boolean canBeBipartite = solution.isBipartite(graph);
        System.out.println(canBeBipartite);
    }

}

class Vex {

    private Integer vexNum;

    public Vex(Integer vexNum, String color) {
        this.vexNum = vexNum;
        this.color = color;
    }

    private String color;

    public Integer getVexNum() {
        return vexNum;
    }

    public void setVexNum(Integer vexNum) {
        this.vexNum = vexNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
