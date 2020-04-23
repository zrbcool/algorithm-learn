package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution_0705 {
    /**
     * 设计哈希集合
     * 不使用任何内建的哈希表库设计一个哈希集合
     *
     * 具体地说，你的设计应该包含以下的功能
     *
     * add(value)：向哈希集合中插入一个值。
     * contains(value) ：返回哈希集合中是否存在这个值。
     * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
     *
     * 示例:
     *
     * MyHashSet hashSet = new MyHashSet();
     * hashSet.add(1);
     * hashSet.add(2);
     * hashSet.contains(1);    // 返回 true
     * hashSet.contains(3);    // 返回 false (未找到)
     * hashSet.add(2);
     * hashSet.contains(2);    // 返回 true
     * hashSet.remove(2);
     * hashSet.contains(2);    // 返回  false (已经被删除)
     *
     * 注意：
     *
     * 所有的值都在 [0, 1000000]的范围内。
     * 操作的总数目在[1, 10000]范围内。
     * 不要使用内建的哈希集合库。
     */
    static class MyHashSet {
        private List<Integer>[] bucket = new LinkedList[2048];

        /** Initialize your data structure here. */
        public MyHashSet() {

        }

        private int hash(int key) {
            return key % bucket.length;
        }

        public void add(int key) {
            List<Integer> list = initBucket(bucket, hash(key));
            if (list.contains(key))
                return;
            list.add(key);
        }

        private List<Integer> initBucket(List<Integer>[] bucket, int hash) {
            if (bucket[hash] == null) {
                bucket[hash] = new LinkedList<>();
            }
            return bucket[hash];
        }

        public void remove(int key) {
            List<Integer> list = initBucket(bucket, hash(key));
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == key)
                    index = i;

            }
            if (index >= 0)
                list.remove(index);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            List<Integer> list = initBucket(bucket, hash(key));
            for (Integer k : list) {
                if (k == key)
                    return true;
            }
            return false;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
