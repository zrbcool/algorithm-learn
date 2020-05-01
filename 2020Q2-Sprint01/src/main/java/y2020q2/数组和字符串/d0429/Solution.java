package y2020q2.数组和字符串.d0429;

import java.util.*;

public class Solution {
    /**
     * 对角线遍历
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     *
     * 示例:
     *
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     *
     * 输出:  [1,2,4,7,5,3,6,8,9]
     *
     * 解释:
     *
     * 说明:
     *
     * 给定矩阵中的元素总数不会超过 100000 。
     *
     *
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};
        int M = matrix.length;
        int N = matrix[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            /**
             * r=0,c=0
             * r=1,c=0 r=0,c=1
             * r=2,c=0 r=1,c=1 r=0,c=2
             */
            List<Integer> subList = new LinkedList<>();
            int r = x, c = 0;
            while (r >= 0 || c < N) {
                if (r < 0) r = 0;
                subList.add(matrix[r][c]);
                r--;
                c++;
            }
            list.add(subList);
        }

        for (int y = 1; y < M; y++) {
            /**
             * r=2,c=1 r=1,c=2
             * r=2,c=2
             */
            List<Integer> subList = new LinkedList<>();
            for (int r = N - 1, c = y, i = 0; i <= (N - y - 1) && r - i >= 0 && r - i < M; i++) {
                subList.add(matrix[r - i][c + i]);
            }
            list.add(subList);
        }

        int[] res = new int[M * N];
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subList = list.get(i);
            if (i % 2 == 1) {
                Collections.reverse(subList);
            }
            for (Integer item : subList) {
                res[idx++] = item;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "[[2,3]]";
        test = test.replace('[', '{').replace(']','}');
        System.out.println(test);

        int[][] matrix = new int[][]{{2,3}};
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(matrix)));
    }
}
