package com.hzy.structure.linear.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.deleteDoubleNode(1);
        list.addDoubleNode(new DoubleLinkedNode(1, "3001"));
        list.listDouble();
        list.deleteDoubleNode(1);
        list.listDouble();
        list.addDoubleNode(new DoubleLinkedNode(2, "3002"));
        list.addDoubleNode(new DoubleLinkedNode(6, "3006"));
        list.addDoubleNode(new DoubleLinkedNode(4, "3004"));
        list.listDouble();
        list.deleteDoubleNode(6);
        list.listDouble();
        list.addDoubleNode(new DoubleLinkedNode(9, "3009"));
        list.listDouble();
        list.deleteDoubleNode(9);
        list.listDouble();
        list.updateDoubleNode(new DoubleLinkedNode(4, "30044"));
        list.listDouble();
        System.out.println("===========测试顺序添加=========");
        DoubleLinkedList list2 = new DoubleLinkedList();
        list2.addDoubleNodeOrder(new DoubleLinkedNode(2, "3002"));
        list2.addDoubleNodeOrder(new DoubleLinkedNode(7, "3007"));
        list2.addDoubleNodeOrder(new DoubleLinkedNode(1, "3001"));
        list2.addDoubleNodeOrder(new DoubleLinkedNode(9, "3009"));
        list2.addDoubleNodeOrder(new DoubleLinkedNode(6, "3006"));
        list2.addDoubleNodeOrder(new DoubleLinkedNode(4, "3004"));
        list2.listDouble();
    }

}


class DoubleLinkedList {
    private DoubleLinkedNode head = new DoubleLinkedNode(0, "");

    public DoubleLinkedNode getHead() {
        return head;
    }

    /**
     * 添加节点
     * 找到末尾，前后互指
     *
     * @param node
     */
    public void addDoubleNode(DoubleLinkedNode node) {
        // 寻找最后节点
        DoubleLinkedNode temp = head;
        // 退出循环时取到了最后节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next; // 后移temp
        }
        temp.next = node;
        node.pre = temp;
        System.out.println("添加节点 " + node);
    }

    /**
     * 插入新的节点，并将链表自动排序
     *
     * @param newNode
     */
    public void addDoubleNodeOrder(DoubleLinkedNode newNode) {
        System.out.println("传入" + newNode.code);
        DoubleLinkedNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("已经是末尾了");
                break;
            } else if (temp.next.code > newNode.code) {
                // 找到大于当前节点值得节点
                System.out.println("找到中间空隙");
                break;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.pre = temp;
        temp.next = newNode;
    }

    /**
     * 删除节点
     * 与单链表不同的是存储了前后节点信息，可以直接找到节点本身后处理
     *
     * @param code
     */
    public void deleteDoubleNode(int code) {
        if (head.next == null) {
            System.out.println("已经空了");
            return;
        }
        DoubleLinkedNode temp = head.next;
        // 是否找到要删除的节点
        boolean isFund = false;
        while (true) {
            if (temp == null) {
                System.out.println("遍历到头了");
                break;
            }
            // 找到当前节点
            if (temp.code == code) {
                System.out.printf("找到了目标节点 %d \n", code);
                isFund = true;
                break;
            }
            temp = temp.next;
        }
        if (isFund) {
            System.out.printf("找到了目标节点, 移除节点 %d \n", code);
            if (temp.next != null) {
                // 不是最后节点，将下一个节点的前置节点指向当前节点的前置节点
                temp.next.pre = temp.pre;
            }
            // 最后节点，将当前节点的前置节点的后置节点置空
            temp.pre.next = temp.next;
        } else {
            System.out.println("未找到要删除的节点");
        }
    }

    /**
     * 更新节点属性值
     *
     * @param updateNode
     */
    public void updateDoubleNode(DoubleLinkedNode updateNode) {
        if (head.next == null) {
            System.out.println("空了");
            return;
        }
        DoubleLinkedNode temp = head.next;
        boolean isFund = false;
        // 遍历找数据
        while (true) {
            if (temp == null) {
                System.out.println("空");
                break;
            }
            if (temp.code == updateNode.code) {
                isFund = true;
                break;
            }
            temp = temp.next;
        }
        if (isFund) {
            temp.name = updateNode.name;
            System.out.println("更换属性值");
            return;
        } else {
            System.out.println("遍历到末尾，未找到");
        }
    }

    /**
     * 遍历节点
     */
    public void listDouble() {
        if (head.next == null) {
            System.out.println("空了");
            return;
        }

        DoubleLinkedNode temp = head.next;
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
 * 定义节点信息
 */
class DoubleLinkedNode {
    public Integer code;
    public String name;
    public DoubleLinkedNode pre;
    public DoubleLinkedNode next;

    public DoubleLinkedNode(Integer code, String name) {
        this.code = code;
        this.name = name;
        this.pre = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
