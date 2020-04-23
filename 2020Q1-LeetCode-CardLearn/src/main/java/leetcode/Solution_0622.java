package leetcode;

public class Solution_0622 {
    private final int[] array;
    private int head = -1;
    private int tail = -1;
    private int size = 0;
    private final int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public Solution_0622(int k) {
        this.capacity = k;
        this.array = new int[capacity];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull())
            return false;

        tail++;
        if (tail > capacity - 1)
            tail = 0;
        array[tail] = value;

        if (isEmpty()) {
            head++;
        }
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        head++;
        if (head > capacity -1)
            head = 0;

        if (size == 1) {
            head = -1;
            tail = -1;
        }
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())
            return -1;
        return array[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())
            return -1;
        return array[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size >= capacity;
    }

    /**
     * ["Solution_0622","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
     * [[3],[1],[2],[3],[4],[],[],[],[4],[]]
     * [null,true,true,true,false,3,true,true,true,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution_0622 queue = new Solution_0622(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
    }
}

/**
 * Your Solution_0622 object will be instantiated and called as such:
 * Solution_0622 obj = new Solution_0622(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */