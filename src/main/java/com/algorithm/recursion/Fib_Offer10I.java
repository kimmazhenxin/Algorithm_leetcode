package com.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 *
 * @Author: kim
 * @Description: 剑指 Offer 10- I. 斐波那契数列
 * @Date: 15:00 2021/7/20
 * @Version: 1.0
 */
public class Fib_Offer10I {

    private int mod = 1000000007;
    // 存储n和对应的计算结果 f(n)
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 简单版，但是存在重复计算问题
     * 时间复杂度: O(2^n)
     * 空间复杂度: O(n)
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fib(n-1) + fib(n-2)) % mod;
    }

    /**
     * 使用备忘录,解决重复计算问题
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // 先判断是否存在计算过的值
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int data = (fib(n - 1) + fib(n - 2)) % mod;
        map.put(n, data);
        return data;
    }


    public static void main(String[] args) {
        Fib_Offer10I fib = new Fib_Offer10I();
        int k = fib.fib2(5);
        System.out.println(k);
    }
}
