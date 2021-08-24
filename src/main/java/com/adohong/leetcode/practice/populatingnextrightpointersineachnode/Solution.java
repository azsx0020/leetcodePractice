package com.adohong.leetcode.practice.populatingnextrightpointersineachnode;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import com.adohong.leetcode.practice.common.datastructure.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(root);
        Queue currentWorkOn = queue1;
        while(!currentWorkOn.isEmpty()) {
            Node temp = (Node) currentWorkOn.poll();
            temp.next = (Node) currentWorkOn.peek();
            if (currentWorkOn == queue1) {
                if (temp.left != null) {
                    queue2.add(temp.left);
                }
                if (temp.right != null) {
                    queue2.add(temp.right);
                }
            } else {
                if (temp.left != null) {
                    queue1.add(temp.left);
                }
                if (temp.right != null) {
                    queue1.add(temp.right);
                }
            }
            if (currentWorkOn.isEmpty()) {
                currentWorkOn = (currentWorkOn == queue1 ? queue2 : queue1);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Solution solution = new Solution();
        solution.connect(root);
    }
}