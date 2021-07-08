package com.algorithm.stack;

import java.util.Stack;

/**
 * 删除连续重复字符(腾讯实习)
 * 字符串删除掉连续的3个重复的字符。比如 "abbbc",返回 "ac"; "abbbaac",返回 "c"; "abbaaabcc",返回 "acc"
 *
 * 解题思路:
 * . 该题目本质就是消消乐类型题,删除连续的多少个元素
 * . 使用栈来实现,定义一个类型元素来存储字符和字符的个数,每次压栈时候比较该字符是否达到3个,达到就将该元素出栈;否则添加该元素或者修改该元素的个数
 *
 * @Author: kim
 * @Description: 删除连续重复字符
 * @Date: 2021/7/8 22:16
 * @Version: 1.0
 */
public class RemoveThreeDuplicates {

	public static void main(String[] args) {
		RemoveThreeDuplicates removeThreeDuplicates = new RemoveThreeDuplicates();
		String s1 = "abbbc";
		String s2 = "abbbaac";
		String s3 = "abbaaabcc";
		System.out.println(removeThreeDuplicates.remove(s1));
		System.out.println(removeThreeDuplicates.remove(s2));
		System.out.println(removeThreeDuplicates.remove(s3));
	}


	public String remove(String str) {
		Stack<CharWithCout> stack = new Stack<>();
		int n = str.length();
		// 遍历字符串
		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			// 栈为空,直接入栈
			if (stack.isEmpty()) {
				stack.push(new CharWithCout(1, c));
				continue;
			}

			// 栈不为空,那栈顶的字符和c比较,如果不相同就直接入栈
			CharWithCout topChar = stack.peek();
			if (topChar.c != c) {
				stack.push(new CharWithCout(1, c));
			} else {
				// 相同就增加原栈顶该字符的个数,同时判断是否达到3的连消,达到3的话就出栈该元素
				if (topChar.count == 2) {
					stack.pop();
					continue;
				}
				// 没达到就增加该字符个数
				topChar.count++;
			}
		}

		// 下面的逻辑是将栈中的字符数据取出来即可,两种方式
		// 1. 用栈将数据颠倒一下
		// 2. 先把栈的数据放到数组中,再反转数组
		Stack<Character> tmpStack = new Stack<>();
		while (!stack.isEmpty()) {
			tmpStack.push(stack.pop().c);
		}
		StringBuilder reslut = new StringBuilder();
		while (!tmpStack.isEmpty()) {
			reslut.append(tmpStack.pop());
		}
		return reslut.toString();
	}


	// 定义一个类,存储元素的值和元素出现的次数
	public class CharWithCout {
		// 字符出现的个数
		public int count;
		// 字符
		public char c;

		public CharWithCout(int count, char c) {
			this.count = count;
			this.c = c;
		}
	}
}
