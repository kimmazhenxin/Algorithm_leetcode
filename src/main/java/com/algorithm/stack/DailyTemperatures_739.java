package com.algorithm.stack;

import java.util.Stack;

/**
 * leetcode 739.每日温度
 * 请根据每日气温列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 解题思路:
 * 1. 单调栈: 栈中的元素大小是递减的......
 *
 * @Author: kim
 * @Description: 739.每日温度
 * @Date: 9:19 2021/7/12
 * @Version: 1.0
 */
public class DailyTemperatures_739 {

    public static void main(String[] args) {

        DailyTemperatures_739 d = new DailyTemperatures_739();
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] reslut = d.dailyTemperatures(temp);

    }

    // 单调栈解法
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // 存储元素下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 如果栈中的元素大小大于等于列表中遍历对应的元素大小,那么入栈;否则就出栈
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                // 元素下标
                int idx = stack.peek();
                // 此时栈中小标对应的温度是小于列表中的温度的,那么存入对应的下标差
                result[idx] = i - idx;
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }



    // 暴力解法
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] reslut = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i +1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    // 找到第一个比 它大的温度的下标,存入即可
                    reslut[i] = j - i;
                    break;
                }
            }
        }
        return reslut;
    }
}
