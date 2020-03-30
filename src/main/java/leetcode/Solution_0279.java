package leetcode;

import java.util.*;

public class Solution_0279 {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     *
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     *
     * 示例 2:
     *
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     * @param n
     * @return
     */
    public int numSquares(int n) {

        Queue<Integer> list = new LinkedList<>();
        list.offer(n);

        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> level = new HashMap<>();
        while (!list.isEmpty()) {
            Integer remove = list.remove();
            for (int i = 1; i < remove + 1; i++) {
                int newValue = remove - i * i;
                if (newValue == 0)
                    return level.getOrDefault(remove, 0) + 1;
                if (newValue < 0 || seen.contains(newValue))
                    continue;
                level.put(newValue, level.getOrDefault(remove, 0) + 1);
                list.offer(newValue);
                seen.add(newValue);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution_0279().numSquares(12));
        System.out.println(new Solution_0279().numSquares(1));
    }
}
