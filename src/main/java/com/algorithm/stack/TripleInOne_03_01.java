package com.algorithm.stack;

/**
 * leetcode 面试题 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈的下标(栈0,栈1,栈2)，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 解题思路:
 * 1. 将一个数组分开成三个栈,隔开存储每个栈中的元素,实际上每个栈中的相邻元素下标相差3,例如:
 *    第一个元素 1存储到栈0中,对应数组下标0;(栈顶top0 = 0)
 *    第二个元素 3存储到栈1中,对应的数组下标是1;(栈顶top1= 1)
 *    第三个元素 5 存储到栈2中,对应的数组下标是2;(栈顶top2= 2)
 *    假如来一个元素 7,它要存储到栈1(stackNum = 1)中的,实际上它存储在整个数组中的下标是 top1 + 3 = 4,对应的top1修改为 = 4,然后该元素写入数组对应的下标位置;
 *    同理假如来一个元素9,它要存储到栈2(stackNum = 2)中的,实际上它存储在整个数组中的下标是top2 + 3 = 5,对应的top2修改为 = 5,然后该元素写入数组对应的下标位置;
 *
 *
 * @Author: kim
 * @Description: 面试题 03.01. 三合一
 * @Date: 10:57 2021/7/13
 * @Version: 1.0
 */
public class TripleInOne_03_01 {

    private int[] array;
    // 数组大小
    private int n;

    // 保存每个栈的栈顶下标
    private int[] top;

    public TripleInOne_03_01() {
    }

    public TripleInOne_03_01(int stackSize) {
        this.n = 3*stackSize;
        // 数组的大小是每个栈大小的3倍
        array = new int[3*stackSize];

        top = new int[3];
        // 这里要注意栈顶的初始下标赋值的技巧
        top[0] = -3;    // 栈0的栈顶下标
        top[1] = -2;    // 栈1的栈顶下标
        top[2] = -1;    // 栈2的栈顶下标
    }

    /**
     * 入栈
     * @param stackNum  栈下标,0,1,2 表示该元素要压入三个栈中的哪一个栈
     * @param value     元素值
     */
    public void push(int stackNum, int value) {
        // 要先判断该元素入栈后对应的栈顶下标是否已经超过了数组的大小,超过了就无法入栈
        if (top[stackNum] + 3 >= n) {
            return;
        }
        // 修改栈顶下标
        top[stackNum] = top[stackNum] + 3;
        // 存入到数组中入栈
        array[top[stackNum]] = value;
    }

    /**
     * 出栈
     * @param stackNum 栈下标,0,1,2 表示要取三个栈中的哪一个栈的栈顶元素
     * @return
     */
    public int pop(int stackNum) {
        // 表示此时该栈没有数据,为空
        if (top[stackNum] < 0) {
            return -1;
        }
        // 取对应栈顶元素
        int data = array[top[stackNum]];
        // 修改栈顶的下标
        top[stackNum] -= 3;
        return data;
    }

    /**
     * 出栈但不删除栈顶元素
     * @param stackNum  栈下标,0,1,2 表示要取三个栈中的哪一个栈的栈顶元素
     * @return
     */
    public int peek(int stackNum) {
        // 表示此时该栈没有数据
        if (top[stackNum] < 0) {
            return -1;
        }
        // 取对应栈顶元素
        int data = array[top[stackNum]];
        return data;
    }

    /**
     * 判断栈是否为空,其实只需要看栈顶的下标是否小于0,这里就用到了初始化栈顶时候小标都小于0的技巧了
     * @param stackNum
     * @return
     */
    public boolean isEmpty(int stackNum) {
        if (top[stackNum] < 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        TripleInOne_03_01 triple = new TripleInOne_03_01(10);
        triple.push(1, 5);
        triple.push(1, 4);
        triple.push(0, 3);
        triple.push(0, 2);
        System.out.println("栈0: " + triple.pop(0));
        System.out.println("栈0: " + triple.peek(0));
        System.out.println("栈1: " + triple.peek(1));
    }
}
