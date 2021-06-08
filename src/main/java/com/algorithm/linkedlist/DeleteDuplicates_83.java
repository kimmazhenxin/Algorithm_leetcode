package com.algorithm.linkedlist;

import static com.algorithm.linkedlist.ListNode.printAll;

/**
 * leetcode 83. 删除排序链表中的重复元素
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素只出现一次 。返回同样按升序排列的结果链表。
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 解题思路:
 * 1.遍历链表,找到相邻节点的data值比较
 * 2.构建新链表和尾节点
 *
 * @Author: kim
 * @Description: 83. 删除排序链表中的重复元素
 * @Date: 11:27 2021/6/1
 * @Version: 1.0
 */
public class DeleteDuplicates_83 {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(null,1);
        ListNode n2= new ListNode(null,1);
        ListNode n3 = new ListNode(null,2);
        ListNode n4 = new ListNode(null,3);
        ListNode n5 = new ListNode(null,3);
        ListNode n6 = new ListNode(null,5);
        ListNode n7 = new ListNode(null,5);

        n1.setNextNode(n2);
        n2.setNextNode(n3);
        n3.setNextNode(n4);
        n4.setNextNode(n5);
        n5.setNextNode(n6);
        n6.setNextNode(n7);

        printAll(deleteDuplicates(n1));
        printAll(deleteDuplicates2(n1));

    }

    // 1.原地遍历迁移链表节点
    public static ListNode deleteDuplicates(ListNode head) {
        // 空链表或者只有一个节点的链表
        if (null == head || head.nextNode == null) {
            return head;
        }

        ListNode p = head;
        while (p.nextNode != null) {
            if (p.data == p.nextNode.data) {
                p.nextNode = p.nextNode.nextNode;
            } else {
                p = p.nextNode;
            }
        }
        return head;
    }

    // 2. 构建新链表和尾节点
    public static ListNode deleteDuplicates2(ListNode head) {
        if (null == head) {
            return null;
        }
        // 这里引入一个虚拟头结点,存储的数据是不在正常数据范围之内的
        ListNode newHead = new ListNode(null, -111);
        // 尾节点,是为了方便,不需要去遍历链表,方便链表的尾部插入节点(巧妙)
        ListNode tail = newHead;
        ListNode p = head;
        // 注意循环遍历结束的条件
        while (p != null) {
            // 保留它的下一个节点,因为如果p添加到尾节点的话,那么后续会设置p节点的下一个节点为Null,这时候就不对了
            ListNode tmp = p.nextNode;
            // 判断尾节点和当前指向的节点值是否相同,不同就直接添加到尾节点后面
            if (p.data != tail.data) {
                // 尾节点的下一个节点指向新节点
                tail.nextNode = p;
                // 更改尾节点
                tail = p;
                // 因为此时p是新链表的尾节点了,那么它的下一个节点就要设置为Null
                p.nextNode = null;
            }
            // 这里就是将p指向它的下一个节点(p = p.nextNode),只不过因为上述存在设置p.nextNode = null的情况,所以要临时保存一下这个
            p = tmp;
        }
        return newHead.nextNode;
    }
}
