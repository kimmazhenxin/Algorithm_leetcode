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
 *
 * @Author: kim
 * @Description: 203. 移除链表元素
 * @Date: 2021/5/31 21:29
 * @Version: 1.0
 */
public class RemoveElements {

	public static void main(String[] args) {

	}


	public static ListNode removeElements(ListNode head, int val) {


		return null;

	}


	public class ListNode {
		private ListNode nextNode;

		private int data;

		public ListNode() {
		}

		public ListNode(ListNode nextNode, int data) {
			this.nextNode = nextNode;
			this.data = data;
		}
	}

}
