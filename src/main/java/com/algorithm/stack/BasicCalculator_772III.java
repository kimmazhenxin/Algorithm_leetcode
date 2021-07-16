package com.algorithm.stack;

import java.util.Stack;

/**
 * leetcode 772. 基本计算器 III(包括括号)
 * 实现一个基本的计算器来计算简单的表达式字符串。
 * 表达式字符串只包含非负整数,运算符 +、-、*、/ ,左括号 ( 和右括号 )。整数除法需要向下截断。
 * 你可以假定给定的表达式总是有效的。所有的中间结果的范围为 [-2^31, 2^31 - 1]。
 *
 * 示例:
 * 输入: s = "6-4/2"
 * 输出: 4
 *
 * 输入: s = "2*(5+5*2)/3+(6/2+8)"
 * 输出: 21
 *
 * 解题思路:(参考16_26题目)
 * 1. 申请两个栈,从头遍历表达公式,一个栈存储数字,一个栈存储运算符
 * 2.
 *      1）数字：直接入栈
 *      2）运算符：
 *         栈为空 或者 运算符 c > ops栈顶的优先级时，直接入栈（比如 *、/ 大于 +、-）;
 *         运算符 c <= ops栈顶的优先级时，取出 nums栈的两个数字，结合该运算符c进行表达式的计算;
 *     3) 如果是 '(',直接入栈
 *     4) 如果是 ')',出栈计算,直到碰到 '('为止
 *
 *
 * @Author: kim
 * @Description: 772. 基本计算器 III
 * @Date: 10:15 2021/7/15
 * @Version: 1.0
 */
public class BasicCalculator_772III {

    // 表达式计算
    public int calculate(String s) {
        // 存数据
        Stack<Integer> data = new Stack<>();
        // 存运算符和括号'('
        Stack<Character> ops = new Stack<>();

        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') { // 去掉空格特殊情况
                i++;
            } else if (isDigit(c)) {    // 数字直接入数字栈
                // 这时候需要把数字压栈到nums中,但是注意是要把字符串转为完整的数字
                // 比如: 356 - 23 * 2 + 125 - 3, 需要把完整的365、23等压栈
                // 遍历字符串取完整的整数
                int number = 0;
                while (i < n && isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                data.push(number);
            } else if (c == '(') {  // 左括号直接入运算符栈
                ops.push(c);
                i++;
            } else if (c == ')') { // 右括号要计算表达式直到遇到左括号 '('为止
                while (!ops.isEmpty() && ops.peek() != '(') {
                    fetchAndCal(data, ops);
                }
                ops.pop();  // 弹出左括号 '('
                i++;
            } else { // 其它运算符 +、-、*、/ 情况
                if (ops.isEmpty() || prior(c, ops.peek())) { // 运算符优先级大于栈顶运算符优先级,直接入运算符栈
                    ops.push(c);
                } else {
                    while (!ops.isEmpty() && !prior(c, ops.peek())) {
                        fetchAndCal(data, ops);
                    }
                    // 计算后再将c压栈
                    ops.push(c);
                }
                i++;
            }
        }

        // 上述整个表达式遍历结束后,开始取出ops中剩余的运算符进行计算,直到ops为空即表达式计算完成
        while (!ops.isEmpty()) {
            fetchAndCal(data, ops);
        }
        return data.pop();
    }

    // 表达式计算
    private void fetchAndCal(Stack<Integer> data, Stack<Character> ops) {
        Integer number2 = data.pop();
        Integer number1 = data.pop();
        char op = ops.pop();
        int reslult = cal(op, number1, number2);
        //入栈
        data.push(reslult);
    }


    /**
     * 判断运算符 a 的优先级是否大于 b
     * *、/ 大于 +、- ,而且任何运算符优先级都大于左括号 '('
     * @param a 运算符1
     * @param b 运算符2
     * @return
     */
    private boolean prior(char a, char b) {
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return true;
        }
        // 任何运算符的优先级都大于左括号,直接入栈即可
        if (b == '(') {
            return true;
        }
        return false;
    }


    // +、-、*、/ 运算
    private int cal(char op, int number1, int number2) {
        switch (op) {
            case '+': return number1 + number2;
            case '-': return number1 - number2;
            case '*': return number1 * number2;
            case '/': return number1 / number2;
            default:
                break;
        }
        return -1;
    }

    // 判断字符是不是数字
    public boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }


    public static void main(String[] args) {
        BasicCalculator_772III basicCalcu = new BasicCalculator_772III();
        String exrpess1 = "6-4/2";
        String exrpess2 = "2*(5+5*2)/3+(6/2+8)";
        int result1 = basicCalcu.calculate(exrpess1);
        int result2 = basicCalcu.calculate(exrpess2);
        System.out.println(exrpess1 + " = " + result1);
        System.out.println(exrpess2 + " = " + result2);
    }
}
