package com.algorithm.linkedlist;

import static com.algorithm.linkedlist.ListNode.printAll;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * 解题思路:
 *  双指针,一个个遍历两个链表进行比较
 *
 *
 *
 * @Author: kim
 * @Description: 剑指 Offer 25. 合并两个排序的链表
 * @Date: 2021/6/5 19:46
 * @Version: 1.0
 */
public class MergeTwoLists_Offer25 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(null,1);
		ListNode n2= new ListNode(null,2);
		ListNode n3 = new ListNode(null,4);
		ListNode n4 = new ListNode(null,5);

		ListNode n5 = new ListNode(null,1);
		ListNode n6 = new ListNode(null,3);
		ListNode n7 = new ListNode(null,4);

		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);

		n5.setNextNode(n6);
		n6.setNextNode(n7);


		printAll(n1);
		printAll(n5);
		printAll(mergerTwoList(n1, n5));

	}


	public static ListNode mergerTwoList(ListNode l1, ListNode l2){
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		// 构建一个虚拟的头结点(什么也不存储,但是这里很巧妙)
		ListNode newHead = new ListNode();
		// 尾指针,方便插入尾部元素
		ListNode tail = newHead;

		// 分别遍历两个链表的指针
		ListNode p1 = l1;
		ListNode p2 = l2;

		// 注意循环遍历结束的条件
		while (p1 != null && p2 !=null) {
			if (p1.data <= p2.data) {
				tail.setNextNode(p1);
				// 修改tail指针
				tail = p1;
				p1 = p1.nextNode;
			} else {
				tail.setNextNode(p2);
				tail = p2;
				p2 = p2.nextNode;
			}
		}

		// 如果p2还没处理完,就把剩下的直接接到tail后面去
		if (p2 != null) {
			tail.nextNode= p2;
		}

		// 如果p1还没处理完,就把剩下的直接接到tail后面去
		if (p1 != null) {
			tail.nextNode = p1;
		}

		return newHead.nextNode;
	}
}
