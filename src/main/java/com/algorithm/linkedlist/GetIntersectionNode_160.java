package com.algorithm.linkedlist;

/**
 * leetcode 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 题目解析:
 * 两个链表相交,指得是链表的节点是同一个节点(节点地址相同,并不是说节点中的data属性值相等)
 *
 * 解题思路:
 * 1. 假设headA的长度是lA,headB的长度是lB. 两个链表相交,在相交节点之前,链表的个数必然相差lA-LB,也就是说相交链表一定是在后面
 * 2. 遍历两个链表,得出长度lA,lB。如果lA > lB,那么先让指针pA遍历链表先走lA-LB步,反之亦然
 * 3. 再开始指针pB遍历第二个链表,同时遍历两个链表,当pA==pB时即满足。
 *
 * @Author: kim
 * @Description: 160. 相交链表
 * @Date: 2021/6/9 23:09
 * @Version: 1.0
 */
public class GetIntersectionNode_160 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(null,2);
		ListNode n2= new ListNode(null,1);
		ListNode n3 = new ListNode(null,3);
		ListNode n4 = new ListNode(null,5);
		ListNode n5 = new ListNode(null,6);
		ListNode n6 = new ListNode(null,4);
		ListNode n7 = new ListNode(null,7);

		ListNode n8 = new ListNode(null,8);
		ListNode n9 = new ListNode(null,1);

		// 链表1
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		n4.setNextNode(n5);
		n5.setNextNode(n6);
		n6.setNextNode(n7);

		// 链表2
		n8.setNextNode(n9);
		n9.setNextNode(n5);

		// 结果应该是节点n5
		System.out.println(getIntersectionNode(n1, n8).data);
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// 1.遍历A链表求长度
		ListNode pA = headA;
		int lengthA = 0;
		while (pA != null) {
			lengthA++;
			pA = pA.nextNode;
		}

		// 2.遍历B链表求长度
		ListNode pB = headB;
		int lengthB = 0;
		while (pB != null) {
			lengthB++;
			pB = pB.nextNode;
		}

		// 准备遍历链表
		pA = headA;
		pB = headB;

		// 3.判断那个链表长度大
		if (lengthA >= lengthB) {
			// 遍历A链表让pA先走 lengthA-lengthB步
			int k = 0;
			while (k < lengthA-lengthB){
				k++;
				pA = pA.nextNode;
			}
		} else {
			// 遍历A链表让pA先走 lengthA-lengthB步
			int k = 0;
			while (k < lengthB-lengthA){
				k++;
				pB = pB.nextNode;
			}
		}

		// 4.继续遍历两个链表,比较是否pA==pB即可
		while (pA != null && pB != null && pA != pB) {
			pA = pA.nextNode;
			pB = pB.nextNode;
		}

		// 只要有一个遍历完,那肯定就没有相交节点
		if (pA == null || pB == null) {
			return null;
		} else {
			return pA;
		}
	}
}
