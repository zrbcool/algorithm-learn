package y2020q2.队列和栈.d0428;

import java.util.Stack;

public class Solution_0394 {
    /**
     * 字符串解码
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
     */
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> multiStack = new Stack<>();
        StringBuilder rb = new StringBuilder();
        int multi = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == ']') {
                StringBuilder temp = new StringBuilder();
                Integer mPop = multiStack.pop();
                for (int integer = 0; integer < mPop; integer++) {
                    temp.append(rb.toString());
                }
                rb = new StringBuilder(stringStack.pop() + temp.toString());
            }
            else if (charAt >= '0' && charAt <= '9') {
                multi = multi * 10 + (charAt - '0');
            }
            else if (charAt == '[') {
                stringStack.push(rb.toString());
                multiStack.push(multi);
                rb = new StringBuilder();
                multi = 0;
            } else {
                rb.append(charAt);
            }
        }
        return rb.toString();
    }

    public static void main(String[] args) {
        /**
         * "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
         * "3[z]
         * 2[2[y]pq4[2[jk]e1[f]]]
         * ef"
         * "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
         * "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
         * "yypqjkjkefyypqjkjkefyypqjkjkefyypqjkjkefyypqjkjkefyypqjkjkefyypqjkjkefyypqjkjkefef"
         */

        System.out.println(new Solution_0394().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }


}
