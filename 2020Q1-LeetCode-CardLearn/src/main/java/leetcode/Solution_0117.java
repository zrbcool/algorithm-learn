package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_0117 {
    private static class Node {
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
    }

    /**
     * 填充每个节点的下一个右侧节点指针 II
     * 给定一个二叉树
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * 进阶：
     *
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *
     * 提示：
     *
     * 树中的节点数小于 6000
     * -100 <= node.val <= 100
     */
    public Node connect(Node root) {
        preOder(root, 0);
        for (List<Node> list : heightToList.values()) {
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }
        return root;
    }
    private Map<Integer, List<Node>> heightToList = new HashMap<>();
    public void preOder(Node root, int height) {
        if (root == null)
            return;
        List<Node> list = heightToList.getOrDefault(height, new ArrayList<>());
        list.add(root);
        heightToList.put(height, list);

        preOder(root.left, height + 1);
        preOder(root.right, height + 1);
    }

    public void connect(Node left, Node right) {
        //orphan
        if (left == null) {
            return;
        }

        left.next = right;

        if (left.left != null) {
            if (left.right != null) {
                connect(left.left, left.right);
            }
            else if (right != null) {
                if (right.left != null) {
                    connect(left.left, right.left);
                }
                else {
                    connect(left.left, right.right);
                }
            }
        }
        if (left.right != null) {
            if (right != null) {
                if (right.left != null) {
                    connect(left.right, right.left);
                }
                else {
                    connect(left.right, right.right);
                }
            }
        }
        if (right != null) {
            if (right.left != null) {
                connect(right.left, right.right);
            }
        }
    }
}
