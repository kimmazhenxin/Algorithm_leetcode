package com.algorithm.linkedlist;

/**
 * leetcode 876.链表的中间结点
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * 解题思路:
 *  1.
 *
 *
 * @Author: kim
 * @Description: 链表的中间结点
 * @Date: 10:37 2021/6/1
 * @Version: 1.0
 */
public class MiddleNode_876 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(null,1);
        ListNode n2= new ListNode(null,2);
        ListNode n3 = new ListNode(null,3);
        ListNode n4 = new ListNode(null,4);
        ListNode n5 = new ListNode(null,5);
        ListNode n6 = new ListNode(null,6);

        n1.setNextNode(n2);
        n2.setNextNode(n3);
        n3.setNextNode(n4);
        n4.setNextNode(n5);
        n5.setNextNode(n6);

        System.out.println(middleNode(n1).data);
    }


    public static ListNode middleNode(ListNode head) {

        ListNode p = head;
        // 链表节点个数
        int k = 0;
        while (p != null) {
            k++;
            p = p.nextNode;
        }

        p = head;
        int m = 0;
        // 中间节点位置,从1开始
        int i = k/2+1;
        while (p != null) {
            m++;
            if (m == i) {
                return p;
            }
            p = p.nextNode;
        }
        return null;
    }
}



