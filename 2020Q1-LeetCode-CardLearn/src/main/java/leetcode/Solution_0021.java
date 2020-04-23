package leetcode;

import leetcode.models.ListNode;

public class Solution_0021 {
    /**
     * 合并两个有序链表
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode stl = new ListNode(-1);

        ListNode cur1 = l1, cur2 = l2, rst = stl;

        while (cur1 != null || cur2 != null) {
            if (cur1 != null && cur2 != null) {
                if (cur1.val < cur2.val) {
                    rst.next = cur1;
                    rst = rst.next;
                    cur1 = cur1.next;
                } else {
                    rst.next = cur2;
                    rst = rst.next;
                    cur2 = cur2.next;
                }
            }
            else if (cur1 != null) {
                rst.next = cur1;
                rst = rst.next;
                cur1 = cur1.next;
            }
            else {
                rst.next = cur2;
                rst = rst.next;
                cur2 = cur2.next;
            }
        }
        return stl.next;
    }
}
