package com.hzy.structure.linear.stack;

/**
 * 数组模拟栈
 */
public class StackSimulationByArray {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
        arrayStack.list();
        // 出栈两个
        System.out.println("准备出栈");
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.list();
        // 再添加
        System.out.println("再插入");
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i * 5 + 1000);
        }
        arrayStack.list();
    }

}

class ArrayStack {
    private final int maxSize; // 最大值
    private final int[] stack;  // 存储数据
    private int top = -1;  //栈顶指针，默认初始-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int insertValue) {
        if (isFull()) {
            System.out.println("满了");
            return;
        }
        stack[++top] = insertValue;
        System.out.println("插入数据" + insertValue);
    }

    public int peek(){
        return stack[top];
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空了");
        }
        int topValue = stack[top--];
        System.out.println("取出数据-----" + topValue);
        return topValue;
    }

    /**
     * 列出栈内数据，应该是从栈顶向下
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("空了");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
    }
}
