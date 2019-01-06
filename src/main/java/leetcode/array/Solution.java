package leetcode.array;

import java.util.*;

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
                if (chars[i] != lastC ) {
                    if ((i - begin) >= 3) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(begin);
                        temp.add(i - 1);
                        list.add(temp);
                    }
                    begin = 0;
                    state = 0;
                }
            }
            lastC = chars[i];
        }
        return list;
    }

}
