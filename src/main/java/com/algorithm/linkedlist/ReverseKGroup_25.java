package com.algorithm.linkedlist;

/**
 * leetcode 25. K个一组翻转链表
 * 给你一个链表，每 k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 解题思路:
 * 1. (双指针)先找到每段k个链表的头结点、尾节点
 * 2. 反转每一段符合条件的链表,这里注意反转后不仅要返回头结点,也要返回尾节点
 * 3. 将每段反转后的链表链接起来
 *
 * @Author: kim
 * @Description: 25. K 个一组翻转链表
 * @Date: 8:29 2021/6/9
 * @Version: 1.0
 */
public class ReverseKGroup_25 {

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
        ListNode.printAll(reverseKGroup(n1, 3));
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        // 申请一个虚拟头结点
        ListNode newHead = new ListNode();
        ListNode tail = newHead;

        ListNode p = head;
        while (p != null) {
            int count = 0;
            ListNode q = p;

            // 找到k个一组的链表
            while (q != null) {
                count++;
                if (count == k) {
                    break;
                }
                q = q.nextNode;
            }

            // 这个时候说明已经遍历到链表的尾部了,但是又不满足k的整数倍
            if (q == null) {
                tail.nextNode = p;
                return newHead.nextNode;
            } else {
                // 保存尾节点的下一个节点,因为反转时候回修改nextNode
                ListNode tmp = q.nextNode;
                ListNode[] nodes = reverseList(p, q);

                // 将反转链表添加到新链表的尾部
                tail.nextNode = nodes[0];
                tail = nodes[1];

                // 头结点重新复制到尾节点的下一个节点
                p = tmp;
            }
        }
        return newHead.nextNode;
    }

    /**
     * 反转链表
     * @param head  头结点
     * @param tail  尾节点
     * @return 返回头结点和尾节点的数组: 第一个元素是头结点、第二个元素是尾节点
     */
    public static ListNode[] reverseList(ListNode head, ListNode tail) {
        if (null == head) {
            return null;
        }
        ListNode newHead = null;
        ListNode p = head;
        // 循环结束条件
        while (p != tail) {
            ListNode tmp = p.nextNode;
            p.nextNode = newHead;
            newHead = p;
            p = tmp;
        }
        // tail节点更新
        tail.nextNode = newHead;
        newHead = tail;
        return new ListNode[]{tail,head};
    }
}
