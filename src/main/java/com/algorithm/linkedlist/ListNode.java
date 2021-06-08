package com.algorithm.linkedlist;

/**
 * @Author: kim
 * @Description: 链表节点
 * @Date: 11:29 2021/6/1
 * @Version: 1.0
 */
public class ListNode {
        public ListNode nextNode;

        public int data;

        public ListNode() {
        }

        public ListNode(int data) {
            this.data = data;
            this.nextNode = null;
        }

        public ListNode(ListNode nextNode, int data) {
            this.nextNode = nextNode;
            this.data = data;
        }

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }


        // 遍历输出链表元素
        public static void printAll(ListNode head) {
            ListNode p = head;
            if (null == head) {
                return;
            }
            while (p != null) {
                System.out.print(p.getData() + " ");
                p = p.nextNode;
            }
            System.out.println();
        }


    @Override
    public String toString() {
        return "ListNode{" +
                "nextNode=" + nextNode +
                ", data=" + data +
                '}';
    }
}
