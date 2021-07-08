package com.algorithm.queue;

/**
 * 基于单链表实现队列
 * @Author: kim
 * @Description:
 * @Date: 15:29 2021/7/8
 * @Version: 1.0
 */
public class LinkedListQueue {

    public class Node {
        public String data;

        public Node next;

        public Node() {

        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // 头指针,指向链表的第一个节点
    private Node head;

    // 尾指针,这里尾指针指向的是链表的最后一个节点
    private Node tail;


    // 入队
    public boolean enqueue(String item) {
        Node node = new Node(item, null);
        // 特殊情况的空链表
        if (null == tail) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        return true;
    }


    // 出队
    public String dequeue() {
        // 链表为空
        if (head == null) {
            return null;
        }

        String item = head.data;
        head = head.next;
        // 注意这里的条件,当只有一个节点时需要考虑出队后的 tail指针指向
        if (head == null) {
            tail = null;
        }
        return item;
    }
}
