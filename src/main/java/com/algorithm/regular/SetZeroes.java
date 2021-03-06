package com.algorithm.regular;

/**
 * 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例：
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 解题思路:
 * 用两个标记变量分别记录每一行和每一列是否有零出现
 *
 *
 * @Author: kim
 * @Description: 零矩阵
 * @Date: 2021/5/22 22:14
 * @Version: 1.0
 */
public class SetZeroes {

	public static void main(String[] args) {
		// 4*3 矩阵
		int[][] a = new int[4][];
		a[0] = new int[]{1,2,3};
		a[1] = new int[]{4,5,6};
		a[2] = new int[]{7,8,9};
		a[3] = new int[]{0,10,11};
		System.out.println("a.length = " + a.length);
		System.out.println("a[0].length = " + a[0].length);
		System.out.println("a[1].length = " + a[1].length);

		// 设置0
		setZeroes(a);
		System.out.println("---------------------------");
	}


	// m*n矩阵
	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		// 记录哪一列哪一行有0要清空
		boolean[] zeroRow = new boolean[m];
		boolean[] zeroColumn = new boolean[n];

		// 先遍历矩阵,找出元素为0的行与列
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					zeroRow[i] = true;
					zeroColumn[j] = true;
				}
			}
		}
		// 再次遍历矩阵,根据之前的位置设置相应位置元素为0
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (zeroRow[i] || zeroColumn[j]) {
					matrix[i][j] = 0;
				}
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
