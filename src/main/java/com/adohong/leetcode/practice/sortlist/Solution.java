package com.adohong.leetcode.practice.sortlist;

import com.adohong.leetcode.practice.common.datastructure.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode midNode = findMidNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;
        ListNode leftSortedList = sortList(head);
        ListNode rightSortedList = sortList(rightHead);
        return doMerge(leftSortedList, rightSortedList);
    }

    private ListNode findMidNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next;
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

    private ListNode doMerge(ListNode leftSortedList, ListNode rightSortedList) {
        ListNode resultHead = null;
        ListNode tempHead = null;
        ListNode tempLeftNode = leftSortedList;
        ListNode tempRightNode = rightSortedList;
        while(tempLeftNode != null && tempRightNode != null) {
            if (tempLeftNode.val <= tempRightNode.val) {
                if (tempHead == null) {
                    tempHead = new ListNode(tempLeftNode.val);
                    resultHead = tempHead;
                } else {
                    tempHead.next = new ListNode(tempLeftNode.val);
                    tempHead = tempHead.next;
                }
                tempLeftNode = tempLeftNode.next;
            } else {
                if (tempHead == null) {
                    tempHead = new ListNode(tempRightNode.val);
                    resultHead = tempHead;
                } else {
                    tempHead.next = new ListNode(tempRightNode.val);
                    tempHead = tempHead.next;
                }
                tempRightNode = tempRightNode.next;
            }
        }
        if (tempLeftNode == null) {
            tempHead.next = tempRightNode;
        }
        if (tempRightNode == null) {
            tempHead.next = tempLeftNode;
        }
        return resultHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode sortedList = solution.sortList(head);
        ListNode temp = sortedList;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
