package com.algorithm.linkedlist;

import java.util.List;

/**
 * leetcode 369. 给单链表加一
 *
 * 用一个非空单链表来表示一个非负整数，然后将这个整数加一。
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
 *
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 *
 * 解题思路:
 * 1. 反转链表,然后低位加1,再次反转链表即可.
 * 2. 通过举例分析,发现在末位加一的话,只需要把链表最后一个非9节点加1,然后剩余的后续为9的节点全部置为0即可
 *
 *
 * @Author: kim
 * @Description: 369. 给单链表加一
 * @Date: 2021/6/9 23:17
 * @Version: 1.0
 */
public class PlusOne_369 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(null,9);
		ListNode n2= new ListNode(null,9);
		ListNode n3 = new ListNode(null,9);

		n1.setNextNode(n2);
		n2.setNextNode(n3);

		ListNode.printAll(plusOne(n1));
//		ListNode.printAll(plusOne2(n1));
	}

	// 解法1
	public static ListNode plusOne(ListNode head) {
		// 1. 反转链表,低位在前,高位在后
		ListNode newHead = reverseList(head);

		// 2. 加1
		ListNode node = pulus(newHead);
		// 3. 反转链表
		newHead = reverseList(node);
		return newHead;
	}


	// 解法2
	public static ListNode plusOne2(ListNode head) {
		// 添加虚拟头结点
		ListNode newHead = new ListNode(null, 0);
		newHead.nextNode = head;

		// 1.找到链表中最后一个非9的节点
		ListNode lastOne9 = newHead;
		ListNode p = newHead;
		while (p != null) {
			if (p.data != 9) {
				lastOne9 = p;
			}
			p = p.nextNode;
		}

		// 2.将lastOne9即非9节点后的所有9节点设置为0
		p = lastOne9.nextNode;
		while (p != null) {
			p.data = 0;
			p = p.nextNode;
		}
		// 3.将latNon9的值加1
		lastOne9.data +=lastOne9.data + 1;

		// 4.这里要考虑一个特殊情况,原来的链表节点全是999,那么加完以后是1000,这时候返回的就是头结点newHead;否则返回头结点下一个节点
		if (newHead.data == 0) {
			return newHead.nextNode;
		} else {
			return newHead;
		}
	}




	// 反转链表
	public static ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		ListNode p = head;
		// 临时存储p的下一个节点
		ListNode tmp = null;
		while (p != null) {
			tmp = p.nextNode;
			p.nextNode = newHead;
			newHead = p;
			p = tmp;
		}
		return newHead;
	}

	// 低位加1(此时是低位在前)
	public static ListNode pulus(ListNode head) {
		// 申请一个虚拟节点
		ListNode newHead = new ListNode();
		ListNode tail = newHead;

		ListNode p = head;
		// 进位
		int carry = 0;
		// 每位相加和
		int sum = 0;
		int count = 0;
		while (p !=null){
			count++;
			if (count == 1) {
				sum = p.data + 1 + carry;
			} else {
				sum = p.data + carry;
			}
			// 进位
			carry = sum/10;
			// 取余
			p.data = sum%10;

			// 添加到新链表
			tail.nextNode = p;
			tail = p;

			p = p.nextNode;
		}

		// 特殊情况:也就是最后一位又进了位1,这时候要新增节点
		if (carry == 1) {
			tail.nextNode = new ListNode(null, 1);
			tail = tail.nextNode;
		}
		return newHead.nextNode;
	}

}
