package com.algorithm.regular;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13]
 *
 * @Author: kim
 * @Description: 扑克牌中的顺子
 * @Date: 20:17 2021/5/25
 * @Version: 1.0
 */
public class IsStraight_Offer61 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("isStraight = " + isStraight(array));
    }


    public static boolean isStraight(int[] nums) {


        return false;
    }

}
