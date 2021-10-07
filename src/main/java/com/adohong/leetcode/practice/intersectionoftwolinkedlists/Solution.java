package com.adohong.leetcode.practice.intersectionoftwolinkedlists;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

// 链表交叉，双指针法
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currentTraversListNodeHeadA = headA;
        ListNode currentTraversListNodeHeadB = headB;
        ListNode Apointer = currentTraversListNodeHeadA;
        ListNode Bpointer = currentTraversListNodeHeadB;
        int moveCount = 0;
        while(Apointer != Bpointer) {
            if (Apointer == null) {
                if (currentTraversListNodeHeadA == headA) {
                    Apointer = headB;
                    currentTraversListNodeHeadA = headB;
                } else {
                    return null;
                }
            } else {
                Apointer = Apointer.next;
            }
            if (Bpointer == null) {
                if (currentTraversListNodeHeadB == headB) {
                    Bpointer = headA;
                    currentTraversListNodeHeadB = headA;
                } else {
                    return null;
                }
            } else {
                Bpointer = Bpointer.next;
            }
        }
        return Apointer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }
}
