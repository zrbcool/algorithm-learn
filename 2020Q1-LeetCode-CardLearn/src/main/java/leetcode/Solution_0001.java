package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_0001 {
    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    private class Method_01 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return new int[]{};

            for (int i = 0; i < nums.length; i++) {
                int adder = nums[i];
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (i == j)
                        continue;
                    if (nums[j] + adder == target)
                        return new int[]{i, j};
                }
            }

            return new int[]{};
        }
    }

    private class Method_02 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return new int[]{};
            Map<Integer,Integer> record = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int delta = target - nums[i];
                if (record.containsKey(delta) && record.get(delta) != i)
                    return new int[]{record.get(delta), i};
                record.put(nums[i], i);
            }
            return new int[]{};
        }
    }
}
