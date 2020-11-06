package com.adohong.leetcode.practice.linkedlistcycle;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

public class Solution2 {
    public boolean hasCycle(ListNode head) {
        boolean hasCycle = true;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        do {
            if (slowPointer == null || fastPointer == null || fastPointer.next == null) {
                hasCycle = false;
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        } while (slowPointer != fastPointer);

        return hasCycle;
    }
}
