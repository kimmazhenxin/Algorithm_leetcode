package com.algorithm.string;

/**
 * leetcode 9.回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 输入：x = 121
 * 输出：true
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @Author: kim
 * @Description: 回文数
 * @Date: 2021/4/11 10:26
 * @Version: 1.0
 */
public class PalindromeNumber_9 {

	public static void main(String[] args) {
		int a = 12321;
		int b = 1221;
		int c = 12551;
		System.out.println(isPalindrome(a));
		System.out.println(isPalindrome(b));
		System.out.println(isPalindrome(c));
		System.out.println(isPalindrome2(a));
		System.out.println(isPalindrome2(b));
		System.out.println(isPalindrome2(c));

	}

	// 采用反转一半数字比较前后一半是否相同的方法(时间复杂度O(logn))
	public static boolean isPalindrome(int x) {
		// 先考虑特殊情况:
		// 负数不可能是回文数
		if (x < 0 ) {return false;}
		// 个位数为0的数字不可能是回文数(0除外)
		if (x % 10 ==0 && x != 0) {return false;}

		// 反转,等到反转数字大于x之后,说明已经反转到一半了
		int revertedNumber = 0;
		while (x > revertedNumber) {
			revertedNumber = revertedNumber*10 + (x % 10);
			x = x / 10;
		}
		// x为偶数
		if (x == revertedNumber) {
			return true;
		}
		// x为奇数,此时上面的反转一半会多一位,需要去除个位数再比较
		if (x == (revertedNumber / 10)) {
			return true;
		}
		return false;
	}

	// 转换成字符串比较字符串是否是回文串(空间复杂度是O(n))
	public static boolean isPalindrome2(int x) {
		// 先考虑特殊情况:
		// 负数不可能是回文数
		if (x < 0 ) {return false;}
		// 个位数为0的数字不可能是回文数(0除外)
		if (x % 10 ==0 && x != 0) {return false;}
		// 数字转字符串验证一个字符串是否是回文串
		String s = String.valueOf(x);
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
