package com.algorithm.stack;

/**
 * 数组尾部实现出栈、入栈
 * @Author: kim
 * @Description: 基于数组实现栈
 * @Date: 21:08 2021/6/4
 * @Version: 1.0
 */
public class ArrayStack {
    // 数组
    private int[] items;
    // 栈中元素个数
    private int count;
    // 栈的大小,实际就是数组大小
    private int n;

    public ArrayStack(int n) {
        items = new int[n];
        this.count = 0;
        this.n = n;
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(int item) {
        // 数组空间不够了,入栈失败
        if (count == n) {
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }


    /**
     * 出栈且删除元素
     * @return
     */
    public int pop() {
        // 栈中没有元素
        if (count ==0) {
            return -1;
        }
        // 返回下表为count-1的数组元素,并且栈中元素的个数count要减1
        int a = items[count-1];
        count--;
        return a;
    }


    /**
     * 出栈但不删除元素
     * @return
     */
    public int peek() {
        // 栈中没有元素
        if (count ==0) {
            return -1;
        }
        return items[count-1];
    }


    public static void main(String[] args) {

    }
}
