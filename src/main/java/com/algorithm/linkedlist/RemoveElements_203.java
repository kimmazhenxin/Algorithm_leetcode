package com.algorithm.linkedlist;

/**
 * leetcode 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例:
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 解题思路:
 *  遍历节点,找到删除元素的前节点
 *
 *
 * @Author: kim
 * @Description: 203. 移除链表元素
 * @Date: 2021/5/31 21:29
 * @Version: 1.0
 */
public class RemoveElements_203 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(null,1);
		ListNode n2= new ListNode(null,2);
		ListNode n3 = new ListNode(null,6);
		ListNode n4 = new ListNode(null,3);
		ListNode n5 = new ListNode(null,4);
		ListNode n6 = new ListNode(null,5);
		ListNode n7 = new ListNode(null,6);

		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		n4.setNextNode(n5);
		n5.setNextNode(n6);
		n6.setNextNode(n7);

		removeElements(n1, 6);

	}


	public static ListNode removeElements(ListNode head, int val) {
		// 特殊情况处理
		if (null == head) {
			return null;
		}

		// 1.初始值. 指向头结点,目的是找到删除节点的前节点
		ListNode prev = head;
		// 2.遍历结束的条件
		while (prev.nextNode != null) {
			// 3.遍历的核心逻辑
			if (prev.nextNode.data == val) {
				prev.nextNode = prev.nextNode.nextNode;
			} else {
				prev = prev.nextNode;
			}
		}

		// 4.特殊情况处理
		if (head.data == val) {
			head = head.nextNode;
		}
		return head;
	}
}

