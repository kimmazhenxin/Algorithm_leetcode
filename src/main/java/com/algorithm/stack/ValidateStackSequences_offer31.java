package com.algorithm.stack;

import java.util.Stack;

/**
 * leectcode 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列(也就是压入数字 1,2,3,4,5入栈)，序列 {4,5,3,2,1}是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 示例:
 * 输入: pushed = [1,2,3,4,5], popped = [2,4,3,5,1]
 * 输出: true
 *
 * 输入: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出: false
 *
 * 解题思路:(类似找规律题)
 * 1. 这里需要注意的是,在压栈的过程中是可以出栈的.
 *    遍历出栈序列,依次看看每个出栈元素与入栈的元素比较
 *
 *
 *
 * @Author: kim
 * @Description: 剑指 Offer 31. 栈的压入、弹出序列
 * @Date: 10:22 2021/7/15
 * @Version: 1.0
 */
public class ValidateStackSequences_offer31 {


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 压栈数据
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popped.length; i++) {
            int number = popped[i];
            // 如果出栈的元素等于入栈的栈顶元素,那么这种情况是合理的,弹出栈顶元素
            if (!stack.isEmpty() && stack.peek() == number) {
                stack.pop();
            } else {    // 否则就遍历压栈序列依次压栈元素
                // 按照压栈序列压栈,直到即将压栈的元素等于出栈的元素时终止或者压栈序列已经到终点了
                while (j < pushed.length && pushed[j] != number) {
                    stack.push(pushed[j]);
                    j++;
                }
                // 上述循环结束的条件有两种情况,如果是压栈序列已经遍历到尾了,说明栈顶没有找到和出栈元素相等的元素,此时出栈序列是false
                if (j == pushed.length) {
                    return false;
                }
                // 增加到下一个值,跳过相等的那个压栈值
                j++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // 入栈元素
        int[] pushed1 = {1,2,3,4,5};
        // 出栈元素
        int[] popped1 = {2,4,3,5,1};
        int[] popped2 = {4,3,5,1,2};

        ValidateStackSequences_offer31 valid = new ValidateStackSequences_offer31();
        System.out.println("出栈顺序是否正确: " + valid.validateStackSequences(pushed1, popped1));
        System.out.println("出栈顺序是否正确: " + valid.validateStackSequences(pushed1, popped2));

    }

}
