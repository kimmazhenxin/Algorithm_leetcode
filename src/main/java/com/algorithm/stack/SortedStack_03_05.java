package com.algorithm.stack;

import java.util.Stack;

/**
 * leetcode 面试题 03.05. 栈排序
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 解题思路:
 * 1.push的时候直接入栈,pop、peek的时候倒腾排序,得到最小值元素    (出栈倒腾)
 * 2.push的时候排序,pop、peek的时候直接出栈,类似于插入排序,一直让栈中的元素从大到小(从栈底到栈顶) (入栈倒腾)
 *
 * @Author: kim
 * @Description: 面试题 03.05. 栈排序
 * @Date: 11:07 2021/7/13
 * @Version: 1.0
 */
public class SortedStack_03_05 {

    private Stack<Integer> stack;
    // 临时栈
    private Stack<Integer> tmpStack;

    public SortedStack_03_05() {
        stack = new Stack<>();
        tmpStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

    }

    // 每次出栈要求元素是栈中最小的元素
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        // 最小值先初始化
        int min = Integer.MAX_VALUE;
        // 是否已经弹出了最小值(主要是用于最小值为2个及以上的情况,这时候只需要移除一个即可)
        boolean removeFlag = false;

        // 先找出栈中的最小值元素
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (min > pop) {
                min = pop;
            }
            tmpStack.push(pop);
        }

        // 将临时栈中的元素再放回原来的栈中,但是要删除最小的元素中的一个
        while (!tmpStack.isEmpty()) {
            int value = tmpStack.pop();
            // 遍历时找到和最小值相等的那个元素,然后标记为删除,不放入栈中;否则该元素就入栈
            if (min == value && !removeFlag) {
                removeFlag = true;
            } else {
               stack.push(value);
            }
        }
    }
    // 每次出栈(不删除)要求元素是栈中最小的元素
    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (value < min) {
                min = value;
            }
            tmpStack.push(value);
        }

        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
        return min;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack_03_05 sortStack = new SortedStack_03_05();
        sortStack.push(3);
        sortStack.push(6);
        sortStack.push(2);
        sortStack.push(2);
        sortStack.push(9);

        System.out.println(sortStack.peek());
    }
}

// 解法2
class SortedStack {

    private Stack<Integer> stack;

    private Stack<Integer> tmpStack;

    public SortedStack() {
        stack = new Stack<>();
        tmpStack = new Stack<>();
    }

    // 入栈时候进行排序,从栈底到栈顶一次从大到小
    public void push(int value) {
        // 如果入栈元素大于栈元素,那么栈元素先入临时栈中
        while (!stack.isEmpty() && stack.peek() < value) {
            tmpStack.push(stack.pop());
        }
        // 插入栈
        tmpStack.push(value);

        // 再讲临时栈中的元素弹出压栈到原栈中
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }

    // 每次出栈要求元素是栈中最小的元素
    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
        }

    }

    // 每次出栈(不删除)要求元素是栈中最小的元素
    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
