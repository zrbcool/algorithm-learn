package leetcode;

import java.util.*;

public class Solution_0542 {
    /**
     * 01 矩阵
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     *
     * 两个相邻元素间的距离为 1 。
     *
     * 示例 1:
     * 输入:
     *
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * 输出:
     *
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * 示例 2:
     * 输入:
     *
     * 0 0 0
     * 0 1 0
     * 1 1 1
     * 输出:
     *
     * 0 0 0
     * 0 1 0
     * 1 2 1
     * 注意:
     *
     * 给定矩阵的元素个数不超过 10000。
     * 给定矩阵中至少有一个元素是 0。
     * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
     */
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1)
                    result[i][j] = dfs(matrix, i, j);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Integer> disMap = new HashMap();

        queue.offer(new int[]{i, j});

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int distance = 0;
        while (!queue.isEmpty()) {
            int[] remove = queue.remove();
            int x = remove[0], y = remove[1];
            distance = disMap.getOrDefault(hash(x, y, matrix[0].length), 0);

            for (int k = 0; k < dx.length; k++) {
                int newx = x + dx[k];
                int newy = y + dy[k];
                if (newx < 0 || newy < 0 || newx >= matrix.length || newy >= matrix[0].length) {
                    continue;
                }
                if (matrix[newx][newy] == 0) {
                    return distance + 1;
                }
                disMap.put(hash(newx, newy, matrix[0].length), distance+1);
                queue.offer(new int[]{newx, newy});
            }
        }
        return distance;
    }

    private int hash(int x, int y, int width) {
        return x * width + y;
    }

    public static void main(String[] args) {
        /**
         * 输入：
         * [[0,0,0],[0,1,0],[1,1,1]]
         * 输出：
         * [[0,0,0],[0,1,0],[1,1,1]]
         * 预期：
         * [[0,0,0],[0,1,0],[1,2,1]]
         */
    }
}
