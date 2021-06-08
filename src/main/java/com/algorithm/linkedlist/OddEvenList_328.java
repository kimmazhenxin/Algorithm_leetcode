package com.algorithm.linkedlist;

/**
 * leetcode 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推
 *
 * 解题思路:
 *  1. 构建两个新链表,遍历原链表,将按照位置的奇偶数分别插入到两个新链表的尾部
 *  2. 将奇链表尾节点指向偶链表的头结点即可
 *
 *
 * @Author: kim
 * @Description: 328. 奇偶链表
 * @Date: 21:11 2021/6/8
 * @Version: 1.0
 */
public class OddEvenList_328 {

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
        ListNode.printAll(oddEvenList(n1));
    }

    //
    public static ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode p = head;
        // 奇链表
        ListNode newHead1 = new ListNode();
        ListNode tail1 = newHead1;
        // 偶链表
        ListNode newHead2 = new ListNode();
        ListNode tail2 = newHead2;

        int k = 0;
        while (p != null) {
            k++;
            // 临时存储p的下一个节点,因为后面会修改p.next = null;
            ListNode tmp = p.nextNode;
            // 存入奇链表
            if (k%2 == 1) {
                tail1.nextNode = p;
                tail1 = p;
            } else {// 存入偶链表
                tail2.nextNode = p;
                tail2 = p;
            }
            // 这里p已经插入到尾节点了,所以设置它的nextNode为null.
            p.nextNode = null;
            // 继续遍历链表
            p = tmp;
        }

        // 将偶数链表插入到奇数链表的尾部
        tail1.nextNode = newHead2.nextNode;
        // 修改尾节点
        tail1 = tail2;

        return newHead1.nextNode;
    }




}
