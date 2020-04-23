package leetcode;

import java.util.*;

public class Solution_0003 {
    /**
     * 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public int lengthOfLongestSubstring(String s) {
        Set<String> counter = new HashSet<>();

        Set<Character> visited = new HashSet<>();
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            visited.clear();
            visited.add(ch);
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            for (int i = j + 1; i < s.length(); i++) {
                char _new = s.charAt(i);
                if (visited.contains(_new)) {
                    break;
                } else {
                    sb.append(_new);
                    visited.add(_new);
                }
            }
            String str = sb.toString();
            counter.add(str);
        }

        int max = 0;
        for (String item : counter) {
            if (item.length() > max)
                max = item.length();
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_0003().lengthOfLongestSubstring("pwwkew"));
    }
}
