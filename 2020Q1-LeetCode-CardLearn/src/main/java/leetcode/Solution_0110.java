package leetcode;

import leetcode.models.TreeNode;

public class Solution_0110 {
    /**
     * 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     */
    public boolean isBalanced(TreeNode root) {
        isBalanced(root, 0);
        return this.result;
    }
    private boolean result = true;
    private boolean finish = false;
    public int isBalanced(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        if (finish) return -1;
        int left = isBalanced(node.left, depth + 1);
        if (finish) return -1;
        int right = isBalanced(node.right, depth + 1);
        if (finish) return -1;

        if (Math.abs(left - right) > 1) {
            this.result = false;
            this.finish = true;
        }
        return Math.max(left, right);
    }
}
