package leetcode;

public class Solution_0367 {
    /**
     * 有效的完全平方数
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     *
     * 说明：不要使用任何内置的库函数，如  sqrt。
     *
     * 示例 1：
     *
     * 输入：16
     * 输出：True
     * 示例 2：
     *
     * 输入：14
     * 输出：False
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2)
            return true;

        long L = 2;
        long R = num / 2;
        while (L <= R) {
            long m = L + (R - L) / 2;
            long square = m * m;
            if (square == num) {
                return true;
            }
            else if (square > num) {
                R = m - 1;
            }
            else {
                L = m + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_0367().isPerfectSquare(144));
    }
}
