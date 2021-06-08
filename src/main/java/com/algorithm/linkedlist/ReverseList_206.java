package com.algorithm.linkedlist;

/**
 * leetcode 206. 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 解题思路:
 *  1.构建新头结点遍历
 *  2.迭代或者递归
 *
 * @Author: kim
 * @Description: 206. 反转链表
 * @Date: 2021/6/5 22:20
 * @Version: 1.0
 */
public class ReverseList_206 {


	public static void main(String[] args) {
		ListNode n1 = new ListNode(null,1);
		ListNode n2= new ListNode(null,2);
		ListNode n3 = new ListNode(null,4);
		ListNode n4 = new ListNode(null,5);

		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		ListNode.printAll(reverseList(n1));
	}


	public static ListNode reverseList(ListNode head) {
		if (null == head) {
			return null;
		}
		ListNode newHead = null;
		ListNode p = head;
		while (p != null) {
			// 将p的下一个节点临时保存被后续使用
			ListNode tmp = p.nextNode;
			p.nextNode = newHead;
			// 修改头结点
			newHead = p;
			// p重新指向之前链表中的下一个节点
			p = tmp;
		}

		return newHead;
	}
}
