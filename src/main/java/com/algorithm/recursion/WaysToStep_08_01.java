package com.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007
 *
 *
 * 解题思路:
 * 1. 递归
 * 2. 动态规划(迭代)
 *
 * @Author: kim
 * @Description: 面试题 08.01. 三步问题
 * @Date: 15:24 2021/7/20
 * @Version: 1.0
 */
public class WaysToStep_08_01 {

    private int mod = 1000000007;

    // 存储n和对应的计算结果 f(n)
    private Map<Integer, Integer> map = new HashMap<>();

    // 递归
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ways = (waysToStep(n-1) + waysToStep(n-2) + waysToStep(n-3)) % mod;
        map.put(n, ways);
        return ways;
    }


    // 迭代
    // 这种解法实际就是用了每n个台阶的解法实际是前面三个台阶的解法之和。
    public int waysToStep2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        int a = 1;
        int b = 1;
        int c = 1;
        int d = 0;

        for (int i = 4; i <= n; i++) {
            d = ((c+b)%mod + a)%mod; // 每次得到一个结果
            // 将之前的结果依次往后赋值
            a = b;
            b = c;
            c = d;
        }
        return d;
    }


    public static void main(String[] args) {
        WaysToStep_08_01 ways = new WaysToStep_08_01();
        System.out.println(ways.waysToStep(5));
    }
}
