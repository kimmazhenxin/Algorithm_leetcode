package com.algorithm.string;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * @Author: kim
 * @Description: 替换空格
 * @Date: 15:22 2021/4/14
 * @Version: 1.0
 */
public class ReplaceSpace_Offer05 {

    public static void main(String[] args) {
        String s = "We are  happy.";
        System.out.println(replaceSpace(s));

    }


    public static String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
