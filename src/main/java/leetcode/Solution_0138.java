package leetcode;

import leetcode.models.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution_0138 {
    /**
     * 复制带随机指针的链表
     * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     *
     * 要求返回这个链表的 深拷贝。
     *
     * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     *
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     */
    public Node copyRandomList(Node head) {
        Node stl = new Node(-1);
        Map<Node, Node> visited = new HashMap<>();
        dfs(visited, head, stl, false);
        return stl.next;
    }

    private Node dfs(Map<Node, Node> visited, Node cur, Node res, boolean random) {
        while (cur != null) {
            if (visited.containsKey(cur)) {
                if (random) {
                    res.random = visited.get(cur);
                } else {
                    res.next = visited.get(cur);
                }
                return res;
            }

            Node clone = new Node(cur.val);
            if (random) {
                res.random = clone;
                res = res.random;
                random = false;
            }
            else {
                res.next = clone;
                res = res.next;
            }

            visited.put(cur, clone);
            if (cur.random != null) {
                Node succ = cur.next;
                Node pred = res;
                cur = cur.random;
                dfs(visited, cur, res, true);
                res = pred;
                cur = succ;
            } else {
                cur = cur.next;
            }
        }
        return res;
    }
}
