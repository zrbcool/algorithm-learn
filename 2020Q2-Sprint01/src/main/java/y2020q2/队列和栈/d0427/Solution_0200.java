package y2020q2.队列和栈.d0427;

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
     */
    char[][] _grid;
    int h;
    int w;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        h = grid.length;
        w = grid[0].length;
        this._grid = grid;
        int numIslands = 0;
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (_grid[row][col] == '1') {
                    numIslands++;
                    dfs(row, col);
                }
            }
        }
        return numIslands;
    }

    private void dfs(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (nrow < 0 || ncol < 0 || nrow >= h || ncol >= w) continue;
            if (_grid[nrow][ncol] == '1') {
                _grid[nrow][ncol] = '0';
                dfs(nrow, ncol);
            }
        }
    }
}
