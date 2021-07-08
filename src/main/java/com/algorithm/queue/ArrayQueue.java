package com.algorithm.queue;

/**
 * @Author: kim
 * @Description: 基于数组实现队列
 * @Date: 11:27 2021/7/8
 * @Version: 1.0
 */
public class ArrayQueue {

    private String[] items;
    // 数组大小
    private int n;
    // 队列头下标
    private int head = 0;
    // 队列尾下标
    private int tail = 0;

    public ArrayQueue() {
    }

    public ArrayQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    // 入队,将item放入队尾
    public boolean enqueue(String item) {
        // tail == n表示队列末尾没有空间了,但是并不表示队列前面head之前的位置已经满了,所以需要判断head之前的位置空间
        if (tail == n) {
            // tail == n && head == 0 说明整个队列已经占满了
            if (head == 0) {
                return false;
            }
            // 否则搬移数据,将 head 到 tail 之间的数据搬移到 0 到 tail - head的位置
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }

            // 注意: 搬移完数据之后,要修改队头和队尾的下标
            tail = tail - head;
            head = 0;
        }

        // 入队
        items[tail] = item;
        tail++;
        return true;
    }

    // 出队
    public String dequeue() {
        // 判断队列是否为空
        if (tail == head) {
            return null;
        }
        String item = items[head];

        head++;
        return item;
    }

}
