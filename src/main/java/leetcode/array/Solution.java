package leetcode.array;

import java.util.*;

class Solution {

    /**
     * 905. 按奇偶排序数组
     * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
     *
     * 你可以返回满足此条件的任何数组作为答案。
     *
     *
     *
     * 示例：
     *
     * 输入：[3,1,2,4]
     * 输出：[2,4,3,1]
     * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
     *
     *
     * 提示：
     *
     * 1 <= A.length <= 5000
     * 0 <= A[i] <= 5000
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0)
            return A;

        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 == 0) {
                i++;
            } else {
                if (A[j] % 2 == 0) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    j--;
                } else {
                    j--;
                }
            }
        }
        return A;
    }

    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     *
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     *
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     *
     * 示例 1:
     *
     * 输入: [[1,1,0],[1,0,1],[0,0,0]]
     * 输出: [[1,0,0],[0,1,0],[1,1,1]]
     * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     * 示例 2:
     *
     * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * 说明:
     *
     * 1 <= A.length = A[0].length <= 20
     * 0 <= A[i][j] <= 1
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0)
            return A;
        int[][] result = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < A[i].length; i1++) {
                if (A[i][i1] == 0) {
                    result[i][A.length - i1 - 1] = 1;
                } else {
                    result[i][A.length - i1 - 1] = 0;
                }
            }
        }
        return result;
    }

    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     *
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *
     * 你可以返回任何满足上述条件的数组作为答案。
     *
     *
     *
     * 示例：
     *
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     *
     *
     * 提示：
     *
     * 2 <= A.length <= 20000
     * A.length % 2 == 0
     * 0 <= A[i] <= 1000
     * @param A
     * @return
     */
//    public int[] sortArrayByParityII(int[] A) {
//        if (A == null || A.length == 0)
//            return A;
//        int i = 0;
//        int j = A.length - 1;
//        while (i < j) {
//            if (i % 2 == 1) {
//                if (A[i] % 2 == 1) {
//                    i++;
//                } else {
//                    if (A[j] % 2 == 1 && j % 2 != 1) {
//                        int temp = A[i];
//                        A[i] = A[j];
//                        A[j] = temp;
//                        j--;
//                    } else {
//                        j--;
//                    }
//                }
//            } else {
//                if (j % 2 == 1) {
//                    if (A[j] % 2 == 1) {
//                        j--;
//                    } else if (A[i] % 2 == 1) {
//                        int temp = A[i];
//                        A[i] = A[j];
//                        A[j] = temp;
//                        i++;
//                        j--;
//                    } else {
//                        i++;
//                    }
//                } else {
//                    if (A[j] % 2 == 1) {
//                        i++;
//                    } else {
//                        if (A[i] % 2 == 1) {
//                            j--;
//                        } else {
//                            i++;
//                        }
//                    }
//                }
//            }
//        }
//        return A;
//    }
    boolean ji(int var) {
        return var % 2 == 1;
    }

    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0)
            return A;
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (ji(A[i])) {
                if (ji(i)) {
                    i++;
                    continue;
                }
            }
            if (ji(A[j])) {
                if (ji(j)) {
                    j--;
                    continue;
                }
            }
            if (ji(A[i]) && !ji(i) && !ji(A[j]) && ji(j)) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
            }
            else if (ji(A[j]) && !ji(j) && !ji(A[i]) && ji(i)) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j--;
            }
            else {
                if (ji(A[i]) && !(ji(A[j]) && ji(j)))
                    j--;
                else if (ji(A[j]) && !(ji(A[i]) && ji(i))) {
                    i++;
                } else {
                    i++;
                }
            }
        }
        return A;
    }

    /**
     * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
     *
     * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
     *
     * 示例 1:
     *
     * 输入:
     * matrix = [
     *   [1,2,3,4],
     *   [5,1,2,3],
     *   [9,5,1,2]
     * ]
     * 输出: True
     * 解释:
     * 在上述矩阵中, 其对角线为:
     * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
     * 各条对角线上的所有元素均相同, 因此答案是True。
     * 示例 2:
     *
     * 输入:
     * matrix = [
     *   [1,2],
     *   [2,2]
     * ]
     * 输出: False
     * 解释:
     * 对角线"[1, 2]"上的元素不同。
     * 说明:
     *
     *  matrix 是一个包含整数的二维数组。
     * matrix 的行数和列数均在 [1, 20]范围内。
     * matrix[i][j] 包含的整数在 [0, 99]范围内。
     * 进阶:
     *
     * 如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
     * 如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null)
            return false;
        boolean result = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (i + j >= matrix.length)
                    continue;
                if (matrix[i][0] != matrix[i + j][j]) {
                    result = false;
                    break;
                }
            }
        }
        if (!result)
            return result;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i + j >= matrix[0].length)
                    continue;
                if (matrix[0][i] != matrix[j][i + j]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 2))
                return entry.getKey();
        }
        return 0;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                list.add(i);
        }

        if (list.size() < 1)
            return;

        for (int i = 0; i < list.size(); i++) {
            Integer index = list.get(i);
            Integer nextIndex;
            if (i + 1 > list.size() - 1) {
                nextIndex = nums.length;
            } else {
                nextIndex = list.get(i + 1);
            }
            int gap = nextIndex - index - 1;
            for (int j = 0; j < gap; j++) {
                nums[index + j - i] = nums[index + j + 1];
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }

    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     *
     * 示例 1:
     *
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * 注意：
     *
     * 输入的数组只包含 0 和1。
     * 输入数组的长度是正整数，且不超过 10,000。
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        /**
         * state:
         * 0 : init/wait
         * 1 : counting
         */
        int state = 0;

        int max = 0;
        int counter = 0;
        boolean reset = false;
        for (int i = 0; i < nums.length; i++) {
            if (state == 0) {
                if (nums[i] == 1) {
                    counter++;
                    state = 1;
                }
            } else {
                if (nums[i] == 1) {
                    counter++;
                    state = 1;
                } else {
                    // reset
                    reset = true;
                    if (counter > max)
                        max = counter;
                    counter = 0;
                    state = 0;
                }
            }
        }
        if (!reset || counter > max)
            max = counter;
        return max;
    }

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

    /**
     * 217. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,1]
     * 输出: true
     * 示例 2:
     *
     * 输入: [1,2,3,4]
     * 输出: false
     * 示例 3:
     *
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                return true;
            else
                map.put(num, 1);
        }
        return false;
    }

    /**
     * 448. 找到所有数组中消失的数字
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     *
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     *
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     * 示例:
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [5,6]
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int gap = nums[i + 1] - nums[i];
            if (gap > 1) {
                for (int j = 0; j < gap - 1; j++) {
                    list.add(nums[i] + 1 + j);
                }
            }
        }

        int gap = nums.length - nums[nums.length - 1];
        if (gap > 0) {
            for (int j = 0; j < gap; j++) {
                list.add(nums[nums.length - 1] + 1 + j);
            }
        }
        gap = nums[0];
        if (gap > 0) {
            for (int i = 0; i < gap - 1; i++) {
                list.add(i + 1);
            }
        }
        return list;
    }

    /**
     * 697. 数组的度
     * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
     *
     * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     *
     * 示例 1:
     *
     * 输入: [1, 2, 2, 3, 1]
     * 输出: 2
     * 解释:
     * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     * 连续子数组里面拥有相同度的有如下所示:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组[2, 2]的长度为2，所以返回2.
     * 示例 2:
     *
     * 输入: [1,2,2,3,1,4,2]
     * 输出: 6
     * 注意:
     *
     * nums.length 在1到50,000区间范围内。
     * nums[i] 是一个在0到49,999范围内的整数。
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 1)
            return 1;
        Map<Integer, Integer> numToTimes = new HashMap<>();
        Map<Integer, List<Integer>> timesToNum = new HashMap<>();
        int maxTimes = Integer.MIN_VALUE;
        for (int num : nums) {
            int times = numToTimes.getOrDefault(num, 0) + 1;
            numToTimes.put(num, times);
            List<Integer> list = timesToNum.getOrDefault(times, new ArrayList<>());
            list.add(num);
            timesToNum.put(times, list);
            maxTimes = Math.max(maxTimes, times);
        }
        if (maxTimes == 1)
            return 1;

        /**
         * 0: close 1: open
         */
        boolean open = false;
        int result = Integer.MAX_VALUE;
        for (Integer num0 : timesToNum.get(maxTimes)) {
            int idxBegin = Integer.MAX_VALUE;
            int du = 0;
            for (int i = 0; i < nums.length; i++) {
                if (open) {
                    if (nums[i] == num0)
                        du++;
                    if (du >= maxTimes) {
                        open = false;
                        if (i - idxBegin < result)
                            result = i - idxBegin + 1;
                    }
                } else {
                    if (nums[i] == num0) {
                        du++;
                        open = true;
                        idxBegin = i;
                    }
                }
            }
            open = false;
        }
        return result;
    }

    /**
     * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
     *
     * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
     *
     * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
     *
     * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
     *
     *
     *
     * 示例 1：
     *
     * 输入：A = [1,1], B = [2,2]
     * 输出：[1,2]
     * 示例 2：
     *
     * 输入：A = [1,2], B = [2,3]
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：A = [2], B = [1,3]
     * 输出：[2,3]
     * 示例 4：
     *
     * 输入：A = [1,2,5], B = [2,4]
     * 输出：[5,4]
     *
     *
     * 提示：
     *
     * 1 <= A.length <= 10000
     * 1 <= B.length <= 10000
     * 1 <= A[i] <= 100000
     * 1 <= B[i] <= 100000
     * 保证爱丽丝与鲍勃的糖果总量不同。
     * 答案肯定存在。
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ints = new int[2];
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return ints;
        int sa = 0, sb = 0;
        for (int i : A) {
            sa += i;
        }
        Set<Integer> bSet = new HashSet<>();
        for (int i : B) {
            sb += i;
            bSet.add(i);
        }
        // delta = x - y
        int delta = (sa - sb) / 2;
        for (int x : A) {
            int y = x - delta;
            if (bSet.contains(y)) {
                ints[0] = x;
                ints[1] = y;
                return ints;
            }
        }
        return ints;
    }

    /**
     * 628. 三个数的最大乘积
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     * 输出: 6
     * 示例 2:
     *
     * 输入: [1,2,3,4]
     * 输出: 24
     * 注意:
     *
     * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
     * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        for (int i = nums.length - 1; i >= nums.length - 3; i--) {
            result = result * nums[i];
        }
        int r1 = nums[0] * nums[1] * nums[nums.length - 1];
        if (r1 > result)
            return r1;
        return result;
    }

    /**
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     *
     * 最终结果按照字典顺序输出。
     *
     * 示例 1:
     *
     * 输入: "abbxxxxzzy"
     * 输出: [[3,6]]
     * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
     * 示例 2:
     *
     * 输入: "abc"
     * 输出: []
     * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
     * 示例 3:
     *
     * 输入: "abcdddeeeeaabbbcd"
     * 输出: [[3,5],[6,9],[12,14]]
     * 说明:  1 <= S.length <= 1000
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        char[] chars = S.toCharArray();
        List<List<Integer>> list = new ArrayList<>();
        char lastC = Character.MAX_VALUE;
        int state = 0;//0 close 1 open
        int begin = 0;
        for (int i = 0; i < chars.length; i++) {
            if (state == 0) {
                if (chars[i] == lastC) {
                    state = 1;
                    begin = i - 1;
                }
            } else {
                if (chars[i] != lastC) {
                    if ((i - begin) >= 3) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(begin);
                        temp.add(i - 1);
                        list.add(temp);
                    }
                    begin = 0;
                    state = 0;
                } else if (i + 1 >= chars.length) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(begin);
                    temp.add(i);
                    list.add(temp);
                }
            }
            lastC = chars[i];
        }
        return list;
    }

    /**
     * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
     *
     * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
     *
     * 示例 1:
     *
     * 输入:
     * bits = [1, 0, 0]
     * 输出: True
     * 解释:
     * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
     * 示例 2:
     *
     * 输入:
     * bits = [1, 1, 1, 0]
     * 输出: False
     * 解释:
     * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
     * 注意:
     *
     * 1 <= len(bits) <= 1000.
     * bits[i] 总是0 或 1.
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length < 3) {
            return bits.length == 1 || bits[0] == 0;
        } else if (bits.length % 2 == 1) {
            if (bits[bits.length - 3] == 1) {
                if (bits.length == 3) return true;
                else if (bits[bits.length - 4] == 0) return true;
                else if (bits[bits.length - 5] == 1) return true;
                else return bits[bits.length - 2] == 0;
            }
            else {
                return bits[bits.length - 2] != 1;
            }
        } else {
            return (bits[bits.length - 4] == 0 && bits[bits.length - 3] == 1) || (bits[bits.length - 4] == 0 && bits[bits.length - 2] == 0) || (bits[bits.length - 4] == 1 && bits[bits.length - 2] == 0);
        }
    }

    /**
     * 747. 至少是其他数字两倍的最大数
     * 在一个给定的数组nums中，总是存在一个最大元素 。
     *
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     *
     * 如果是，则返回最大元素的索引，否则返回-1。
     *
     * 示例 1:
     *
     * 输入: nums = [3, 6, 1, 0]
     * 输出: 1
     * 解释: 6是最大的整数, 对于数组中的其他整数,
     * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
     *
     *
     * 示例 2:
     *
     * 输入: nums = [1, 2, 3, 4]
     * 输出: -1
     * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
     *
     *
     * 提示:
     *
     * nums 的长度范围在[1, 50].
     * 每个 nums[i] 的整数范围在 [0, 99].
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valueToIndex.put(nums[i], i);
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] >= nums[nums.length - 2] * 2) {
            return valueToIndex.get(nums[nums.length - 1]);
        } else {
            return -1;
        }
    }

    /**
     * 674. 最长连续递增序列
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,4,7]
     * 输出: 3
     * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
     * 示例 2:
     *
     * 输入: [2,2,2,2,2]
     * 输出: 1
     * 解释: 最长连续递增序列是 [2], 长度为1。
     * 注意：数组长度不会超过10000。
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int state = 0, result = 1; //0: close 1: open
        int temp = 0, numLast = Integer.MAX_VALUE;
        for (int num : nums) {
            if (state == 0) {
                if (num > numLast) {
                    temp = 2;
                    state = 1;
                } else {
                    temp = 0;
                }
            } else {
                if (num > numLast) {
                    temp++;
                } else {
                    state = 0;
                    result = Math.max(result, temp);
                }
            }
            numLast = num;
        }
        if (state == 1) {
            result = Math.max(result, temp);
        }
        return result;
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] + numbers[j] == target)
//                    return new int[]{i + 1, j + 1};
//            }
//        }
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int temp = numbers[l] + numbers[r];
            if (temp == target)
                return new int[]{l + 1, r + 1};
            else if (temp > target)
                r--;
            else
                l++;
        }
        throw new IllegalArgumentException();
    }
}
