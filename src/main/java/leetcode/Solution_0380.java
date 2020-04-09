package leetcode;

import java.util.*;

public class Solution_0380 {
    /**
     * 常数时间插入、删除和获取随机元素
     * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
     *
     * insert(val)：当元素 val 不存在时，向集合中插入该项。
     * remove(val)：元素 val 存在时，从集合中移除该项。
     * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
     * 示例 :
     *
     * // 初始化一个空的集合。
     * RandomizedSet randomSet = new RandomizedSet();
     *
     * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
     * randomSet.insert(1);
     *
     * // 返回 false ，表示集合中不存在 2 。
     * randomSet.remove(2);
     *
     * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
     * randomSet.insert(2);
     *
     * // getRandom 应随机返回 1 或 2 。
     * randomSet.getRandom();
     *
     * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
     * randomSet.remove(1);
     *
     * // 2 已在集合中，所以返回 false 。
     * randomSet.insert(2);
     *
     * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
     * randomSet.getRandom();
     */
    static class RandomizedSet {

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        private final Map<Integer, Integer> val2idx = new HashMap<>();
        private final List<Integer> list = new ArrayList<>();
        private final Random random = new Random();

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (val2idx.containsKey(val)) {
                return false;
            } else {
                val2idx.put(val, list.size());
                list.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!val2idx.containsKey(val)) {
                return false;
            } else {
                Integer idx = val2idx.get(val);
                Integer replace = list.get(list.size() - 1);
                val2idx.put(replace, idx);
                val2idx.remove(val);
                list.set(idx, replace);
                list.remove(list.size() - 1);
                return true;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        /**
         * ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
         * [[],[1],[2],[2],[],[1],[2],[]]
         */
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));;
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        /**
         * 输入：
         * ["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
         * [[],[0],[0],[0],[],[0],[0]]
         * 输出：
         * [null,false,false,true,0,true,false]
         * 预期：
         * [null,false,false,true,0,true,true]
         */
    }
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
