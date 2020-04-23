package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution_0200 {
    private static class Solution_BFS {

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0)
                return 0;
            int high = grid.length;
            int width = grid[0].length;
            int numIslands = 0;

            for (int i = 0; i < high; i++) {
                for (int j = 0; j < width; j++) {
                    int seq = i * width + j;
                    if (grid[i][j] == '1') {
                        numIslands++;
                        grid[i][j] = '0';
                        bfs(grid, seq);
                    }
                }
            }
            return numIslands;
        }

        private void bfs(char[][] grid, int seq) {
            int high = grid.length;
            int width = grid[0].length;

            Queue<Integer> list = new LinkedList<>();
            list.add(seq);
            while (!list.isEmpty()) {
                Integer remove = list.remove();
                int col = remove % width;
                int row = remove / width;
                if (col + 1 < width) {
                    if (grid[row][col + 1] == '1') {
                        grid[row][col + 1] = '0';
                        list.add(row * width + col + 1);
                    }
                }
                if (col - 1 >= 0) {
                    if (grid[row][col - 1] == '1') {
                        grid[row][col - 1] = '0';
                        list.add(row * width + col - 1);
                    }
                }
                if (row + 1 < high) {
                    if (grid[row + 1][col] == '1') {
                        grid[row + 1][col] = '0';
                        list.add((row + 1) * width + col);
                    }
                }
                if (row - 1 >= 0) {
                    if (grid[row - 1][col] == '1') {
                        grid[row - 1][col] = '0';
                        list.add((row - 1) * width + col);
                    }
                }
            }
        }
    }

    /**
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * <p>
     * 输出: 1
     * <p>
     * 示例 2:
     * <p>
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * <p>
     * 输出: 3
     */
    private static class Solution_DFS {
        public int numIslands(char[][] grid) {
            Set<Integer> seen = new HashSet<>();
            int numIslands = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        boolean dfs = dfs(grid, i, j, seen);
//                        System.out.println(String.format("i=%s, j=%s, dfs=%s", i, j, dfs));
                        if (dfs) {
                            numIslands++;
                        }
                    }
                }
            }

            return numIslands;
        }

        private int hash(int width, int x, int y) {
            return x * width + y;
        }

        private boolean dfs(char[][] grid, int x, int y, Set<Integer> seen) {
            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};
            int width = grid[0].length;
            int hash = hash(width, x, y);
            if (seen.contains(hash)) {
                return false;
            }
            seen.add(hash);

            for (int i = 0; i < dx.length; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if (newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length) {
                    continue;
                }
                if (grid[newx][newy] == '1' && !seen.contains(hash(width, newx, newy))) {
                    dfs(grid, newx, newy, seen);
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[4][];
        /**
         * 输入:
         * 11110
         * 11010
         * 11000
         * 00000
         *
         * 输出: 1
         */
        grid[0] = new char[]{'1', '1', '1', '1', '0'};
        grid[1] = new char[]{'1', '1', '0', '1', '0'};
        grid[2] = new char[]{'1', '1', '0', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '0', '0'};
        System.out.println(new Solution_DFS().numIslands(grid));

        /**
         * 输入:
         * 11000
         * 11000
         * 00100
         * 00011
         *
         * 输出: 3
         */
        grid[0] = new char[]{'1', '1', '0', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '1', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '1', '1'};
        System.out.println(new Solution_DFS().numIslands(grid));

        grid = new char[][] {{'1'}};
        System.out.println(new Solution_DFS().numIslands(grid));


//        Set<int[]> set = new HashSet<>();
//        set.add(new int[]{1,1});
//        set.add(new int[]{1,1});
//        set.add(new int[]{1,1});
//        set.add(new int[]{1,1});
//        System.out.println(set);
    }
}