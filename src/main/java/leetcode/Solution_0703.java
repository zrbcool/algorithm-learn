package leetcode;

public class Solution_0703 {
    private static class KthLargest {
        /**
         * Kth Largest Element in a Stream
         * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
         *
         * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
         *
         * 示例:
         *
         * int k = 3;
         * int[] arr = [4,5,8,2];
         * KthLargest kthLargest = new KthLargest(3, arr);
         * kthLargest.add(3);   // returns 4
         * kthLargest.add(5);   // returns 5
         * kthLargest.add(10);  // returns 5
         * kthLargest.add(9);   // returns 8
         * kthLargest.add(4);   // returns 8
         * 说明:
         * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
         *
         * 输入：
         * ["KthLargest","add","add","add","add","add"]
         * [[1,[]],[-3],[-2],[-4],[0],[4]]
         * 输出：
         * [null,-1,-1,-1,0,4]
         * 预期：
         * [null,-3,-2,-2,0,4]
         *
         */
        private static class TreeNode {
            public int val;
            public int count = 1;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        private static class BST {
            private KthLargest.TreeNode root;
            public BST() {
            }

            public void add(int val) {
                if (root == null) {
                    root = new KthLargest.TreeNode(val);
                } else {
                    add(val, root);
                }
            }

            private KthLargest.TreeNode add(int val, KthLargest.TreeNode node) {
                if (node == null) {
                    return new KthLargest.TreeNode(val);
                }
                if (node.val < val) {
                    node.right = add(val, node.right);
                }
                else if (node.val > val) {
                    node.left = add(val, node.left);
                }
                node.count++;
                return node;
            }

            public KthLargest.TreeNode search(int k) {
                return search(root, k);
            }

            private KthLargest.TreeNode search(KthLargest.TreeNode node, int k) {
                if (node == null) {
                    return null;
                }
                int leftNodeCount = node.left != null ? node.left.count : 0;
                int rightNodeCount = node.right != null ? node.right.count : 0;
                int currNodeCount = node.count - leftNodeCount - rightNodeCount;
                if (k > currNodeCount + rightNodeCount ) {
                    // k > 当前结点数加右子树的结点数，则搜索左子树
                    return search(node.left, k - currNodeCount - rightNodeCount);
                } else if (k <= rightNodeCount) {
                    // k <= 右子树的结点数，则搜索右子树
                    return search(node.right, k);
                } else {
                    // k == 当前结点数加右子树的结点数，则找到第k大的结点
                    return node;
                }
            }
        }

        private BST bst;
        private int k;
        public KthLargest(int k, int[] nums) {
            BST bst = new BST();
            for (int num : nums) {
                bst.add(num);
            }
            this.bst = bst;
            this.k = k;
        }

        public int add(int val) {
            bst.add(val);
            return bst.search(k).val;
        }
    }
}
