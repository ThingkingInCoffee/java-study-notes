package com.hzy.structure.linear.queue;

public class QueueSimulationByCycleArray {


}

/**
 * 解决数组队列复用问题 此版本预留一个空间用于判断
 */
class ArrayQueueCycle {
    private int maxSize;  // 最大数量
    private int front; // 头部 初始值 0 指向队列的第一个元素，即 arr[front]是队列第一个元素
    private int rear;  // 尾部 初始值 0 指向队列的最后元素的后一个位置， 即下一个存放元素的位置
    private int[] arr;  // 存储容器

    /**
     * 初始化
     *
     * @param size
     */
    public ArrayQueueCycle(int size) {
        maxSize = size;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断是否满了，如果下一个存储位置 + 1 和 容量 取余相等，那么判断为满了
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addElement(int ele) {
        if (isFull()) {
            System.out.println("满了");
        }
        arr[rear] = ele;
        rear = (rear + 1) % maxSize;
    }

    public int getElement() {
        if (isEmpty()) {
            throw new RuntimeException("空了");
        }
        int i = arr[front++];
        front = front % maxSize;
        return i;
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("空了");
        }
        for (int i = front; i < front + getSize(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    private int getSize() {
        return (maxSize - front + rear);
    }


}