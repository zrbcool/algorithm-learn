package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_0211 {
    /**
     * 添加与搜索单词 - 数据结构设计
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addWord(word)
     * bool search(word)
     * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
     *
     * 示例:
     *
     * addWord("bad")
     * addWord("dad")
     * addWord("mad")
     * search("pad") -> false
     * search("bad") -> true
     * search(".ad") -> true
     * search("b..") -> true
     * 说明:
     *
     * 你可以假设所有单词都是由小写字母 a-z 组成的。
     */
    static class WordDictionary {

        class Node {
            Character c;
            Map<Character, Node> map = new HashMap<>();
            boolean end;

            public Node(Character c) {
                this.c = c;
            }
        }

        /** Initialize your data structure here. */
        public WordDictionary() {

        }

        private Node root = new Node('0');

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word == null || word.equals("")) return;
            Node cur = this.root;
            for (int i = 0; i < word.length(); i++) {
                char charAt = word.charAt(i);
                if (cur.map.containsKey(charAt)) {
                    cur = cur.map.get(charAt);
                } else {
                    Node node = new Node(charAt);
                    cur.map.put(charAt, node);
                    cur = node;
                }
            }
            if (cur != null) {
                cur.end = true;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            if (word == null || word.equals("")) return false;
            this.searchResult = false;
            this.brk = false;
            search(root, word, 0);
            return this.searchResult;
        }

        private boolean searchResult;
        private boolean brk;
        private boolean search(Node node, String word, int index) {
            Node cur = node;
            if (this.brk) return this.searchResult;
            for (int i = index; i < word.length(); i++) {
                char charAt = word.charAt(i);
                if (this.brk) return this.searchResult;
                if (charAt == '.') {
                    if (cur.map.isEmpty()) return this.searchResult;
                    boolean temp = false;
                    for (Node value : cur.map.values()) {
                        if (this.brk) return this.searchResult;
                        temp = search(value, word, i + 1);
                    }
                    if (!temp) {
                        return this.searchResult;
                    }
                } else {
                    if (!cur.map.containsKey(charAt)) {
                        return this.searchResult;
                    } else {
                        cur = cur.map.get(charAt);
                    }
                }
            }
            if (cur.end) {
                this.searchResult = true;
                this.brk = true;
            }
            return this.searchResult;
        }
    }

    public static void main(String[] args) {
        /**
         * 输入：
         * ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
         * [[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
         * 输出：
         * [null,null,null,null,null,false,false,null,false,true,false,false,false,false]
         * 预期：
         * [null,null,null,null,null,false,false,null,true,true,false,false,true,false]
         */
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(false + " " + wordDictionary.search("a"));
        System.out.println(false + " " + wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(true + " " + wordDictionary.search(".at"));
        System.out.println(true + " " + wordDictionary.search("an."));
        System.out.println(false + " " + wordDictionary.search("a.d."));
        System.out.println(false + " " + wordDictionary.search("b."));
        System.out.println(true + " " + wordDictionary.search("a.d"));
        System.out.println(false + " " + wordDictionary.search("."));


//        System.out.println(wordDictionary.search(".at"));
//        wordDictionary.addWord("bat");
//        System.out.println(wordDictionary.search(".at"));
    }
}
