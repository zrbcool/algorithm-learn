package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_0590 {
    /**
     * N-ary Tree Postorder Traversal
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     *
     * 例如，给定一个 3叉树 :
     *
     * 返回其后序遍历: [5,6,3,2,4,1].
     *
     *
     *
     * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
     */
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(Node node, List<Integer> list) {
        if (node == null) return;
        for (Node child : node.children) {
            postorder(child, list);
        }
        list.add(node.val);
    }
}
