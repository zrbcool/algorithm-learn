package leetcode;

import leetcode.models.GuessGame;

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
public class Solution_0374 extends GuessGame {
    /**
     * 猜数字大小
     * 我们正在玩一个猜数字游戏。 游戏规则如下：
     * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
     * 每次你猜错了，我会告诉你这个数字是大了还是小了。
     * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
     *
     * -1 : 我的数字比较小
     *  1 : 我的数字比较大
     *  0 : 恭喜！你猜对了！
     * 示例 :
     *
     * 输入: n = 10, pick = 6
     * 输出: 6
     */
    public int guessNumber(int n) {
        int L = 0, R = n;
        int m = 0;

        while (L <= R) {
            m = L + (R - L) / 2;
            if (this.guess(m) == -1) {
                //System.out.println(String.format("guess(m) == -1 m=%s, L=%s, R=%s", m, L, R));
                R = m - 1;
                //System.out.println(String.format("guess(m) == 1 R = m - 1 = %s", R));
            }
            else if (this.guess(m) == 1) {
                //System.out.println(String.format("guess(m) == 1 m=%s, L=%s, R=%s", m, L, R));
                L = m + 1;
                //System.out.println(String.format("guess(m) == -1 L = m + 1 = %s", L));
            }
            else {
                //System.out.println(String.format("guess(m) == 0 m=%s, L=%s, R=%s", m, L, R));
                return m;
            }
        }
        return m;
    }
}
