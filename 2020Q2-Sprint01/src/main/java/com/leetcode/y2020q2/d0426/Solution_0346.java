package com.leetcode.y2020q2.d0426;

public class Solution_0346 {
    /**
     * 数据流中的移动平均值
     * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
     *
     * 示例:
     *
     * MovingAverage m = new MovingAverage(3);
     * m.next(1) = 1
     * m.next(10) = (1 + 10) / 2
     * m.next(3) = (1 + 10 + 3) / 3
     * m.next(5) = (10 + 3 + 5) / 3
     */
    class RingBuffer {

        int head = -1;
        int tail = -1;
        int[] ring;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public RingBuffer(int k) {
            this.ring = new int[k];
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) return false;
            if (head == -1 && tail == -1) {
                head = 0;
                tail = 0;
            } else {
                tail++;
                if (tail > ring.length - 1) {
                    tail = 0;
                }
            }
            ring[tail] = value;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) return false;
            if (head == tail) {
                tail = -1;
                head = -1;
            } else {
                head++;
                if (head > ring.length - 1) {
                    head = 0;
                }
            }
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()) return -1;
            return ring[head];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()) return -1;
            return ring[tail];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return head == -1 && tail == -1;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return head == tail + 1 || (head == 0 && tail == ring.length - 1);
        }
    }

    class MovingAverage {
        double winSum = 0;
        RingBuffer ringBuffer;
        int size = 0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            ringBuffer = new RingBuffer(size);
        }

        public double next(int val) {
            if (ringBuffer.isFull()) {
                winSum -= ringBuffer.Front();
                ringBuffer.deQueue();
            } else {
                size++;
            }
            winSum += val;
            ringBuffer.enQueue(val);
            return winSum / size;
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
