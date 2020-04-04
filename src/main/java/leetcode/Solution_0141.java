package leetcode;

public class Solution_0141 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next, slow = head;

        while (slow != null) {
            for (int i = 0; i < 2 && fast != null; i++) {
                if (fast == slow)
                    return true;
                fast = fast.next;
            }
            slow = slow.next;
        }

        return false;
    }
}
