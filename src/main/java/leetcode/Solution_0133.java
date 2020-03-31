package leetcode;

import java.util.*;

public class Solution_0133 {
    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
     * 输出：[[2,4],[1,3],[2,4],[1,3]]
     * 解释：
     * 图中有 4 个节点。
     * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
     * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
     * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
     * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
     */
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> seen = new HashMap<>();
        Node clone = new Node(node.val);
        return cloneNode(node, clone, seen);
    }

    private Node cloneNode(Node node, Node clone, Map<Integer, Node> seen) {
        if (seen.containsKey(node.val))
            return seen.get(node.val);
        seen.put(node.val, clone);
        clone.val = node.val;
        for (Node neighbor : node.neighbors) {
            Node neighborClone = new Node(neighbor.val);
            clone.neighbors.add(cloneNode(neighbor, neighborClone, seen));
        }
        return clone;
    }
}
