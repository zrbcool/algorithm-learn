package leetcode;

import java.util.*;

public class Solution_0677 {
    /**
     * Map Sum Pairs
     * 实现一个 MapSum 类里的两个方法，insert 和 sum。
     *
     * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
     *
     * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
     *
     * 示例 1:
     *
     * 输入: insert("apple", 3), 输出: Null
     * 输入: sum("ap"), 输出: 3
     * 输入: insert("app", 2), 输出: Null
     * 输入: sum("ap"), 输出: 5
     */
    class MapSum {
        class Trie {
            private class DicNode {
                Character character;
                Map<Character, DicNode> map = new HashMap<>();
                int value;

                public DicNode(Character character) {
                    this.character = character;
                }
            }
            public Trie() {

            }

            private DicNode dic = new DicNode('z');

            public void insert(String word, int value) {
                if (word == null || "".equals(word)) return;
                DicNode cur = this.dic;
                for (int i = 0; i < word.length(); i++) {
                    char charAt = word.charAt(i);
                    if (cur.map.containsKey(charAt)) {
                        cur = cur.map.get(charAt);
                    } else {
                        DicNode node = new DicNode(charAt);
                        cur.map.put(charAt, node);
                        cur = node;
                    }
                }
                if (cur != null)
                    cur.value = value;
            }

            public DicNode search(String word) {
                if (word == null || "".equals(word)) return null;
                DicNode cur = this.dic;
                for (int i = 0; i < word.length(); i++) {
                    char charAt = word.charAt(i);
                    if (!cur.map.containsKey(charAt)) {
                        return null;
                    }
                    cur = cur.map.get(charAt);
                }
                return cur;
            }
        }
        
        /** Initialize your data structure here. */
        public MapSum() {

        }
        private Trie root = new Trie();
        public void insert(String key, int val) {
            root.insert(key, val);
        }

        public int sum(String prefix) {
            Trie.DicNode search = root.search(prefix);
            if (search == null) return 0;
            int sum = search.value;
            // BFS
            Queue<Collection<Trie.DicNode>> queue = new LinkedList<>();
            queue.offer(search.map.values());

            while (!queue.isEmpty()) {
                Collection<Trie.DicNode> remove = queue.remove();
                if (remove != null) {
                    for (Trie.DicNode dicNode : remove) {
                        sum += dicNode.value;
                        queue.offer(dicNode.map.values());
                    }
                }
            }
            return sum;
        }
    }
}
