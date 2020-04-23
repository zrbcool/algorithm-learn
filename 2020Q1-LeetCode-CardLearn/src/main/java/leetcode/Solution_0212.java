package leetcode;

import java.util.*;

public class Solution_0212 {
    /**
     * 单词搜索 II
     * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     *
     * 示例:
     *
     * 输入:
     * words = ["oath","pea","eat","rain"] and board =
     * [
     *   ['o','a','a','n'],
     *   ['e','t','a','e'],
     *   ['i','h','k','r'],
     *   ['i','f','l','v']
     * ]
     *
     * 输出: ["eat","oath"]
     * 说明:
     * 你可以假设所有输入都由小写字母 a-z 组成。
     *
     * 提示:
     *
     * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
     * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
     */

    static class TrieNode {
        Character c;
        String word;
        Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode(Character c) {
            this.c = c;
        }
    }
    private TrieNode root = new TrieNode('0');

    void insert(String word) {
        if (word == null || "".equals(word)) return;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char charAt = word.charAt(i);
            if (cur.children.containsKey(charAt)) {
                cur = cur.children.get(charAt);
            } else {
                TrieNode n = new TrieNode(charAt);
                cur.children.put(charAt, n);
                cur = n;
            }
        }
        cur.word = word;
    }

    private List<String> result = new ArrayList<>();
    private char[][] _board;
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0) return result;
        for (String word : words) {
            this.insert(word);
        }

        this._board = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    dfs(root.children.get(board[row][col]), row, col);
                }
            }
        }
        return this.result;
    }

    void dfs(TrieNode node, int row, int col) {
        char c = this._board[row][col];
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        this._board[row][col] = '#';
        for (int i = 0; i < dx.length; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (node.word != null) {
                this.result.add(node.word);
                node.word = null;
            }
            if (nrow < 0 || nrow >= _board.length || ncol < 0 || ncol >= _board[nrow].length) continue;
            char charAt = _board[nrow][ncol];
            if (node.children.containsKey(charAt)) {
                dfs(node.children.get(charAt), nrow, ncol);
            }
        }
        this._board[row][col] = c;
    }
}
