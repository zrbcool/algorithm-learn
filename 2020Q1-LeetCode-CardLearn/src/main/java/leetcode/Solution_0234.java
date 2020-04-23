package leetcode;

import leetcode.models.ListNode;

public class Solution_0234 {

    /**
     * 回文链表
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        ListNode reverse = reverse(head);

        while (cur != null && reverse != null) {
            if (cur.val != reverse.val)
                return false;
            else {
                cur = cur.next;
                reverse = reverse.next;
            }
        }

        return cur == null && reverse == null;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode head1 = new ListNode(head.val);;

        ListNode stl = new ListNode(-1);
        stl.next = head1;

        ListNode cur = head;
        cur = cur.next;
        while (cur != null) {
            ListNode clone = new ListNode(cur.val);
            clone.next = stl.next;
            stl.next = clone;
            cur = cur.next;
        }
        return stl.next;
    }
}
