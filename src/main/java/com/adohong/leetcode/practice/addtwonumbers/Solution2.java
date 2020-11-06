package com.adohong.leetcode.practice.addtwonumbers;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int borrow = 0;
        ListNode result = null;
        ListNode resultHead = null;
        int sum = 0;
        while (l1 != null || l2 != null || borrow != 0) {
            sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + borrow;
            borrow = sum / 10;
            if (result == null) {
                result = new ListNode(sum % 10);
                resultHead = result;
            } else {
                result.next = new ListNode(sum % 10);
                result = result.next;
            }
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        return resultHead;
    }
}
