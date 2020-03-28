package leetcode;

import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        String begin = "0000";
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains(begin))
            return -1;
        if (target.equals(begin))
            return 0;
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        int step = 0;
        Queue<String> list = new LinkedList<>();
        list.offer(begin);
        while (!list.isEmpty()) {
            String current = list.poll();
            if (current == null) {
                step++;
                continue;
            }
            Queue<String> nexts = findNexts(current);
            for (String next : nexts) {
                if (deads.contains(next) || visited.contains(next))
                    continue;
                if (target.equals(next)) {
                    return step;
                }
                visited.add(next);
                list.offer(next);
            }
            list.offer(null);
        }
        return step;
    }

    private Queue<String> findNexts(String current) {
        Queue<String> list = new LinkedList<>();
        char[] chars = current.toCharArray();

        for (int i = 0; i < 4; i++) {
            char[] tempArr = current.toCharArray();
            tempArr[i] = (char)(chars[i] == '9' ? '0' : chars[i] + 1);
            StringBuilder sb = new StringBuilder();
            sb.append(tempArr);
            list.offer(sb.toString());

            sb = new StringBuilder();
            tempArr[i] = (char)(chars[i] == '0' ? '9' : chars[i] - 1);
            sb.append(tempArr);
            list.offer(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        /**
         * ["0201","0101","0102","1212","2002"]
         * "0202"
         */
        String[] deads = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(new Solution().openLock(deads, target));
    }
}