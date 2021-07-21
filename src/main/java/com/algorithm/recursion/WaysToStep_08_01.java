package com.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007
 *
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


    public static void main(String[] args) {
        WaysToStep_08_01 ways = new WaysToStep_08_01();
        System.out.println(ways.waysToStep(5));
    }
}
