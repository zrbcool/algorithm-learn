package leetcode;

public class Solution_0153 {
    /**
     * 寻找旋转排序数组中的最小值
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 请找出其中最小的元素。
     *
     * 你可以假设数组中不存在重复元素。
     *
     * 示例 1:
     *
     * 输入: [3,4,5,1,2]
     * 输出: 1
     * 示例 2:
     *
     * 输入: [4,5,6,7,0,1,2]
     * 输出: 0
     */
    public int findMin(int[] nums) {
        if (nums != null && nums.length == 1) return nums[0];
        if (nums == null) return -1;
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            int m = L + (R - L) / 2;
            // left
            if (m == 0 && nums[m] < nums[nums.length - 1]) return nums[m];
            // right
            else if (m == nums.length - 1 && nums[m] < nums[m - 1]) return nums[m];
            // mid
            else {
                if (m == 0) {
                    L = m + 1;
                }
                else if (m == nums.length - 1) {
                    R = m - 1;
                }
                else if (nums[m] < nums[m - 1] && nums[m] < nums[m + 1]) {
                    return nums[m];
                }
                else if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                    return nums[m + 1];
                }
                else {
                    // 上坡，两种情况，1）最低点在右边 2）最低点在左边
                    if (nums[m] > nums[0]) {
                        //最低点在右边
                        L = m + 1;
                    } else {
                        //最低点在左边
                        R = m - 1;
                    }
                }
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().findMin(new int[]{3,4,5,1,2}));
        System.out.println(new Solution_0153().findMin(new int[]{2,1}));
    }
}
