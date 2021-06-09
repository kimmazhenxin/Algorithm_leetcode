package com.algorithm.linkedlist;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 解题思路:
 * 1. 双指针: 先fast指针遍历到第K个节点,然后slow指针从头开始遍历,每次两个指针遍历链表,
 *  当fast指针遍历到最后一个节点的时候,恰好slow指向到倒数第K个节点（这是因为fast和slow两个指针之间始终相差K）
 *
 *
 *
 * @Author: kim
 * @Description: 22. 链表中倒数第k个节点
 * @Date: 18:58 2021/6/9
 * @Version: 1.0
 */
public class GetKthFromEnd_Offer22 {

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


        // 输出
        ListNode.printAll(getKthFromEnd(n1, 2));

    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        ListNode fast = head;
        int count = 0;
        // 1. 先正序遍历链表找到第K个节点
        while (fast != null) {
            count++;
            if (count == k) {
                break;
            }
            fast = fast.nextNode;
        }
        // 防止出现k大于链表长度
        if (fast == null) {
            return null;
        }

        // 2.慢指针从头开始遍历,两者之间恰好相差K
        ListNode slow = head;
        // 注意结束条件: fast指针遍历到最后一个节点
        while (fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = null;
        ListNode p = head;
        ListNode tmp;

        while (p != null) {
            tmp = p.nextNode;
            p.nextNode = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }

}
