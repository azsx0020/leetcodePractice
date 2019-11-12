package com.adohong.leetcode.practice.addtwonumbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        int bit = 0, sum = 0;
        ListNode currentNode = listNode;
        for (ListNode node1 = l1, node2 = l2; node1 != null || node2 != null;
            node1 = (null == node1 ? null : node1.next), node2 = (null == node2 ? null : node2.next)) {
            sum = (null == node1 ? 0 : node1.val) + (null == node2 ? 0 : node2.val) + bit;
            currentNode.next = new ListNode(sum % 10);
            bit = sum / 10;
            currentNode = currentNode.next;
        }
        if (0 != bit) {
            currentNode.next = new ListNode(bit);
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(8);
        ListNode node2 = new ListNode(0);
        Solution solution = new Solution();
        solution.addTwoNumbers(node1, node2);
    }


}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
