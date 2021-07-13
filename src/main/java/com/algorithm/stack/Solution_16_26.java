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
 * 2.
 *      1）数字：直接入栈
 *      2）运算符：
 *         运算符 c > ops栈顶的优先级时，直接入栈（比如 *、/ 大于 +、-）；
 *         运算符 c <= ops栈顶的优先级时，取出 nums栈的两个数字，结合该运算符c进行表达式的计算
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
        String expression1 = " 3/2 ";
        String expression2 = " 3*5 - 6 + 4 *3 - 5 * 2 ";
        System.out.println(solution.calculate(expression1));
        System.out.println(solution.calculate(expression2));
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
            } else if (isDigit(c)) { // 判断字符是否是数字,数字直接入数字栈
                // 这时候需要把数字压栈到nums中,但是注意是要把字符串转为完整的数字
                // 比如: 356 - 23 * 2 + 125 - 3, 需要把完整的365、23等压栈
                // 遍历字符串取完整的整数
                int number = 0;
                while (i < n && isDigit(s.charAt(i))) { // 遇到运算符就退出
                    // 字符串转化成整数
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                // 将上述得到的数字压栈
                nums.push(number);
            } else { // 该字符是运算符,这时候就会比较字符优先级了进而考虑是计算表达式还是说运算符直接入栈
                // 如果c 优先级大于栈顶的优先级,那么直接入栈
                if (ops.isEmpty() || prior(c, ops.peek())) {
                    ops.push(c);
                } else {
                    // 如果c 小于等于栈顶的优先级,那么取出栈顶运算符和数字栈的两个数字进行计算,计算结果压入数字栈,c压入运算符栈
                    // 数字栈出栈
                    while (!ops.isEmpty() && !prior(c, ops.peek())) {
                        Integer number2 = nums.pop();
                        Integer number1 = nums.pop();
                        char op = ops.pop();
                        int result = cal(op, number1, number2);
                        nums.push(result);
                    }
                    // 直到ops为空或者c运算符优先级大于栈顶优先级的时候,把c压栈
                    // 上述计算结果入栈
                    ops.push(c);
                }
                i++;
            }
        }

        // 上述整个表达式遍历结束后,开始取出ops中剩余的运算符进行计算,直到ops为空即表达式计算完成
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
