package leetcode;

import leetcode.models.TreeNode;

public class Solution_0112 {
    /**
     * 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    /**
     * 0 true, 1 false,
     */
    public boolean dfs(TreeNode node, int preSum, int sum) {
        if (node == null) {
            return false;
        } else {
            if (node.left == null && node.right == null) {
                return preSum + node.val == sum;
            } else {
                if (dfs(node.left, preSum + node.val, sum)) {
                    return true;
                }
                return dfs(node.right, preSum + node.val, sum);
            }
        }
    }
}
