package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_0498 {
    /**
     * 对角线遍历
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     *
     *
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
     *
     *
     * 说明:
     *
     * 给定矩阵中的元素总数不会超过 100000 。
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int[] result = new int[matrix.length * matrix[0].length];

        int index = 0;
        int lineCount = 0;
        List<Integer> list;
        for (int i = 0; i < matrix[0].length; i++) {
            list = new ArrayList<>();
            for (int x = 0, y = i; y >=0 && x < matrix.length; y--, x++) {
                list.add(matrix[x][y]);
            }
            if (lineCount % 2 == 0) {
                Collections.reverse(list);
            }
            for (Integer integer : list) {
                result[index++] = integer;
            }
            lineCount++;
        }

        for (int i = 1; i < matrix.length; i++) {
            list = new ArrayList<>();
            for (int x = i, y = matrix[0].length - 1; x < matrix.length && y >=0; x++, y--) {
                list.add(matrix[x][y]);
            }
            if (lineCount % 2 == 0) {
                Collections.reverse(list);
            }
            for (Integer integer : list) {
                result[index++] = integer;
            }
            lineCount++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};
        for (int i : new Solution_0498().findDiagonalOrder(matrix)) {
            System.out.print(i + ",");
        }

        System.out.println();
        matrix = new int[1][1];
        matrix[0] = new int[]{2, 3};
        for (int i : new Solution_0498().findDiagonalOrder(matrix)) {
            System.out.print(i + ",");
        }
    }

}
