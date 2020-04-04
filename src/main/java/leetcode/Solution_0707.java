package leetcode;

public class Solution_0707 {
    /**
     * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
     *
     * 在链表类中实现这些功能：
     *
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     *
     * 示例：
     *
     * MyLinkedList linkedList = new MyLinkedList();
     * linkedList.addAtHead(1);
     * linkedList.addAtTail(3);
     * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
     * linkedList.get(1);            //返回2
     * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
     * linkedList.get(1);            //返回3
     *
     *
     * 提示：
     *
     * 所有val值都在 [1, 1000] 之内。
     * 操作次数将在  [1, 1000] 之内。
     * 请不要使用内置的 LinkedList 库。
     *
     * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
     * [[],[1],[3],[1,2],[1],[1],[1]]
     */
    private static class MyLinkedList1 {

        private static class Node {
            private int val;
            private Node next;

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }

        private Node head;
        private Node tail;

        /** Initialize your data structure here. */
        public MyLinkedList1() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            Node node = getNode(index);
            return node == null ? -1 : node.val;
        }

        private Node getNode(int index) {
            Node find;
            if (head == null)
                return null;
            find = head;
            for (int i = 0; i < index; i++) {
                find = find.next;
                if (find == null)
                    break;
            }
            return find;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            if (head == null) {
                head = new Node(val, null);
                tail = head;
            } else {
                head = new Node(val,
                        head);
            }
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            if (head == null) {
                head = new Node(val, null);
                tail = head;
            } else {
                Node newTail = new Node(val, null);
                tail.next = newTail;
                tail = newTail;
            }
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            Node pre = getNode(index - 1);
            if (pre == null)
                return;
            Node add = new Node(val,
                    pre.next);
            if (pre == tail) {
                tail = add;
            }
            pre.next = add;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index == 0) {
                tail = head == tail ? null : tail;
                head = head.next;
                return;
            }
            Node pre = getNode(index - 1);
            if (pre == null || pre == tail)
                return;
            tail = pre.next == tail ? pre : tail;
            Node target = pre.next;
            pre.next = target.next;
            target.next = null;
        }
    }

    private static class MyLinkedList2 {

    }

    public static void main(String[] args) {
        /**
         * 输入：
         * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
         * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
         * 输出：
         * [null,null,null,null,null,null,null,null,-1,null,null,null]
         * 预期：
         * [null,null,null,null,null,null,null,null,4,null,null,null]
         */
        MyLinkedList1 list = new MyLinkedList1();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);

        /**
         * 输入：
         * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
         * [[],[1],[3],[1,2],[1],[0],[0]]
         * 输出：
         * [null,null,null,null,2,null,1]
         * 预期：
         * [null,null,null,null,2,null,2]
         */
        list = new MyLinkedList1();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        System.out.println(list.get(1));
        list.deleteAtIndex(0);
        System.out.println(list.get(0));
        /**
         * 输入：
         * ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
         * [[],[0,10],[0,20],[1,30],[0]]
         * 输出：
         * [null,null,null,null,-1]
         * 预期：
         * [null,null,null,null,20]
         */
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
