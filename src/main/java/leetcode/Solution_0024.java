package leetcode;

import leetcode.models.ListNode;

public class Solution_0024 {
    /**
     * 反转链表
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode sentinel = new ListNode(-1);
        sentinel.next = cur;
        ListNode prev;
        while (cur != null) {
            prev = cur.next;
            if (prev != null) {
                cur.next = prev.next;
                prev.next = sentinel.next;
                sentinel.next = prev;
            } else {
                break;
            }
        }
        return sentinel.next;
    }
}
