package leetcode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution_0094 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
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
     * <p>
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        stack.push(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            if (pop.right != null && (stack.empty() || pop.right != stack.peek())) {
                stack.push(pop.right);
            }
            if (pop.left == null || seen.contains(pop.left)) {
                result.add(pop.val);
                seen.add(pop);
                continue;
            }

            stack.push(pop);
            stack.push(pop.left);
        }
        return result;
    }

    public static void main(String[] args) {
        /**
         * [3,1,2]
         */
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        root.left = node2;
        root.right = node3;

        System.out.println(new Solution_0094().inorderTraversal(root));


    }
}
