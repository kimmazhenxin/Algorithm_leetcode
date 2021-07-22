package com.algorithm.recursion;

/**
 * leetcode 面试题 08.05. 递归乘法
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 *
 * 解题思路:
 * A*B 实际拆分成 A为偶数 (A/2 * B) + (A/2 * B); A为奇数 (A/2 * B) + (A/2 * B) + B;
 *
 * @Author: kim
 * @Description: 面试题 08.05. 递归乘法
 * @Date: 13:47 2021/7/21
 * @Version: 1.0
 */
public class Multiply_08_05 {
    /**
     * 时间复杂度:log2 (n)
     * 空间复杂度:log2 (n)
     * @param A
     * @param B
     * @return
     */
    public int multiply(int A, int B) {
        if (A == 1) { // 递归终止条件
            return B;
        }
        int halfValue = multiply(A / 2, B);
        if (A%2 == 0) {
            return halfValue + halfValue;
        } else {
            return halfValue + halfValue + B;
        }
    }

    /**
     * 优化:
     * A*B = B+B+...+B (A个B相加)
     * A*B = A+A+...+A (B个A相加)
     * 我们找最大值作为被加数，最小值作为加的个数,例如 2*5 = 5+5,减少加的次数
     * @param A
     * @param B
     * @return
     */
    public int multiply2(int A, int B) {
        int n = Math.min(A, B);
        int k = Math.max(A, B);
        if (n == 1) { // 递归终止条件
            return B;
        }
        // n个k相加=(n/2个k相加) + (n/2个k相加) + 0(k)
        int halfValut = multiply2(n/2, k);
        if (n%2 == 0) {
            return halfValut + halfValut;
        } else {
            return halfValut + halfValut + k;
        }
    }


    public static void main(String[] args) {
        Multiply_08_05 m = new Multiply_08_05();
        int A1 = 3, B1 = 5;
        int A2 = 4, B2 = 10;
        System.out.println(A1 + " * " + B1 + " = " + m.multiply(A1, B1));
        System.out.println(A2 + " * " + B2 + " = " + m.multiply(A2, B2));
        System.out.println("================================================");
        System.out.println(A1 + " * " + B1 + " = " + m.multiply2(A1, B1));
        System.out.println(A2 + " * " + B2 + " = " + m.multiply2(A2, B2));
    }
}
