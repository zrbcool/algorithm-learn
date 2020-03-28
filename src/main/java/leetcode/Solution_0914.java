package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_0914 {
    /**
     * 给定一副牌，每张牌上都写着一个整数。
     * <p>
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * <p>
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * <p>
     * 仅当你可选的 X >= 2 时返回 true。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     * <p>
     * 示例 2：
     * <p>
     * 输入：[1,1,1,2,2,2,3,3]
     * 输出：false
     * 解释：没有满足要求的分组。
     * <p>
     * 示例 3：
     * <p>
     * 输入：[1]
     * 输出：false
     * 解释：没有满足要求的分组。
     * <p>
     * 示例 4：
     * <p>
     * 输入：[1,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]
     * <p>
     * 示例 5：
     * <p>
     * 输入：[1,1,2,2,2,2]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= deck.length <= 10000
     * 0 <= deck[i] < 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int one : deck) {
            Integer count = map.getOrDefault(one, 0) + 1;
            map.put(one, count);
        }

        if (map.values().size() == 1) {
            return (int) map.values().toArray()[0] >= 2;
        }

        Set<Integer> countSet = new HashSet<>();
        int minCount = Integer.MAX_VALUE;
        for (Integer value : map.values()) {
            if (value < minCount)
                minCount = value;
            countSet.add(value);
        }
        int a = (int) countSet.toArray()[0];
        for (Integer b : countSet) {
            if (gcd(a, b) < 2)
                return false;
            a = b;
        }

        return true;
    }

    private int gcd(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] param;
        param = new int[]{1,1,2,2,2,2};
//        param = new int[]{1};
        System.out.println(new Solution_0914().hasGroupsSizeX(param));
    }

//
//        //backup
//        int old = -1;
//        for (Integer value : map.values()) {
//            if (old == -1) {
//                old = value;
//            } else {
//                if (value != old && (value % old != 0))
//                    return false;
//            }
//        }
//
//        Set<Integer> set = new HashSet<>();
//        for (int one : deck) {
//            set.add(one);
//        }
//        if (set.size() >= 2)
//            result = true;
//        return result;
}
