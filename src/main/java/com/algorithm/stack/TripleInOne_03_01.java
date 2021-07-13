package com.algorithm.stack;

/**
 * leetcode 面试题 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 解题思路:
 *
 *
 * @Author: kim
 * @Description: 面试题 03.01. 三合一
 * @Date: 10:57 2021/7/13
 * @Version: 1.0
 */
public class TripleInOne_03_01 {

    private int[] items;
    // 数组大小
    private int n;

    public TripleInOne_03_01() {
    }

    public TripleInOne_03_01(int n) {
        this.n = n;
        items = new int[n];
    }

    public void push(int stackNum, int value) {

    }

    public int pop(int stackNum) {

        return -1;
    }

    public int peek(int stackNum) {

        return -1;
    }


    public boolean isEmpty(int stackNum) {

        return false;
    }

    public static void main(String[] args) {
        TripleInOne_03_01 triple = new TripleInOne_03_01(10);


    }
}
