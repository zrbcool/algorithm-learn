package leetcode;

import leetcode.models.TreeNode;

import java.util.*;

public class Solution_0652 {
    /**
     * 寻找重复的子树
     * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     *
     * 两棵树重复是指它们具有相同的结构以及相同的结点值。
     *
     * 示例 1：
     *
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   2   4
     *        /
     *       4
     * 下面是两个重复的子树：
     *
     *       2
     *      /
     *     4
     * 和
     *
     *     4
     * 因此，你需要以列表的形式返回上述重复子树的根结点。
     */
    List<TreeNode> result = new ArrayList<>();
    Map<String, Integer> recorder = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        collect(root);
        return result;
    }

    public String collect(TreeNode node) {
        if (node == null)
            return "";
        String str = "#" + node.val + "," + collect(node.left) + "," + collect(node.right);
        if (recorder.containsKey(str)) {
            int count = recorder.get(str) + 1;
            recorder.put(str, count);
            if (count == 2)
                result.add(node);
        } else {
            recorder.put(str, 1);
        }
        return str;
    }

    public static void main(String[] args) {
        /**
         * 输入
         * [1,2,3,4,null,2,4,null,null,4]
         * 输出
         * [[4],[2,4],[4]]
         * 差别
         * 预期结果
         * [[2,4],[4]]
         */

    }
}
