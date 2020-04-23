package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_0020 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     *     左括号必须用相同类型的右括号闭合。
     *     左括号必须以正确的顺序闭合。
     *
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     *
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     *
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     *
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     *
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     * @param s
     * @return
     */
    static class Stack {
        List<Character> list = new ArrayList<>();
        void push(Character c) {
            list.add(c);
        }

        Character pop() {
            if (!list.isEmpty()) {
                return list.remove(list.size() - 1);
            }
            return null;
        }

        boolean isEmpty() {
            return list.size() == 0;
        }
    }


    public boolean isValid(String s) {
        Set<Character> leftSet = new HashSet<>();
        leftSet.add('(');
        leftSet.add('[');
        leftSet.add('{');
        Set<Character> rightSet = new HashSet<>();
        rightSet.add(')');
        rightSet.add(']');
        rightSet.add('}');

        Stack stack = new Stack();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (leftSet.contains(chars[i])) {
                stack.push(chars[i]);
            } else if (rightSet.contains(chars[i])) {
                Character left = stack.pop();
                if (!isPair(left, chars[i]))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(Character left, Character right) {
        if (left != null && left == '(') return right == ')';
        if (left != null && left == '[') return right == ']';
        if (left != null && left == '{') return right == '}';
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution_0020().isValid("["));
        System.out.println(new Solution_0020().isValid("]"));
    }
}
