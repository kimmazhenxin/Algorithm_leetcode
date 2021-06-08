package com.algorithm.linkedlist;

import java.util.Scanner;

/**
 * 基于单链表实现LRU算法
 *
 * 思路:
 *  维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 *   1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 *   2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 *    如果此时缓存未满，则将此结点直接插入到链表的头部；
 *    如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 *
 * @Author: kim
 * @Description: 基于单链表实现LRU算法
 * @Date: 8:59 2021/6/3
 * @Version: 1.0
 */
public class LRUBaseLinkedList<T> {
    /**
     * 链表的默认容量
     */
    private final static Integer DEAFULT_CAPACITY = 10;

    /**
     * 链表的头结点,这里引入一个虚拟节点,不存储任何的数据
     */
    private Node<T> head;

    /**
     * 链表的有效长度
     */

    private Integer length;

    /**
     * 链表的容量
     */
    private Integer capacity;


    public LRUBaseLinkedList() {
        this.head = new Node<>();
        this.length = 0;
        this.capacity = DEAFULT_CAPACITY;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * 添加数据
     * @param data
     */
    public void add(T data) {
        // 先找到前驱结点
        Node preNode = findPreNode(data);

        // 没有该节点,那么插入到头结点,否则先删除该节点,然后插入到头结点
        if (null == preNode) {
            if (length >= this.capacity) {
                // 删除尾节点
                deleteNodeEnd();
            }
            // 插入头结点
            insertElementAtBegin(data);
        } else {
            // 删除节点的下一个节点
            deleteNodeNext(preNode);

            // 插入头结点
            insertElementAtBegin(data);
        }
    }

    /**
     * 查找节点的前驱节点
     * @param data
     * @return
     */
    public Node findPreNode(T data) {
        Node p = head;
        while (p.getNext() != null) {
            if (data.equals(p.getNext().getElement())) {
                return p;
            }
            p = p.getNext();
        }
        return null;
    }

    /**
     * 删除节点的下一个节点
     * @param node
     */
    public void deleteNodeNext(Node node) {
        Node tmp = node.getNext();
        node.setNext(tmp.getNext());
        // 链表长度减1
        length--;
        tmp = null;
    }

    /**
     * 删除尾节点
     */
    public void deleteNodeEnd() {
        Node p = head;
        // 空链表直接返回
        if (p.getNext() == null) {
            return;
        }

        // 找到倒数第二个节点
        while (p.getNext().getNext() != null) {
            p = p.getNext();
        }
        // 注意这里把之前的尾节点置NULL
        Node tmp = p.getNext();
        tmp = null;

        // 设置尾节点,链表长度减1
        p.setNext(null);
        length--;
    }


    /**
     * 插入头结点
     * @param data
     */
    public void insertElementAtBegin(T data){
        Node next = head.getNext();

        Node<T> node = new Node<>(data);

        node.setNext(next);

        head.setNext(node);

        // 链表长度加1
        length++;
    }

    /**
     * 遍历输出元素
     */
    public void printAll() {
        Node<T> node = head.getNext();

        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }



    public class Node<T> {

        private T element;

        private Node next;

        public Node(){
            this.next = null;
        }

        public Node(T element){
            this.element = element;
        }

        public Node(T element, Node next){
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }


    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> lru = new LRUBaseLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lru.add(scanner.nextInt());
            lru.printAll();
        }
    }
}
