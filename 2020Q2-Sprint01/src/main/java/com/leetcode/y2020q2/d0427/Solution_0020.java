package com.leetcode.y2020q2.d0427;

import java.util.Stack;

public class Solution_0020 {
    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':;
                case '[':;
                case '{': {
                    stack.push(c);
                    break;
                }
                case ')': {
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                }
                case ']':{
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
                }
                case '}': {
                    if (stack.isEmpty() || stack.peek() != '{')  return false;
                    stack.pop();
                    break;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_0020().isValid("()"));
    }
}
