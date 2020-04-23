package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_0208 {
    /**
     * 实现 Trie (前缀树)
     * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
     *
     * 示例:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // 返回 true
     * trie.search("app");     // 返回 false
     * trie.startsWith("app"); // 返回 true
     * trie.insert("app");
     * trie.search("app");     // 返回 true
     * 说明:
     *
     * 你可以假设所有的输入都是由小写字母 a-z 构成的。
     * 保证所有输入均为非空字符串。
     */
    static class Trie {
        private class DicNode {
            Character character;
            Map<Character, DicNode> map = new HashMap<>();
            boolean isWord = false;

            public DicNode(Character character) {
                this.character = character;
            }
        }
        /** Initialize your data structure here. */
        public Trie() {

        }

        private DicNode dic = new DicNode('z');

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || "".equals(word)) return;
            DicNode cur = this.dic;
            DicNode lastNode = null;
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
                cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word == null || "".equals(word)) return false;
            DicNode cur = this.dic;
            for (int i = 0; i < word.length(); i++) {
                char charAt = word.charAt(i);
                if (!cur.map.containsKey(charAt)) {
                    return false;
                }
                cur = cur.map.get(charAt);
            }
            if (cur.map.isEmpty() || cur.isWord) {
                return true;
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix == null || "".equals(prefix)) return false;
            DicNode cur = this.dic;
            for (int i = 0; i < prefix.length(); i++) {
                char charAt = prefix.charAt(i);
                if (!cur.map.containsKey(charAt)) {
                    return false;
                }
                cur = cur.map.get(charAt);
            }
            return true;
        }
    }

    /**
     * ["Trie","insert","search","search","startsWith","insert","search"]
     * [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.print(trie.search("apple"));
        System.out.print("," + trie.search("app"));
        System.out.print("," + trie.startsWith("app"));
        trie.insert("app");
        System.out.print("," + trie.search("app"));
    }
}
