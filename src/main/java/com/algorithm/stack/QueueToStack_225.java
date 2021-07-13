package com.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 解题思路:
 *  1. push直接使用队列方法入队列, pop和top方法来回倒腾队列
 *  2. push方法来回倒腾队列,pop和top方法直接使用队列方法
 *
 * @Author: kim
 * @Description: 225. 用队列实现栈
 * @Date: 9:56 2021/7/13
 * @Version: 1.0
 */
public class QueueToStack_225 {

    private Queue<Integer> queue;

    public QueueToStack_225() {
        queue = new LinkedList<>();

    }

    // 压栈(直接入)
    public void push(int x) {
        queue.offer(x);
    }

    // 出栈(反复倒腾)
    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        int n = queue.size();
        // 最后一个队列的元素成为栈顶的元素了
        for (int i = 0; i < n - 1; i++) {
            queue.offer(queue.poll());
        }
        // 头部元素即使栈顶元素
        int result = queue.poll();
        return result;
    }

    // 返回栈顶元素(反复倒腾),类似于peek()
    public int top() {
        if (queue.isEmpty()) {
            return -1;
        }
        int n = queue.size();
        // 最后一个队列的元素成为栈顶的元素了
        for (int i = 0; i < n - 1; i++) {
            queue.offer(queue.poll());
        }
        int result = queue.poll();
        // 再放入队列中
        queue.offer(result);
        return result;
    }

    // 判断栈是否为空
    public boolean empty() {
        return queue.isEmpty();
    }
}

// 解法2
class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    // 入栈需要倒腾队列,将入栈元素放入队列的头部
    public void push(int value) {
        int n = queue.size();
        // 入队列
        queue.offer(value);
        for (int i = 0; i < n; i++) {
            // 这样插入的元素就位于队列的头部了
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
