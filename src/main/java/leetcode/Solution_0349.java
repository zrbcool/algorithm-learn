package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_0349 {
    /**
     * 两个数组的交集
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [9,4]
     * 说明:
     *
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                set2.add(i);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for (Integer value : set2) {
            result[index++] = value;
        }
        return result;
    }
}
