package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution_0733 {
    /**
     * 图像渲染
     * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
     *
     * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
     *
     * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
     *
     * 最后返回经过上色渲染后的图像。
     *
     * 示例 1:
     *
     * 输入:
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * sr = 1, sc = 1, newColor = 2
     * 输出: [[2,2,2],[2,2,0],[2,0,1]]
     * 解析:
     * 在图像的正中间，(坐标(sr,sc)=(1,1)),
     * 在路径上所有符合条件的像素点的颜色都被更改成2。
     * 注意，右下角的像素没有更改为2，
     * 因为它不是在上下左右四个方向上与初始点相连的像素点。
     * 注意:
     *
     * image 和 image[0] 的长度在范围 [1, 50] 内。
     * 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
     * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        int oldColor = image[sr][sc];
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        Set<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] remove = queue.remove();
            seen.add(hash(remove[0], remove[1], image[0].length));
            if (image[remove[0]][remove[1]] == oldColor) {
                image[remove[0]][remove[1]] = newColor;
                for (int i = 0; i < dx.length; i++) {
                    int newx = remove[0] + dx[i];
                    int newy = remove[1] + dy[i];
                    int width = image[0].length;
                    int hash = hash(newx, newy, width);
                    if (newx >= image.length || newx < 0 || newy >= width || newy < 0 || seen.contains(hash)) {
                        continue;
                    }
                    seen.add(hash);
                    queue.offer(new int[]{newx, newy});
                }
            }
        }
        return image;
    }

    private int hash(int x, int y, int width) {
        return x * width + y;
    }
}
