package leetcode;


import java.util.*;

public class Solution_0336 {
    /**
     * 回文对
     * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     *
     * 示例 1:
     *
     * 输入: ["abcd","dcba","lls","s","sssll"]
     * 输出: [[0,1],[1,0],[3,2],[2,4]]
     * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
     * 示例 2:
     *
     * 输入: ["bat","tab","cat"]
     * 输出: [[0,1],[1,0]]
     * 解释: 可拼接成的回文串为 ["battab","tabbat"]
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            TrieNode cur = root;
            if ("".equals(word)) {
                TrieNode node = new TrieNode();
                node.c = '#';
                node.end = true;
                node.index = index;
                cur.children.put(node.c, node);
                continue;
            }
            StringBuilder reverse = new StringBuilder(word).reverse();
            for (int i = 0; i < reverse.length(); i++) {
                char charAt = reverse.charAt(i);
                if (cur.children.containsKey(charAt)) {
                    TrieNode node = cur.children.get(charAt);
                    if (i + 1 < reverse.length()) {
                        String postfix = reverse.substring(i + 1);
                        node.postfixes.put(postfix, index);
                    }
                    cur = node;
                }
                else {
                    TrieNode node = new TrieNode();
                    if (i + 1 < reverse.length()) {
                        String postfix = reverse.substring(i + 1);
                        node.postfixes.put(postfix, index);
                    }
                    node.c = charAt;
                    cur.children.put(charAt, node);
                    cur = node;
                }
            }
            if (cur != root) {
                cur.end = true;
                cur.index = index;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            String word = words[i];
            int index;
            for (index = 0; index < word.length(); index++) {
                char charAt = word.charAt(index);
                if (cur.end) {
                    // x < y
                    if (this.isHuiWenString(word.substring(index))) {
                        result.add(Arrays.asList(i, cur.index));
                    }
                }
                if (cur.children.containsKey(charAt)) {
                    cur = cur.children.get(charAt);
                } else {
                    break;
                }
            }
            if (word.length() == 1 && index == word.length()) {
                for (Map.Entry<String, Integer> entry : cur.postfixes.entrySet()) {
                    if (this.isHuiWenString(entry.getKey())) {
                        result.add(Arrays.asList(i, entry.getValue()));
                    }
                }
                if (root.children.containsKey('#')) {
                    result.add(Arrays.asList(i, root.children.get('#').index));
                }
            }
            else if (index == word.length()) {
                // x == y
                if (cur.end) {
                    result.add(Arrays.asList(i, cur.index));
                } else {
                    for (Map.Entry<String, Integer> entry : cur.postfixes.entrySet()) {
                        if (this.isHuiWenString(entry.getKey())) {
                            result.add(Arrays.asList(i, entry.getValue()));
                        }
                    }
                }
            }
            else if (index < word.length()) {
                // x > y
                if (cur.end) {
                    if (this.isHuiWenString(word.substring(index))) {
                        result.add(Arrays.asList(i, cur.index));
                    }
                }
            }
        }
        return result;
    }

    static class TrieNode {
        Character c;
        boolean end = false;
        int index;
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> postfixes = new HashMap<>();
    }

    public boolean isHuiWenString(String word) {
        if (word == null) return false;
        int i = 0, j = word.length() - 1;
        char[] chars = word.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        /**
         * 输入：
         * ["a",""]
         * 输出：
         * [[0,1],[1,1]]
         * 预期：
         * [[0,1],[1,0]]
         */
        Solution_0336 solution0336 = new Solution_0336();
        System.out.println(solution0336.palindromePairs(new String[]{"a",""}));
//        System.out.println(solution2.isHuiWenString("abba"));
//        System.out.println(solution2.isHuiWenString("aba"));
    }
}
