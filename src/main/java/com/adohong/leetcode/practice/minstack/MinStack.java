package com.adohong.leetcode.practice.minstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

    private List<Integer> sortedList;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        sortedList = new ArrayList<>();
    }

    public void push(int val) {
        if (sortedList.size() == 0) {
            sortedList.add(val);
        } else {
            boolean added = false;
            for (int i = 0; i < sortedList.size(); i++) {
                if (val <= sortedList.get(i)) {
                    sortedList.add(i, val);
                    added = true;
                    break;
                }
            }
            if (!added) {
                sortedList.add(val);
            }
        }
        stack.push(val);

    }

    public void pop() {
        int val = stack.pop();
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) == val) {
                sortedList.remove(i);
                i--;
                break;
            }
        }
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return sortedList.get(0);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
