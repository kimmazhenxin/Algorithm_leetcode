package com.algorithm.stack;

import java.util.Stack;

/**
 * leetcode 面试题 16.26. 计算器
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。
 *
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 解题思路:
 * 1. 申请两个栈,从头遍历表达公式,一个栈存储数字,一个栈存储运算符
 *
 *
 * @Author: kim
 * @Description: 计算器
 * @Date: 9:04 2021/7/9
 * @Version: 1.0
 */
public class Solution_16_26 {

    public static void main(String[] args) {
        Solution_16_26 solution = new Solution_16_26();
        String expression = " 3/2 ";
        System.out.println(solution.calculate(expression));

    }



    public int calculate(String s) {
        // 存储数字
        Stack<Integer> nums = new Stack<>();
        // 存储运算符
        Stack<Character> ops = new Stack<>();

        int i = 0;
        int n = s.length();

        // 遍历表达式
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') { // 过滤空格
                i++;
            } else if (isDigit(c)) { // 判断字符是否是数字
                // 这时候需要把数字压栈到nums中,但是注意是要把字符串转为完整的数字
                // 比如: 356 - 23 * 2 + 125 - 3, 需要把完整的365、23等压栈
                // 遍历字符串取完整的整数
                int number = 0;
                while (i < n && isDigit(s.charAt(i))) { // 遇到运算符就退出
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                // 将上述得到的数字压栈
                nums.push(number);
            } else { // 该字符是运算符,这时候就会比较字符优先级了
                // 如果c 优先级大于栈顶的优先级,那么直接入栈
                // 如果c 小于等于栈顶的优先级,那么取出栈顶运算符和数字栈的两个数字进行计算,计算结果压入数字栈,c压入运算符栈
                if (ops.isEmpty() || prior(c, ops.peek())) {
                    ops.push(c);
                } else {
                    // 数字栈出栈
                    while (!ops.isEmpty() && !prior(c, ops.peek())) {
                        Integer number2 = nums.pop();
                        Integer number1 = nums.pop();
                        int result = cal(c, number1, number2);
                        nums.push(result);
                    }
                    // 上述计算结果入栈
                    ops.push(c);
                }
                i++;
            }
        }

        // 遍历结束后的特殊情况
        while (!ops.isEmpty()) {
            Integer number2 = nums.pop();
            Integer number1 = nums.pop();
            char op = ops.pop();
            int result = cal(op, number1, number2);
            nums.push(result);
        }
        return nums.pop();
    }

    // 表达式计算
    public int cal(char op, int number1, int number2) {
        switch (op) {
            case '+': return number1 + number2;
            case '-': return number1 - number2;
            case '*': return number1 * number2;
            case '/': return number1 / number2;
            case '÷': return number1 / number2;
            default:
                return -1;
        }
    }

    /**
     * 判断运算符 op1的优先级是否大于等于op2
     * *、/ 大于 +、-
     * @param op1 运算符1
     * @param op2 运算符2
     * @return
     */
    public boolean prior(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return true;
        }
        return false;
    }

    // 判断字符是不是数字
    public boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }
}
