package leetcode;

import leetcode.models.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_0019 {
    /**
     * 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode cur = sentinel;
        int offset = 0;

        Map<Integer, ListNode> offsetToNode = new HashMap<>();

        while (cur != null) {
            offsetToNode.put(offset++, cur);
            cur = cur.next;
        }

        ListNode pred = offsetToNode.get(offset - n - 1);
        pred.next = offsetToNode.get(offset - n + 1);

        return sentinel.next;
    }
}
