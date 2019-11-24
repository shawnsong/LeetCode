package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q1188_DesignBoundedBlockingQueue {

    private Lock lock;
    private Condition full;
    private Condition empty;
    private int[] queue;
    private int size;
    private int head;
    private int tail;

    public Q1188_DesignBoundedBlockingQueue() {
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
        size = 0;
        head = 0;
        tail = 0;
    }

    public void enqueue(int value) throws InterruptedException {
        lock.lock();
        try {
            while (size == queue.length) {
                full.await();
            }
            size++;
            queue[tail] = value;
            tail++;
            tail = tail % queue.length;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                empty.await();
            }
            int res = queue[head];
            head++;
            head = head % queue.length;
            size--;
            full.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }
}
