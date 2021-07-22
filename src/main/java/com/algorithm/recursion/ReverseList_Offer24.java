package com.algorithm.recursion;

import com.algorithm.linkedlist.ListNode;

/**
 * leetcode 剑指Offer 24. 反转链表
 * 定义一个函数,输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 *
 *
 * @Author: kim
 * @Description: 反转链表
 * @Date: 18:30 2021/7/20
 * @Version: 1.0
 */
public class ReverseList_Offer24 {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 注意点: 这个才是递归退出的条件,也就是只有一个节点(非常重要!!!)
        if (head.nextNode == null) {
            return head;
        }
        // 返回头结点
        ListNode node = reverseList(head.nextNode);
        // 反转后的尾节点就是反转前链表的head.nextNode
        // 尾节点的下一个节点指向反转前的头结点
        head.nextNode.nextNode = head;
        // 头结点的下一个节点设置为Null
        head.nextNode = null;
        return node;
    }



    public static void main(String[] args) {
        ListNode n1 = new ListNode(null,2);
        ListNode n2= new ListNode(null,1);
        ListNode n3 = new ListNode(null,3);
        ListNode n4 = new ListNode(null,5);
        ListNode n5 = new ListNode(null,6);
        ListNode n6 = new ListNode(null,4);
        ListNode n7 = new ListNode(null,7);
        n1.setNextNode(n2);
        n2.setNextNode(n3);
        n3.setNextNode(n4);
        n4.setNextNode(n5);
        n5.setNextNode(n6);
        n6.setNextNode(n7);

        ReverseList_Offer24 reverse = new ReverseList_Offer24();
        ListNode head = reverse.reverseList(n1);
        ListNode.printAll(head);
    }
}
