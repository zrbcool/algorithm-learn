package leetcode;

import java.util.*;

public class Solution {

    static class Solution_01 {

        public int maxDistance(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;

            int max = -1;
            Queue<Integer> list = new LinkedList<>();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grid[i][j] == 0) {
                        list.offer(hash(i, j, width));
                    }
                }
            }
            return dfs(list, grid);
        }

        private int hash(int x, int y, int width) {
            return x * width + y;
        }

        private int dfs(Queue<Integer> list, int[][] grid) {
            Set<Integer> seen = new HashSet<>();
            Map<Integer, Integer> dist = new HashMap<>();

            int height = grid.length;
            int width = grid[0].length;
            int i = -1, j = -1;
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            seen.add(iterator.next());
//        }

            while (!list.isEmpty()) {
                int remove = list.poll();
                i = remove / width;
                j = remove % width;
//            if (seen.contains(remove)) {
//                continue;
//            }
                seen.add(hash(i, j, width));
                int newi = i + 1;
                int newj = j;
                if (newi < width) {
                    int hash = hash(newi, newj, width);
                    if (!seen.contains(hash)) {
                        if (grid[newi][newj] == 0) {
                            seen.add(hash);
                            list.offer(hash);
                            dist.put(hash, dist.getOrDefault(hash(i, j, width), 1) + 1);
                        }
                    }
                }

                newi = i - 1;
                newj = j;
                if (newi >= 0) {
                    int hash = hash(newi, newj, width);
                    if (!seen.contains(hash)) {
                        if (grid[newi][newj] == 0) {
                            seen.add(hash);
                            list.offer(hash);
                            dist.put(hash, dist.getOrDefault(hash(i, j, width), 1) + 1);
                        }
                    }
                }

                newi = i;
                newj = j + 1;
                if (newj < height) {
                    int hash = hash(newi, newj, width);
                    if (!seen.contains(hash)) {
                        if (grid[newi][newj] == 0) {
                            seen.add(hash);
                            list.offer(hash);
                            dist.put(hash, dist.getOrDefault(hash(i, j, width), 1) + 1);
                        }
                    }
                }

                newi = i;
                newj = j - 1;
                if (newj >= 0) {
                    int hash = hash(newi, newj, width);
                    if (!seen.contains(hash)) {
                        if (grid[newi][newj] == 0) {
                            seen.add(hash);
                            list.offer(hash);
                            dist.put(hash, dist.getOrDefault(hash(i, j, width), 1) + 1);
                        }
                    }
                }
            }

            if (i == -1 && j == -1)
                return -1;
            else
                return dist.getOrDefault(hash(i, j, width), 1) ;
        }

    }

    static class Solution_02 {
        public int maxDistance(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;

            int max = -1;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grid[i][j] == 0) {
                        int temp = bfs(grid, i, j);
                        if (temp > max) {
                            max = temp;
                        }
                    }
                }
            }
            return max;
        }

        private int hash(int x, int y, int width) {
            return x * width + y;
        }

        private int bfs(int[][] grid, int x, int y) {
            int height = grid.length;
            int width = grid[0].length;
            Queue<Integer> list = new LinkedList<>();
            Set<Integer> seen = new HashSet<>();
            int[][] step = new int[width][width];
            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};
            list.offer(hash(x, y, width));
            while (!list.isEmpty()) {
                Integer remove = list.poll();
                int i = remove / width;
                int j = remove % width;
                for (int k = 0; k < dx.length; k++) {
                    int newi = i + dx[k];
                    int newj = j + dy[k];
                    if (newi >= width || newj >= width || newi < 0 || newj < 0)
                        continue;

                    if (grid[newi][newj] == 1) {
                        return step[i][j] + 1;
                    }
                    int hash = hash(newi, newj, width);
                    if (!seen.contains(hash)) {
                        step[newi][newj] = step[i][j] + 1;
                        seen.add(hash);
                        list.offer(hash);
                    }
                }

            }

            return -1;
        }
    }

    public static void main(String[] args) {
        /**
         * 输入：[[1,0,1],[0,0,0],[1,0,1]]
         * 输出：2
         * 解释：
         * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
         */
        int[][] grid = new int[3][3];
        grid[0] = new int[]{1,0,1};
        grid[1] = new int[]{0,0,0};
        grid[2] = new int[]{1,0,1};
        /**
         * [[1,0,0],[0,0,0],[0,0,0]]
         */
//        grid[0] = new int[]{1,0,0};
//        grid[1] = new int[]{0,0,0};
//        grid[2] = new int[]{0,0,0};


//        grid[0] = new int[]{1,1,1};
//        grid[1] = new int[]{1,1,1};
//        grid[2] = new int[]{1,1,1};


//        grid[0] = new int[]{0,0,0};
//        grid[1] = new int[]{0,0,0};
//        grid[2] = new int[]{0,0,0};
        System.out.println(new Solution_02().maxDistance(grid));
    }
}
