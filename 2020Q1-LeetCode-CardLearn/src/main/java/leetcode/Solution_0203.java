package leetcode;

import leetcode.models.ListNode;

public class Solution_0203 {
    /**
     * 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     *
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode cur = head, pred = sentinel;

        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                pred.next = cur;
            } else {
                pred = cur;
                cur = cur.next;
            }
        }

        return sentinel.next;
    }
}
