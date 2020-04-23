package leetcode;

import java.util.*;

public class Solution_0219 {
    /**
     * 存在重复元素 II
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     *
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> record = new HashMap<>();
        if (nums == null || nums.length == 0)
            return false;

        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(nums[i])) {
                record.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                record.put(nums[i], list);
            }
        }

        if (!record.isEmpty()) {
            for (List<Integer> value : record.values()) {
                if (value.size() <= 1)
                    continue;
                for (int i = 0; i < value.size() - 1; i++) {
                    if (value.get(i + 1) - value.get(i) <= k)
                        return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /**
         * [1,2,3,1]
         * 3
         */
        System.out.println(new Solution_0219().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }
}
