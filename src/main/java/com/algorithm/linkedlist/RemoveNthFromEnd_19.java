package com.algorithm.linkedlist;

/**
 * leetcode 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点(n从1开始)。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 解题思路:
 * 1. 本质就是找到链表的倒数第N+1个节点(参考题Offer22),然后删除它的下一个节点即可
 *
 *
 * @Author: kim
 * @Description: 19. 删除链表的倒数第 N 个结点
 * @Date: 2021/6/9 22:28
 * @Version: 1.0
 */
public class RemoveNthFromEnd_19 {

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
		ListNode.printAll(removeNthFromEnd(n1, 4));
	}

	// 解法1:直接找第N+1个节点
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		// 1. 找到倒数第N+1个节点
		if (null == head) {
			return null;
		}
		// 快指针先走第n+1个节点
		ListNode fast = head;
		int count = 0;
		while (fast != null) {
			count++;
			if (count == n+1) {
				break;
			}
			fast = fast.nextNode;
		}
		// 注意: 考虑两种特殊情况
		// 1. 此时说明n大于链表长度
		if (n > count) {
			return null;
		}
		// 2. 此时说明n等于链表长度,那就相当于删除头结点
		if (n == count) {
			head = head.nextNode;
			return head;
		}

		// 上述情况都没有的话,说明n < count,符合正常范围值
		// 慢指针遍历链表
		ListNode slow = head;
		while (fast.nextNode != null) {
			slow = slow.nextNode;
			fast = fast.nextNode;
		}
		// 此时slow指向的就是倒数第N+1个节点了

		// 2. 删除它的下一个节点
		slow.nextNode = slow.nextNode.nextNode;
		return head;
	}


	// 解法2: 先找到第N个节点,再找它的前一个节点
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		if (null == head) {
			return null;
		}
		// 1.快指针先走第n个节点
		ListNode fast = head;
		int count = 0;
		while (fast != null) {
			count++;
			if (count == n) {
				break;
			}
			fast = fast.nextNode;
		}

		// 不够n个
		if (fast == null) {
			return null;
		}


		// 2. 慢指针遍历链表,找到倒数第N个节点的前驱节点
		ListNode slow = head;
		// slow指针的前一个节点
		ListNode preslow = null;
		while (fast.nextNode != null) {
			fast = fast.nextNode;
			// 这一步非常关键
			preslow = slow;
			slow = slow.nextNode;
		}
		// 说明删除的是头结点,也就是n等于链表的长度
		if (preslow == null) {
			head = head.nextNode;
		} else {
			// 就是正常的范围值
			// 此时pre指向的就是倒数第N+1个节点了
			preslow.nextNode = slow.nextNode;
		}
		return head;
	}
}
