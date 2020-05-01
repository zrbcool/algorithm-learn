package y2020q2.队列和栈.d0426;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_0279 {
    /**
     * 完全平方数
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     *
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     *
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     */
    public int numSquares(int n) {
        if (n <= 0) return -1;
        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (int j = 1; j * j <= poll; j++) {
                    if (j * j == poll) {
                        step++;
                        return step;
                    }
                    queue.offer(poll - j * j);
                }
            }
            step++;
        }
        return -1;
    }

    public long binarySearch(long n) {
        long L = 0;
        long R = n;
        while (L + 1 < R) {
            long mid = L + (R - L) / 2;
            long square = mid * mid;
            if (square == n) {
                return mid;
            }
            else if (square > n) {
                R = mid - 1;
            }
            else {
                L = mid;
            }
        }

        if ((L + 1) * (L + 1) <= n) return L + 1;
        else return L;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Solution_0279().numSquares(12));
    }
}
