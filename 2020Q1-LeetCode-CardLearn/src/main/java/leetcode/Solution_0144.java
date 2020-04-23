package leetcode;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_0144 {
    /**
     * 二叉树的前序遍历
     * 给定一个二叉树，返回它的 前序 遍历。
     *
     *  示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,2,3]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * @param root
     * @return
     */
    private static class Solution01 {
        private List<Integer> list = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return list;
            } else {
                list.add(root.val);
                preorderTraversal(root.left);
                preorderTraversal(root.right);
            }
            return list;
        }
    }
}
