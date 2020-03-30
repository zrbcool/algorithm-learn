package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     */
    static class Solution_01 {
        public int[] dailyTemperatures(int[] T) {
            int[] result = new int[T.length];

            for (int i = 0; i < T.length; i++) {
                for (int j = i + 1; j < T.length; j++) {
                    if (T[j] > T[i]) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
            return result;
        }
    }

    static class Solution_02 {
        static class Stack {
            List<int[]> list = new ArrayList<>();
            void push(int[] c) {
                list.add(c);
            }

            int[] pop() {
                if (!list.isEmpty()) {
                    return list.remove(list.size() - 1);
                }
                return null;
            }

            boolean isEmpty() {
                return list.size() == 0;
            }

            int[] top() {
                return list.get(list.size() - 1);
            }

            int size() {
                return list.size();
            }
        }

        public int[] dailyTemperatures(int[] T) {
            Stack stack = new Stack();
            int[] result = new int[T.length];
            for (int i = T.length - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    result[i] = 0;
                    stack.push(new int[]{T[i], i});
                } else if (stack.top()[0] > T[i]) {
                    result[i] = stack.top()[1] - i;
                    stack.push(new int[]{T[i], i});
                } else {
                    int size = stack.size();
                    for (int j = 0; j < size + 1; j++) {
                        if (stack.isEmpty()) {
                            stack.push(new int[]{T[i], i});
                            result[i] = 0;
                            break;
                        } else if (stack.top()[0] > T[i]) {
                            result[i] = stack.top()[1] - i;
                            stack.push(new int[]{T[i], i});
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] temp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        for (int i : new Solution_01().dailyTemperatures(temp)) {
            System.out.print(i + ", ");
        }
        System.out.println();
        for (int i : new Solution_02().dailyTemperatures(temp)) {
            System.out.print(i + ", ");
        }
    }
}
