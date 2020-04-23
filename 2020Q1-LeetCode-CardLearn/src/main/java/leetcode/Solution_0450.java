package leetcode;

import leetcode.models.TreeNode;

public class Solution_0450 {
    /**
     * Delete Node in a BST
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     *
     * 示例:
     *
     * root = [5,3,6,2,4,null,7]
     * key = 3
     *
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
     *
     * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
     *
     *     5
     *    / \
     *   4   6
     *  /     \
     * 2       7
     *
     * 另一个正确答案是 [5,2,6,null,4,null,7]。
     *
     *     5
     *    / \
     *   2   6
     *    \   \
     *     4   7
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode sentinel = new TreeNode(Integer.MAX_VALUE);
        sentinel.left = root;
        deleteNode(sentinel.left, key, sentinel, true);
        return sentinel.left;
    }

    public int rightMin(TreeNode root) {//1.找到以某个结点为根节点的右子树最小值。
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    public void deleteNode(TreeNode node, int key, TreeNode pre, boolean leftOrRight) {
        if (node != null) {
            if (node.val == key) {
                if (node.left == null && node.right == null) {
                    if (leftOrRight) pre.left = null;
                    else pre.right = null;
                }
                else if (node.right != null) {
                    int newVal = rightMin(node);
                    deleteNode(node.right, newVal, node, false);
                    node.val = newVal;
                }
                else {
                    TreeNode succ = node.left;
                    if (leftOrRight) pre.left = succ;
                    else pre.right = succ;
                }
            } else if (node.val > key) {
                deleteNode(node.left, key, node, true);
            } else {
                deleteNode(node.right, key, node, false);
            }
        }
    }
}
