package com.algorithm.stack;

import java.util.Stack;

/**
 * leetcode 42. 接雨水(单调栈)
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少个单位的雨水。
 *
 * 示例:
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 解题思路:
 * 核心思想:
 * 1. 每个柱子之上承载的水量 = min(左侧最高柱子lh,右侧最高柱子rh) - 这个柱子的高度h
 * 2. 总的接水量 = 每个柱子之上承载水量的总和
 * 3. 第一个柱子和最后一个柱子始终是接不了雨水的
 *
 * 方法:
 * 1. 前缀/后缀统计方法
 * 2. 单调栈解法
 * 3. 双指针解法
 *
 *
 * @Author: kim
 * @Description: 42. 接雨水
 * @Date: 10:24 2021/7/15
 * @Version: 1.0
 */
public class CatchRainWater_42 {
    /**
     * 前缀/后缀统计方法(时间复杂度O(n),空间复杂度O(n))
     * 1) 申请一个数组left,记录每个柱子(包含它自己)左侧的最高柱子高度;
     * 2) 申请一个数组right,记录每个柱子(包含它自己)右侧的最高柱子高度;
     * 3) 根据上面的两个数组,按照公式1计算出每个柱子的接水量,累加即可。
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int n = height.length;
        // 前缀左侧
        int[] leftMax = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            leftMax[i] = Math.max(max, height[i]);
            max = leftMax[i];
        }

        // 后缀右侧
        int rightMax[] = new int[n];
        max = 0;
        for (int i = n - 1; i >=0; i--) {
            rightMax[i] = Math.max(max, height[i]);
            max = rightMax[i];
        }

        // 根据上述两个数组按照公式1计算每个柱子的接雨水量,然后累加即可
        int total = 0;
        for (int i = 0; i < leftMax.length; i++) {
            total = total + (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return total;
    }

    /**
     * 单调栈解法
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int n = height.length;
        int reslut = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);// 存下标
                continue;
            }
            while (!stack.isEmpty()) {
                int top = stack.pop();
                if (height[top] == height[i]) {
                    stack.pop();
                    stack.push(i);
                    break;
                } else if (height[top] > height[i]) {
                    stack.push(i);
                    break;
                } else { // 找到凹槽了
                    int mid = stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                        break;
                    }
                    int left = stack.peek();
                    int h = Math.min(height[left], height[i]) - height[mid];
                    int w = i-left-1;
                    reslut += h*w;
                }
            }
        }
        return reslut;
    }


    
    public int trap3(int[] height) {

        return 0;
    }



    public static void main(String[] args) {
        CatchRainWater_42 rain = new CatchRainWater_42();
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};

        System.out.println("height1接雨量: " + rain.trap1(height1));
        System.out.println("height2接雨量: " + rain.trap1(height2));


    }
}
