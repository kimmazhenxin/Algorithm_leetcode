package com.algorithm.linkedlist;

/**
 * leetcode 141. 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 示例:
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 *
 * 解题思路:
 * 1.(双指针),指定快慢指针fast、slow,fast走2步,slow走1步。如果链表是有环的,那么最终fast和slow会进入环,而且最终slow == fast,即slow肯定追上fast
 *
 *
 * @Author: kim
 * @Description: 141. 环形链表
 * @Date: 2021/6/9 23:11
 * @Version: 1.0
 */
public class HasCycle_141 {

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
		// 尾节点指向n4
		n7.setNextNode(n4);


		System.out.println(hasCycle(n1));
	}


	public static boolean hasCycle(ListNode head) {
		ListNode slow = head;
		// 这里是为了防止刚开始的时候fast == slow 推出循环,所以设置为下一个节点,效果一样的
		ListNode fast = head.nextNode;

		// 注意循环结束条件
		// fast == null 在链表个数为偶数时遍历结束条件
		// fast.nextNode == null 在链表个数为奇数时遍历结束条件
		while (fast != null && fast.nextNode != null && slow != fast) {
			fast = fast.nextNode.nextNode;
			slow = slow.nextNode;
		}
		// 这时候说明是有环的
		if (slow == fast) {
			return true;
		}
		return false;
	}
}
