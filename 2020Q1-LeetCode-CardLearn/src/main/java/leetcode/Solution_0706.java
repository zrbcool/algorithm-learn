package leetcode;

import java.util.LinkedList;

public class Solution_0706 {
    /**
     * 设计哈希映射
     * 不使用任何内建的哈希表库设计一个哈希映射
     *
     * 具体地说，你的设计应该包含以下的功能
     *
     * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
     * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
     * remove(key)：如果映射中存在这个键，删除这个数值对。
     *
     * 示例：
     *
     * MyHashMap hashMap = new MyHashMap();
     * hashMap.put(1, 1);
     * hashMap.put(2, 2);
     * hashMap.get(1);            // 返回 1
     * hashMap.get(3);            // 返回 -1 (未找到)
     * hashMap.put(2, 1);         // 更新已有的值
     * hashMap.get(2);            // 返回 1
     * hashMap.remove(2);         // 删除键为2的数据
     * hashMap.get(2);            // 返回 -1 (未找到)
     *
     * 注意：
     *
     * 所有的值都在 [0, 1000000]的范围内。
     * 操作的总数目在[1, 10000]范围内。
     * 不要使用内建的哈希库。
     */
    class MyHashMap {

        class Bucket {
            private LinkedList<Node> container = new LinkedList<>();

            class Node {
                int key;
                int value;

                public Node(int key, int value) {
                    this.key = key;
                    this.value = value;
                }

                @Override
                public boolean equals(Object obj) {
                    if (obj instanceof Node)
                        return ((Node) obj).key == this.key;
                    else
                        return false;
                }
            }

            public void put(int key, int value) {
                Node node = new Node(key, value);
                if (container.contains(node)) {
                    remove(key);
                }
                container.add(0, node);
            }

            public int get(int key) {
                for (Node node : container) {
                    if (node.key == key)
                        return node.value;
                }
                return -1;
            }

            public void remove(int key) {
                Node delete = new Node(key, -1);

                int index = container.indexOf(delete);
                if (index != -1)
                    container.remove(index);
            }
        }
        private Bucket[] buckets = new Bucket[1024];
        /** Initialize your data structure here. */
        public MyHashMap() {

        }

        private int hash(int key) {
            return key % buckets.length;
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            initBucket(key).put(key, value);
        }

        private Bucket initBucket(int key) {
            int hash = hash(key);
            if (buckets[hash] == null) {
                buckets[hash] = new Bucket();
            }
            return buckets[hash];
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return initBucket(key).get(key);
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            initBucket(key).remove(key);
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
