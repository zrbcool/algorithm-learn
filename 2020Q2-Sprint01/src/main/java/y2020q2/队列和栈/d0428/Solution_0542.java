package y2020q2.队列和栈.d0428;

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

    int _h, _w;
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    public int[][] updateMatrix(int[][] matrix) {
        _h = matrix.length;
        _w = matrix[0].length;
        int[][] dest = new int[_h][_w];
        for (int[] ints : dest) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < _h; i++) {
            for (int j = 0; j < _w; j++) {
                if (matrix[i][j] == 0) {
                    dest[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int x = 0; x < size; x++) {
                int[] remove = queue.remove();
                int row = remove[0];
                int col = remove[1];
                for (int y = 0; y < 4; y++) {
                    int nr = row + dx[y];
                    int nc = col + dy[y];
                    if (nr < 0 || nc < 0 || nr >= _h || nc >= _w) continue;
                    if (matrix[nr][nc] > 0) {
                        if (dest[nr][nc] > step + 1) {
                            dest[nr][nc] = step + 1;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            step++;
        }
        return dest;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{0,0,0},
                new int[]{0,1,0},
                new int[]{0,0,0}
        };
        new Solution_0542().updateMatrix(matrix);
    }
}
