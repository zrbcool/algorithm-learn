package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_0387 {
    /**
     * 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 案例:
     *
     * s = "leetcode"
     * 返回 0.
     *
     * s = "loveleetcode",
     * 返回 2.
     *
     *
     * 注意事项：您可以假定该字符串只包含小写字母。
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;
        if (s.length() == 1)
            return 0;
        Set<Character> dup = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dup.contains(c))
                continue;
            if (map.containsKey(c)) {
                map.remove(c);
                dup.add(c);
                continue;
            }
            map.put(c, i);
        }
        int index = Integer.MAX_VALUE;
        if (map.isEmpty())
            return -1;
        else {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() < index)
                    index = entry.getValue();
            }
        }
        return index;
    }
}
