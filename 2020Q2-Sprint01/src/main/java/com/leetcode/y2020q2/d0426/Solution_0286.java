package com.leetcode.y2020q2.d0426;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_0286 {
    /**
     * 墙与门
     * 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
     *
     * -1 表示墙或是障碍物
     * 0 表示一扇门
     * INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
     * 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
     *
     * 示例：
     *
     * 给定二维网格：
     *
     * INF  -1  0  INF
     * INF INF INF  -1
     * INF  -1 INF  -1
     *   0  -1 INF INF
     * 运行完你的函数后，该网格应该变成：
     *
     *   3  -1   0   1
     *   2   2   1  -1
     *   1  -1   2  -1
     *   0  -1   3   4
     */
    int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length <= 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                if (rooms[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] remove = queue.remove();
            int r = remove[0];
            int c = remove[1];

            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr < 0 || nr >= rooms.length || nc < 0 || nc >= rooms[nr].length) continue;
                if (rooms[nr][nc] == INF) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }


    public static void main(String[] args) {
        /**
         * [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
         */
        int[][] room = new int[][]{
            new int[]{2147483647,-1,0,2147483647},
            new int[]{2147483647,2147483647,2147483647,-1},
            new int[]{0,-1,2147483647,2147483647}
        };
        new Solution_0286().wallsAndGates(room);
    }
}
