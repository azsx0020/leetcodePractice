package com.adohong.leetcode.practice.populatingnextrightpointers;

import com.adohong.leetcode.practice.common.datastructure.Node;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {


    private void traversal(Node root) {
        if (root == null) return;

        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while(nodes.size() > 0) {
            int nodeSize = nodes.size();
            Node lastNode = null;
            for(int i = 0; i < nodeSize; i++) {
                Node currentNode = nodes.get(0);
                nodes.remove(0);

                if (currentNode.left != null) {
                    nodes.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodes.add(currentNode.right);
                }
                if (lastNode != null) {
                    lastNode.next = currentNode;
                }
                lastNode = currentNode;
            }
        }

    }

    public Node connect(Node root) {
        traversal(root);
        return root;

    }
}
