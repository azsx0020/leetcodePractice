package com.adohong.leetcode.practice.reorderlist;

import com.adohong.leetcode.practice.common.datastructure.ListNode;


// 有更好的方案：新建一个列表，把node都放进去。
public class Solution {
    public void reorderList(ListNode head) {
        ListNode first = head;
        ListNode last = head;
        ListNode secondLast = head;
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        while (first != secondLast && first.next != null) {
            processReorder(first, secondLast);
            first = first.next.next;
            secondLast = head;
            while (secondLast.next.next != null) {
                secondLast = secondLast.next;
            }

        }

    }

    private void processReorder(ListNode first, ListNode secondLast) {
        ListNode last = secondLast.next;
        secondLast.next = null;
        ListNode temp = first.next;
        first.next = last;
        last.next = temp;
    }
}
