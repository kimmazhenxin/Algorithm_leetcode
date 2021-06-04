package com.algorithm.stack;

import java.util.Stack;

/**
 * 从链表头部实现出栈、入栈
 * @Author: kim
 * @Description: 基于单链表实现栈
 * @Date: 21:45 2021/6/4
 * @Version: 1.0
 */
public class LinkedListStack {

    public class ListNode {
        public int data;

        public ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    // 头结点
    private ListNode head;


    /**
     * 入栈
     * @param data
     * @return
     */
    public boolean push(int data) {
        ListNode node = new ListNode(data, null);
        node.next = head;
        head = node;
        return true;
    }

    /**
     * 出栈且删除栈顶元素
     * @return
     */
    public int pop() {
        if (head == null) {
            return -1;
        }

        int value = head.data;
        ListNode tmp = this.head;
        this.head = this.head.next;
        tmp = null;
        return value;
    }


    /**
     * 出栈但不删除栈顶元素
     * @return
     */
    public int peek() {
        if (head == null) {
            return -1;
        }

        int value = head.data;
        return value;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.push("hello");
        // 出栈
        String value = stack.pop();
        // 取出栈首元素但是不删除元素
        String peek = stack.peek();
    }

}
