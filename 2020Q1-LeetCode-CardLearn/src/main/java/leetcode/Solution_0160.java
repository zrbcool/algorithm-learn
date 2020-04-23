package leetcode;

import leetcode.models.ListNode;

public class Solution_0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode curA = headA, curB = headB;

        int cycle = 0;
        while (cycle <= 2) {
            if (curA == curB)
                return curA;
            else if (curA == null) {
                curA = headB;
                cycle++;
            } else {
                curA = curA.next;
            }

            if (curA == curB)
                return curA;
            else if (curB == null) {
                curB = headA;
                cycle++;
            } else {
                curB = curB.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        /**
         * 8
         * [4,1,8,4,5]
         * [5,0,1,8,4,5]
         * 2
         * 3
         */

        ListNode headA = new ListNode(4);
        ListNode curA = headA;
        curA.next = new ListNode(1);
        curA = curA.next;
        ListNode inter = new ListNode(8);
        curA.next = inter;
        curA = curA.next;
        curA.next = new ListNode(4);
        curA = curA.next;
        curA.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        ListNode curB = headB;
        curB.next = new ListNode(0);
        curB = curB.next;
        curB.next = new ListNode(1);
        curB = curB.next;
        curB.next = inter;

        System.out.println(new Solution_0160().getIntersectionNode(headA, headB));

    }
}
