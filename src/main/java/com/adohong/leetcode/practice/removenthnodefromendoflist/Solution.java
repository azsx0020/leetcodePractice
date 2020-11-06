package com.adohong.leetcode.practice.removenthnodefromendoflist;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode first = head;
        ListNode second = null;
        boolean lenthLittleThanN = true;
        for(int i = 0; first.next != null; i++) {
            first = first.next;
            if (n < 2 || i >= n - 2) lenthLittleThanN = false;
            if (i >= n - 1) {
                if (second == null) {
                    second = head;
                } else {
                    second = second.next;
                }

            }
        }
        if (lenthLittleThanN) {
            return null;
        }
        if (second == null) {
            return head.next;
        }
        if (second.next != null) {
            second.next = second.next.next;
        }
        return head;
    }
}
