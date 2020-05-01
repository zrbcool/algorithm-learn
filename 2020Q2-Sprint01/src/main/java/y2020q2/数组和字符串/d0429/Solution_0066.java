package y2020q2.数组和字符串.d0429;

public class Solution_0066 {
    /**
     * 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     *
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;

        int delta = 1;
        int[] bigger = new int[digits.length + 1];
        int temp;
        for (int i = digits.length - 1; i >= 0; i--) {
            temp = digits[i] + delta;
            digits[i] = temp % 10;
            bigger[i] = digits[i];
            delta = temp / 10;
        }

        if (delta > 0) {
            bigger[0] = delta;
            return bigger;
        } else {
            return digits;
        }
    }
}
