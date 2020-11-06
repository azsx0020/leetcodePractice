package com.adohong.leetcode.practice.linkedlistcycle;

import com.adohong.leetcode.practice.common.datastructure.ListNode;
import java.util.HashSet;

public class Solution {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        boolean hasCycle = false;
        while (head != null) {
            if (!hashSet.add(head)) {
                hasCycle = true;
                break;
            }
            head = head.next;
        }
        return hasCycle;
    }
}
