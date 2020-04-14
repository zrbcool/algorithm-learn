package leetcode;

import leetcode.models.TreeNode;

import java.util.*;

public class Solution_0102 {
    /**
     * 二叉树的层序遍历
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     *
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * [3,9,20,null,null,15,7]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, List<Integer>> level2List = new HashMap<>();
        Map<TreeNode, Integer> node2Level = new HashMap<>();
        int level = 0;
        queue.offer(root);
        node2Level.put(root, level);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null)
                continue;
            level = node2Level.get(poll);
            List<Integer> list = level2List.getOrDefault(level, new ArrayList<>());
            list.add(poll.val);
            level2List.put(level, list);
            if (poll.left != null) {
                queue.offer(poll.left);
                node2Level.put(poll.left, level + 1);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                node2Level.put(poll.right, level + 1);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : level2List.entrySet()) {
            lists.add(entry.getKey(), entry.getValue());
        }
        return lists;
    }
}
