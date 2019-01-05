package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] plusOne(int[] digits) {
        boolean overflow = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] < 10) {
                break;
            } else {
                digits[i] = 0;
                if (i == 0)
                    overflow = true;
            }
        }
        if (overflow) {
            int[] digitsNew = new int[digits.length + 1];
            for (int i = 0; i < digitsNew.length; i++) {
                if (i == 0) {
                    digitsNew[i] = 1;
                } else {
                    digitsNew[i] = 0;
                }
            }
            return digitsNew;
        }
        return digits;
    }
    private int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 给定一个矩阵 A， 返回 A 的转置矩阵。
     *
     * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[1,4,7],[2,5,8],[3,6,9]]
     * 示例 2：
     *
     * 输入：[[1,2,3],[4,5,6]]
     * 输出：[[1,4],[2,5],[3,6]]
     *
     *
     * 提示：
     *
     * 1 <= A.length <= 1000
     * 1 <= A[0].length <= 1000
     * @param A
     * @return
     */
    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0)
            return A;
        int[][] result = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    /**
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
     *
     * 示例 1:
     *
     * 输入: [1,4,3,2]
     *
     * 输出: 4
     * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
     * 提示:
     *
     * n 是正整数,范围在 [1, 10000].
     * 数组中的元素范围在 [-10000, 10000].
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i+=2) {
            result += nums[i];
        }
        return result;
    }

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     *
     *
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return new ArrayList<>();
        Integer[][] A = new Integer[numRows][];
        for (int i = 0; i < numRows; i++) {
            A[i] = new Integer[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (i < 2 || j == 0 || j == i)
                    A[i][j] = 1;
                else {
                    A[i][j] = A[i - 1][j - 1] + A[i - 1][j];
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(Arrays.asList(A[i]));
        }
        return list;
    }

    /**
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     *
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     *
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     *
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * 示例 1:
     *
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     * 解释:
     * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     * 示例 2:
     *
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 2, c = 4
     * 输出:
     * [[1,2],
     *  [3,4]]
     * 解释:
     * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
     * 注意：
     *
     * 给定矩阵的宽和高范围在 [1, 100]。
     * 给定的 r 和 c 都是正数。
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null)
            return nums;

        if (r * c > nums.length * nums[0].length)
            return nums;
        int k =0, l = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 0; i1 < nums[i].length; i1++) {
                if (l < c) {
                    result[k][l] = nums[i][i1];
                    l++;
                } else {
                    l = 0;
                    k++;
                    result[k][l] = nums[i][i1];
                    l++;
                }
            }
        }
        return result;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意你不能在买入股票前卖出股票。
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int buy = Integer.MAX_VALUE;
        int result = 0;

        for (int price : prices) {
            buy = Math.min(buy, price);
            result = Math.max(result, price - buy);
        }
        return result;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        int index = 0;
        int total = 0;
        boolean finish = false;
        while (index < prices.length && !finish) {
            int result = 0;
            int buy = Integer.MAX_VALUE;
            for (int i = index; i < prices.length; i++) {
                buy = Math.min(buy, prices[i]);
                result = Math.max(result, prices[i] - buy);
                if (result > 0) {
                    index = i;
                    break;
                }
                if (i + 1 >= prices.length)
                    finish = true;
            }
            total = total + result;
        }
        return total;
    }

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     *
     * 示例 1:
     *
     * 输入: [3,0,1]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     * 说明:
     * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        if (nums[0] == 1)
            return 0;

        int last = 0;
        for (int num : nums) {
            if (num - last > 1)
                return num - 1;
            last = num;
        }
        return last + 1;
    }

    /**
     * 如果数组是单调递增或单调递减的，那么它是单调的。
     *
     * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
     *
     * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,2,3]
     * 输出：true
     * 示例 2：
     *
     * 输入：[6,5,4,4]
     * 输出：true
     * 示例 3：
     *
     * 输入：[1,3,2]
     * 输出：false
     * 示例 4：
     *
     * 输入：[1,2,4,5]
     * 输出：true
     * 示例 5：
     *
     * 输入：[1,1,1]
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= A.length <= 50000
     * -100000 <= A[i] <= 100000
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {
        return increase(A) || decrease(A);
    }
    public boolean decrease(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1])
                return false;
        }
        return true;
    }
    public boolean increase(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{1,0}));
//        System.out.println(new Solution().maxProfitII(new int[]{1,2,3,4,5}));
//        int[] param = new int[]{9};
//        print(new Solution().plusOne(param));

//        int[][] A = new int[][]{{5,4}, {7, 10}};
//        print(new Solution().transpose(A));

//        System.out.println(new Solution().generate(5));
//        int[][] ints = new Solution().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1);
//        System.out.println(ints);
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ",");
            }
            System.out.println("]");
        }
    }

    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
    }
}
