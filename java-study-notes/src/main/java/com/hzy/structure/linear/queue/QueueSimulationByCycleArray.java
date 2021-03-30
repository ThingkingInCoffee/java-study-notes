package com.hzy.structure.linear.queue;

public class QueueSimulationByCycleArray {

    public static void main(String[] args) {
        testArrayDemo();
    }

    /**
     * 建单队列demo
     */
    public static void testArrayDemo() {
        ArrayQueueCycle queue = new ArrayQueueCycle(5);
        queue.addElement(1);
        queue.addElement(2);
        queue.addElement(3);
        queue.addElement(4);
        queue.addElement(5);  // 队列已满
        queue.addElement(6);  // 队列已满
        queue.addElement(7);  // 队列已满

        queue.show();

        queue.getElement();
        queue.getElement();
        queue.getElement();
        queue.getElement();
//        queue.getElement(); // 队列已空

        System.out.println("+++++++重新插入数据++++++++");
        queue.addElement(1);
        queue.addElement(2);
        queue.addElement(3);
        queue.addElement(4);

        queue.getElement();
        queue.getElement();

        queue.addElement(5);
        queue.addElement(6);

        queue.show();
    }

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
            return;
        }
        arr[rear] = ele;
        rear = (rear + 1) % maxSize;
        System.out.println("添加元素 " + ele);
    }

    public int getElement() {
        if (isEmpty()) {
            throw new RuntimeException("空了");
        }
        int i = arr[front++];
        front = front % maxSize;
        System.out.println("获取数据 " + i);
        return i;
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("空了");
        }
        System.out.print("展示队列数据：");
        for (int i = front; i < front + getSize(); i++) {
            System.out.print(arr[i % maxSize] + " ");
        }
        System.out.println();
    }



    private int getSize() {
        // rear - front 是有效数，
        // 该值可能为负数，则 +maxSize 补正
        // 该值可能为正，则 +maxSize 后取余平衡
        return (rear - front + maxSize) % maxSize;
    }


}