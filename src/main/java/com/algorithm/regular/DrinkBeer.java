package com.algorithm.regular;

/**
 * 规律题:
 * 现有x瓶啤酒，每3个空瓶子换一瓶啤酒，每7个瓶盖子也可以换一瓶啤酒，问最后可以喝多少瓶啤酒?
 *
 * 解题思路:
 *  通过简单举例子总结规律
 *
 * @Author: kim
 * @Description:
 * @Date: 11:24 2021/5/13
 * @Version: 1.0
 */
public class DrinkBeer {

    public static void main(String[] args) {
        System.out.println("啤酒数量: " + drink(9));
    }

    /**
     * 计算最终喝啤酒瓶数
     * @param x x瓶啤酒
     * @return
     */
    public static int drink(int x) {
        // 喝了多少瓶啤酒
        int count = x;
        // 有多少空瓶子
        int k1 = x;
        // 有多少空瓶盖
        int k2 = x;

        // 循环截止条件: k1 <3 和k2 < 7 说明就换不了任何一瓶啤酒了
        while (k1 >= 3 | k2 >= 7) {
            // 先从空瓶子情况入手
            while (k1 >= 3) {
                int change = k1/3;
                count += change;
                // 兑换完啤酒后k1剩余的数量
                k1 %= 3;
                // 喝完啤酒后k1的数量
                k1 += change;
                k2 += change;
            }

            // 从空瓶盖情况入手
            while (k2 >=7) {
                int change = k2/7;
                count += change;
                k1 += change;
                // 兑换完啤酒后k1剩余的数量
                k2 %= 7;
                // 喝完啤酒后k1的数量
                k2 += change;
            }
        }
        return count;
    }
}
