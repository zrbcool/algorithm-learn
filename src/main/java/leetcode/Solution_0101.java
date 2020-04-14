package leetcode;

import leetcode.models.TreeNode;

public class Solution_0101 {
    /**
     * 对称二叉树
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     *
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     *
     * 进阶：
     *
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return traversal(root.left, root.right);
    }

    public boolean traversal(TreeNode L, TreeNode R) {
        if (L != null && R != null) {
            if (L.val != R.val) {
                return false;
            }
            else {
                return traversal(L.left, R.right) && traversal(L.right, R.left);
            }
        }
        else return L == null && R == null;
    }
}
