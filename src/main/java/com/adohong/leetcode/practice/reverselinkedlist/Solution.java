package com.adohong.leetcode.practice.reverselinkedlist;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

public class Solution {

    private ListNode recursiveRevert(ListNode head) {
        if (head.next != null) {
            ListNode reversedList = recursiveRevert(head.next);
            head.next = null;
            ListNode newTail = reversedList;
            while (newTail.next != null) {
                newTail = newTail.next;
            }
            newTail.next = head;
            return reversedList;
        } else {
             return head;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return recursiveRevert(head);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        ListNode result = solution.reverseList(head);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
