package com.algorithm.string;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 *
 * 限制：
 * 1 <= k < s.length <= 10000
 *
 * 解题思路:
 *  遍历字符串
 *
 * @Author: kim
 * @Description: 左旋转字符串
 * @Date: 11:12 2021/5/14
 * @Version: 1.0
 */
public class ReverseLeftWords_Offer58II {

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverseLeftWords(str, 2));
    }

    public static String reverseLeftWords(String str, int n) {
        // 方式1: str.substring(n) + str.substring(0, n);

        // 方式2: 遍历
        StringBuilder word = new StringBuilder();
        for (int i = n; i < n + str.length(); i++) {
            // 取余非常巧妙
            word.append(str.charAt(i % str.length()));
        }
        return word.toString();
    }
}
