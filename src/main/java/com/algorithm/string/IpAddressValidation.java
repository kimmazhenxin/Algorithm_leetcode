package com.algorithm.string;

/**
 * (拼多多面试题) 纯编程题
 * 给定一个字符串表示的IP地址,比如 "123.92.2.34",判断其是否合法.合法的IP地址的规则如下:
 * a.除了空格、数字和 .之外,不得包含其他字符
 * b.IP地址由四个数字构成,由 . 分隔,每个 .隔开的数字大小在0~255之间
 * c.数字前后可以有空格,但中间不能有空格.比如 " 123 .92. 2 .34"合法,但是 "12 3.9 2. 2.34"非法
 *
 * 当然,这个问题还可以继续加一些规则.比如每个数字不能有前导0,但是可以为0.
 * 比如 "021.3.02.34"非法, "0.2.0.33"合法
 *
 * 只考虑a.b.c要求,测试用例
 * 1. "123.9.2.0" 合法
 * 2. " 233 . 33. 13 . 33 " 合法
 * 3. " 233. 22 1. 233. 1"	非法
 * 4. " 222. 319. 2. 4" 非法
 * 5. "2ba. 23. 34. 11" 非法
 * 6. "232. 232. 11" 非法
 * 7. "233. . 33.2"非法
 * 8. "" or null   非法
 *
 * @Author: kim
 * @Description:IP地址解析
 * @Date: 2021/4/10 9:11
 * @Version: 1.0
 */
public class IpAddressValidation {

	public static void main(String[] args) {
		System.out.println(check("123.9.2.0"));
		System.out.println(check(" 233 . 33. 13 . 33 "));
		System.out.println(check(" 233. 22 1. 233. 1"));
		System.out.println(check(" 222. 319. 2. 4"));
		System.out.println(check("2ba. 23. 34. 11"));
		System.out.println(check("232. 232. 11"));
		System.out.println(check("233. . 33.2"));

	}


	// 校验ip地址的合法化
	public static boolean check(String ip) {
		if (null == ip) {return false;}
		// 将ip分隔为子段
		String[] ipSegments = ip.split("\\.");
		// 校验是否满足子段个数为4
		if (ipSegments.length != 4) {
			return false;
		}
		// 验证每段是否合法
		for (int i = 0; i < 4; i++) {
			boolean vaild = checkSegment(ipSegments[i]);
			if (!vaild) {return false;}
		}
		return true;
	}

	// 校验ip地址的合法化,没有使用split切割函数
	public static boolean check2(String ip) {
		if (null == ip) {return false;}
		// segment个数
		int count = 0;
		for (int i = 0; i < ip.length(); i++) {
			int j = i;
			// 找到 . 的位置,count++记录segment个数
			while (j < ip.length() && ip.charAt(j) !='.') {
				j++;
			}
			count++;
			String segment = ip.substring(i, j);
			boolean valid = checkSegment(segment);
			if (!valid) {return false;}
			// i从下一个.之后重新判断
			i = j;
		}
		// segment个数大于4说明不满足条件
		if (count > 4) {return false;}
		return true;
	}


	// 校验每段是否合法化
	// "123", " 123 " " 12 3", "288", "2db", "   "
	public static boolean checkSegment(String segment) {
		int n = segment.length();
		int i = 0;
		// 跳过前导空格,例如: " 123"
		while (i < n && segment.charAt(i) == ' ') {
			i++;
		}
		// 如果字符串全是空格
		if (i == n) {return false;}

		// 处理数字(将字符串转化成数字),例如: "123  "
		int digit = 0;
		while (i < n && segment.charAt(i) != ' ') {
			char c = segment.charAt(i);
			// 非数字字符
			if (c < '0' || c > '9') {return false;}
			// 将字符串转化成数字的核心逻辑
			digit = digit*10 + (c-'0');
			// 数字超过255
			if (digit >255) {return false;}
			i++;
		}

		// 处理后置空格,例如: "123 " or "12 3"
		while (i < n) {
			char c = segment.charAt(i);
			// 后面居然又有非空格字符,也就是说数字之间不能有空格
			if (c != ' ') {return false;}
			i++;
		}
		return true;
	}
}
