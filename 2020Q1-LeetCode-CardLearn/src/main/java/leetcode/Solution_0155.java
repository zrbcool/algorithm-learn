package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution_0155 {
    /**
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     *     push(x) -- 将元素 x 推入栈中。
     *     pop() -- 删除栈顶的元素。
     *     top() -- 获取栈顶元素。
     *     getMin() -- 检索栈中的最小元素。
     *
     * 示例:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class MinStack {
        static class Node {
            private Node pre;
            private Node next;
            private int value;

            public Node(Node pre, Node next, int value) {
                this.pre = pre;
                this.next = next;
                this.value = value;
            }
        }
        private List<Integer> container = new LinkedList<>();
        private Node head;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            container.add(x);
            if (head == null) {
                head = new Node(null, null, x);
            } else {
                Node cur = head;
                while (cur != null) {
                    if (x <= cur.value) {

                        Node n = new Node(null, null, x);
                        n.next = cur;
                        n.pre = cur.pre;

                        if (cur == head)
                            head = n;
                        else
                            cur.pre = n;
                        break;
                    }
                    cur = cur.next;
                }
            }
        }

        public void pop() {
            if (!container.isEmpty()) {
                Integer remove = container.remove(container.size() - 1);
                Node cur = head;
                while (cur != null) {
                    if (remove == cur.value) {
                        if (cur.pre != null)
                            cur.pre.next = cur.next;
                        else
                            head = cur.next;
                        break;
                    }
                    cur = cur.next;
                }
            }
        }

        public int top() {
            return container.get(container.size() - 1);
        }

        public int getMin() {
            return head.value;
        }

        public static void main(String[] args) {
            MinStack minStack = new MinStack();
//            minStack.push(-2);
//            minStack.push(0);
//            minStack.push(-3);
//            System.out.println(minStack.getMin());//--> 返回 -3.
//            minStack.pop();
//            System.out.println(minStack.top());//--> 返回 0.
//            System.out.println(minStack.getMin());//--> 返回 -2.

            /**
             * ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
             * [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
             */

            minStack.push(2);
            minStack.push(0);
            minStack.push(3);
            minStack.push(0);
            System.out.println(minStack.getMin());
            minStack.pop();
            System.out.println(minStack.getMin());
            minStack.pop();
            System.out.println(minStack.getMin());
            minStack.pop();
            System.out.println(minStack.getMin());
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
