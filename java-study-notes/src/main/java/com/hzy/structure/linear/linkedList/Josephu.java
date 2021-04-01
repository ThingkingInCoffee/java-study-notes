package com.hzy.structure.linear.linkedList;

public class Josephu {

    public static void main(String[] args) {
        BoyLinkedList list = new BoyLinkedList();
        list.addBoy(5);
        list.listBoy();
        list.getSpecialBoy(2, 3);
    }

}

class BoyLinkedList {
    // 头指针
    private Boy head = null;

    /**
     * 约瑟夫问题
     * 指定一个环形链表从第几个起，每间隔一定数值得节点按序弹出
     *
     * @param start    开始下标 1 开始
     * @param interval 间隔几个，即需要几个人报数
     */
    public void getSpecialBoy(int start, int interval) {
        Boy temp = head;
        // 首先将head调整至指定start位置
        // 如果开始为1，需要调整辅助位置到末尾
        if (1 == start) {
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
        } else {
            for (int i = 1; i < start; i++) {
                if (i != 1) {
                    temp = temp.getNext();
                }
                head = head.getNext();
            }
        }
        System.out.println("head---"+head);
        System.out.println("temp---"+temp);
        System.out.println("调整起始位置结束");
        listBoy();
        // 开始从起点报数, 只要最后没空就继续
        while(temp != head){ //当剩下一个节点时，终止并输出最后一个出圈
            for (int i = 1; i < interval; i++) {
                temp = temp.getNext();
                head = head.getNext();
            }
            System.out.println("报数后head---"+head);
            System.out.println("报数后temp---"+temp);
            // 移除head所在位置
            System.out.println("移除---"+head);
            temp.setNext(head.getNext());
            head = head.getNext();
        }
        System.out.println("移除最后---"+head);
    }


    public void addBoy(int num) {
        Boy current = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            // 第一个需要先将next指向自己
            if (i == 1) {
                head = boy;
                head.setNext(boy);
            } else {
                current.setNext(boy);
                boy.setNext(head);
            }
            current = boy;
        }
    }

    public void listBoy() {
        if (head == null) {
            System.out.println("空了");
        }
        Boy boy = head;
        while (true) {
            System.out.println(boy);
            boy = boy.getNext();
            if (boy.getCode() == head.getCode()) {
                // 当重新指到头部时，跳出
                break;
            }
        }
    }
}


class Boy {
    private int code;
    private Boy next;

    public Boy(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "code=" + code +
                '}';
    }
}
