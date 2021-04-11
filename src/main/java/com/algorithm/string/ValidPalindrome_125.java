package com.algorithm.string;

/**
 * leetcode 125.验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 输入: "race a car"
 * 输出: false
 *
 * @Author: kim
 * @Description: 验证回文串
 * @Date: 2021/4/11 8:53
 * @Version: 1.0
 */
public class ValidPalindrome_125 {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		String s1 = "race a car";
		String s2 = "  ";
		System.out.println(isPalindrome(s));
		System.out.println(isPalindrome(s1));
		System.out.println(isPalindrome(s2));
	}


	// 双指针
	public static boolean isPalindrome(String s) {
		String s1 = s.toLowerCase();
		int left = 0;
		int right = s1.length() - 1;
		while (left < right) {
			// 从左到右找到有效的字母或者数字
			while (left < right && !Character.isLetterOrDigit(s1.charAt(left))) {
				left++;
			}
			// 从右到左找到有效的字母或者数字
			while (left < right && !Character.isLetterOrDigit(s1.charAt(right))) {
				right--;
			}
			// 验证是否相等
			if (left < right) {
				if (s1.charAt(left) != s1.charAt(right)) {
					return false;
				}
				left++;
				right--;
			}
		}
		return true;
	}

	// 验证字符是否为字母或者数字,类似于Character.isLetterOrDigit(char c)方法
	public static boolean isChar(char c) {
		if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9')) {
			return true;
		}
		return false;
	}
}
