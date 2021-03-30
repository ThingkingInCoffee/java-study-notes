package com.hzy.structure.linear.linkedList;

/**
 * 单链表demo
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        LinkedNode node01 = new LinkedNode(1, "10001");
        LinkedNode node02 = new LinkedNode(6, "10006");
        LinkedNode node03 = new LinkedNode(3, "10003");
        LinkedNode node04 = new LinkedNode(9, "10009");

        SingleLinkedList linkedList = new SingleLinkedList();

        linkedList.list();

        linkedList.addNode(node01);
        linkedList.addNode(node02);
        linkedList.addNode(node03);
        linkedList.addNode(node04);

        linkedList.list();

        SingleLinkedList linkedListOrder = new SingleLinkedList();
        linkedListOrder.addNodeOrder(node01);
        linkedListOrder.addNodeOrder(node02);
        linkedListOrder.addNodeOrder(node03);
        linkedListOrder.addNodeOrder(node04);
        linkedListOrder.list();
    }


}

/**
 * 单链表模拟类
 */
class SingleLinkedList {
    // 头结点
    private LinkedNode head = new LinkedNode(0, "");

    /**
     * 添加节点
     * 1、不考虑顺序的情况下，先找到最后一个节点
     * 2、在最后一个节点后添加节点
     *
     * @param node
     */
    public void addNode(LinkedNode node) {
        // 寻找最后节点
        LinkedNode temp = head;
        // 退出循环时取到了最后节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next; // 后移temp
        }
        temp.next = node;
        System.out.println("添加节点 " + node);
    }

    /**
     * 考虑顺序的情况下插入
     * 1、找到比插入数大的节点
     * 2、替换
     * 3、如果存在则提示
     *
     * @param node
     */
    public void addNodeOrder(LinkedNode node) {
        System.out.println("准备添加节点--" + node);
        LinkedNode temp = head;
        boolean exists = false;
        boolean isLast = false;

        while (true) {
            if (temp.next == null) {
                // 最后一个节点
                isLast = true;
                break;
            } else if (temp.next.code > node.code) {
                // 下个节点的值大于插入的节点的值
                break;
            } else if (temp.next.code == node.code) {
                System.out.println("后面已经存在了");
                exists = true;
                break;
            } else {
                temp = temp.next;
            }
            System.out.println("循环");
        }
        if (exists) {
            // 存在直接返回
            return;
        }
        if (isLast && temp.code == node.code) {
            System.out.println("前面已经存在了");
            return;
        }
        node.next = temp.next;
        // 当前节点后一个指向新增
        temp.next = node;
    }

    /**
     * 遍历节点
     */
    public void list() {
        if (head.next == null) {
            System.out.println("空了");
            return;
        }
        LinkedNode temp = head.next;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }


}

/**
 * 链表节点
 */
class LinkedNode {
    public Integer code;
    public String name;
    public LinkedNode next;

    public LinkedNode(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
