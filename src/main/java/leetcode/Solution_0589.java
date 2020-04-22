package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_0589 {
    /**
     * N叉树的前序遍历
     * N-ary Tree Preorder Traversal
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     *
     * 例如，给定一个 3叉树 :
     *
     * 返回其前序遍历: [1,3,5,6,2,4]。
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

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        for (Node child : node.children) {
            preorder(child, list);
        }
    }
}
