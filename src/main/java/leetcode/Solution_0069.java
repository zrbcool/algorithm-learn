package leetcode;

public class Solution_0069 {
    /**
     * x 的平方根
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     *
     * 输入: 4
     * 输出: 2
     * 示例 2:
     *
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     */
    public int mySqrt(int x) {
        /**
         * if (x == 0) {
         *             return 0;
         *         }
         *         // 注意：针对特殊测试用例，例如 2147395599
         *         // 要把搜索的范围设置成长整型
         *         long left = 1;
         *         long right = x / 2;
         *         while (left < right) {
         *             // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
         *             // long mid = left + (right - left + 1) / 2;
         *             long mid = (left + right + 1) >>> 1;
         *             long square = mid * mid;
         *             if (square > x) {
         *                 right = mid - 1;
         *             } else {
         *                 left = mid;
         *             }
         *         }
         *         // 因为一定存在，因此无需后处理
         *         return (int) left;
         */
        if (x == 0) return 0;
        long L = 1;
        long R = x / 2;
        long m;
        long s;
        while (L < R) {
            System.out.println("------");
            m = (L + R + 1) / 2;
            s = m * m;
            System.out.println(String.format("L=%s, R=%s, m=%s, s=%s", L, R, m, s));
            if (s > x) {
                R = m - 1;
                System.out.println(String.format("s > x : R(%s) = m", R));
            }
            else {
                L = m;
                System.out.println(String.format("s <= x : L(%s) = m + 1", L));
            }
        }
        System.out.println("------------");
        System.out.println("Result is L -> " + L);
        return (int)L;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_0069().mySqrt(8));
    }
}
