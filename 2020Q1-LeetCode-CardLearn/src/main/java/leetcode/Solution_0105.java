package leetcode;

import leetcode.models.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_0105 {
    /**
     * 从前序与中序遍历序列构造二叉树
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        TreeNode root = buildTree(0, preorder.length - 1, 0, preorder.length - 1);
        return root;
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe)
            return null;
        int rootVal = preorder[ps];
        int ri = map.get(rootVal);
        TreeNode node = new TreeNode(rootVal);

        node.left = buildTree(is, ri - 1, ps + 1, ps + 1 + ri - 1 - is);
        node.right = buildTree(ri + 1, ie, ps + 1 + ri - 1 - is + 1, pe);
        return node;
    }
}
