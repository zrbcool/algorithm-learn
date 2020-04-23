package leetcode;

import leetcode.models.Node;

public class Solution_0430 {
    /**
     * 扁平化多级双向链表
     * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
     *
     * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
     */
    public Node flatten(Node head) {
        Node stl = new Node();
        stl.next = head;

        dfs(head, stl);
        if (stl.next != null) {
            stl.next.prev = null;
        }
        return stl.next;
    }

    public Node dfs(Node cur, Node res) {
        while (cur != null) {
            Node succ;
            if (cur.child == null) {
                res.next = cur;
                cur.prev = res;
                res = res.next;
                cur = cur.next;
            }
            else {
                succ = cur.next;
                //链接node
                res.next = cur;
                cur.prev = res;

                //前进
                res = res.next;
                cur = cur.child;

                res.child = null;

                //链接子链表的head
                res = dfs(cur, res);
                cur = succ;
            }
        }
        return res;
    }
}
