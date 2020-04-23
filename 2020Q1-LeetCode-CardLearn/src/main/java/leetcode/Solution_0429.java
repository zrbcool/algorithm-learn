package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_0429 {
    /**
     * N叉树的层序遍历
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     *
     * 例如，给定一个 3叉树 :
     *
     * 返回其层序遍历:
     *
     * [
     *      [1],
     *      [3,2,4],
     *      [5,6]
     * ]
     *
     * 说明:
     *
     * 树的深度不会超过 1000。
     * 树的节点总数不会超过 5000。
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

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        Queue<List<Node>> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rList = new ArrayList<>();
        rList.add(root.val);
        result.add(rList);
        queue.offer(root.children);
        queue.offer(null);

        rList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Node> remove = queue.remove();
            if (remove == null) {
                if (queue.isEmpty()) break;
                queue.offer(null);
                result.add(rList);
                rList = new ArrayList<>();
                continue;
            }
            for (Node node : remove) {
                rList.add(node.val);
                queue.offer(node.children);
            }
        }
        return result;
    }
}
