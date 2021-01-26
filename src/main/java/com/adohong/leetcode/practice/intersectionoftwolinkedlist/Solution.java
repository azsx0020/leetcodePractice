package com.adohong.leetcode.practice.intersectionoftwolinkedlist;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode firstPointer = headA;
        ListNode secondPointer = headB;
        int countA = 0;
        ListNode tmpA = headA;
        while (tmpA != null) {
            tmpA = tmpA.next;
            countA++;
        }

        int countB = 0;
        ListNode tmpB = headB;
        while (tmpB != null) {
            tmpB = tmpB.next;
            countB++;
        }
        int count = 0;
        while (count < countA + countB && firstPointer != secondPointer) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
            if (firstPointer == null) {
                firstPointer = headB;
            }
            if (secondPointer == null) {
                secondPointer = headA;
            }
            count++;
        }
        if (firstPointer == secondPointer) {
            return firstPointer;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
        ListNode result = solution.getIntersectionNode(headA, headB);
        System.out.println(result.val);
    }
}
