package com.adohong.leetcode.practice.mergeksortedlists;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode result = mergeList(lists, 0, lists.length - 1);
        return result;
    }

    private ListNode mergeList(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (end == start + 1) {
            return mergeTwoLists(lists[start], lists[end]);
        }
        int mid = (start + end) / 2;
        return mergeTwoLists(mergeList(lists, start, mid), mergeList(lists, mid + 1, end));

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }
        return head.next;
    }
}
