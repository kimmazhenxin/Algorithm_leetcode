package com.algorithm.stack;

import java.util.Stack;

/**
 * leetcode 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。也就是空间复杂度是O(1).
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 解题思路:
 * 1. 利用空间换时间,每次入栈的时候压入两个元素，先压栈一个是元素本身，再压栈一个是栈中的最小值元素(只用一个栈即可)
 * 2. 思想同上,只不过用到一个临时最小栈,每次元素压栈时,也需要压栈2个元素,只不过元素压入数据栈,最小值压入最小栈,一一对应
 *    获取最小值时直接弹出最小栈即可
 *
 * @Author: kim
 * @Description: 155. 最小栈
 * @Date: 11:04 2021/7/13
 * @Version: 1.0
 */
public class MinStack_155 {

    private Stack<Integer> stack;

    public MinStack_155() {
        stack = new Stack<>();
    }

    public void push(int value) {
        int minValue = 0;
        // 第一个元素入栈
        if (stack.isEmpty()) {
            minValue = value;
            // 先压栈元素
            stack.push(value);
            // 再压栈最小元素
            stack.push(minValue);
        } else {
            // 获取栈中目前的最小值
            minValue = stack.peek();
            // 比较最小值和value的大小
            if (minValue > value) {
                minValue = value;
            }
            // 先压栈元素
            stack.push(value);
            // 再压栈最小元素
            stack.push(minValue);
        }
    }

    // 弹出两次即可
    public void pop(){
        stack.pop();
        stack.pop();
    }

    // 弹出两次,第一次是最小值,第二次才是栈顶元素本身
    public int peek(){
        int minValue = stack.pop();
        Integer data = stack.peek();
        // 再放入最小值
        stack.push(minValue);
        return data;
    }

    public int getMin() {
        return stack.peek();
    }


    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();
        minStack.push(4);
        minStack.push(6);
        minStack.push(5);
        minStack.push(2);
        minStack.push(9);
        minStack.push(1);

        System.out.println("栈最小值: " + minStack.getMin());
        System.out.println("peek()栈顶元素: " + minStack.peek());
        System.out.println("执行pop()出栈......");
        minStack.pop();
        System.out.println("栈最小值: " + minStack.getMin());
        System.out.println("peek()栈顶元素: " + minStack.peek());
    }


    // 解法2: 使用临时栈
    class MinStack {

        private Stack<Integer> stack;

        private Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        // 入栈,需要一一对应数据栈与最小栈
        public void push(int value) {
            int minValue;
            if (stack.isEmpty()) {
                minValue =  value;
            } else {
                // 最小栈中的栈顶元素肯定是最小值,拿最小值和压栈元素比较
                minValue = minStack.peek();
                if (minValue > value) {
                    // 重新赋值最小值
                    minValue = value;
                }
            }
            // 分别压入数据栈和最小值栈
            stack.push(value);
            minStack.push(minValue);

        }

        public void pop(){
            stack.pop();
            minStack.pop();
        }

        public int peek(){
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}


