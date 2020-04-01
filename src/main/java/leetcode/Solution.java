package leetcode;

import java.util.Stack;

public class Solution {
    /**
     * 字符串解码
     *
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *
     * 示例:
     *
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     *
     * "3[a2[c]]"
     */
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        return subDecode(chars, 0, chars.length - 1);
    }

    private String subDecode(char[] chars, int i, int j) {
        Stack<Character> num = new Stack<>();
        StringBuilder subStr = new StringBuilder();
        StringBuilder pre = new StringBuilder();
        out: for (int x = i; x <= j; x++) {
            if (isNumber(chars[x])) {
                num.push(chars[x]);
            } else if (chars[x] == '[') {
                for (int y = j; y > x; y--) {
                    if (chars[y] == ']') {
                        subStr.append(subDecode(chars, x + 1, y - 1));
                        break out;
                    }
                }
            } else if (chars[x] == ']') {
                break;
            } else {
                pre.append(chars[x]);
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(pre.toString());
        if (num.empty()) {
            return result.toString();
        } else {
            StringBuilder temp = new StringBuilder();
            while (!num.empty()) {
                temp.append(num.pop());
            }
            for (int k = 0; k < Integer.parseInt(temp.reverse().toString()); k++) {
                result.append(subStr.toString());
            }
            return result.toString();
        }
    }

    private boolean isNumber(char x) {
        return x >= '0' && x <= '9';
    }

    public static void main(String[] args) {
        /**
         * * 示例:
         *      *
         *      * s = "3[a]2[bc]", 返回 "aaabcbc".
         *      * s = "3[a2[c]]", 返回 "accaccacc".
         *      * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
         */
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
}
