package leetcode;

public class Solution_0014 {
    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int minLength = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength)
                minLength = strs[i].length();
        }
        int i = 0;
        out: for (; i < minLength; i++) {
            char last = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != last) {
                    break out;
                }
            }
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_0014().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
