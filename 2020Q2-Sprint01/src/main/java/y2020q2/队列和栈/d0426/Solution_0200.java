package y2020q2.队列和栈.d0426;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_0200 {
    /**
     * 岛屿数量
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     *
     *
     * 示例 1:
     *
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * 输出: 1
     * 示例 2:
     *
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * 输出: 3
     * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     *
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int _h = grid.length;
        int _w = grid[0].length;
        int result = 0;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int row = 0; row < _h; row++) {
            for (int col = 0; col < _w; col++) {
                if (grid[row][col] == '1') {
                    grid[row][col] = '0';
                    result++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(row * _w + col);

                    while (!queue.isEmpty()) {
                        int poll = queue.remove();
                        int r = poll / _w;
                        int c = poll % _w;

                        for (int i = 0; i < 4; i++) {
                            int nr = r + dx[i];
                            int nc = c + dy[i];
                            if (nr < 0 || nc < 0 || nr >= _h || nc >= _w) continue;
                            if (grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                queue.offer(nr * _w + nc);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * [
     *  ["1","1","0","0","0"],
     *  ["1","1","0","0","0"],
     *  ["0","0","1","0","0"],
     *  ["0","0","0","1","1"]
     * ]
     */
}
