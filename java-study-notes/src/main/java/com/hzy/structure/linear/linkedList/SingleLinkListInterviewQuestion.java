package com.hzy.structure.linear.linkedList;

import java.util.Stack;

/**
 * 面试题目
 */
public class SingleLinkListInterviewQuestion {

    public static void main(String[] args) {
        LinkedNode node01 = new LinkedNode(1, "20001");
        LinkedNode node02 = new LinkedNode(6, "20006");
        LinkedNode node03 = new LinkedNode(3, "20003");
        LinkedNode node04 = new LinkedNode(9, "20009");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.list();
        linkedList.addNode(node01);
        linkedList.addNode(node02);
        linkedList.addNode(node03);
        linkedList.addNode(node04);
        linkedList.list();

        int nodeNum = checkEffectiveNodeNum(linkedList.getHead());
        System.out.println(nodeNum);

        getSpecialNodeDesc(linkedList.getHead(), 3);

        System.out.println("开始反转");
        reverseLinkedList(linkedList.getHead());
        System.out.println("反转结果：");
        linkedList.list();

        System.out.println("栈结构反转结果：");
        // 使用栈反转链表
        reversePrint(linkedList.getHead());
    }


    /**
     * 题目 1，求单链表的有效节点数
     *
     * @param head
     * @return
     */
    public static int checkEffectiveNodeNum(LinkedNode head) {
        if (head.next == null) {
            System.out.println("空的");
            return 0;
        }
        int length = 0;
        LinkedNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 题目 2
     * 获取倒数指定位置的节点内容
     * 1-2-3-4-5-6-7-8-9
     * 倒数第 index 个 如 倒数3个， 则需要移动的指针次数 为 6
     *
     * @param head
     * @param index
     */
    public static LinkedNode getSpecialNodeDesc(LinkedNode head, int index) {
        if (head.next == null) {
            System.out.println("空的");
        }
        // 得到领表长度
        int size = checkEffectiveNodeNum(head);
        if (index <= 0 || index > size) {
            System.out.println("不合法的位置");
            return null;
        }
        // 此处节点temp初始指向第一个节点，如果要指向倒数的第n个节点，需要移动 size - index 次， i 代表的是移动次数
        LinkedNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        System.out.println("找到的节点是" + temp);
        return temp;
    }

    /**
     * 题目 3
     * 单链表反转
     *
     * @param head
     * @return
     */
    public static void reverseLinkedList(LinkedNode head) {
        if (head.next == null) {
            System.out.println("空的");
            return;
        }
        LinkedNode reverseNodeHead = new LinkedNode(0, "");
        LinkedNode source = head.next;
        LinkedNode nextNode;
        while (source != null) {
            nextNode = source.next;  // 保存原链表节点的下一节点数据
            source.next = reverseNodeHead.next;  // 将反转链表head后的所有节点追加到当前传入节点
            reverseNodeHead.next = source; // 将追加了反转链表的原数据节点追加到反转链表头节点后面
            source = nextNode; // 原始节点指向下一个节点
        }
        head.next = reverseNodeHead.next;
    }

    /**
     * 题目 4
     * 倒叙遍历单链表
     * 使用栈的结构，先进后出
     *
     * @param head
     */
    public static void reversePrint(LinkedNode head) {
        if (head.next == null) {
            System.out.println("空的");
            return;
        }
        LinkedNode current = head.next;
        Stack<LinkedNode> stack = new Stack<>();
        while (current != null) {
            stack.add(current);
            current = current.next;
        }
        for (LinkedNode node : stack) {
            System.out.println(node);
        }
    }

    /**
     *  题目 5
     *  合并两个单链表，并排序
     * @param first
     * @param second
     */
    public static void mergeAndSortTwoLinkedList(LinkedNode first, LinkedNode second) {

    }


}
