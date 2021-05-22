package com.algorithm.string;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：
 * 假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 *
 * 解题思路:
 *
 *
 *
 * @Author: kim
 * @Description: 把字符串转换成整数
 * @Date: 2021/5/22 20:32
 * @Version: 1.0
 */
public class StrToInt_Offer67 {

	public static void main(String[] array) {
		String s = "-4193 with words";
		String s1 = "a4193 with words";
		String s2 = "-91283472332";
		System.out.println(strToInt(s));
		System.out.println(strToInt(s1));
		System.out.println(strToInt(s2));
	}


	public static int strToInt(String str) {
		char[] chars = str.trim().toCharArray();
		if (chars.length == 0) {
			return 0;
		}
		// 存储字符串转换后的数字值
		int res = 0;
		// 边界调节的判断 2147483647/10 = 214748364
		int bndry = Integer.MAX_VALUE / 10;

		// 假设数组的0号位是符号位,也就是'+'、'-'
		int i = 1;
		// 符号位标志,默认设为正
		int sign = 1;

		// 表明首个字母的符号位是负
		if (chars[0] == '-') {
			sign = -1;
		} else if (chars[0] != '+') {
			//第一位是无符号,那么从位置0开始遍历数组
			i = 0;
		}

		for (int j = i; j < chars.length; j++) {
			// 除符号位以外的首字母必须是数字
			if (chars[j] < '0' || chars[j] > '9') {break;}
			// 注意这里的边界条件两种情况:
			// 1: 大于214748364
			// 2: 等于214748364且后续末位数字大于7
			if (res > bndry || res == bndry && chars[j] > '7') {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + (chars[j] - '0');
		}
		return sign * res;
	}
}
