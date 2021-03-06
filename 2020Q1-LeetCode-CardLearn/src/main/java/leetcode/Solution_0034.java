package leetcode;

public class Solution_0034 {
    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {

        int L = 0;
        int R = nums.length - 1;
        int first = -1;
        while (L <= R) {
            int m = L + ((R - L) >> 1);
            if (nums[m] < target) {
                L = m + 1;
            }
            else if (nums[m] > target) {
                R = m - 1;
            }
            else {
                if (m == 0 || nums[m - 1] != target) {
                    first = m;
                    break;
                }
                else {
                    R = m -1;
                }
            }
        }
        if (first == -1) return new int[]{-1,-1};

        int last = -1;
        L = 0;
        R = nums.length - 1;
        while (L <= R) {
            int m = L + ((R - L) >> 1);
            if (nums[m] < target) {
                L = m + 1;
            }
            else if (nums[m] > target) {
                R = m - 1;
            }
            else {
                if (m == nums.length - 1 || nums[m + 1] != target) {
                    last = m;
                    break;
                }
                else {
                    L = m + 1;
                }
            }
        }
        return new int[]{first, last};
    }
}
