package leetcode;

import java.util.*;

public class Solution_0347 {
    /**
     * 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     * 说明：
     *
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> topK = new HashMap<>();
        for (int num : nums) {
            topK.put(num, topK.getOrDefault(num, 0) + 1);
        }
        Map<Integer, List<Integer>> count2nums = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : topK.entrySet()) {
            List<Integer> list = count2nums.getOrDefault(entry.getValue(), new ArrayList<>());
            list.add(entry.getKey());
            count2nums.put(entry.getValue(), list);
        }

        List<Integer> res = new ArrayList<>();

        List<Integer> list = new LinkedList<>(count2nums.keySet());
        Collections.sort(list);
        Collections.reverse(list);

        int count = 0;
        int idx = 0;
        while (count < k && idx < list.size()) {
            List<Integer> integers = count2nums.get(list.get(idx));
            res.addAll(integers);
            idx++;
            count = count + integers.size();
        }

        return res;
    }
}
