package com.algorithm.recursion;

/**
 * leetcode 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例:
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 解题思路:
 * 1. 递归
 *
 * @Author: kim
 * @Description: 70. 爬楼梯
 * @Date: 8:56 2021/7/20
 * @Version: 1.0
 */
public class ClimbStairs_70 {

    private int[] mem;

    public int solution(int n) {
        mem = new int[n+1];
        return climbStairs(n);
    }

    // 递推逻辑
    public int climbStairs(int n) {
        // 递归终止条件
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        // 备忘录判断
        if (mem[n] !=0) {
            return mem[n];
        }
        // 递推公式
        mem[n] = climbStairs(n-1) + climbStairs(n-2);
        return mem[n];
    }


    public static void main(String[] args) {
        ClimbStairs_70 climb = new ClimbStairs_70();
        int n = 3;
        System.out.println("n = " + n + " 的解法: " + climb.solution(n));
    }
}
