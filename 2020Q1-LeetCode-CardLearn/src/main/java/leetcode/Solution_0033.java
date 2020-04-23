package leetcode;

public class Solution_0033 {
    /**
     * 搜索旋转排序数组
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int _old = nums[0];
        int brk = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < _old) {
                brk = i;
                break;
            }
        }

        int L, R, idx;
        if (brk == -1) {
            L = 0;
            R = nums.length - 1;
            return binarySearch(nums, target, L, R);
        } else {
            // 0...brk
            L = 0;
            R = brk - 1;
            idx = binarySearch(nums, target, L, R);
            if (idx != -1) return idx;
            // brk...nums.length
            L = brk;
            R = nums.length - 1;
            idx = binarySearch(nums, target, L, R);
            return idx;
        }
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int idx = l + (r - l) / 2;
            if (nums[idx] < target) {
                l = idx + 1;
            }
            else if (nums[idx] > target) {
                r = idx - 1;
            }
            else if (nums[idx] ==  target) {
                return idx;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /**
         * [4,5,6,7,0,1,2]
         * 0
         */
        System.out.println(new Solution_0033().search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
