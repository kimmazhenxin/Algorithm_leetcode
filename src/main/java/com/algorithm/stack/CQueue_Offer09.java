package com.algorithm.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 *
 * 解题思路:
 *
 *
 *
 * @Author: kim
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 * @Date: 16:48 2021/6/10
 * @Version: 1.0
 */
public class CQueue_Offer09 {
    // 存放数据
    private Stack<Integer> stack;
    // 临时栈
    private Stack<Integer> tmpStack;

    public CQueue_Offer09() {
        stack = new Stack<Integer>();
        tmpStack = new Stack<Integer>();
    }


    public static void main(String[] args) {
        CQueue_Offer09 c = new CQueue_Offer09();
        c.appendTail(1);
        c.appendTail(2);
        c.appendTail(3);
        System.out.println(c.deleteHead());

    }

    // 1. 直接使用Java中提供的栈stack来解决(底层基于数组,需要考虑扩容问题)
    // 入队列
    public void appendTail(int value) {
        // 直接
        stack.push(value);
    }

    // 出队列
    public int deleteHead() {
        // 栈为空
        if (stack.isEmpty()) {
            return -1;
        }
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }

        Integer reslut = tmpStack.pop();

        // 再放回原栈中
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }

        return reslut;
    }


    // 2. 使用LinkedList作为栈来解决
    public class LinkedListToQueue {

        private LinkedList<Integer> stack;

        private LinkedList<Integer> tmpStack;

        public LinkedListToQueue() {
            stack = new LinkedList<>();
            tmpStack = new LinkedList<>();
        }

        // 入队列
        public void enqueue(int value) {
            stack.add(value);

        }

        // 出队列
        public int dequeue() {
            if (tmpStack.isEmpty()) {
                if (stack.isEmpty()) {
                    return -1;
                }
                while (!stack.isEmpty()) {
                    tmpStack.add(stack.pop());
                }
                return tmpStack.pop();
            } else {
                return tmpStack.pop();
            }
        }
    }
}
