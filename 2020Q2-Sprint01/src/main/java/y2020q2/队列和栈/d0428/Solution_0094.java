package y2020q2.队列和栈.d0428;

import java.util.*;

public class Solution_0094 {
    /**
     * 二叉树的中序遍历
     * 给定一个二叉树，返回它的中序 遍历。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> seen = new HashSet<>();

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (!seen.contains(pop.left) && pop.left != null) {
                stack.push(pop);
                stack.push(pop.left);
            }
            else {
                result.add(pop.val);
                seen.add(pop);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
            }
        }
        return result;
    }
}
