package com.leetcode.y2020q2.d0427;

public class Solution_0494 {
    /**
     * 目标和
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     *
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     * 示例 1:
     *
     * 输入: nums: [1, 1, 1, 1, 1], S: 3
     * 输出: 5
     * 解释:
     *
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * 一共有5种方法让最终目标和为3。
     * 注意:
     *
     * 数组非空，且长度不会超过20。
     * 初始的数组的和不会超过1000。
     * 保证返回的最终结果能被32位整数存下。
     */
    int[] _nums;
    int S;
    int count;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            if (S == 0) return 1;
            else return 0;
        }
        this._nums = nums;
        this.S = S;
        dfs(0, 0);
        return count;
    }

    public void dfs(int index, int sum) {
        if (index == _nums.length) {
            if (sum == S) {
                count++;
            }
            return;
        }
        dfs(index + 1, sum + _nums[index]);
        dfs(index + 1, sum - _nums[index]);
    }
}