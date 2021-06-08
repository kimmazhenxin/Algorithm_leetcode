package com.algorithm.linkedlist;

/**
 * leetcode 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 解题思路:
 * 1. 先找到中间节点,从中间节点反转链表,两个链表进行比较
 *
 *
 *
 * @Author: kim
 * @Description: 234. 回文链表
 * @Date: 2021/6/5 22:45
 * @Version: 1.0
 */
public class IsPalindrome_234 {


	public static void main(String[] args) {
		ListNode n1 = new ListNode(null,1);
		ListNode n2= new ListNode(null,2);
		ListNode n3 = new ListNode(null,3);
		ListNode n4 = new ListNode(null,3);
		ListNode n5 = new ListNode(null,2);
		ListNode n6 = new ListNode(null,1);
		ListNode n7 = new ListNode(null,6);

		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		n4.setNextNode(n5);
		n5.setNextNode(n6);
		n6.setNextNode(n7);
		System.out.println(isPalindrome(n1));

	}

	// 回文链表
	public static boolean isPalindrome(ListNode head) {
		// 1. 先找到中间节点
		ListNode midNode = findMidNode(head);

		// 2.从中间节点的右侧下一个节点反转链表
		ListNode rightHalfHead = reverseList(midNode.nextNode);

		ListNode p = head;
		ListNode q = rightHalfHead;

		// 3.遍历比较,这里注意结束条件,即右边链表遍历完即可
		while (q !=null) {
			if (p.data != q.data) {
				return false;
			}
			p = p.nextNode;
			q = q.nextNode;
		}
		return true;
	}

	// 反转链表
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


	// 找到中间节点(注意:这里偶数时返回第一个节点)
	public static ListNode findMidNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.nextNode != null && fast.nextNode.nextNode !=null){
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
		}
		return slow;
	}

}
