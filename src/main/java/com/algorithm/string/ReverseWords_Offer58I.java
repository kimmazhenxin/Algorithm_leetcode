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
 *  1. 先split -> 再反转单词 (空间复杂度O(n))
 *  2. 两次反转 -> 空间复杂度O(1) 原地反转
 *
 *
 * @Author: kim
 * @Description: 翻转单词顺序
 * @Date: 9:08 2021/4/8
 * @Version: 1.0
 */
public class ReverseWords_Offer58I {

    public static void main(String[] args) {
        String str = "  the sky  is   blue  ";
        //System.out.println(reverseWords(str));
        System.out.println(reverseWords2(str));
    }

    /**
     * 重点！！ 原地删除字符串的前置、后置空格,以及内部的多余空格,只保留单词之间一个空格
     * @param str
     * @return 返回新字符串的长度
     */
    public static int trim(char[] str) {
        int i = 0;
        int n = str.length;
        // 新数组的长度
        int k = 0;
        // 先找到前面第一个非空格字符
        while (i < n && str[i] == ' ') {
            i++;
        }
        while (i < n) {
            // 关键点: 删除内部多余的空格和末尾的空格
            if (str[i] == ' ') {
                if (i+1 < n && str[i+1] != ' ') {
                    str[k] = ' ';
                    k++;
                }
            } else {
                // 非空格就正常赋值,将其向前移
                str[k] = str[i];
                k++;
            }
            i++;
        }
        return k;
    }

    /**
     * 重点,要熟练！！返回[p,r]之间的字符串，注意这⾥是闭区间，当然，前开后闭区间也可以，但代码中i<=mid应该改为i<mid
     * @param str
     * @param p 前索引
     * @param r 后索引
     */
    public static void reverse(char[] str, int p, int r) {
        int mid = (p + r + 1)/2;
        for (int i = p; i < mid; i++) {
            char tmp = str[i];
            str[i] = str[r-(i-p)];
            str[r-(i-p)] = tmp;
        }
    }


    // 解法1: 分隔
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

    
    // 解法2:两次反转(最佳解法)
    public static String reverseWords2(String s) {
        char[] str = s.toCharArray();
        // 去除字符串中的前后、中间多余空格,只保留中间的一个
        int n = trim(str);
        // 说明该字符全是空格
        if (0 == n) {return "";}
        // 整个字符串先反转一次
        reverse(str, 0, n-1);
        int p = 0;
        while (p < n) {
            int r = p;
            // 找到单词的前后位置
            while (r < n && str[r] != ' ') {
                r++;
            }
            // 反转每个单词
            reverse(str, p, r-1);
            // 下个单词的起始位置
            p = r+1;
        }
        return String.valueOf(str, 0, n);
    }



    // 双指针法
    public static String reverseWords3(String s) {
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
