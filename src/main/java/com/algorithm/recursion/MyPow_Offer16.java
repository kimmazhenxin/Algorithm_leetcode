package com.algorithm.recursion;

/**
 * leetcode 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 其中:
 * -2^31 <= n <= 2^31 - 1
 *
 *
 * 解决思路:
 * 1. 对于n次幂计算,如果n为偶数,X^n实际可以拆分为 x^(n/2) * x^(n/2);如果n为奇数,它可以拆解为 x^(n/2) * x^(n/2) * x
 * 2. 加入n=-2^31,那么在计算时需要注意,不能直接去计算x^(-2^31),这样会数值溢出,需要 -1*(-2^31 + 1) * x
 *
 *
 * @Author: kim
 * @Description: 数值的整数次方
 * @Date: 10:22 2021/7/21
 * @Version: 1.0
 */
public class MyPow_Offer16 {


    // 时间复杂度: O(log2 n)
    // 空间复杂度: O(log2 n)
    public double myPow(double x, int n) {
        if (n >= 0) {
            return rProw(x, n);
        } else {
            return 1 / (rProw(x, -1*(n+1))*x);
        }
    }


    public double rProw(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double halfPow = rProw(x, n / 2);
        if (n%2 == 1) {
            return halfPow * halfPow * x;
        } else {
            return halfPow * halfPow;
        }
    }


    public static void main(String[] args) {
        MyPow_Offer16 pow = new MyPow_Offer16();
        System.out.println(pow.myPow(2, -10));
    }

}
