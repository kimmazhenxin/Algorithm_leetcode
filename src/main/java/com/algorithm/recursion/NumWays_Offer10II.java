package com.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 * @Author: kim
 * @Description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @Date: 15:16 2021/7/20
 * @Version: 1.0
 */
public class NumWays_Offer10II {

    private int mod = 1000000007;

    // 存储n和对应的计算结果 f(n)
    private Map<Integer, Integer> map = new HashMap<>();

    public int numWays(int n) {
        if (0 == n) {
            return 1;
        }
        if (1 == n) {
            return 1;
        }
        // 先判断是否存在计算过的值
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int data = (numWays(n - 1) + numWays(n - 2)) % mod;
        map.put(n, data);
        return data;
    }




    public static void main(String[] args) {
        NumWays_Offer10II ways = new NumWays_Offer10II();
        System.out.println(ways.numWays(2));
        System.out.println(ways.numWays(7));
    }
}
