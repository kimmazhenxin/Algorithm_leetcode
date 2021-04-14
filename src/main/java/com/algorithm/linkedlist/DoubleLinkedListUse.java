package com.algorithm.linkedlist;

/**
 * @Author: kim
 * @Description: 双向链表的使用
 * @Date: 9:21 2021/4/14
 * @Version: 1.0
 */
public class DoubleLinkedListUse {
    public class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // 记录链表头结点位置(链表一定要定义头节点)
    private Node head = null;

    /**
     * 获取链表的第k个节点(k从0开始)
     * @param k
     * @return
     */
    public Node get(int k) {
        // 空链表
        if (head == null) {
            return null;
        }
        Node p = head;
        int i = 0;
        while (null != p) {
            if (i == k) {
                return p;
            }
            p = p.next;
            i++;
        }
       return null;
    }

    /**
     * 查找链表中的第一个值
     * @param value
     * @return
     */
    public Node find(int value) {
        if (null == head) {
            return null;
        }
        Node p = head;
        while (null != p) {
            if (p.data == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * 往链表头部插入
     * @param value
     */
    public void insertHead(int value) {
        Node newNode = new Node(value, null, null);
        // 空链表情况
        if (null == head) {
            head = newNode;
        } else {
            // 地址交换
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    /**
     * 往链表尾部插入
     * @param value
     */
    public void insertAtTail(int value) {
        Node newNode = new Node(value, null, null);
        Node p = head;
        if (null == head) {
            head = newNode;
        } else {
            // 遍历到尾节点
            while (null != p.next) {
                p = p.next;
            }
            p.next = newNode;
            newNode.prev = p;
        }
    }

    /**
     * 在给定节点之后插入一个新节点
     * @param p
     * @param value
     */
    public void insertAfter(Node p, int value) {
        if (null == p ) {
            return;
        }
        Node newNode = new Node(value, null, null);
        p.next.prev = newNode;
        newNode.next = p.next;
        p.next = newNode;
        newNode.prev = p;
    }

    /**
     * 删除给定节点之后的节点
     * @param p
     */
    public void deleteNextNode(Node p) {
        // p为空节点或者尾节点
        if (null == p || p.next == null) {
            return;
        }
        p.next = p.next.next;
        p.next.next.prev = p;
    }

    /**
     * 删除给定的节点
     * @param p
     */
    public void deleteThisNode(Node p) {
        if (null == p || head == null) {
            return;
        }
        // 删除头节点
        if (p == head) {
            head = head.next;
            p.next.prev = null;
            return;
        }
        p.prev.next = p.next;
        p.next.prev = p.prev;
    }
}



