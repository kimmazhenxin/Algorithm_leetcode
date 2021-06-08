package com.algorithm.linkedlist;

/**
 * leetcode 2. 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 解题思路:
 *
 *
 *
 * @Author: kim
 * @Description: 2. 两数相加
 * @Date: 2021/6/5 18:39
 * @Version: 1.0
 */
public class AddTwoNumbers_2 {


	public static void main(String[] args) {
		ListNode n1 = new ListNode(null,3);
		ListNode n2= new ListNode(null,9);
		ListNode n3 = new ListNode(null,9);
		ListNode n4 = new ListNode(null,9);

		ListNode n5 = new ListNode(null,8);
		ListNode n6 = new ListNode(null,1);

		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);

		n5.setNextNode(n6);

		// 输出
		ListNode.printAll(addTwoNumbers(n1, n5));
	}


	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		// 定义一个虚拟节点
		ListNode newHead = new ListNode();
		// 定义尾节点,方便插入链表尾部
		ListNode tail = newHead;
		// 进位
		int carry = 0;

		// 循环结束条件,两个链表都遍历到尾部才会退出循环
		while (p1 != null || p2 != null) {
			int sum = 0;
			if (p1 != null){
				sum += p1.data;
				p1 = p1.nextNode;
			}
			if (p2 != null){
				sum += p2.data;
				p2 = p2.nextNode;
			}
			if (carry != 0) {
				sum += carry;
			}
			// 根据对应位相加的结果构建新的节点
			ListNode newNode = new ListNode(sum%10);
			// 该次相加的进位
			carry = sum/10;
			// 插入链表尾部
			tail.nextNode = newNode;
			// 更改tail指针
			tail = tail.nextNode;
		}

		// 注意特殊情况,就是所有遍历完了以后,可能会产生新的一位进位1,比如 9993 + 18 = 10011,这里就新产生了一个进位1
		if (carry !=0) {
			ListNode tailNode = new ListNode(carry);
			tail.nextNode = tailNode;
			tail = tail.nextNode;
		}

		// 注意这里的返回值,因为引入了虚拟节点
		return newHead.nextNode;
	}
}
