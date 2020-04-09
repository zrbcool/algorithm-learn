package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_0454 {
    /**
     * 四数相加 II
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     *
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     *
     * 例如:
     *
     * 输入:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     *
     * 输出:
     * 2
     *
     * 解释:
     * 两个元组如下:
     * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */
    Map<Integer, List<Integer>> cache = new HashMap<>();
    int N;
    List<Integer> last = new ArrayList<>();


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> count = new HashMap();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (count.containsKey(sum)) {
                    count.put(sum, count.get(sum) + 1);
                } else {
                    count.put(sum, 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < C.length; j++) {
                int sum = D[i] + C[j];
                res += count.getOrDefault(-sum, 0);
            }
        }
        return res;
    }



    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        for (int a = 0; a < A.length; a++) {
            for (int b = 0; b < B.length; b++) {
                for (int c = 0; c < C.length; c++) {
                    for (int d = 0; d < D.length; d++) {
                        if (A[a] + B[b] + C[c] + D[d] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 1)
            return A[0] + B[0] + C[0] + D[0] == 0 ? 1 : 0;

        for (int value : D) {
            last.add(value);
        }
        this.N = A.length;
        int[][] matrix = new int[][]{A, B, C, D};
        int count = 0;
        for (int i = 0; i < N; i++) {
            List<Integer> dfs = dfs1(matrix, 0, i);
            for (Integer df : dfs) {
                if (df == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Integer> dfs1(int[][] matrix, int x, int y) {
        if (x == matrix.length - 1) {
            List<Integer> list = new ArrayList<>();
            list.add(matrix[x][y]);
            return list;
        }
        int row =  x + 1;
        if (cache.containsKey(x * N + y))
            return cache.get(x * N + y);
        List<Integer> rst = new ArrayList<>();
        for (int col = 0; col < N; col++) {
            List<Integer> dfs = dfs1(matrix, row, col);
            for (Integer df : dfs) {
                rst.add(matrix[x][y] + df);
            }
        }
        cache.put(x * N + y, rst);
        return rst;
    }

    public static void main(String[] args) {
        /**
         * [1,2]
         * [-2,-1]
         * [-1,2]
         * [0,2]
         */
//        System.out.println(new Solution().fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        /**
         * [-1,-1]
         * [-1,1]
         * [-1,1]
         * [1,-1]
         */
        System.out.println(new Solution_0454().fourSumCount(new int[]{-1, 1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}));
    }
}
