package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Solution_0200 {

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
                    dfs(grid, seq);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int seq) {
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
                    list.add((row -1) * width + col);
                }
            }
        }
    }

}