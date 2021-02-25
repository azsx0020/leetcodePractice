package com.adohong.leetcode.practice.removelinkedlistelements;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

// 创建一个临时的head，很重要
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode tempHead = new ListNode(Integer.MAX_VALUE);
        tempHead.next = head;
        ListNode first = tempHead;
        ListNode second = head;
        while (second != null) {
            if (second.val == val) {
                first.next = second.next;
            } else {
                first = second;
            }
            second = second.next;
        }
        return tempHead.next;
    }

}