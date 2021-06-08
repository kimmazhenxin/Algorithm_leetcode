package com.algorithm.array;

/**
 * leetcode 26. 删除有序数组中的重复项
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *  
 *
 * 提示：
 * 0 <= nums.length <= 3 * 10000
 * -104 <= nums[i] <= 10000
 * nums 已按升序排列
 *
 * 解题思路：
 * 双指针
 *
 * @Author: kim
 * @Description: 删除有序数组中的重复项
 * @Date: 2021/5/22 18:34
 * @Version: 1.0
 */
public class RemoveDuplicates_26 {

	public static void main(String[] args) {
		int[] a = {1, 1, 3, 3, 4, 5, 6, 6, 6, 8, 8, 9};
		System.out.println("removeDuplicates: " + removeDuplicates(a));
	}

	/**
	 *
	 * @param array
	 * @return 返回数组的新长度
	 */
	public static int removeDuplicates(int[] array) {
		// 注意特殊情况
		if (null == array || 0 == array.length) {
			return 0;
		}
		int p = 0;
		int q = 1;
		while (q < array.length) {
			if (array[p] == array[q]) {
				q++;
			} else {
				if (q - p > 1) {
					array[p+1] = array[q];
				}
				p++;
				q++;
			}
		}
		return p + 1;
	}
}
