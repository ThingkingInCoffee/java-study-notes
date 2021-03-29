package com.hzy.structure.linear.queue;

/**
 * 数组模拟队列
 */
public class QueueSimulationByArray {

    public static void main(String[] args) {
        testArrayDemo();
    }

    /**
     * 建单队列demo
     */
    public static void testArrayDemo() {
        ArrayQueue queue = new ArrayQueue(5);
        queue.addQueueData(1);
        queue.addQueueData(2);
        queue.addQueueData(3);
        queue.addQueueData(4);
        queue.addQueueData(5);
//        queue.addQueueData(6);  // 队列已满

        queue.showQueueData();

        queue.showFront();

        queue.getQueueData();
        queue.getQueueData();
        queue.getQueueData();
        queue.getQueueData();
        queue.getQueueData();
//        queue.getQueueData(); // 队列已空
    }

}

/**
 * 简易数组队列
 * 存在问题：队列容量使用之后，无法再次使用，例如容量 3 ，存入三个数据，取出后，无法再存储使用
 */
class ArrayQueue {

    private int maxSize;  // 最大数量
    private int front; // 头部
    private int rear;  // 尾部
    private int[] arr;  // 存储容器

    public ArrayQueue(int size) {
        maxSize = size;
        arr = new int[maxSize];
        front = -1;  // 指向队列头部（不包含数据），front指向头得前一个位置
        rear = -1;  // 指向队列尾部（含数据），
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueueData(int element) {
        if (isFull()) {
            System.out.println("队列已经满了");
            return;
        }
        arr[++rear] = element;
    }

    public int getQueueData() {
        if (isEmpty()) {
            throw new RuntimeException("队列已经空了");
        }
        int data = arr[++front];
        System.out.println(data);
        return data;
    }

    public void showQueueData() {
        if (isEmpty()) {
            throw new RuntimeException("队列已经空了");
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void showFront() {
        System.out.println(arr[front + 1]);
    }
}


