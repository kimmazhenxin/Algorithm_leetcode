package com.algorithm.recursion;

import com.algorithm.linkedlist.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例:
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 解题思路:
 * 1. 递归,假设已经把 head.next链表反转打印了,那么只需要在此基础上加上 head节点的数据即可
 *
 * @Author: kim
 * @Description: 剑指 Offer 06. 从尾到头打印链表
 * @Date: 10:13 2021/7/20
 * @Version: 1.0
 */
public class ReverseLinkedListPrint_Offer06 {


    public int[] reversePrint(ListNode head) {
        // 存储最后的结果
        List<Integer> list = new ArrayList<>();
        reverseTravel(head, list);

        // 数组返回结果
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // 递归函数
    public void reverseTravel(ListNode head, List<Integer> reslut) {
        // 终止条件
        if (null == head) {
            return;
        }
        // 递推公式,相当于先反转打印 head.next链表
        reverseTravel(head.nextNode, reslut);
        // 将头结点添加到最后(后置逻辑)
        reslut.add(head.data);
    }

    public static void main(String[] args) {
        ReverseLinkedListPrint_Offer06 p = new ReverseLinkedListPrint_Offer06();

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

        int[] result = p.reversePrint(n1);
        for (int k : result) {
            System.out.println(k);
        }
    }

}
