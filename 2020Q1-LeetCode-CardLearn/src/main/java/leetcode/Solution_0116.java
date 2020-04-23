package leetcode;

public class Solution_0116 {
    /**
     * 填充每个节点的下一个右侧节点指针
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
     *
     * 提示：
     *
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     */
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

    public Node connect(Node root) {
        connect(root, null);
        return root;
    }

    public void connect(Node leftRoot, Node rightRoot) {
        if (leftRoot == null)
            return;
        leftRoot.next = rightRoot;
        if (leftRoot.right != null && rightRoot != null) {
            leftRoot.right.next = rightRoot.left;
            connect(leftRoot.right, rightRoot.left);
        }
        connect(leftRoot.left, leftRoot.right);
        if (rightRoot != null) {
            connect(rightRoot.left, rightRoot.right);
        }
    }
}
