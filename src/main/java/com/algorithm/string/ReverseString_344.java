package com.algorithm.string;

/**
 * leetcode 344.反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例:
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 解题思路:
 *  双指针解法
 *
 * @Author: kim
 * @Description: 反转字符串
 * @Date: 2021/4/10 10:24
 * @Version: 1.0
 */
public class ReverseString_344 {

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(reverseString(s.toCharArray()));

	}


	// 双指针法解法:其实就是将str[i] 与 str[n - 1 - i]交换
	// 将 left 指向字符数组首元素，right 指向字符数组尾元素。
	// 当 left < right：
	// 交换 s[left] 和 s[right]；
	// left 指针右移一位，即 left = left + 1；
	// right 指针左移一位，即 right = right - 1。
	// 当 left >= right，反转结束，返回字符数组即可。
	public static String reverseString(char[] str) {
		int n = str.length;
		for (int left = 0, right = n - 1; left < right; left++, right--) {
			char c = str[left];
			str[left] = str[right];
			str[right] = c;
		}
		return String.valueOf(str);
	}
}
