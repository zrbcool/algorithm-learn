package leetcode;

public class Solution_0154 {
    /**
     * 寻找旋转排序数组中的最小值 II
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 请找出其中最小的元素。
     *
     * 注意数组中可能存在重复的元素。
     *
     * 示例 1：
     *
     * 输入: [1,3,5]
     * 输出: 1
     * 示例 2：
     *
     * 输入: [2,2,2,0,1]
     * 输出: 0
     * 说明：
     *
     * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
     * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left;
        if (nums[nums.length - 1] <= nums[0]) {
            //发生旋转
            int L = 0;
            int R = nums.length - 1;
            while (L + 1 < R) {
                int m = L + (R - L) / 2;
                if (nums[m] < nums[R]) {
                    R = m;
                } else if (nums[m] > nums[R]) {
                    L = m;
                } else {
                    R = R - 1;
                }
            }
            if (nums[L] < nums[nums.length -  1]) {
                left = L;
            } else {
                left = L + 1;
            }
        }
        else {
            left = 0;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        /**
         * 输入:
         * [3,3,1,3]
         * 输出
         * 3
         * 预期结果
         * 1
         */
        System.out.println(new Solution_0154().findMin(new int[]{3,3,1,3}));
    }
}
