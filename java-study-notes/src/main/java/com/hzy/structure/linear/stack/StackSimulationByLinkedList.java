package com.hzy.structure.linear.stack;

public class StackSimulationByLinkedList {

    public static void main(String[] args) {
        StackLinkedList list = new StackLinkedList(5);
        for (int i = 0; i < 6; i++) {
            list.push(i);
        }
        list.list();
        list.pop();
        list.pop();
        list.list();
        list.push(7);
        list.list();

    }

}

class StackLinkedList {
    private StackNode head = new StackNode(-1);
    private int top = -1;
    private int maxSize;

    public StackLinkedList(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("链表栈满了");
            return;
        }
        StackNode insertNode = new StackNode(value);
        insertNode.next = head.next;
        head.next = insertNode;
        top++;
        System.out.println("链表栈入栈===" + value);
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("链表栈空了");
        }
        int value = head.next.nodeValue;
        head.next = head.next.next;
        top--;
        System.out.println("链表栈出栈===" + value);
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("链表栈空了");
            return;
        }
        System.out.println("遍历栈数据=======");
        StackNode temp = head.next;
        while (temp != null) {
            System.out.print(temp.nodeValue + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}

class StackNode {
    public int nodeValue;
    public StackNode next;

    public StackNode(int nodeValue) {
        this.nodeValue = nodeValue;
        this.next = null;
    }
}

