package com.algorithm.string;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 示例:
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 解题思路:
 *
 *
 * @Author: kim
 * @Description: 翻转单词顺序
 * @Date: 9:08 2021/4/8
 * @Version: 1.0
 */
public class ReverseWords_Offer58I {

    public static void main(String[] args) {
        String str = " the sky  is  blue ";
        System.out.println(reverseWords(str));
        System.out.println(reverseWords2(str));
    }

    // 分隔
    public static String reverseWords(String s) {
        // 删除收尾空格,按照空格分隔字符串,如果单词之间有x个空格,那么按照空格切割,那么单词之间会有x-1个空字符串
        String[] strs = s.trim().split(" ");
        System.out.println(strs.length);
        StringBuilder result = new StringBuilder();
        // 倒序遍历单词列表
        for (int i = strs.length - 1; i >=0 ; i--) {
            // 遇到空单词则跳过
            if ("" .equals(strs[i])) { continue; }
            // 将单词拼接到StringBuilder
            result.append(strs[i] + " ");
        }
        // 转化为字符串,删除尾部空格
        return result.toString().trim();
    }


    // 双指针法
    public static String reverseWords2(String s) {
        String str = s.trim();
        StringBuilder result = new StringBuilder();
        // 从字符串尾部开始遍历
        int i = str.length() - 1;
        int j = i;
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && str.charAt(i) != ' ') {i--;}
            // 截取i到j之间的单词,添加单词和空格
            // 这里注意截取字符串不包含末端,所以得j+1索引
            result.append(str.substring(i+1, j+1) + " ");
            // 跳过单词之间的空格
            while (i >= 0 && str.charAt(i) == ' ') {i--;}
            // j执行下个单词的尾字符
            j = i;
        }
        return result.toString().trim();
    }


}
