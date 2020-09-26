package com.adohong.leetcode.practice.populatingnextrightpointers;

import com.adohong.leetcode.practice.common.datastructure.Node;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<NodeWithLevel> traversal(Node root, int level) {
        List<NodeWithLevel> nodeWithLevels = new ArrayList<>();
        if (root != null) {
            NodeWithLevel nodeWithLevel = new NodeWithLevel();
            nodeWithLevel.node = root;
            nodeWithLevel.level = level;
            nodeWithLevels.add(nodeWithLevel);
            nodeWithLevels.addAll(traversal(root.left, level + 1));
            nodeWithLevels.addAll(traversal(root.right, level + 1));
        }
        return nodeWithLevels;
    }

    public Node connect(Node root) {
        if (root == null) return null;
        List<NodeWithLevel> nodeWithLevels = traversal(root, 0);
        for (int i = 0; i < nodeWithLevels.size() - 1; i++) {
            for (int j = i + 1; j < nodeWithLevels.size(); j++) {
                if (nodeWithLevels.get(i).level == nodeWithLevels.get(j).level) {
                    nodeWithLevels.get(i).node.next = nodeWithLevels.get(j).node;
                    break;
                }
            }
        }
        return root;

    }
}

class NodeWithLevel {
    int level;
    Node node;
}
