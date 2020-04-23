package leetcode;

import leetcode.models.TreeNode;

public class Solution_0235 {
    /**
     * 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     *
     *
     *
     *
     * 示例 1:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * 示例 2:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     *
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }
    private TreeNode result;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        boolean left = false, right = false, mid;
        if (p.val < root.val && q.val < root.val) {
            left = dfs(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            right = dfs(root.right, p, q);
        } else {
            left = dfs(root.left, p, q);
            right = dfs(root.right, p, q);
        }
        mid = root == p || root == q;

        if (mid) {
            if (left || right) {
                this.result = root;
                return true;
            }
        } else {
            if (left && right) {
                this.result = root;
                return true;
            }
        }
        return mid || right || left;
    }
}
