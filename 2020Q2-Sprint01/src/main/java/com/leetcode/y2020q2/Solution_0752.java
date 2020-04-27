package com.leetcode.y2020q2;

import java.util.*;

public class Solution_0752 {
    /**
     * 打开转盘锁
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     *
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     *
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     *
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     *
     * 提示：
     *
     * 死亡列表 deadends 的长度范围为 [1, 500]。
     * 目标数字 target 不会在 deadends 之中。
     * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet, deadends);

        Set<String> seen = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        seen.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int num = 0; num < size; num++) {
                String poll = queue.poll();
                if (deadSet.contains(poll)) continue;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        char[] chars = poll.toCharArray();
                        char c = chars[i];
                        if (j % 2 == 0) {
                            chars[i] = swap(c, 1);
                        } else {
                            chars[i] = swap(c, -1);
                        }
                        String nstr = new String(chars);
                        if (nstr.equals(target)) return ++step;
                        if (seen.contains(nstr)) continue;
                        if (deadSet.contains(nstr)) continue;
                        queue.offer(nstr);
                        seen.add(nstr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public char swap(char c, int offset) {
        if (c == '0' && offset == -1) {
            return '9';
        }
        else if (c == '9' && offset == 1) {
            return '0';
        }
        else {
            return (char) (c + offset);
        }
    }

    public static void main(String[] args) {
        /**
         * 输入：
         * ["0000"]
         * "8888"
         * 输出：
         * 8
         * 预期：
         * -1
         */
        String[] dead = new String[]{"0201","0101","0102","1212","2002"};
        System.out.println(new Solution_0752().openLock(dead, "0202"));
    }
}
