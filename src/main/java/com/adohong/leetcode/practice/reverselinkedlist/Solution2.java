package com.adohong.leetcode.practice.reverselinkedlist;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

public class Solution2 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode newHead = head;
        ListNode next = null;
        while(newHead != null) {
            next = newHead.next;
            newHead.next = pre;
            pre = newHead;
            newHead = next;
        }
        return pre;

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        ListNode result = solution2.reverseList(head);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
