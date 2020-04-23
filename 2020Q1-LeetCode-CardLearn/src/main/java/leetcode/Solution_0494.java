package leetcode;

public class Solution_0494 {
    /**
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
     *
     * 注意:
     *
     *     数组非空，且长度不会超过20。
     *     初始的数组的和不会超过1000。
     *     保证返回的最终结果能被32位整数存下。
     */
    private int count;
    private int[] nums;
    private int S;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        this.nums = nums;
        this.S = S;
        dfs(0, 0);
        return count;
    }

    private void dfs(int level, int parentSum) {
        if (level + 1 < nums.length) {
            dfs(level + 1, parentSum + nums[level]);
            dfs(level + 1, parentSum - nums[level]);
        } else {
            if (parentSum + nums[level] == S)
                count++;
            if (parentSum - nums[level] == S)
                count++;
        }
    }

    public static void main(String[] args) {
        int[] nums; int S;
        nums = new int[]{1, 1, 1, 1, 1};
        S = 3;
        System.out.println(new Solution_0494().findTargetSumWays(nums, S));

        nums = new int[]{1, 0};
        S = 1;
        System.out.println(new Solution_0494().findTargetSumWays(nums, S));
    }
}
