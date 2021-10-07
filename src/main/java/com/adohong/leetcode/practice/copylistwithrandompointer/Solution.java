package com.adohong.leetcode.practice.copylistwithrandompointer;


import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> hashMapForOriginalList = new HashMap<>();
        Map<Integer, Node> hashMapForCopiedList = new HashMap<>();
        Node tempOriginal = head;
        Node copiedHead = null;
        Node tempCopied = null;
        int sequenceOriginal = 0;
        while (tempOriginal != null) {
            hashMapForOriginalList.put(tempOriginal, sequenceOriginal);
            if (copiedHead == null) {
                copiedHead = new Node(tempOriginal.val);
                tempCopied = copiedHead;
            } else {
                tempCopied.next = new Node(tempOriginal.val);
                tempCopied = tempCopied.next;
            }
            hashMapForCopiedList.put(sequenceOriginal,tempCopied);
            sequenceOriginal++;
            tempOriginal = tempOriginal.next;
        }
        tempOriginal = head;
        tempCopied = copiedHead;
        while (tempOriginal != null) {
            if (tempOriginal.random != null) {
                int sequence = hashMapForOriginalList.get(tempOriginal.random);
                tempCopied.random = hashMapForCopiedList.get(sequence);
            }
            tempOriginal = tempOriginal.next;
            tempCopied = tempCopied.next;
        }
        return copiedHead;
    }
}
