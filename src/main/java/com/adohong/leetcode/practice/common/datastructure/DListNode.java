package com.adohong.leetcode.practice.common.datastructure;

public class DListNode {

    private int val;
    private DListNode prev;
    private DListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public DListNode getPrev() {
        return prev;
    }

    public void setPrev(DListNode prev) {
        this.prev = prev;
    }

    public DListNode getNext() {
        return next;
    }

    public void setNext(DListNode next) {
        this.next = next;
    }
}
