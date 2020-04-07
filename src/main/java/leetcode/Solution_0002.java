package leetcode;

import leetcode.models.ListNode;

public class Solution_0002 {
    /**
     * 两数相加
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode stl = new ListNode(-1);

        ListNode cur1 = l1, cur2 = l2, res = stl;
        int delta = 0;

        while (cur1 != null || cur2 != null) {
            if (cur1 != null && cur2 != null) {
                int calc = cur1.val + cur2.val + delta;
                res.next = new ListNode(calc % 10);
                delta = calc / 10;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            else if (cur1 != null) {
                int calc = cur1.val + delta;
                res.next = new ListNode(calc % 10);
                delta = calc / 10;
                cur1 = cur1.next;
            }
            else {
                int calc = cur2.val + delta;
                res.next = new ListNode(calc % 10);
                delta = calc / 10;
                cur2 = cur2.next;
            }
            res = res.next;
        }

        if (delta > 0)
            res.next = new ListNode(delta);

        return stl.next;
    }
}
