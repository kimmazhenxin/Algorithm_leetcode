package com.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1.两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例:
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 *
 * 解题思路:
 * 	两层for循环，或者Map解决，或排序+双指针
 *
 * @Author: kim
 * @Description:两数之后
 * @Date: 8:57 2021/4/8
 * @Version: 1.0
 */
public class TwoSum_1 {

	public static void main(String[] args) {
		//数组无序
		int[] array1 = {3, 7, 5, 9};
		int[] result = twoSum(array1, 8);
		for (int i : result) {
			System.out.println(i);
		}

		//数组有序
		int[] array2 = {1, 3, 5, 9, 11};
		int[] ints = twoSumSort(array2, 8);
		for (int i : ints) {
			System.out.println(i);
		}
	}

	//哈希法(数组无序)
	public static int[] twoSum(int[] array, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			//判断Map中是否有target - x,有的话就返回对应的下标
			if (map.containsKey(target - array[i])) {
				return new int[]{map.get(target - array[i]), i};
			}
			//存储数组值和下标
			map.put(array[i], i);
		}
		return new int[0];
	}

	//如果数组是有序的,解法如下
	public static int[] twoSumSort(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int sum = array[left] + array[right];
			if (sum == target) {
				return new int[]{left, right};
			} else if (sum < target) {
				//left向右移,让sum大一点
				left++;
			} else if (sum > target) {
				//right向左移,让sum小一点
				right--;
			}
		}
		return new int[0];
	}
}
