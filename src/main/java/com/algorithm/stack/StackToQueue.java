package com.algorithm.stack;

import java.util.Stack;

/**
 * 字节实习:
 *  用栈实现队列
 *
 *  解题思路:
 *  1. 入队 直接操作栈,相当于将数据直接入栈
 *  2. 出队 需要申请一个临时栈,将原来栈中的元素一个个弹出到临时栈中,然后取出临时栈的栈顶元素。
 *     最后将临时栈中的其它元素再压栈到原来的栈中即可
 * @Author: kim
 * @Description: 用栈实现队列
 * @Date: 19:42 2021/7/8
 * @Version: 1.0
 */
public class StackToQueue {
    // 真正存数据的栈
    private Stack<Integer> stack;
    // 临时栈
    private Stack<Integer> tmpStack;

    public StackToQueue() {
        stack = new Stack<>();
        tmpStack = new Stack<>();
    }


    // 入队列
    public boolean enqueue(Integer data) {
        stack.push(data);
        return true;
    }


    // 出队列
    public Integer dequeue() {
        // 栈没有元素
        if (stack.isEmpty()) {
            return null;
        }
        // 入临时栈
        while (!stack.isEmpty()){
            tmpStack.push(stack.pop());
        }

        // 出栈取元素
        Integer data = tmpStack.pop();

        // 再恢复
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
        return data;
    }
}
