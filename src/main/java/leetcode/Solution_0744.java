package leetcode;

public class Solution_0744 {
    /**
     * 寻找比目标字母大的最小字母
     * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
     *
     * 在比较时，数组里字母的是循环有序的。举个例子：
     *
     * 如果目标字母 target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
     * 如果目标字母 target = 'n' 并且有序数组为 letters = ['m', 'z', 'c', 'f', 'j'] ，则答案返回 'z' 。
     *
     *
     * 示例：
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "a"
     * 输出: "c"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "c"
     * 输出: "f"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "d"
     * 输出: "f"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "g"
     * 输出: "j"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "j"
     * 输出: "c"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "k"
     * 输出: "c"
     *
     *
     * 提示：
     *
     * letters长度范围在[2, 10000]区间内。
     * letters 仅由小写字母组成，最少包含两个不同的字母。
     * 目标字母target 是一个小写字母。
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int L = 0;
        int R = letters.length - 1;
        int q = letters.length - 1;
        while (L + 1 < R) {
            int m = L + (R - L) / 2;
            if (letters[m] > letters[m + 1]) {
                q = m;
                break;
            } else {
                if (letters[m] > letters[0]) {
                    L = m;
                } else {
                    R = m;
                }
            }
        }
        if (q == letters.length - 1) {
            return nextGreatestLetter(letters, target, 0, q);
        } else {
            if (letters[L] > letters[L + 1]) q = L;
            else q = L + 1;
            // [0..q], [q..length-1]
            char left = nextGreatestLetter(letters, target, 0, q);
            char right = nextGreatestLetter(letters, target, q + 1, letters.length - 1);
            if (left == '-') return right;
            else if (right == '-') return left;
            else return left < right ? left : right;
        }
    }

    public char nextGreatestLetter(char[] letters, char target, int from, int to) {
        int L = from;
        int R = to;
        while (L + 1 < R) {
            int m = L + (R - L) / 2;
            if (letters[m] > target) {
                R = m;
            } else {
                L = m;
            }
        }

        if (letters[L + 1] < target) {
            return '-';
        } else {
            if (letters[L] > target) return letters[L];
            else return letters[L + 1];
        }
    }

    public static void main(String[] args) {
        /**
         * ["c","f","j"]
         * "j"
         */
        System.out.println(new Solution_0744().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int L = 0;
        int R = letters.length - 1;

        while (L + 1 < R) {
            int m = L + (R - L) / 2;
            if (letters[m] < target) {
                L = m + 1;
            } else {
                R = m;
            }
        }
        int idx;
        if (letters[L + 1] < target) idx = L + 1;
        else idx = L;

        char tarNew = letters[idx];
        if (idx < 2) return letters[0] < letters[idx] ? letters[0] : letters[idx];
        //求小于tarNew的最小idx
        L = idx;
        R = letters.length - 1;
        int minIdx = -1;
        while (L + 1 < R) {
            int m = L + (R - L) / 2;
            if (letters[m] < target) {
                R = m;
            } else {
                L = m - 1;
            }
        }

        if (letters[L] < target) idx = L;
        else idx = L + 1;
        return letters[idx];
    }
}
