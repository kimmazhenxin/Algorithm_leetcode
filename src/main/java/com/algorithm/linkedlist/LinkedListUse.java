package com.algorithm.linkedlist;

/**
 * @Author: kim
 * @Description: 链表的使用
 * @Date: 10:06 2021/4/9
 * @Version: 1.0
 */
public class LinkedListUse {
    //头结点
    private Node head = null;


    /**
     * 获取链表的第k个节点(k从0开始)
     * @param k
     * @return
     */
    public Node get(int k) {

        return null;
    }


    //查找
    public Node find() {

        return null;
    }

    //插入
    public void insert() {

    }


    //删除
    public void delete() {

    }
}


/**
 * 链表的节点
 */
class Node {
    //存储的数据
    public int data;
    //存储下一个节点的引用(地址)
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
