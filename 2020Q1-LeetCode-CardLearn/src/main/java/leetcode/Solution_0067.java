package leetcode;

public class Solution_0067 {
    /**
     * 二进制求和
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     *
     * 输入为非空字符串且只包含数字 1 和 0。
     *
     * 示例 1:
     *
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        char[] lStr;
        char[] sStr;

        if (a.length() >= b.length()) {
            lStr = a.toCharArray();
            sStr = b.toCharArray();
        } else {
            lStr = b.toCharArray();
            sStr = a.toCharArray();
        }
        int delta = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = lStr.length - 1, j = sStr.length - 1; i >= 0; i--, j--) {
            char adder = '0';
            if (j >= 0) {
                adder = sStr[j];
            }
            int[] add = add(lStr[i], adder, delta);
            sb.append(add[0]);
            delta = add[1];
        }
        if (delta > 0)
            sb.append(delta);
        return sb.reverse().toString();
    }

    private int[] add(char x, char y, int delta) {
        if (x == '1' && y == '1') {
            if (delta == 1) {
                return new int[]{1, 1};
            } else {
                return new int[]{0, 1};
            }
        } else if (x == '0' && y == '0') {
            if (delta == 1) {
                return new int[]{1, 0};
            } else {
                return new int[]{0, 0};
            }
        } else {
            if (delta == 1) {
                return new int[]{0, 1};
            } else {
                return new int[]{1, 0};
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution_0067().addBinary("1010", "1011"));
    }
}
