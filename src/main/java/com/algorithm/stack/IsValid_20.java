package com.algorithm.stack;

import java.util.Stack;

/**
 * leetcode 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例:
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 输入：s = "([)]"
 * 输出：false
 *
 * 解题思路:
 * 1. 类似于连连消/消消乐问题,
 *  栈中存储的是没有消掉的(左括号)，每次入栈时候比较栈顶元素和入栈元素的值,一旦发现右括号和栈顶元素不能消除,那么肯定是无效括号了
 *  最终的话栈中应该是空的,这样字符串才是有效括号
 *
 *
 * @Author: kim
 * @Description: 20. 有效的括号
 * @Date: 10:11 2021/7/15
 * @Version: 1.0
 */
public class IsValid_20 {

    public static boolean isValid(String s){
        // 构造一个栈
        Stack<Character> stack = new Stack<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 左括号才可以入栈
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else { // 说明是右括号,这时候要取栈顶的元素进行比较,看能否消除
                // 处理下空栈的特殊情况
                if (stack.isEmpty()){
                    return false;
                }
                // 弹出栈顶元素
                char topChar = stack.pop();
                if (topChar != '(' && c == ')') {
                    return false;
                }
                if (topChar != '{' && c == '}') {
                    return false;
                }
                if (topChar != '[' && c == ']') {
                    return false;
                }
            }
        }
        // 最终栈如果是空的,连连消了,那么说明是有效括号
        return stack.isEmpty();
    }



    public static void main(String[] args) {
        String str1 = "()[]{}";
        String str2 = "{[]}";
        String str3 = "([)]";
        System.out.println("str1: " + isValid(str1));
        System.out.println("str2: " + isValid(str2));
        System.out.println("str3: " + isValid(str3));

    }

}
