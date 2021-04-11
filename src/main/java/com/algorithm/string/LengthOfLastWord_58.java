package com.algorithm.string;

/**
 * leetcode 58.最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 输入：s = " "
 * 输出：0
 *
 * @Author: kim
 * @Description: 最后一个单词的长度
 * @Date: 2021/4/11 11:23
 * @Version: 1.0
 */
public class LengthOfLastWord_58 {

	public static void main(String[] args) {
		String s = "I am Hello you World  ";
		String s1 = "   ";
		System.out.println(lengthOfLastWord(s));
		System.out.println(lengthOfLastWord(s1));
		System.out.println(lengthOfLastSecondWord(s));
		System.out.println(lengthOfLastSecondWord(s1));

	}

	// 返回倒数第一个单词长度
	public static int lengthOfLastWord(String s) {
		int i = s.length() - 1;
		int j = 0;
		while (i >= 0 && s.charAt(i) == ' ') {i--;}
		j = i;
		while (i >= 0 && s.charAt(i) != ' ') {i--;}
		return j - i;
	}

	// 返回倒数第二个单词长度
	public static int lengthOfLastSecondWord(String s) {
		int i = s.length() - 1;
		int count = 0;
		int j = 0;
		while (count < 2) {
			while (i >= 0 && s.charAt(i) == ' ') {i--;}
			j = i;
			while (i >= 0 && s.charAt(i) != ' ') {i--;}
			count++;
		}
		return j - i;
	}


}
