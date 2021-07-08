package com.algorithm.queue;

/**
 * 基于数组实现循环队列
 * @Author: kim
 * @Description:
 * @Date: 15:30 2021/7/8
 * @Version: 1.0
 */
public class CircularQueue {

    private String[] items;
    // 数组大小,即队列容量n,实际只能存 n -1个数,tail指向的位置不存数据
    private int n;
    // 头指针
    private int head;
    // 尾指针,循环队列中,使用数组时这里的尾指针指向的位置不存储数据
    private int tail;

    public CircularQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    // 入队
    public boolean enqueue(String item) {
        // 先判断队列是否已满
        if (head == (tail +1)%n) {
            return false;
        }
        // 入队
        items[tail] = item;
        // 注意尾指针的位置指向
        tail = (tail + 1) % n;
        return true;
    }

    // 出队
    public String dequeue() {
        // 先判断队列是否为空
        if (head == tail) {
            return null;
        }
        String item = items[head];
        // 注意头指针的位置指向
        head = (head +1) % n ;
        return item;
    }
}
